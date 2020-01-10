package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.TwitterApi;
import model.ResponsFromAPI;
import model.TwitterModelAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class DescribeActivity extends AppCompatActivity {

    private Button btn_describe;
    private EditText et_name;
    private String username,emailaddress,propassword,filemane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);
        et_name=findViewById( R.id.et_name );


        Bundle profileBundle = getIntent().getExtras();
        if (profileBundle != null) {
            username = profileBundle.getString( "pname1" );
            emailaddress = profileBundle.getString( "pemail1" );
            propassword = profileBundle.getString( "password1" );
            filemane = profileBundle.getString( "filename1" );
        }


        System.out.println(filemane+"");
        btn_describe=findViewById(R.id.btn_describe);
        btn_describe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwitterModelAPI twitterModelAPI = new TwitterModelAPI();
                twitterModelAPI.setEmail( emailaddress );
                twitterModelAPI.setPassword( propassword );
                twitterModelAPI.setFilename( filemane );
                twitterModelAPI.setBio( et_name.getText().toString().trim() );
                twitterModelAPI.setUsername( username );
                TwitterApi twitterApi= Url.getInstance().create( TwitterApi.class );
                Call<ResponsFromAPI> voidCall= twitterApi.register( twitterModelAPI );

                voidCall.enqueue( new Callback<ResponsFromAPI>() {
                    @Override
                    public void onResponse(Call<ResponsFromAPI> call, Response<ResponsFromAPI> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText( DescribeActivity.this, response.code(), Toast.LENGTH_SHORT ).show();
                            return;
                        }else {
                            if(response.body().getStatus()){
                                Toast.makeText( DescribeActivity.this, response.body().getMessage()+"", Toast.LENGTH_SHORT ).show();
                                Intent intent=new Intent(DescribeActivity.this, SyncContactActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText( DescribeActivity.this, response.body().getMessage()+"", Toast.LENGTH_SHORT ).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsFromAPI> call, Throwable t) {
                        Toast.makeText( DescribeActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT ).show();

                    }
                } );


            }
        });
    }
}
