package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_name, et_email;
    private Button btn_create;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );

        et_name = findViewById( R.id.et_name );
        et_email = findViewById( R.id.et_username );
        btn_create = findViewById( R.id.btn_create );

        btn_create.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty( et_name.getText().toString() )) {
                    et_name.setError( "Enter Nname" );
                    et_name.requestFocus();
                    return;
                } else if (et_name.length() < 3) {
                    et_name.setError( "at least 3 characters" );
                    et_name.requestFocus();
                    return;
                } else if (TextUtils.isEmpty( et_email.getText().toString() )) {
                    et_email.setError( "Enter Email" );
                    et_email.requestFocus();
                    return;
                } else if (!et_email.getText().toString().trim().matches( emailPattern )) {
                    et_email.setError( "Invalid email address" );
                    et_email.requestFocus();
                    return;
                }


                String name = et_name.getText().toString().trim();
                String email = et_email.getText().toString().trim();
//                System.out.println( name );
//                System.out.println( email );

                Intent intent = new Intent( SignUpActivity.this, CustomizeActivity.class );
                intent.putExtra( "name", name );
                intent.putExtra( "email", email );
                startActivity( intent );
            }
        } );

    }
}
