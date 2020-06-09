package controlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Division;
import models.Responsible;
import models.Service;
import models.Visit;
import models.Visitor;
import modelsDbUtil.DivisionDbUtil;
import modelsDbUtil.ResponsibleDbUtil;
import modelsDbUtil.ServiceDbutil;
import modelsDbUtil.VisitDbUtil;
import modelsDbUtil.VisitorDbUtil;

/**
 * Servlet implementation class visitControler
 */
public class visitControler extends HttpServlet {
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
				listVisit(request, response);
				break;
				
			case 2:
				addVisit(request, response);
				break;
		    case 3:
		    	deletVisit(request,response);
		    	break;
		    case 4:
		    	updarVisit(request,response);
		    	break;

			default:
				listVisit(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}

	private void updarVisit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		
		int id = Integer.parseInt(request.getParameter("modifvisit"));
		int idvisitor = Integer.parseInt(request.getParameter("idvisitor"));
		int iddivision = Integer.parseInt(request.getParameter("iddivision"));
		 String etat = request.getParameter("newetat");
         String startDateStr = request.getParameter("newdate");
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		 Date DateVisi = sdf.parse(startDateStr);
		 
		 
		 
		 Visit rsp = new Visit(id, etat,DateVisi);
		 
		 
		if(VisitDbUtil.updteVisit(rsp, id,VisitorDbUtil.getById(idvisitor) , DivisionDbUtil.getById(iddivision)))
		{
			HttpSession session = request.getSession();
			
			
			session.setAttribute("rspo", ResponsibleDbUtil.getResponsibleById(idsesion));
			session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(idsesion));
			
			response.sendRedirect("basic_visits.jsp");
		}
		
		
		
		
		
		
	}

	private void deletVisit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int iddeleted = Integer.parseInt(request.getParameter("iddeleted"));
		
		
		Visit visit ;
		Responsible rspSes;
		try {
			visit = VisitDbUtil.getVisitByID(iddeleted);
			rspSes = ResponsibleDbUtil.getResponsibleById(idsesion);
						
		} catch (Exception e) {
			rspSes =null;
			visit = null;
			
	}
		
		if(visit != null  && rspSes != null) {
			
		VisitDbUtil.deleteVisit(iddeleted);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("rspo", rspSes);
		session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(rspSes.getID()));
		
		
		
	        response.sendRedirect("basic_visits.jsp");
		}else {
			response.sendRedirect("basic_visits.jsp");
		}
		
		
	}
	private void addVisit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		
		 int id  =  Integer.parseInt(request.getParameter("idvsit"));
		 Visit rs;
		 try {
			rs = VisitDbUtil.getVisitByID(id);
		} catch (Exception e) {
			rs = null;
		}
		 
		 String etat = request.getParameter("etat");
		 
		 int idvisitor = Integer.parseInt(request.getParameter("visitor"));
		 int iddivis = Integer.parseInt(request.getParameter("division"));
		 
		 String startDateStr = request.getParameter("DateVisi");
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		 Date DateVisi = sdf.parse(startDateStr);
		
		 if(rs==null) {
		 Visit visit = new Visit(id, etat, DateVisi);
		 
		 
		 VisitDbUtil.addVisit(visit, VisitorDbUtil.getById(idvisitor), DivisionDbUtil.getById(iddivis));
		 
		 listVisit(request,response);
		 
		 }else {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/form_visits.jsp");
				dispatcher.forward(request, response);
		
		 }
		
	}
	private void listVisit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<Visit> res = VisitDbUtil.getAll();
				
				
				// add students to the request
			
					
					request.setAttribute("Visit", res);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("/basic_visits.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	
}
