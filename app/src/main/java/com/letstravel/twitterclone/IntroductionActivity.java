package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroductionActivity extends AppCompatActivity {

    private TextView tv_login;
    private Button btn_create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction );

        tv_login=findViewById(R.id.tv_login);
        btn_create_account=findViewById(R.id.btn_create_account);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntroductionActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });


        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( IntroductionActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
