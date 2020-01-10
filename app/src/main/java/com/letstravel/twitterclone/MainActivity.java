package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.TwitterAdapter;
import api.TwitterApi;
import model.TwitterModel;
import model.TwitterModelAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private ImageView drawee_user_photo_nav;
private TextView  tv_drawee_name;
private TextView  tv_drawee_username;
private String username,filename,email;
private Button nav_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawee_user_photo_nav=findViewById(R.id.drawee_user_photo_nav);
        tv_drawee_name=findViewById(R.id.tv_drawee_name);
        tv_drawee_username=findViewById(R.id.tv_drawee_username);
        recyclerView=findViewById(R.id.recyclerview_tweets);

        nav_logout=findViewById(R.id.nav_logout);
        nav_logout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, IntroductionActivity.class);
                startActivity(intent);
            }
        } );


        TwitterApi twitterApi= Url.getInstance().create( TwitterApi.class );
        Call<TwitterModelAPI> twitterModelAPICall= twitterApi.getUsersById( Url.id );
        twitterModelAPICall.enqueue( new Callback<TwitterModelAPI>() {
            @Override
            public void onResponse(Call<TwitterModelAPI> call, Response<TwitterModelAPI> response) {
                if(!response.isSuccessful()){
                    Toast.makeText( MainActivity.this, response.code(), Toast.LENGTH_SHORT ).show();
                    return;
                }else{
                    String imgpath = Url.base_url + response.body().getFilename();
                    StrictMode();
                    try{
                        URL url = new URL(imgpath);
                        drawee_user_photo_nav.setImageBitmap( BitmapFactory.decodeStream((InputStream) url.getContent()));
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_drawee_name.setText(response.body().getUsername());
                    tv_drawee_username.setText(response.body().getEmail());


                }
            }

            @Override
            public void onFailure(Call<TwitterModelAPI> call, Throwable t) {
                Toast.makeText( MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );


        List<TwitterModel> twitterModelList = new ArrayList<>();
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Maheswor", "@Maheswor","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Karan", "@Karan","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Raman", "@Raman","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Giriraj", "@Giriraj","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Manish", "@Manish","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Prabin", "@Prabin","Twitter Integration allows you to easily create."));

        TwitterAdapter twitterAdapter=new TwitterAdapter(this, twitterModelList);
        recyclerView.setAdapter(twitterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }
}
