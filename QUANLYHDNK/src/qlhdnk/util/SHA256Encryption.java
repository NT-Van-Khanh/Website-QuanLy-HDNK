package qlhdnk.util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SHA256Encryption {
    public static String toSHA256(String str){
        String salt="@ptithcm";
        str= str+salt;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
		
	        byte[] hash=md.digest(str.getBytes(StandardCharsets.UTF_8));
	        StringBuilder hexString = new StringBuilder();
	        for(int index = 0; index<hash.length;index++){
	            String hex = Integer.toHexString(0xff&hash[index]);
	            if(hex.length()==1){
	                hexString.append('0');   
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return null;
    }
}
