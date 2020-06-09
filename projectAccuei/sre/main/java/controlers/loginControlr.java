package controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;
import modelsDbUtil.*;

/**
 * Servlet implementation class loginControlr
 */
public class loginControlr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		     Responsible responsible = ResponsibleDbUtil.getResponsibleById(id);
		     
		     if(responsible != null) {
		    	 
		    	      if(responsible.getNom().equalsIgnoreCase(nom) && responsible.getPrenom().equalsIgnoreCase(prenom)) {
		    	    	      
		    	    	  
		    	    	  switch (responsible.getID()) {
						case 24:
							session.setAttribute("rspo", responsible);
							session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(responsible.getID()));
							response.sendRedirect("indexAccuei.jsp");

							break;
						case 23:
							session.setAttribute("rspo", responsible);
							session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(responsible.getID()));
							response.sendRedirect("indexModerator.jsp");
							break;

						default:
							session.setAttribute("rspo", responsible);
							session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(responsible.getID()));
							response.sendRedirect("index.jsp");
							break;
							
						}
		 
		    	      }else {
		    	    	  
		    	    	   out.println("<script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>");
		    	    	   out.println("<script type='text/javascript'>");
		    	    	   out.println("$(document).ready( function() {");
		    	    	   out.println("alert('le nom au le prenom est incorrecte');");
		    	    	   out.println(" });");
		    	    	   out.println("</script>");
		    	    	   RequestDispatcher re = request.getRequestDispatcher("login.jsp");
		    	    	   re.include(request, response);
						}

		    	 
		     }else {
		    	 out.println("<script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>");
  	    	   out.println("<script type='text/javascript'>");
  	    	   out.println("$(document).ready( function() {");
  	    	   out.println("alert('Id est incorrecte');");
  	    	   out.println(" });");
  	    	   out.println("</script>");
  	    	   RequestDispatcher re = request.getRequestDispatcher("login.jsp");
  	    	   re.include(request, response);
				}
	}
}