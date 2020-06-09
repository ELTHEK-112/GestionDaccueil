package controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Responsible;
import models.Service;
import modelsDbUtil.ResponsibleDbUtil;
import modelsDbUtil.ServiceDbutil;

/**
 * Servlet implementation class deletResponsibleControlr
 */

@WebServlet(name = "deletResponsibleControlr", urlPatterns = {"/deletResponsibleControlr"})
public class deletResponsibleControlr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idsesion = Integer.parseInt(request.getParameter("idsesion"));
		int iddeleted = Integer.parseInt(request.getParameter("iddeleted"));
		int idServ = Integer.parseInt(request.getParameter("idserv"));
		
		Responsible rspdeletd ;
		Responsible rspSes;
		Service servSes;
		try {
			rspdeletd = ResponsibleDbUtil.getResponsibleById(iddeleted);
			rspSes = ResponsibleDbUtil.getResponsibleById(idsesion);
			servSes = ServiceDbutil.getById(idServ);			
		} catch (Exception e) {
			rspSes =null;
			rspdeletd = null;
			servSes = null;
	}
		if(rspdeletd != null && servSes != null && rspSes != null) {
			
		ResponsibleDbUtil.deleteResponsible(iddeleted);
		
		HttpSession session = request.getSession();
		
		
		session.setAttribute("resp", rspSes);
		session.setAttribute("serv", servSes);
		
		
		
	    response.sendRedirect("basic_responsible.jsp");
		
		}
		}

}
