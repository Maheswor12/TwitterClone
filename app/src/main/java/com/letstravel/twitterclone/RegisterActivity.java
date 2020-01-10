package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private EditText rname, remail;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        btn_register = findViewById( R.id.btn_register );
        rname = findViewById( R.id.rName );
        remail = findViewById( R.id.remail );


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            rname.setText( bundle.getString( "cname" ) );
            remail.setText( bundle.getString( "cemail" ) );

        }


        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty( rname.getText().toString() )) {
                    rname.setError( "Enter Nname" );
                    rname.requestFocus();
                    return;
                } else if (rname.length() < 3) {
                    rname.setError( "at least 3 characters" );
                    rname.requestFocus();
                    return;
                } else if (TextUtils.isEmpty( remail.getText().toString() )) {
                    remail.setError( "Enter Email" );
                    remail.requestFocus();
                    return;
                } else if (!remail.getText().toString().trim().matches( emailPattern )) {
                    remail.setError( "Invalid email address" );
                    remail.requestFocus();
                    return;
                }
                String regname = rname.getText().toString().trim();
                String regemail = remail.getText().toString().trim();
                Intent intent = new Intent( RegisterActivity.this, PasswordActivity.class );
                intent.putExtra( "regname", regname );
                intent.putExtra( "regemail", regemail );
                startActivity( intent );

            }
        } );
    }
}
