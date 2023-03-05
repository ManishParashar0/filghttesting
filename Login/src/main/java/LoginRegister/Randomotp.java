package LoginRegister;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Randomotp extends HttpServlet {
	
	
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String parameter = req.getParameter("mobilenumber");
			String otp = req.getParameter("otp");
			
			System.out.println(parameter+"THIS IS A NUMBER");
		    boolean forgot = Loginjdbc.FORGOT(parameter);
		    System.out.println(forgot);
		    if (forgot==true&&otp.equals("8094")) {
				RequestDispatcher rs=req.getRequestDispatcher("/flight.html");
				rs.forward(req, resp);
			}
		    else {
		    	RequestDispatcher rs=req.getRequestDispatcher("/NewFile.html");
				rs.forward(req, resp);
			}
		}
		
			
		
			
//			String gernratedOTP = Randomotp.gernratedOTP(6);
//			System.out.println(gernratedOTP);
//			String apikey = "ESqzovX3dj5swoqvygzhLB8aI6VI10bqRzfoTfk5P7wfemZuJrBsPEMfEDvQ";
//			SendOTP.SendOTP1("manish", number, apikey);}
	}

//	public static void main(String[] args) {
//		String otp = null;
//
//		try {
//			otp = gernratedOTP(6);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//		System.out.println(otp + " otp");
//	}

//	public static String gernratedOTP(int i) {
//		StringBuilder append = null;
//		Random random = new Random();
//		StringBuilder sb = new StringBuilder();
//		for (int j = 0; j < i; j++) {
//			append = sb.append(random.nextInt(10));
//
//		}
//		String otp = append.toString();
//
//		return otp;
	//}

