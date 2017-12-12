package com.pythe.common.utils;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder; 

public class AES {  
	public static boolean initialized = false;  
	
	/**
	 * AES解密
	 * @param content 密文
	 * @return
	 * @throws InvalidAlgorithmParameterException 
	 * @throws NoSuchProviderException 
	 */
	public String decrypt(String encryptedData,String sessionKey,String iv) throws InvalidAlgorithmParameterException {
		
		initialize();
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			
			// 被加密的数据
//	        byte[] dataByte = Base64.decodeBase64(encryptedData.getBytes());
	        byte[] dataByte = base64Decoder.decodeBuffer(encryptedData);
	        // 加密秘钥
//	        byte[] keyByte = base64Decoder.decodeBuffer(sessionKey);
	        // 偏移量
	        byte[] ivByte = base64Decoder.decodeBuffer(iv);
//	        IvParameterSpec ivs = new IvParameterSpec(iv.getBytes()); 

			// 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
//            int base = 16;
//            if (keyByte.length % base != 0) {
//                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
//                byte[] temp = new byte[groups * base];
//                Arrays.fill(temp, (byte) 0);
//                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
//                keyByte = temp;
//            }

            byte[] keyByte = null;
            try {
                byte[] keys = sessionKey.getBytes("UTF-8");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
                sr.setSeed(keys);
                keyGenerator.init(128, sr);
                SecretKey skey = keyGenerator.generateKey();
                keyByte = skey.getEncoded();

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
			Key sKeySpec = new SecretKeySpec(keyByte, "AES");
			
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));
//			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, ivs);

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
            return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();  
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();  
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}  
	
	public static void initialize(){  
        if (initialized) return;  
        Security.addProvider(new BouncyCastleProvider());  
        initialized = true;  
    }
	//生成iv  
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception{  
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");  
        params.init(new IvParameterSpec(iv));  
        return params;  
    }  
}  