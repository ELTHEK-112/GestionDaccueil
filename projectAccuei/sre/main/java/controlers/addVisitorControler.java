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
import models.Visitor;
import modelsDbUtil.DivisionDbUtil;
import modelsDbUtil.ResponsibleDbUtil;
import modelsDbUtil.VisitorDbUtil;

/**
 * Servlet implementation class addVisitorControler
 */
public class addVisitorControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVisitorControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
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
					listVisitor(request, response);
					break;
					
				case 2:
					addVisitor(request, response);
					break;
			    case 3:
			    	deletVisitor(request,response);
			    	break;
			    case 4:
			    	updarVisitor(request,response);
			    	break;

				default:
					listVisitor(request, response);
				}
					
			}
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
			
		}

		private void updarVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int idsesion = Integer.parseInt(request.getParameter("idsesion"));
			int id = Integer.parseInt(request.getParameter("modifvistor"));
			 String nom = request.getParameter("newnom");
			 String prenom = request.getParameter("newprenom");
			 String cin = request.getParameter("newcin");
			 
			 Visitor rsp = new Visitor(id, nom, prenom, cin);
			 
			 
			if(VisitorDbUtil.update(id, rsp))
			{
				HttpSession session = request.getSession();
				
				
				session.setAttribute("rspo", ResponsibleDbUtil.getResponsibleById(idsesion));
				session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(idsesion));
				
				response.sendRedirect("basic_Visitor.jsp");
			}
			
			
			
			
			
			
		}

		private void deletVisitor(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			int idsesion = Integer.parseInt(request.getParameter("idsesion"));
			int iddeleted = Integer.parseInt(request.getParameter("iddeleted"));
			
			
			Visitor visitor ;
			Responsible rspSes;
			try {
				visitor =  VisitorDbUtil.getById(iddeleted);
				rspSes = ResponsibleDbUtil.getResponsibleById(idsesion);
							
			} catch (Exception e) {
				rspSes =null;
				visitor = null;
				
		}
			
			if(visitor != null  && rspSes != null) {
				
			VisitorDbUtil.delete(iddeleted);
			
			HttpSession session = request.getSession();
			
			
			session.setAttribute("rspo", rspSes);
			session.setAttribute("divs", DivisionDbUtil.getByIdResponsible(rspSes.getID()));
			
			
			
		        response.sendRedirect("basic_Visitor.jsp");
			}else {
				response.sendRedirect("basic_Visitor.jsp");
			}
			
			
		}
		private void addVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			 int id  =  Integer.parseInt(request.getParameter("id"));
			 Visitor rs;
			 try {
				rs = VisitorDbUtil.getById(id);
			} catch (Exception e) {
				rs = null;
			}
			 
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom");
			 String cin = request.getParameter("cin");
		  
			 if(rs==null) {
			 Visitor visitor = new Visitor(id, nom, prenom, cin);
			 
			 
			 VisitorDbUtil.addVisitor(visitor);
			    
			 
			 listVisitor(request,response);
			 
			 }else {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/form_Visitor.jsp");
					dispatcher.forward(request, response);
			
			 }
			
		}
		private void listVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// get students from db util
					List<Visitor> res = VisitorDbUtil.getAll();
					
					
					// add students to the request
				
						
						request.setAttribute("rspon", res);
						
						// send to JSP page (view)
						RequestDispatcher dispatcher = request.getRequestDispatcher("/basic_Visitor.jsp");
						dispatcher.forward(request, response);
				
						
					
					
			
		}
}
