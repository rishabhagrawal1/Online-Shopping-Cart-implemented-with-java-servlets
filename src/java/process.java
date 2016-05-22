/*
 * process.java
 *
 * Created on 28 June, 2009, 4:01 PM
 */

import java.io.*;
import java.net.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author rishabh
 * @version
 */
public class process extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        HttpSession session=request.getSession(false);  
       if(session!=null)
        { 
          String str1=request.getParameter("choice");
          if(str1==null)
          {
            out.print("<font color=red><b>Please Select Your Choice</font>");  
               RequestDispatcher rd=request.getRequestDispatcher("Product");
         rd.include(request,response);
          }
          else{
          session.setAttribute("choice",str1);
          //out.print("<h1><font color=blue><b><i>valid user "+str1+"</i></b></font></h1>");
        out.print("<h1><font color=blue><b><i>"+session.getAttribute("name")+" your choice "+str1+"</i></b></font></h1>");
       RequestDispatcher rd=request.getRequestDispatcher("showIteams");
         rd.include(request,response);
       }}
        else
        {
        out.print("<h2><font color=red>Please login to get this page</font><h2>");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Admin</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Admin at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        }
        catch(Exception e)
         {out.print(e);}
        
        
       
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
