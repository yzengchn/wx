package com.yzeng.utils.wx;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.yzeng.constans.WxConstans;

/**
 * 微信签名验证
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class SignUtil {
	public static boolean checkSignature(String signature, String timestamp, String nonce)
    {
        
        String[] ckArr = new String[] {WxConstans.TOKEN, timestamp, nonce};
        
        Arrays.sort(ckArr);
        
        StringBuilder ckStr = new StringBuilder();
        
        for (int i = 0; i < ckArr.length; i++)
        {
            ckStr.append(ckArr[i]);
        }
        
        MessageDigest md = null;
        
        String tmpStr = null;
        
        try
        {
            md = MessageDigest.getInstance("SHA-1");
            
            byte[] digest = md.digest(ckStr.toString().getBytes());
            
            tmpStr = bytesToStr(digest);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        ckStr = null;
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }
    
    /**
     * @param digest
     * @return
     * @Description:
     */
    private static String bytesToStr(byte[] digest)
    {
        StringBuilder digStr = new StringBuilder();
        for (int i = 0; i < digest.length; i++)
        {
            digStr.append(byteToHexStr(digest[i]));
        }
        return digStr.toString();
    }
    
    /**
     * @param b
     * @return
     * @Description:
     */
    private static String byteToHexStr(byte mByte)
    {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        
        String s = new String(tempArr);
        return s;
    }
}
