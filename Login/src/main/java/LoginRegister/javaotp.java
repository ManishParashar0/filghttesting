//package LoginRegister;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Date;
//
//import javax.net.ssl.HttpsURLConnection;
//
//public class javaotp {
//	public static void otp(String message, String string) {
//	try {
//		System.out.println(message + "" + string);
//		String apikay="ESqzovX3dj5swoqvygzhLB8aI6VI10bqRzfoTfk5P7wfemZuJrBsPEMfEDvQ";
//        String sender_id="TXTIND";
//      String language="english";
//      message = URLEncoder.encode(message,"UTF-8");
//      System.out.println(message+"url encoder");
//      String route="v3";
//      String myurl="GET https://www.fast2sms.com/dev/bulkV2?authorization="+apikay+"&sender_id="+sender_id+"&message="+message+"&language="+language+"&route="+route+"&numbers="+string;
//			System.out.println(myurl);
//			System.out.println(message+"this is a message");
//			URL url=new URL(myurl);
//			HttpsURLConnection con =(HttpsURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.setRequestProperty("User-Agent", "Mozilla/5.0");
//			con.setRequestProperty("cache-control", "no-cache");
//			System.out.println("wait....");
//			int responseCode = con.getResponseCode();
//			System.out.println(responseCode);
//			StringBuffer BF=new StringBuffer();
//			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
//			while (true) {
//				String  line =	br.readLine();
//				if (line==null) {
//					break;
//				} 
//				BF.append(line);  
//			}
//			System.out.println(BF);
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		System.out.println("program start.....");
//
//		javaotp.otp("this is over msg..." + new Date().toLocaleString(), " 8094950909");
//	}
//}
