package com.letstravel.twitterclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import adapter.TwitterAdapter;
import model.TwitterModel;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview_tweets);

        List<TwitterModel> twitterModelList = new ArrayList<>();
        twitterModelList.add(new TwitterModel(R.drawable.male, "RM", "raman10","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));
        twitterModelList.add(new TwitterModel(R.drawable.female, "Tirtha", "tirtha12","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));
        twitterModelList.add(new TwitterModel(R.drawable.male, "Greatly", "greatly11","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));
        twitterModelList.add(new TwitterModel(R.drawable.female, "Ramila", "ramila13","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));
        twitterModelList.add(new TwitterModel(R.drawable.male, "Dhiren", "dhiren14","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));
        twitterModelList.add(new TwitterModel(R.drawable.female, "Gita", "gita15","Twitter Integration allows you to easily create Twitter bots with natural language understanding based on the Dialogflow technology."));

        TwitterAdapter twitterAdapter=new TwitterAdapter(this, twitterModelList);
        recyclerView.setAdapter(twitterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }
}
