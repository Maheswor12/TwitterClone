package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.letstravel.twitterclone.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.TwitterModel;

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.TwitterViewHolder> {

    Context mContext;
    List<TwitterModel> twitterModelList;

    public TwitterAdapter( Context mContext, List<TwitterModel> twitterModelList){
        this.mContext=mContext;
        this.twitterModelList=twitterModelList;
    }

    @NonNull
    @Override
    public TwitterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout_tweet, parent, false);

        return new TwitterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwitterViewHolder holder, int position) {

        TwitterModel twitterModel=twitterModelList.get(position);
        holder.profile_image.setImageResource(twitterModel.getProfile_image());
        holder.txtname.setText(twitterModel.getName());
        holder.txtusername.setText(twitterModel.getUsername());
        holder.txttweet.setText(twitterModel.getTweet());
    }

    @Override
    public int getItemCount() {
        return twitterModelList.size();
    }

    public class TwitterViewHolder extends RecyclerView.ViewHolder {


        private CircleImageView profile_image;
        private TextView txtname, txtusername, txttweet;

        public TwitterViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_image=itemView.findViewById(R.id.profile_photo);
            txtname=itemView.findViewById(R.id.tv_name);
            txtusername=itemView.findViewById(R.id.tv_username);
            txttweet=itemView.findViewById(R.id.tv_tweet_text);

        }
    }
}
