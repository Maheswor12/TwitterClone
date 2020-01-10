package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterestActivity extends AppCompatActivity {

    private Button btn_interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        btn_interest=findViewById(R.id.btn_interest);
        btn_interest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InterestActivity.this, SuggestionActivity.class);
                startActivity(intent);
            }
        } );
    }
}
