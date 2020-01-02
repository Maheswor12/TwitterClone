package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordActivity extends AppCompatActivity {

    private Button btn_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        btn_password=findViewById(R.id.btn_password);

        btn_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PasswordActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
