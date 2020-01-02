package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity {

    private TextView tv_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin );

        tv_sign_up=findViewById(R.id.tv_sign_up);

        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( SigninActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
