package top.lc951.demos.util;

import android.content.Context;

import com.leo.gesturelibrary.util.ConfigUtil;

import static top.lc951.demos.MainActivity.PASS_KEY;

/**
 * Created by leo on 16/4/5.
 */
public class PasswordUtil {

    /**
     * 获取设置过的密码
     */
    public static String getPin(Context context) {
        String password = ConfigUtil.getInstance(context).getString(PASS_KEY);
        return password;
    }
}
