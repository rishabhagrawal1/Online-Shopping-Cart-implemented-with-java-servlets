/*
 * intermediate2.java
 *
 * Created on 28 June, 2009, 6:59 PM
 */

import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author rishabh
 * @version
 */
public class add extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);  
       if(session!=null)
        {out.print("<body bgcolor=#00FFFF>");
             out.print("<p align=right><font color=violet><a href=signout>logout</a></font></p>");
        String str[]=request.getParameterValues("choice1");
        if(str==null)
        {
        out.print("<center><font color=red size=+3>Please Select some items to add in cart</font><br><br>");
        out.print("<input type=submit value=\"Back to product list\" onclick=location.href=\"Product\" />");
        out.print("<input type=submit value=\"view Cart\" onclick=location.href=\"view\" /></center><br>");
        }
        else{
        /*session.setAttribute("choice1",str);
         out.print("your choices are<br>");
        for(String s:str)
       {
        out.print(s+"<br>");
       }
     out.print("<center><input type=submit value=\"Add to Cart\" onclick=location.href=\"add\"; />");*/
     ArrayList ar=new ArrayList();
         // String ch[]=(String[])session.getAttribute("choice1");
      
                  
          for(String s: str)
          {
        
          ar.add(s);
          }
          ArrayList sar=new ArrayList();
        sar=(ArrayList)session.getAttribute("cart");
          if(sar==null)
          {
              session.setAttribute("cart",ar);
         
          }
          else
          {
              sar.addAll(ar);
              session.setAttribute("cart",sar);
         
          }
                       out.print("<font color=green size=+3><i>your selected item have succefully added</i></font><br><br>");
        
       out.print("<center><a href=Product><font color=blue size=+2>go back to product list </font></a><br><br>");
out.print("<table width=80% align=center><tr><td><img src=images/books8.jpg width=1100 height=300></td></tr></table>");
        out.print("<input type=submit value=\"Delete from cart\" onclick=location.href=\"delete\" />");
        out.print("<input type=submit value=\"view Cart\" onclick=location.href=\"view\" /></center><br>");

        
        
        } 
        
      
       }
        else
        {
        out.print("Please login to get this page");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
        
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet intermediate2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet intermediate2 at " + request.getContextPath () + "</h1>");
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
