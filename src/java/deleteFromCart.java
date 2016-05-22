/*
 * deleteFromCart.java
 *
 * Created on 29 June, 2009, 12:16 AM
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
public class deleteFromCart extends HttpServlet {
    
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
        { out.print("<body bgcolor=#00FFFF><p align=right><font color=violet><a href=signout>logout</a></font></p>");
       //ArrayList dar=new ArrayList();
        String str[]=request.getParameterValues("choice1");
        
        ArrayList sar=(ArrayList)session.getAttribute("cart");
         Iterator k= sar.iterator();//Iterator j= dar.iterator();    
          
          if(!k.hasNext())// if cart have no item
          {
          out.print("<center><h3><font color=red>your cart is already null</font></h3><br><br>");
          }
        else if(str==null)  //if without selecting checkbox come to this page  
          {if(request.getParameter("delete").equals("Remove All"))
           {
          sar.clear();
              session.setAttribute("cart",sar);
         out.print("<h3 align=center><font color=blue>All items from cart have succefully deleted</font></h3><br>");     
           }else{
             out.print("<center><h3><font color=red>please select some item if you really want to delete them</font></h3><br><br>");
               out.print("<input type=submit value=\"view Cart\" onclick=location.href=\"view\" />");    
          }}
        else
        {
         {
             for(String s:str)
           {
                 //out.print(s);
          //  dar.add(s);
           sar.remove(s);
             }
        //sar.removeAll(dar);
        
              session.setAttribute("cart",sar);
        out.print("<h3 align=center><font color=blue>your selected item have succefully deleted</font></h3><br>");
         }
         
         out.print("<center><input type=submit value=\"view Cart\" onclick=location.href=\"view\" />");
        }
         out.print("<input type=submit value=\"Back to product list\" onclick=location.href=\"Product\" /></center>");
      
         
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
        out.println("<title>Servlet deleteFromCart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet deleteFromCart at " + request.getContextPath () + "</h1>");
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
