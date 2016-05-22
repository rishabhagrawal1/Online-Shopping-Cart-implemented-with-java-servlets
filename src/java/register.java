/*
 * register.java
 *
 * Created on 28 June, 2009, 12:03 AM
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
public class register extends HttpServlet {
    ResultSet rs,rs1;Statement st;Connection c;PrintWriter out;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         out = response.getWriter();
       try{
       
        HttpSession session=request.getSession(false);
       if(session!=null)
       { 
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
       String str1=(String)session.getAttribute("name");
       String str2=(String)session.getAttribute("password");
       String str3=(String)session.getAttribute("contact");
       String str4=(String)session.getAttribute("address");
        String query="select * from login where name='"+str1+"' ";
       rs=st.executeQuery(query);
       if(rs.next())
       {out.print("<h3><font color=silver>user name already exist,try another one</font></h3>");
        session.invalidate();
            RequestDispatcher rd=request.getRequestDispatcher("userform.html");
         rd.include(request,response);
       }else{
       String query1="insert into login values('"+str1+"','"+str2+"','"+str3+"','"+str4+"')";
       st.executeUpdate(query1);
            out.print("<h2><font color=green>"+str1+" you have successfully register<br>now login to enter in our site</font></h2>");
         session.invalidate();
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
       }
       }
       else
       {out.print("<h1 align=center>Please fill reqierd information to register<h1>");
         RequestDispatcher rd=request.getRequestDispatcher("userform.html");
         rd.include(request,response);
       
       }
        }
        catch(Exception e)
        {
            out.print(e);} 
        
        
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet register</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet register at " + request.getContextPath () + "</h1>");
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
