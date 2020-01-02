package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DescribeActivity extends AppCompatActivity {

    private Button btn_describe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);

        btn_describe=findViewById(R.id.btn_describe);
        btn_describe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DescribeActivity.this, SyncContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
