package com.xheghun.rowtian.tech.app.protoype.projects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.xheghun.rowtian.tech.app.protoype.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProjectRecyclerAdapater extends RecyclerView.Adapter<ViewHolder> {
    List<Project> mProject;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rtp_project_list_item,parent,false);
        return new ViewHolder(view);
    }

    public ProjectRecyclerAdapater(List<Project> mProject,Context context) {
        this.mProject = mProject;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project project = mProject.get(position);
        holder.projectName.setText(project.projectName);
        holder.projectInfo.setText(project.projectInfo);
        Glide.with(context).load(project.projectIcon).into(holder.projectIcon);
    }

    @Override
    public int getItemCount() {
        return mProject.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView projectName;
    TextView projectInfo;
    CircleImageView projectIcon;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        projectName = itemView.findViewById(R.id.rtp_project_title);
        projectInfo = itemView.findViewById(R.id.rtp_project_info);
        projectIcon = itemView.findViewById(R.id.rtp_project_icon);
    }
}
