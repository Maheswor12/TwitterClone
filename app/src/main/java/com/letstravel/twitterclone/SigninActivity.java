package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import api.TwitterApi;
import model.ResponsFromAPI;
import model.TwitterModelAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class SigninActivity extends AppCompatActivity {

    private TextView tv_sign_up;
    private EditText et_username, et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signin );

        tv_sign_up = findViewById( R.id.tv_sign_up );
        btn_login = findViewById( R.id.btn_login );
        et_username = findViewById( R.id.et_username );
        et_password = findViewById( R.id.et_password );

        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TwitterApi twitterApi= Url.getInstance().create( TwitterApi.class );
                    Call<ResponsFromAPI> responsFromAPICall= twitterApi.login( et_username.getText().toString().trim(),et_password.getText().toString().trim() );
                    responsFromAPICall.enqueue( new Callback<ResponsFromAPI>() {
                        @Override
                        public void onResponse(Call<ResponsFromAPI> call, Response<ResponsFromAPI> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText( SigninActivity.this, response.code(), Toast.LENGTH_SHORT ).show();
                                return;
                            }else {
                                if(response.body().getStatus()){
                                    Url.accessToken = response.body().getAccessToken();
                                    Url.id = response.body().getId();
                                    Toast.makeText( SigninActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT ).show();
                                    Intent intent=new Intent( SigninActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText( SigninActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT ).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponsFromAPI> call, Throwable t) {
                            Toast.makeText( SigninActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT ).show();
                        }
                    } );

            }
        } );

        tv_sign_up.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SigninActivity.this, SignUpActivity.class );
                startActivity( intent );
            }
        } );
    }
}
