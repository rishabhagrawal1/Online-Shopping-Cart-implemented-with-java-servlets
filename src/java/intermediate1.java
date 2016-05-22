/*
 * intermediate1.java
 *
 * Created on 28 June, 2009, 2:04 AM
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
public class intermediate1 extends HttpServlet {
   
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    HttpSession session=request.getSession(false);
 String submit=request.getParameter("submit");
String submit1="flag";
 if(session!=null)
 submit1=(String)session.getAttribute("submit1");
if(submit1==null)
    submit1="flag";
    
      if(submit==null||submit1.equals("flag"))
       {String str5=null;
          
         if(session==null ||(session.getAttribute("password")==null) )
         {String str1=request.getParameter("name"); 
        String str2=request.getParameter("password"); 
              String str3=request.getParameter("contact"); 
                    String str4=request.getParameter("address"); 
                      
           session=request.getSession(true);
        session.setAttribute("name",str1);
         session.setAttribute("password",str2);
         session.setAttribute("contact",str3);
         session.setAttribute("address",str4);
         }
         //out.print("");
       int arr[]=new int[6];
int count=0,i=0,a;
while(count!=6)
{
a=(int)(Math.random()*150);
if((a>65&&a<91)||(a>98&&a<123))
{
arr[i]=a;
count++;
i++;
}
}
char c[]=new char[6];
for(i=0;i<=5;i++)
{
c[i]=(char)(arr[i]);
}
str5=String.valueOf(c);
out.println("<font color=yellow size=4><pre>       enter the charactors same as display</pre></font><br>");
out.print("<pre><font color=red face=chiller,sans-serif  size=+5>            "+str5+"</font></pre>");
session.setAttribute("str5",str5);

out.print("<form method=post><pre>               <input type=text name=response /></pre><br>");
out.print("<pre>                     <input type=submit name=submit value=\"Submit\" /></pre></form>");
session.setAttribute("submit1","f"); 
RequestDispatcher rd=request.getRequestDispatcher("userform.html");
         rd.include(request,response);
       }
        
        
 else{
    
      if(session!=null)
      {
       String str=request.getParameter("response");          
       String str5=(String)session.getAttribute("str5");          
       
       if(str5.equals(str))
         {
          RequestDispatcher rd=request.getRequestDispatcher("register");
          rd.include(request,response);
         }
         else
         {if(str!=null)
          out.println("<font size=5 color=\"blue\"><pre>  sorry input does not match</pre></font>");
          
         submit1="flag";
session.setAttribute("submit1",submit1);
          RequestDispatcher rd=request.getRequestDispatcher("intermediate1");
          rd.include(request,response);
         
         }
      }
     else{
        out.println("<center><font size=5 color=\"light blue\">please login to get this page</font></center>");
          }
        }
          
                 
         /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet intermediate1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet intermediate1 at " + request.getContextPath () + "</h1>");
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
