package com.evo.sp.common.aop;

import com.evo.sp.common.aop.SpLogAspectJ;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class IpUtil {

    public final static String ERROR_IP = "127.0.0.1";

    private static final Logger logger = LoggerFactory.getLogger(SpLogAspectJ.class);

    public final static Pattern pattern = Pattern.
            compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");

    /**
     * 取外网IP
     *
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
       /* X-Forwarded-For: 1.1.1.1, 2.2.2.2, 3.3.3.3
        代表 请求由1.1.1.1发出，经过三层代理，第一层是2.2.2.2，第二层是3.3.3.3，而本次请求的来源IP4.4.4.4是第三层代理
        而X-Real-IP，一般只记录真实发出请求的客户端IP，上面的例子，如果配置了X-Read-IP，将会是
        X-Real-IP: 1.1.1.1
        所以 ，如果只有一层代理，这两个头的值就是一样的
        */

        String ip = request.getHeader("x-real-ip");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        //过滤反向代理的ip
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1) {
            //得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }

        ip = ip.trim();
        if (ip.length() > 23) {//取22位网络地址
            ip = ip.substring(0, 23);
        }

        return ip;
    }

    /**
     * 获取用户的真实ip
     *
     * @param request
     * @return
     */
    public static String getUserIP(HttpServletRequest request) {

        // 优先取X-Real-IP
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = ERROR_IP;
            }
        }

        if ("unknown".equalsIgnoreCase(ip)) {
            ip = ERROR_IP;
            return ip;
        }

        int pos = ip.indexOf(',');
        if (pos >= 0) {
            ip = ip.substring(0, pos);
        }

        return ip;
    }

    public static String getLastIpSegment(HttpServletRequest request) {
        String ip = getUserIP(request);
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static boolean isValidIP(HttpServletRequest request) {
        String ip = getUserIP(request);
        return isValidIP(ip);
    }

    /**
     * 判断我们获取的ip是否是一个符合规则ip
     *
     * @param ip
     * @return
     */
    public static boolean isValidIP(String ip) {
        if (StringUtils.isEmpty(ip)) {
            logger.debug("ip is null. valid result is false");
            return false;
        }

        Matcher matcher = pattern.matcher(ip);
        boolean isValid = matcher.matches();
        logger.debug("valid ip:" + ip + " result is: " + isValid);
        return isValid;
    }

    public static String getLastServerIpSegment() {
        String ip = getServerIP();
        if (ip != null) {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else {
            ip = "0";
        }
        return ip;
    }

    public static String getServerIP() {
        InetAddress inet;
        try {
            inet = InetAddress.getLocalHost();
            String hostAddress = inet.getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "127.0.0.1";
    }
}