package top.lc951.demos;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.leo.gesturelibrary.enums.LockMode;
import com.leo.gesturelibrary.util.ConfigUtil;

import top.lc951.demos.util.ToastUtil;

public class SettingActivity extends AppCompatActivity {
    // 屏幕状态广播
    ScreenStatusReceiver screenStatusReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

// 屏幕状态广播初始化
        screenStatusReceiver = new ScreenStatusReceiver();
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter screenStatusIF = new IntentFilter();
        screenStatusIF.addAction(Intent.ACTION_SCREEN_ON);
        screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF);
// 注册
        registerReceiver(screenStatusReceiver, screenStatusIF);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(screenStatusReceiver);
    }
    public void setPassWord(View view){
        String pw= checkPassWord();
        if(!TextUtils.isEmpty(pw)) {
            ToastUtil.showMessage(this,"已设置密码，请修改密码！");
            return;
        }
        MainActivity.startAction(this, LockMode.SETTING_PASSWORD);
    }

    private String checkPassWord() {
        return ConfigUtil.getInstance(this).getString(MainActivity.PASS_KEY);
    }

    public void verifyPassword(View view){
        if(TextUtils.isEmpty(checkPassWord())) {
            ToastUtil.showMessage(this,"暂未设置密码，请设置密码！");
            return;
        }
        MainActivity.startAction(this, LockMode.VERIFY_PASSWORD);
    }
    public void changePassword(View view){
        if(TextUtils.isEmpty(checkPassWord())) {
            ToastUtil.showMessage(this,"暂未设置密码，请设置密码！");
            return;
        }
        MainActivity.startAction(this, LockMode.EDIT_PASSWORD);
    }

    public void clearPassword(View view){
        String pw=checkPassWord();
        if(TextUtils.isEmpty(pw)) {
            ToastUtil.showMessage(this,"暂未设置密码，请设置密码！");
            return;
        }
        MainActivity.startAction(this, LockMode.CLEAR_PASSWORD);
    }

}
