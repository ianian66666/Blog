package com.ian.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Ian
 * @date 2020/4/18 -  上午 11:58
 */
public class MD5Utils {

        public static String md5(String str) {
            try {

                MessageDigest md = MessageDigest.getInstance("md5");
                byte[] result = md.digest(str.getBytes());
                StringBuffer buffer = new StringBuffer();

                for (byte b : result) {

                    int number = b & 0xff;
                    String s = Integer.toHexString(number);
                    if (s.length() == 1) {
                        buffer.append("0");
                    }
                    buffer.append(s);
                }
                return buffer.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return "";
            }
        }
        public static void main(String [] args){
            System.out.println(md5("1234"));
        }
}
