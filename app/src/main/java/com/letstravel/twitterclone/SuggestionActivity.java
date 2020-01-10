package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import adapter.FollowAdapter;
import model.TwitterModel;

public class SuggestionActivity extends AppCompatActivity {
    private RecyclerView suggestion_recyclerview;
    private Button btn_follow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_suggestion );

        suggestion_recyclerview=findViewById(R.id.suggestion_recyclerview);
        btn_follow=findViewById(R.id.btn_follow);

        List<TwitterModel> twitterModelList = new ArrayList<>();
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Maheswor", "@Maheswor","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Karan", "@Karan","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Raman", "@Raman","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Giriraj", "@Giriraj","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Manish", "@Manish","Twitter Integration allows you to easily create."));
        twitterModelList.add(new TwitterModel(R.drawable.profilepic, "Prabin", "@Prabin","Twitter Integration allows you to easily create."));

        FollowAdapter followAdapter=new FollowAdapter(this, twitterModelList);
        suggestion_recyclerview.setAdapter(followAdapter);
        suggestion_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuggestionActivity.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
