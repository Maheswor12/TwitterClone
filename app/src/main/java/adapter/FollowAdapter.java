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

public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.FollowViewHolder>{

    Context mContext;
    List<TwitterModel> twitterModelList;

    public FollowAdapter( Context mContext, List<TwitterModel> twitterModelList){
        this.mContext=mContext;
        this.twitterModelList=twitterModelList;
    }

    @NonNull
    @Override
    public FollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.follow_suggested, parent, false);
        return new FollowAdapter.FollowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowViewHolder holder, int position) {
        TwitterModel twitterModel=twitterModelList.get(position);
        holder.circleImageView.setImageResource(twitterModel.getProfile_image());
        holder.follow_name.setText(twitterModel.getName());
        holder.follow_username.setText(twitterModel.getUsername());
        holder.follow_tweet.setText(twitterModel.getTweet());
    }

    @Override
    public int getItemCount() {
        return twitterModelList.size();
    }

    public class FollowViewHolder extends RecyclerView.ViewHolder {


        private CircleImageView circleImageView;
        private TextView follow_name, follow_username, follow_tweet;

        public FollowViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView=itemView.findViewById( R.id.circleImageView);
            follow_name=itemView.findViewById( R.id.follow_name);
            follow_username=itemView.findViewById( R.id.follow_username);
            follow_tweet=itemView.findViewById( R.id.follow_tweet);

        }
    }
}
