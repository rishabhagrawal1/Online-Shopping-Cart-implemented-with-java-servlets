/*
 * delete.java
 *
 * Created on 28 June, 2009, 7:15 PM
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
public class delete extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
            ArrayList ar=new ArrayList();
        HttpSession session=request.getSession(false);  
       if(session!=null)
        {
            out.print("<body bgcolor=#00FFFF leftmargin=20> ");
          ar=(ArrayList)session.getAttribute("cart");
          //Iterator k= ar.iterator();    
          if(ar.isEmpty())
          {
              out.print("<center><font size=+2 color=red>you have presently no item in cart</font><br><br>");
         out.print("<input type=submit value=\"Back to product list\" onclick=location.href=\"Product\" /></center><br><br>");
      
          }
          else{
              out.print("<font size=+3 color=blue><i>your cart have following iteams</i></font><br><br><br>");
     out.print("<form action=deleteFromCart method=post>");
     Iterator i= ar.iterator();    
     String str;
     while(i.hasNext())
     {
         str=(String)i.next();
       out.print("<font color=green size=+2><input type=checkbox name=choice1 value=\""+str+"\" />"+" "+str+"</font><br>");
         // Rs."+str3[j]+" 
         }
       out.print("<br><center><input type=submit name=delete value=\"Remove From Cart\" />");
       out.print("<input type=submit name=delete value=\"Remove All\" /></center><br></form>");
          }}
        else
        {
        out.print("<font color=red size=+3>Please login to get this page</font>");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
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
