package com.evo.sp.common;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <p>
 *  token
 * </p>
 *
 * @author sgt
 * @since 2019-04-30 09:49
 */
public class SpToken {
    /**
     *
     * 生成token
     */
    public static String getToken(String userId){
        //用户密码加密,加密方式MD5
        ByteSource credentialsSalt = ByteSource.Util.bytes(userId);
        SimpleHash token = new SimpleHash(SpConstantInter.ENCRYPTION_TYPE,userId, credentialsSalt);
        return token.toString();
    }

    /**
     *
     * 对比token
     */
    public static boolean tokenCompare(String userId,String token){
       return  getToken(userId).equals(token);
    }
}
