package controlers;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Division;
import models.Responsible;
import modelsDbUtil.DivisionDbUtil;
import modelsDbUtil.ResponsibleDbUtil;

/**
 * Servlet implementation class controlerDivision
 */

public class controlerDivision extends HttpServlet {
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
				listDivision(request, response);
				break;
				
			case 2:
				addDivision(request, response);
				break;
		    case 3:
		    	deletDivision(request,response);
		    	break;
		    case 4:
		    	updarDivision(request,response);
		    	break;

			default:
				listDivision(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}

	private void updarDivision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int RspoID = Integer.parseInt(request.getParameter("idRispdiv"));
		int id = Integer.parseInt(request.getParameter("modifrediv"));
		 String nom = request.getParameter("newnom");
		 
		 
		 Division rsp = new Division(id, nom);
		 
		 
		if(DivisionDbUtil.updateDivision(id, rsp, RspoID))
		{
			HttpSession session = request.getSession();
			
			
			session.setAttribute("rspo", ResponsibleDbUtil.getResponsibleById(idsesion));
			session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(idsesion));
			
			response.sendRedirect("basic_division.jsp");
		}
		
		
		
		
		
		
	}

	private void deletDivision(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int iddeleted = Integer.parseInt(request.getParameter("iddeleted"));
		
		
		Division Divdeletd ;
		Responsible rspSes;
		try {
			Divdeletd = DivisionDbUtil.getById(iddeleted);
			rspSes = ResponsibleDbUtil.getResponsibleById(idsesion);
						
		} catch (Exception e) {
			rspSes =null;
			Divdeletd = null;
			
	}
		
		if(Divdeletd != null  && rspSes != null) {
			
		DivisionDbUtil.delete(iddeleted);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("rspo", rspSes);
		session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(rspSes.getID()));
		
		
		
	        response.sendRedirect("basic_division.jsp");
		}else {
			response.sendRedirect("basic_division.jsp");
		}
		
		
	}
	private void addDivision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int idrsp = Integer.parseInt(request.getParameter("Responsible"));
		 int id  =  Integer.parseInt(request.getParameter("iddivision"));
		 
		 String nom = request.getParameter("nomdiv");
		 Division respo = new Division(id, nom);
		 
		 PrintWriter out = response.getWriter();
		 
		 
		 Division rs ;
		 Division rs1;
		 try {
			rs = DivisionDbUtil.getById(id);
			rs1= DivisionDbUtil.getByIdResponsible(idrsp);
			
			   out.println("<script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>");
	    	   out.println("<script type='text/javascript'>");
	    	   out.println("$(document).ready( function() {");
	    	   out.println("alert('le nom au le prenom est incorrecte');");
	    	   out.println(" });");
	    	   out.println("</script>");
	    	   
	    	   RequestDispatcher re = request.getRequestDispatcher("form_division.jsp");
	    	   re.include(request, response);
			
			
			
		} catch (Exception e) {
			rs = null;
			rs1 = null;
			
			DivisionDbUtil.addDivision(ResponsibleDbUtil.getResponsibleById(idrsp), respo);
			listDivision(request,response);
		}
		 
	}
	private void listDivision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<Division> res = DivisionDbUtil.getAll();
				
				
				// add students to the request
			
					
					request.setAttribute("Divi", res);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("/basic_division.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	
	

}
