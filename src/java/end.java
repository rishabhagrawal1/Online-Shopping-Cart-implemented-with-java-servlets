/*
 * end.java
 *
 * Created on 30 June, 2009, 4:56 AM
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
public class end extends HttpServlet {
   ResultSet rs;Statement st;Connection c; PreparedStatement pst;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {String purchase=null;
    purchase=request.getParameter("purchase");
   
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        HttpSession session=request.getSession(false);  
try{   
        if(session!=null)
        { 
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mittal"); 
       st=c.createStatement();
       //   int j,sum=0;
     //ArrayList ch=new ArrayList();
      
         
        Map m=(HashMap)session.getAttribute("items");
          ArrayList ch=(ArrayList)session.getAttribute("cart");
           Iterator i=ch.iterator();
         if(ch.isEmpty())
         {
         out.print(" <body bgcolor=#00FFFF><p align=right><font color=violet><a href=signout>logout</a></font></p>");
         out.print(" <p align=center><font color=red size=+3>You have no item in your cart</font></p>");
          out.print("<center><input type=submit value=\"Back to product list\" onclick=location.href=\"Product\" /></center>");
         }else{
        out.println("<html>");
        out.println("<head>");
        out.println("<title>purchase items</title>");
        out.println("</head>");
        out.println("<body bgcolor=#00FFFF>");
        out.print(" <p align=right><font color=violet><a href=signout>logout</a></font></p>");
        out.print("<table width=35% align=center><tr><td><img src=\"images/books3.jpg\"></td></tr>");
  
        String s,s1;
    int []arr=new int[50];int l=0;String str1[]=new String[50];
         String str2[]=new String[50];
        
         int flag=0;
String query="select name,quantity from ProductTable where name=?"; 
               //where name like '"+s+"%"+"' ";
pst=c.prepareStatement(query);      


      
//String str9=null;int q=0;    
    
      while(i.hasNext())
          {
            s =(String)i.next();
            s1=(String)m.get(s);
         //  out.print(s+"ris");
            for(int k=0;k<l;k++)
           {
            if(s.equals(str1[k]))
             {
           // out.print("in for");
                arr[k]++;
             flag=1;
            }if(flag==1)
            {break;}
            }
             if(flag!=1&&l!=0)
             {
               str1[l]=s;
             //  out.print("in else");
                str2[l]=s1;
              arr[l]=1;
                l++;

            }if(l==0)
               {//out.print("in if");
                   str1[l]=s;
                str2[l]=s1;
                 arr[l]=1;         
                l++;
                }

                flag=0;                  
    }
             
                
                
                int sum=0;
                
                flag=0;
 
                for(int j=0;j<=l-1;j++)
         {
         pst.setString(1,str1[j]);  
         rs=pst.executeQuery();
         rs.next();
           
               if(rs.getInt("quantity")<arr[j])
               {
                
               out.print("<center><h1><font color=red>we have less pieces  of '"+str1[j]+"' books then your Demand</font></h1></center>");
 out.println("<center><input type=submit name=delete value=\"Delete From Cart\" onclick=location.href=\"delete\" /></center></form>");
               flag=1;
               }
           if(flag==1)
               break;
                }
         if(flag!=1)
         {  out.println("<h1><font color=white> <table bgcolor=magenta background=imges//books3 border=1 align=center cellspacing=2 cellpadding=2 ></h1>");
        out.println("<h3 align=center><font color=green>PaySlip</font><b><h3>");
        out.println("<tr><th>S.No.</th><th>Item</th><th>Detail</th><th>Amount</th></tr>");
     
                    for(int j=0;j<=l-1;j++)
         
         {
                out.println("<tr><td>"+(j+1)+"</td><td>"+str1[j]+"</td><td>"+str2[j]+"*"+arr[j]+"</td><td>"+Integer.parseInt(str2[j])*arr[j]+"</td></tr></b>");        
        sum+=Integer.parseInt(str2[j])*(arr[j]);
         }         
        
        
        
          out.println("<h1><tr><td colspan=3><i>Total Amount</i></td></h1>");
        out.println("<h1><td>"+sum+"</td></tr></font></h1>");
       
        out.println("<h1> </table></h1>");
        session.setAttribute("str1",str1);
        session.setAttribute("str2",str2);
        session.setAttribute("arr",arr);
        session.setAttribute("l",l);
        
        out.println("<center><h2><font color=blue>Time of Purchasing</font></h2></center>");
        
           
         } 
        out.println("</body>");
        out.println("</html>");
     if(purchase==null)
        {   out.println("<form method=post action=end> ");
            out.println("<center><input type=submit name=purchase value=\"Purchase Items\"  /></center></form>");
              
     }  
        
     else
       {
            
            out.print("<html>");
            out.print("<head><title>purchase items</title><script src=\"MyScript.js\"></script></head>");
            out.println("<center><form method=post action=purchasing onsubmit=\"return validate(this)\"> ");
            out.println("<font color=rgb(1,5,3) size=+2>Input your Credit/Debit card no here&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name=card_no value=\"card no\" /><br><br> ");
        out.println("Input your Credit/Debit Pin no here&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name=pin_no value=\"Pin no\" /><br><br> ");
      out.println("<input type=submit value=\"submit Details\" />");
        out.println("</font></form></center><br>  ");
     }
      
        
        
         }
        }   
        
          else
        {
        out.print("<font color=red size=+2>Please login to get this page");
         RequestDispatcher rd=request.getRequestDispatcher("login.html");
         rd.include(request,response);
        }
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet end</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet end at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
              */
}catch(Exception e)
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
