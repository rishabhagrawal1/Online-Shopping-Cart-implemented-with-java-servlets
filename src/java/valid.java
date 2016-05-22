/*
 * valid.java
 *
 * Created on 27 June, 2009, 12:41 AM
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
public class valid extends HttpServlet {
    ResultSet rs;Statement st;Connection c;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        try{
        String str1=request.getParameter("name");
        String str2=request.getParameter("password");
        
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
       String query="select * from login where name='"+str1+"' and password='"+str2+"'";
       rs=st.executeQuery(query);
       if(rs.next())
        {
         HttpSession session=request.getSession();
         session.setAttribute("name",str1);
        
         
         RequestDispatcher rd=request.getRequestDispatcher("Product");
         rd.include(request,response);
        }
        else        
        {
        
     
RequestDispatcher rd=request.getRequestDispatcher("error");
         rd.include(request,response);
        }
        }
        catch(Exception e)
        {
            out.print(e);}
        
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet valid</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet valid at " + request.getContextPath () + "</h1>");
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
