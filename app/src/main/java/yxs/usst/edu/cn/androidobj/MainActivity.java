package yxs.usst.edu.cn.androidobj;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userPwd;
    Button login;
    Button clear;
    boolean flag = false;
    Button changeView;
    TextView imgName;
    FrameLayout background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.inputUserName);
        userPwd = (EditText) findViewById(R.id.inputUserPwd);
        userPwd.setLeft(userName.getLeft());

        login = (Button) findViewById(R.id.loginBtn);
        clear = (Button) findViewById(R.id.clearBtn);
        changeView = (Button) findViewById(R.id.changeBtn);
        imgName = (TextView) findViewById(R.id.imageName);
        background = (FrameLayout) findViewById(R.id.backgroundImg);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0) {
                    flag = true;
                } else {
                    flag = false;
                }
                login.setEnabled(flag);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        userPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0) {
                    flag = true;
                } else {
                    flag = false;
                }
                clear.setEnabled(flag);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        if(flag) {
            login.setEnabled(true);
            clear.setEnabled(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = userName.getText().toString().trim();
                String uPwd = userPwd.getText().toString().trim();
                TextView content = (TextView) findViewById(R.id.showContent);
                content.setText("user name is" + uName + " and user passwd is " + uPwd);
                Log.i("login", content.getText().toString());
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName.setText("");
                userPwd.setText("");
                Log.i("clear", "clear username and password");
            }
        });

        changeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = imgName.getText().toString();
                if(name.equals("芙兰朵露")) {
                    background.setBackgroundResource(R.drawable.bilibili);
                    imgName.setText("bilibili");
                } else if(name.equals("bilibili")) {
                    background.setBackgroundResource(R.drawable.show);
                    imgName.setText("芙兰朵露");
                }
                imgName.setTextColor(Color.WHITE);
            }
        });

    }
}
