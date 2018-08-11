package top.lc951.demos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.leo.gesturelibrary.enums.LockMode;
import com.leo.gesturelibrary.util.ConfigUtil;

public class ScreenStatusReceiver extends BroadcastReceiver {
    String SCREEN_ON = "android.intent.action.SCREEN_ON";
    String SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    @Override
    public void onReceive(Context context, Intent intent) {


        // 屏幕唤醒
        if (SCREEN_ON.equals(intent.getAction())) {
            if (!TextUtils.isEmpty(ConfigUtil.checkPassWord(context)))
                MainActivity.startAction(context, LockMode.VERIFY_PASSWORD);
        }
        // 屏幕休眠
        else if (SCREEN_OFF.equals(intent.getAction())) {

        }
    }
}
