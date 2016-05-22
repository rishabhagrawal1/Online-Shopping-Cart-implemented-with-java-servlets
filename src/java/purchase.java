/*
 * purchase.java
 *
 * Created on 29 June, 2009, 8:35 PM
 */
import java.sql.*;
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
public class purchase extends HttpServlet {
       
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);  
   
    
   /* ArrayList ar1;//=new ArrayList();
    ArrayList ar2;//=new ArrayList();
    ArrayList ar3;//=new ArrayList();
  
  int f=0;

    ar1=(ArrayList)session.getAttribute("ar1");
    if(ar1!=null)
    {
    Iterator x=ar1.iterator();
               while(x.hasNext())
          {
            str1[f] =(String)x.next();
   out.print(str1[f]);
            f++;
    }
    }
    f=0;
    ar2=(ArrayList)session.getAttribute("ar2");
    if(ar2!=null)
    {
    
          Iterator v=ar2.iterator();
    
           while(v.hasNext())
          {
            str2[f] =(String)v.next();
    out.print(str2[f]);
            f++;
    }}
          
    ar3=(ArrayList)session.getAttribute("ar3");
    f=0;
    if(ar3!=null)
    {
    
    Iterator z=ar3.iterator();
    
           while(z.hasNext())
          {
            arr[f] =(Integer)z.next();
            out.print(arr[f]);
    f++;
    }
    
    
    
    String sx=(String)(session.getAttribute("l"));
   if(sx!=null)
   {
   out.print(l);
   l=Integer.parseInt(sx);
   }*/


/*out.print(l);  
         ArrayList ar5=new ArrayList();
   ArrayList ar6=new ArrayList();
    ArrayList ar7=new ArrayList();
  
for(int g=0;g<l;g++)
   {
    out.print(str1[g]);
   ar5.add(str1[g]);
ar6.add(str2[g]);
ar7.add(arr[g]);
}
//ar1.addAll(ar5);      
session.setAttribute("ar1",ar5);
   
//ar2.addAll(ar6);  
session.setAttribute("ar2",ar6);
 
//ar3.addAll(ar7); 
session.setAttribute("ar3",ar7);
   session.setAttribute("l",String.valueOf(l));
 
 }*/
//"*"+detail[j]+,"+Integer.parseInt(sfg.getInitParameter(ch[j]))*(detail[j])+"
        
   /*    RequestDispatcher rd=request.getRequestDispatcher("end");
         rd.include(request,response);
       }
          else
        {
        out.print("Please login to get this page");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
   
   
   out.close();*/
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
