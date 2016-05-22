/*
 * Admin.java
 *
 * Created on 27 June, 2009, 12:59 AM
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
public class Product extends HttpServlet {
        ResultSet rs;Statement st;Connection c;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {int i=0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        HttpSession session=request.getSession(false);  
       if(session!=null)
        {
         String str1[]=new String[10];
       out.print("<p align=right><font color=violet face=4><a href=signout>logout</a></font><p></form>"); 
        out.print("<h2 align=center><font color=blue size=+5><b><i>Welcome " +session.getAttribute("name")+"</i></b></font></h2>");
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
       String query="select distinct type from ProductTable ";
       rs=st.executeQuery(query);
       out.print("<h2 ><font color=rgb(1,3,6) size=+2><b><i>Choose the type of books you need from us</i></b></font></h2>");
       out.print("<form action=process method=post>");
       while(rs.next())
        {
           str1[i]=rs.getString("type");
        i++;
       }
       int j=0;
       //out.print("<table width=50% >");
      out.print(" <body bgcolor=#00FFFF><table width=80% align=center border=0 >");
     out.print("<tr><td width=580 height=153>");
      for(String s: str1)
       {
           if(j>i-1)
            break;
      
           out.print("&nbsp;<b><font color=green size=+2><input type=radio name=choice value="+s+" >"+s+"<br><br>");
       j++;}
   
             out.print("</td>"+
             
             "<td width=401 height=296><img src=images/first.jpg width=400 height=300></td>" +
             "</tr></td><td>&nbsp;</td></tr><tr><td height=84>&nbsp;</td><td>&nbsp;</td>" +
             "  <td>&nbsp;</td></tr></table>");
  
  
    


      
      
  
       
       //out.print("<img src=images\\computer.jpg align=center hspace=500 vspace=0 width=400 height=300 >");
       out.print("<br><center><input type=submit value=Submit /></center></font></b><br>");
       }
        else
        {
        out.print("<h2><font color=red>Please login to get this page</font></h2>");
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
