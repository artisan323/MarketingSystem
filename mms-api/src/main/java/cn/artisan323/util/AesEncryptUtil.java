package cn.artisan323.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AesEncryptUtil {
    /**
     * @Description: 获取KEY对象
     * @Author: shenjie
     * @Date: 2020-2-14
     */
    private static Key generateKey(String key) throws Exception {
        try {
            return new SecretKeySpec(key.getBytes(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 加密
     * @param dataStr
     * @param keyStrs
     * @return
     */
    public static String encrypt(String dataStr, String keyStrs) {
        if (dataStr == null){
            return "";
        }else if ("".equals(dataStr)){
            return "";
        }else {
            String content = "";
            try {
                //加密
                Key key = generateKey(keyStrs);
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] decrypt = cipher.doFinal(dataStr.getBytes());
                //字节数组转16进制
                content = byteArray2HexString(decrypt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return content;
        }
    }

    /**
     * 解密
     * @param content
     * @param keyStrs
     * @return
     */
    public static String decrypt(String content, String keyStrs) {
        if (content == null){
            return null;
        }else if("".equals(content)){
            return "";
        }else {
            String result = "";
            try {
                Key key = generateKey(keyStrs);
                //解密
                Cipher cipher1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher1.init(Cipher.DECRYPT_MODE, key);
                byte[] decrypt2 = cipher1.doFinal(Base64.decodeBase64(content));
                result = new String(decrypt2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * 将16进制转换为二进制
     * @method parseHexStr2Byte
     * @param hexStr
     * @return
     * @throws
     * @since v1.0
     */
    public static byte[] parseHexStr2Byte(String hexStr){
        if(hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 字节数组转为16进制字符串
     * @param bytes 字节数组
     * @return 16进制字符串
     */
    public static String byteArray2HexString(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        //先把byte[] 转换维char[]，再把char[]转换为字符串
        char[] chars = new char[bytes.length * 2]; // 每个byte对应两个字符
        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        for (int i = 0, j = 0; i < bytes.length; i++) {
            chars[j++] = hexDigits[bytes[i] >> 4 & 0x0f]; // 先存byte的高4位
            chars[j++] = hexDigits[bytes[i] & 0x0f]; // 再存byte的低4位
        }

        return new String(chars);
    }



    /**
     * 16进制字符串转字节数组
     * @param hexString 16进制字符串
     * @return 字节数组
     */
    public static byte[] hexString2ByteArray(String hexString) {
        if (hexString == null || "".equals(hexString)) {
            return null;
        }
        //先把字符串转换为char[]，再转换为byte[]
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] bytes = new byte[length];
        String hexDigits = "0123456789ABCDEF";
        for (int i = 0; i < length; i++) {
            int pos = i * 2; // 两个字符对应一个byte
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // 注1
            int l = hexDigits.indexOf(hexChars[pos + 1]); // 注2
            if (h == -1 || l == -1) { // 非16进制字符
                return null;
            }
            bytes[i] = (byte) (h | l);
        }
        return bytes;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        //String str = "15811111111";
//        String str = "字节数组转16进制字符串";
//        String result = null;
//        byte[] bytes = null;
//        long b = System.currentTimeMillis();
//        for(int i=0; i<10000; i++){
//            //result = byteArray2HexString(str.getBytes()); //27
//            result = byteArray2HexString(str.getBytes());    //32
//        }
//        System.out.println("耗时："+(System.currentTimeMillis()-b));

        String result = "T7OWzRR03108AP6048QOyQ==";
        System.out.println("result："+result);
        int  str = AesEncryptUtil.decrypt(result, "192006250b4c0924").length();
        System.out.printf("str = " + str);
        System.out.printf(AesEncryptUtil.decrypt(result, "192006250b4c0924"));
    }

}
