package com.mycompany.quanlynhahang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LeAnhQuan
 */
public class CheckHopLe {
    public static boolean checkSoDienThoai(String sdt){
        Pattern pattern = Pattern.compile("^0[0-9]{9}$");
        Matcher matcher = pattern.matcher(sdt);
        
        return matcher.find();
    }
    
    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&’+\\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)$");
        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();
    }
}
