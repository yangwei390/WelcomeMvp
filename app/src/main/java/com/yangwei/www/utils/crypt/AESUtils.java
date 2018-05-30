/**
 * @Title: AESUtils.java
 * @Package com.jy.modules.platform.ldap.hash.util
 * @Description: AES密码工具类
 * @author luoyr
 * @date 2015年7月22日 下午4:59:57
 * @version V1.0
 */
package com.yangwei.www.utils.crypt;

import com.yangwei.www.net.UrlConfig;

import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author luoyr
 * @ClassName: AESUtils
 * @Description: aes对称加密解密工具类, 注意密钥不能随机生机, 不同客户端调用可能需要考虑不同Provider
 * @date 2015年7月22日 下午4:59:57
 */
public class AESUtils {

    public static final String AES_SECRET = UrlConfig.AES_SECRET;

    /***默认向量常量**/
    public static final String IV = "2015030120123456";

    /**
     * 加密 128位
     *
     * @param content 需要加密的内容
     * @param pkey    加密密码
     * @return
     */
    public static byte[] aesEncrypt(String content, String pkey) {
        try {
            //SecretKey secretKey = generateKey(pkey);
            //byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(pkey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
            return encrypted; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得密钥
     *
     * @param secretKey
     * @return
     * @throws Exception
     */
    private static SecretKey generateKey(String secretKey) throws Exception {
        //防止linux下 随机生成key
        Provider p = Security.getProvider("SUN");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", p);
        secureRandom.setSeed(secretKey.getBytes());
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(secureRandom);
        // 生成密钥
        return kg.generateKey();
    }

    /**
     * @param content
     * @param pkey    长度为16个字符,128位
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: aesEncryptStr
     * @Description: aes对称加密
     */
    public static String aesEncryptStr(String content, String pkey) {
        byte[] aesEncrypt = aesEncrypt(content, pkey);
        String base64EncodeStr = BASE64Encoder.encode(aesEncrypt);
        return base64EncodeStr;
    }

    /**
     * @param content base64处理过的字符串
     * @param pkey
     * @return String    返回类型
     * @throws Exception
     * @throws
     * @Title: aesDecodeStr
     * @Description: 解密 失败将返回NULL
     */
    public static String aesDecodeStr(String content, String pkey) throws Exception {
        byte[] base64DecodeStr = android.util.Base64.decode(content, android.util.Base64.DEFAULT);
//		byte[] base64DecodeStr = Base64.
        byte[] aesDecode = aesDecode(base64DecodeStr, pkey);
        if (aesDecode == null) {
            return null;
        }
        String result = new String(aesDecode, "UTF-8");
        return result;
    }

    /**
     * 解密 128位
     *
     * @param content 待解密内容
     * @param pkey    解密密钥
     * @return
     */
    public static byte[] aesDecode(byte[] content, String pkey) {
        try {
            //SecretKey secretKey = generateKey(pkey);
            //byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(pkey.getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key, iv);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 解密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
