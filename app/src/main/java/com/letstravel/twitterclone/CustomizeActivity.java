package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomizeActivity extends AppCompatActivity {

    private Button btn_customize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        btn_customize=findViewById(R.id.btn_customize);

        btn_customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomizeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
