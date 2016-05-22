/*
 * view.java
 *
 * Created on 28 June, 2009, 8:59 PM
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
public class view extends HttpServlet {
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
        { out.print("<p align=right><font color=violet><a href=signout>logout</a></font></p>");
    Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
          int j,sum=0;
     ArrayList ch=new ArrayList();
     Map m=new HashMap();     
     ch=(ArrayList)session.getAttribute("cart");
         //Iterator k=ch.iterator();
     out.print("<body bgcolor=#00FFFF leftmargin=20>");
     if(ch==null)
     {
              out.print("<center><font color=red size=+3><i>your cart have no item presently</i></font><br>");
     }
     else if(ch.isEmpty())    
         {
              out.print("<center><font color=red size=+3><i>your cart have no item presently</i></font><br>");
          
          }
         else{
                  out.print("<h2><font color=blue><i>Your cart have</i></font></h2><br>");
          Iterator i=ch.iterator();
           
          while(i.hasNext())
          {
              
              String s=(String)i.next();
       
              //out.print(s);}
      String query="select * from ProductTable where name like '"+s+"%"+"' ";
      rs=st.executeQuery(query);
             
              rs.next();
              String s1=rs.getString("price");
    out.print("<font color=green size=+2>"+s+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Rs."+s1+"</font><br>");
          j=Integer.parseInt(s1);
          sum=sum+j;
     m.put(s,s1);     
          
          }
          session.setAttribute("items",m);
          out.print("<br><br><center><h2><font color=rgb(3,2,1)>total price money is ="+sum+"</font></h2></center>");
          out.print("<center><input type=submit value=\"Show ME My Bill\" onclick=location.href=\"end\" />");
          out.print("<input type=submit value=\"Delete From Cart\" onclick=location.href=\"delete\" />");
         }
          out.print("<input type=submit value=\"Back to product list\" onclick=location.href=\"Product\" /></center>");
          
       }
        else
        {
        out.print("<font color=red size=+3>Please login to get this page</font>");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }

         
        }catch(Exception e)
        {out.print(e);}
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet view</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet view at " + request.getContextPath () + "</h1>");
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
