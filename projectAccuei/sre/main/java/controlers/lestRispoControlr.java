package controlers;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Responsible;
import modelsDbUtil.ResponsibleDbUtil;


/**
 * Servlet implementation class lestRispoControlr
 */
public class lestRispoControlr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	                 String prem = request.getParameter("all");
	                 if(prem.equalsIgnoreCase("all")) {
	                	
	                	 
	                	  List<Responsible> listRep = ResponsibleDbUtil.getALL();

	     				// add students to the request
	     			
	     					
	     					request.setAttribute("rspon", listRep);
	     					
	     					// send to JSP page (view)
	     					RequestDispatcher dispatcher = request.getRequestDispatcher("basic_responsible.jsp");
	     					dispatcher.forward(request, response);
	     			
	                 }else {
	                	 
	                	 RequestDispatcher dispatcher = request.getRequestDispatcher("basic_responsible.jsp");
	     					dispatcher.forward(request, response);
					}
	}

}
