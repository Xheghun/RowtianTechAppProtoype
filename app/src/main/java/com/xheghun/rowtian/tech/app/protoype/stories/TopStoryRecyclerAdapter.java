package com.xheghun.rowtian.tech.app.protoype.stories;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.xheghun.rowtian.tech.app.protoype.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopStoryRecyclerAdapter extends RecyclerView.Adapter<StoryCardViewHolder> {

    private List<Stories> story;
    private Context context;
    public TopStoryRecyclerAdapter(List<Stories> stories, Context context) {
        this.context = context;
        this.story = stories;
    }

    @NonNull
    @Override
    public StoryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rtp_top_story_item,parent,false);
        return  new StoryCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryCardViewHolder holder, int position) {
        Stories stories = story.get(position);
        holder.mStoryTitle.setText(stories.storyTitle);
        holder.mStoryText.setText(stories.storyText);
        Glide.with(context).load(stories.storyImage).into(holder.mStoryImage);
        //holder.mStoryImage.setImageResource(stories.storyImage);
        Log.v("SSSH","BinVHol");
    }
    @Override
    public int getItemCount() {
        return story.size();
    }
}
class StoryCardViewHolder extends RecyclerView.ViewHolder {
     TextView mStoryTitle;
     TextView mStoryText;
     ImageView mStoryImage;

    public StoryCardViewHolder(@NonNull View itemView) {
        super(itemView);
        mStoryTitle = itemView.findViewById(R.id.rtp_story_title);
        mStoryText = itemView.findViewById(R.id.rtp_story_text);
        mStoryImage = itemView.findViewById(R.id.rtp_story_image);
    }
}