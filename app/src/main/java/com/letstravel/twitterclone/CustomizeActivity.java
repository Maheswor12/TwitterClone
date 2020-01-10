package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomizeActivity extends AppCompatActivity {

    private Button btn_customize;
    private String cname, cemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_customize );

        btn_customize = findViewById( R.id.btn_customize );
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            cname = bundle.getString( "name" );
            cemail = bundle.getString( "email" );

        }
//            System.out.println( cname );
//            System.out.println( cemail );
        btn_customize.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( CustomizeActivity.this, RegisterActivity.class );
                intent.putExtra( "cname", cname );
                intent.putExtra( "cemail", cemail );
                startActivity( intent );
            }
        } );
    }
}
