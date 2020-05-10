package com.seckill.seckillservicesystem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ProjectName:innovate-admin
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-9-27下午3:12
 * @Describe: 正则校验工具类
 **/
public class RegularCheckUtils {

    /**
     * 校验手机号
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 校验邮箱
     */
    public static boolean isEmail(String email) {
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
