package top.lc951.demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.leo.gesturelibrary.enums.LockMode;
import com.leo.gesturelibrary.util.ConfigUtil;

import top.lc951.demos.util.ToastUtil;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
