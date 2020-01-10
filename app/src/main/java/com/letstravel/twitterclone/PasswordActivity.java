package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private Button btn_password;
    private EditText etPassword;
    private String pname, pemail, ppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_password );

        btn_password = findViewById( R.id.btn_password );
        etPassword = findViewById( R.id.et_password );
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            pname = bundle.getString( "regname" );
            pemail = bundle.getString( "regemail" );
        }
//        System.out.println( pname );
//        System.out.println( pemail );

        btn_password.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty( etPassword.getText().toString() )) {
                    etPassword.setError( "Enter Password" );
                    etPassword.requestFocus();
                    return;
                } else if (etPassword.length() < 4 || etPassword.length() > 10) {
                    etPassword.setError( "between 4 and 10 alphanumeric characters" );
                    etPassword.requestFocus();
                    return;
                }
                Intent intent = new Intent( PasswordActivity.this, ProfileActivity.class );
                String password = etPassword.getText().toString().trim();
//                System.out.println( password );
                intent.putExtra( "pname", pname );
                intent.putExtra( "pemail", pemail );
                intent.putExtra( "password", password );
                startActivity( intent );
            }
        } );
    }
}
