/*
 * purchasing.java
 *
 * Created on 30 June, 2009, 9:30 PM
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
public class purchasing extends HttpServlet {
    
    ResultSet rs;Statement st;Connection c;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession session=request.getSession(false);  
out.print("<body bgcolor=#00FFFF>");
         try{   
        if(session!=null)
        { 

               Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
       
       String str1[]=(String[])session.getAttribute("str1");
        String str2[]=(String[])session.getAttribute("str2");
      int arr[]=(int[])session.getAttribute("arr");
      int l=(Integer)session.getAttribute("l");
  //    out.print("in if");
      ResultSet rs1;
int j=0,quan=0; 
String card=request.getParameter("card_no");
String pin=request.getParameter("pin_no");
if(card==null||pin==null)
{
out.print("<font color=red size=+2>you have not enterd the values <br>or<br> page has expired</font>");
 RequestDispatcher rd=request.getRequestDispatcher("end");
         rd.include(request,response);

}
      String query2="insert into CardDetail values ('"+card+"', '"+pin+"') ";
      st.executeUpdate(query2);
for(int i=0;i<l;i++)
      {
    String query1="select quantity from ProductTable where name ='"+str1[i]+"' ";
      rs1=st.executeQuery(query1);
    rs1.next();
      j=rs1.getInt("quantity");
       
       quan=j-arr[i];
       
 String query="Update ProductTable set quantity="+quan+" where name ='"+str1[i]+"' ";
      st.executeUpdate(query);
      
        
      }int sum=0; 
      out.println("<h2 align=center><font color=purple>Thanks For Purchasing From Our Site</font></h2>");
out.println("<h3 align=center><font color=blue><i><b>HAPPY READING!!!</b></i></font></h3>");
      out.println("<h1> <table border=1 align=center cellspacing=2 cellpadding=2 bgcolor=magenta></h1>");
        out.println("<h1><tr><td colspan=4>PaySlip</td></tr></h1>");
        out.println("<tr><th>S.No.</th><th>Item</th><th>Detail</th><th>Amount</th></tr>");
               for(j=0;j<=l-1;j++)
         
         {
                out.println("<tr><td>"+(j+1)+"</td><td>"+str1[j]+"</td><td>"+str2[j]+"*"+arr[j]+"</td><td>"+Integer.parseInt(str2[j])*arr[j]+"</td></tr>");        
        sum+=Integer.parseInt(str2[j])*(arr[j]);
         }         
        
        
        
          out.println("<h1><tr><td colspan=3>Total Amount</td></h1>");
        out.println("<h1><td>"+sum+"</td></tr></h1>");
       
        out.println("<h1> </table></h1>");
        out.println("<center><input type=submit value=\"print Bill\" onclick=\"javascript:window.print();\" /></center> ");
        }
       
        else
        {
        out.print("<font color=red size=+2>Please login to get this page");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }  }catch(Exception e){out.print(e);}
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
