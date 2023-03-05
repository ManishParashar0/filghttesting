package LoginRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Flightbook extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String from = req.getParameter("from");		
     String where = req.getParameter("where");		
     String startdate = req.getParameter("startdate");		
     String returndate = req.getParameter("returndate");		
     String totalpassanger = req.getParameter("totalpassanger");
     String search = req.getParameter("search");
     System.out.println(search);
     List<String> list= new ArrayList<>();
     
     list.add(from);
     list.add(where);
     list.add(startdate);
     list.add(returndate);
     list.add(totalpassanger);
   System.out.println(list);
     
     HttpSession session=req.getSession();
     
     session.setAttribute("userdata",list);
     
     if (from!=null) {
    	  Loginjdbc.flight(from,where,startdate,returndate,totalpassanger);
    	     System.out.println("DATABASE INSTERT");
    	     RequestDispatcher rd=req.getRequestDispatcher("/NewFile.jsp");
    	     rd.forward(req, resp);
    	     
    	      
	}
   

     if (search!=null) {
    	 try {
 		resp.sendRedirect("https://www.google.com/search?q="+search+"&rlz=1C1CHBF_enIN1032IN1032&oq="+search+"&aqs=chrome.0.69i59l2j46i175i199i512j0i131i433i512j0i131i433j0i512j69i60l2.3823j0j9&sourceid=chrome&ie=UTF-8");
 		System.out.println("success");
    	 }catch (Exception e) {
			System.out.println(e);
		}
 		}
   
   
	}
	

}
