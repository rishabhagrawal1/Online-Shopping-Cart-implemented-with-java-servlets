/*
 * signout.java
 *
 * Created on 27 June, 2009, 1:35 AM
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author rishabh
 * @version
 */
public class signout extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
HttpSession session=request.getSession(false);
out.print("<body bgcolor=\"#00FF66\">");
if(session!=null)
        {    
    session.invalidate();
    out.print("<h2 align=center><font color=red size=+3>logout successfully</font></h2>");
out.print("<center><font color=blue size=+3><a href=login.html>Wanna Login Again???</a></font></center>");

}
        else
        {
            out.print("<h2 align=center><font color=red size=+2>you are already logout</font></h2>");
        RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet signout</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet signout at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
