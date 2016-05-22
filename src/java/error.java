/*
 * error.java
 *
 * Created on 6 July, 2009, 3:15 AM
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
public class error extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<body bgcolor=#00FFCC>");
out.print("<h1 align=center><font color=blue><b>Invalid User</b></font></h1>");
String str1=request.getParameter("name");
out.print("<h3 align=center><font color=purple><b><i>Sorry "+str1+"</i></b></font></h3>");
out.print("<center><font color=blue size=+3><a href=login.html>Wanna Login Again???</a></font></center>");
/* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet error</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet error at " + request.getContextPath () + "</h1>");
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
