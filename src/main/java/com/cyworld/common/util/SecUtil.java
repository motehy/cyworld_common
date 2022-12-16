package com.cyworld.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.security.MessageDigest;

/**
 *
* <pre>
* 간략 : .SHA-512 암호화 : TODO 사용 안할시 삭제
* 상세 : .
* com.coway.common.util
*   |_ SecUtil.java
* </pre>
*
* @Company : DGIST
* @Author  : junghee
* @Date    : 2018. 11. 29. 오전 10:39:28
* @Version : 1.0
 */
@Slf4j
public class SecUtil {

   public static String SHA512(String tmpStr){
       String encodedStr = null;
       try {
           //SHA-512 적용
           MessageDigest md = MessageDigest.getInstance("SHA-512");
           md.update(tmpStr.getBytes());
           byte[] msgb = md.digest();

           StringBuffer sb = new StringBuffer();

           for(int i = 0; i < msgb.length; i++){
               byte temp = msgb[i];
               String str = Integer.toHexString(temp & 0xFF);
               while(str.length() < 2){
                   str = "0" + str;
               }
               str = str.substring(str.length() - 2);

               sb.append(str);
               encodedStr = sb.toString();
           }
       } catch (Exception e) {
           log.error(ExceptionUtils.getStackTrace(e));
       }
       return encodedStr;
   }

   //TODO BASE64 암호화 확인 => JWT 적용 확인
   public static String encodeBase64(String str) {
       return Base64.encodeBase64String(StringUtils.getBytesUtf8(str));
   }

   public static String decodeBase64(String str) throws IOException {
       return StringUtils.newStringUtf8(Base64.decodeBase64(str));
   }

   public static String encryptSha256(final String keys, final String data) {
      return toBase64String(HmacUtils.getHmacSha256(keys.getBytes()).doFinal(data.getBytes()));
  }

  public static String toBase64String(byte[] bytes) {
      byte[] byteArray = Base64.encodeBase64(bytes);
      return new String(byteArray);
  }
}