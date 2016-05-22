/*
 * computer.java
 *
 * Created on 28 June, 2009, 4:45 PM
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
public class showIteams extends HttpServlet {
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
        HttpSession session=request.getSession(false);  
       
       if(session!=null)
        {out.print("<p align=right><font color=violet><a href=signout>logout</a></font></p>"); 
        String str2[]=new String[10];
        String str3[]=new String[10];
        String str4[]=new String[10];
        String str1=(String)session.getAttribute("choice");
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
          String query="select * from ProductTable where type='"+str1+"' ";
       rs=st.executeQuery(query);
       int i=0;
         out.print("<body bgcolor=#00FFFF>");
         out.print("<form action=add method=post>");
       
       
       while(rs.next())
        {
           str2[i]=rs.getString("name");
        str3[i]=rs.getString("price");
         str4[i]=rs.getString("quantity");  
        i++;
       }
       int j=0;out.print("<table><tr><td>");
       for(String s: str2)
       {
           if(j>i-1)
            break;
       out.print("<pre><font color=green size=+2><input type=checkbox name=choice1 value=\""+s+"\" />"+" "+s+"         Rs."+str3[j]+"     "+"Copies available are"+str4[j]+"</font></pre><br>");
       j++;
       }
       out.print("<center><font color=silver size=+2><input type=submit value=\"Add to Cart\"></font></center></form></td>");
       out.print("<td><img src=images//"+str1+"2.jpg  height=300 width=400></td></tr></table></body>");
       }//<tr><td><img src=images//"+str1+"2.jpg  height=300 width=400></td><td><img src=images//"+str1+"3.jpg  height=300 width=400></td></tr>
        else
        {
        out.print("Please login to get this page");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
        }
        catch(Exception e)
         { 
            out.print(e);
        }
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
