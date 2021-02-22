/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otpverification;

import java.util.Random;

/**
 *
 * @author hackphiles
 */
public class OtpGenerator {
    /*public static void main(String[] args){
        String otp = generateOtp(100);
          System.out.println(otp);
    }*/
    public static String generateOtp(int otpLength){
        Random random = new Random();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<otpLength;i++){
            sb.append(random.nextInt(10));
        }
        String otp = sb.toString();
        
        return otp;
    }
}
