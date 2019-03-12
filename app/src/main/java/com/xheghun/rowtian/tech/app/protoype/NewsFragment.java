package com.xheghun.rowtian.tech.app.protoype;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xheghun.rowtian.tech.app.protoype.projects.Project;
import com.xheghun.rowtian.tech.app.protoype.projects.ProjectRecyclerAdapater;
import com.xheghun.rowtian.tech.app.protoype.stories.Stories;
import com.xheghun.rowtian.tech.app.protoype.stories.TopStoryRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    RecyclerView storiesRecyclerView;
    LinearLayoutManager storiesLayoutManager;
    RecyclerView projectsRecyclerView;
    LinearLayoutManager projectsLayoutManager;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.rtp_news_fragment, container, false);
        setupTopStories(view);
        setupProjects(view);
        return view;
    }

    private void setupTopStories(View view) {
        String storyTitles[] = getResources().getStringArray(R.array.rtp_story_titles);
        String storyTxt[] = getResources().getStringArray(R.array.rtp_story_texts);
        int storyImg[] = {R.drawable.a1,R.drawable.a2,
            R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7};

        List<Stories> stories = new ArrayList<>();
        for (int i = 0; i < storyTitles.length; i++) {
            Stories story = new Stories();
            story.storyTitle = storyTitles[i];
            story.storyText = storyTxt[i];
            story.storyImage = storyImg[i];

            stories.add(story);
        }

        storiesLayoutManager = new LinearLayoutManager(getContext());
        storiesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        storiesRecyclerView = view.findViewById(R.id.rtp_story_rc);
        storiesRecyclerView.setLayoutManager(storiesLayoutManager);
        storiesRecyclerView.setHasFixedSize(true);
        storiesRecyclerView.setAdapter(new TopStoryRecyclerAdapter(stories,view.getContext()));
    }

    private void setupProjects(View view) {
        String projectNames[] = getResources().getStringArray(R.array.rtp_project_names);
        String projectDesc[] = getResources().getStringArray(R.array.rtp_project_desc);
        int projectIcons[] = {R.drawable.p1, R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
            R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,
            R.drawable.p12};

        List<Project> project = new ArrayList<>();
        for (int i = 0; i < projectNames.length;i++) {
            Project project1 = new Project();
            project1.projectName = projectNames[i];
            project1.projectInfo = projectDesc[i];
            project1.projectIcon = projectIcons[i];

            project.add(project1);
        }

        projectsRecyclerView = view.findViewById(R.id.rtp_projects_rc);
        projectsLayoutManager = new LinearLayoutManager(getContext());
        projectsLayoutManager.setOrientation(RecyclerView.VERTICAL);
        projectsRecyclerView.setLayoutManager(projectsLayoutManager);
        projectsRecyclerView.setHasFixedSize(true);
        projectsRecyclerView.setAdapter(new ProjectRecyclerAdapater(project,view.getContext()));
    }
}