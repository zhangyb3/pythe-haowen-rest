package com.pythe.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;




public class FactoryUtils {
	/**
	 * 生成UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
/**
	 * 生成M	D5_CODE
	 * @return
	 */
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	// D55C4AC7A4AE1E47E1265BE4B20C1BB2
	//5BEDEBEDAB1AB7FD32DC0AB18F2A0BB4
	  /**
     * 获取签名 md5加密(微信支付必须用MD5加密)
     * 获取支付签名
     * @param params
     * @return
     */
    public static String getSign(SortedMap<String, String> params,String WX_KEY){
        String sign = null;
        StringBuffer sb = new StringBuffer();
        Set es = params.entrySet();
        Iterator iterator = es.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)&& !"key".equals(k)) {
                sb.append(k+"="+v+"&");
            }
        }
        sb.append("key="+WX_KEY);
        System.out.println("============================>sb : " + sb);
//        if (WX_KEY!=null) {
//        	
//		}
      
        sign = FactoryUtils.MD5(sb.toString()).toUpperCase();
        System.out.println("===========================>sign : " + sign);
        return sign;
    }
    
    
  


    /**
     * 参数进行XML化
     * @param map,sign
     * @return
     */
    public static String parseString2Xml(Map<String, String> map,String sign){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = map.entrySet();
        Iterator iterator = es.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            sb.append("<"+k+">"+v+"</"+k+">");
        }
        sb.append("<sign>"+sign+"</sign>");
        sb.append("</xml>");
        return sb.toString();
    }
    
    /**
	 * 得到本地IP地址
	 * 
	 * @return
     * @throws UnknownHostException 
	 */
	public static String getLocalAddress() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}

    
    /**
	 * Message验证码
	 */
	public static String genMessageVerificationCode() {
		//加上三位随机数
		Random random = new Random();
		int code = random.nextInt(9999);
		//如果不足三位前面补0
		String str = String.format("%04d", code);
		
		return str;
	}
    
   

}
