/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otpverification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author hackphiles
 */
public class OtpVerification {

    public static void OtpVerification(String message, String number, String apiKey){
        try{
                String sendId,language,route;
        
                sendId="CHKSMS";
                language = "english";
                route = "q";
        
                message = URLEncoder.encode(message,"UTF-8");
                
                String myURL = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
                
                URL url = new URL(myURL);
                
                HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
                
                con.setRequestMethod("GET");
                
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("cache-control", "no-cache");
                
                System.out.println("wait....");
                
                
                int responseCode = con.getResponseCode();
                
                System.out.println("Response code :"+responseCode);
                
                StringBuffer response = new StringBuffer();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                
                while(true){
                    String line = br.readLine();
                    
                    if(line == null){
                        break;
                    }
                    
                    response.append(line);
                }
                
                System.out.println(response);
                
                        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(" Program Started ");
        OtpGenerator otp = new OtpGenerator();
        
        String otpMessage = otp.generateOtp(6);
        
        System.out.println("Generated OTP is "+otpMessage);
        
        String apiKey = "NYudIasHf34BmDlFXEOb1zRALQyxStv0TZoi9M26PqVpe8cKCJrQ4KOMgSEkjcoeanzDmp3fTqZA92NH";
        String number = "8606113002";
        
        OtpVerification("Your OTP is "+otpMessage,number,apiKey);
    }
    
}
