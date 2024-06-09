package qlhdnk.util;

import java.util.Random;

public class RandomCode {
    private static String numberString="0123456789"; 
    
    public static String randomCode(){
        Random rd = new Random();
        String output="";
        int index;
        for(int i=0;i<4;++i){
             index = rd.nextInt(0,numberString.length());
             output=output + numberString.charAt(index);
            
        }
        return output;
    }
}
