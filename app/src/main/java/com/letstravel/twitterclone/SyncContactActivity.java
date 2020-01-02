package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SyncContactActivity extends AppCompatActivity {

    private TextView txt_not_now;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_contact);

        txt_not_now=findViewById(R.id.txt_not_now);
        txt_not_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SyncContactActivity.this, InterestActivity.class);
                startActivity(intent);
            }
        });
    }
}
