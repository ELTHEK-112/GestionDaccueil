package controlers;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Responsible;

import modelsDbUtil.DivisionDbUtil;
import modelsDbUtil.ResponsibleDbUtil;

/**
 * Servlet implementation class controlerResponsible
 */
public class controlerResponsible extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
			int theCommand = Integer.parseInt(request.getParameter("command"));
			
			// if the command is missing, then default to listing students
			if (theCommand == 0) {
				theCommand = 1;
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case 1:
				listResponsible(request, response);
				break;
				
			case 2:
				addResponsible(request, response);
				break;
		    case 3:
		    	deletResponsible(request,response);
		    	break;
		    case 4:
		    	updarResponsible(request,response);
		    	break;

			default:
				listResponsible(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}

	private void updarResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int id = Integer.parseInt(request.getParameter("modifrespo"));
		 String nom = request.getParameter("newnom");
		 String prenom = request.getParameter("newprenom");
		 String cin = request.getParameter("newcin");
		 
		 Responsible rsp = new Responsible(id, nom, prenom, cin);
		 
		 
		if(ResponsibleDbUtil.updatResponsible(id, rsp))
		{
			HttpSession session = request.getSession();
			
			
			session.setAttribute("rspo", ResponsibleDbUtil.getResponsibleById(idsesion));
			session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(idsesion));
			
			response.sendRedirect("basic_responsible.jsp");
		}
		
		
		
		
		
		
	}

	private void deletResponsible(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int iddeleted = Integer.parseInt(request.getParameter("iddeleted"));
		
		
		Responsible rspdeletd ;
		Responsible rspSes;
		try {
			rspdeletd = ResponsibleDbUtil.getResponsibleById(iddeleted);
			rspSes = ResponsibleDbUtil.getResponsibleById(idsesion);
						
		} catch (Exception e) {
			rspSes =null;
			rspdeletd = null;
			
	}
		
		if(rspdeletd != null  && rspSes != null) {
			
		ResponsibleDbUtil.deleteResponsible(iddeleted);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("rspo", rspSes);
		session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(rspSes.getID()));
		
		
		
	        response.sendRedirect("basic_responsible.jsp");
		}else {
			response.sendRedirect("basic_responsible.jsp");
		}
		
		
	}
	private void addResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int id  =  Integer.parseInt(request.getParameter("responsibleid"));
		 Responsible rs;
		 try {
			rs = ResponsibleDbUtil.getResponsibleById(id);
		} catch (Exception e) {
			rs = null;
		}
		 
		 String nom = request.getParameter("responsiblenom");
		 String prenom = request.getParameter("responsibleprenom");
		 String cin = request.getParameter("responsiblecin");
	  
		 if(rs==null) {
		 Responsible respo = new Responsible(id, nom, prenom, cin);
		 
		 
		 ResponsibleDbUtil.addResponsible(respo);
		    
		 
		 listResponsible(request,response);
		 
		 }else {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/form_responsible.jsp");
				dispatcher.forward(request, response);
		
		 }
		
	}
	private void listResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<Responsible> res = ResponsibleDbUtil.getALL();
				
				
				// add students to the request
			
					
					request.setAttribute("rspon", res);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("/basic_responsible.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	
	
}