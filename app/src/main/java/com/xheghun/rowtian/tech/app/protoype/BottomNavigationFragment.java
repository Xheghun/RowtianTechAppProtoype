package com.xheghun.rowtian.tech.app.protoype;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Transition;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.Objects;


public class BottomNavigationFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.rtp_menu_bottom_toolbar, menu);
        if (menu.hasVisibleItems()) {
            Toast.makeText(getContext(),"Yasss",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rtp_search:
                Toast.makeText(getContext(),"Search", Toast.LENGTH_SHORT)
                .show();
                break;
            case R.id.rtp_setting:
                Toast.makeText(getContext(),"Setting",Toast.LENGTH_SHORT)
                .show();
                break;
            case R.id.rtp_check_for_updates:
                Toast.makeText(getContext(),"Updates",Toast.LENGTH_SHORT)
                .show();
                break;
        }
        return true;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rtp_bottom_navigation_fragment, container, false);
        FragmentTransaction transaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rtp_tab_layout_container, new TabLayoutFragment());
        transaction.commit();
        final BottomAppBar bottomAppBar = view.findViewById(R.id.rtp_bottom_app_bar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animationSet = new AnimatorSet();
                AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
                BottomNavigationDrawerFragment bottomNavigationDrawerFragment = new BottomNavigationDrawerFragment();
                ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationY", (float) 3.0);
                animator.setDuration(2000);
                animationSet.setInterpolator(accelerateInterpolator);
                animationSet.play(animator);

                bottomNavigationDrawerFragment.setEnterTransition(accelerateInterpolator);
                bottomNavigationDrawerFragment.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(),bottomNavigationDrawerFragment.getTag());

            }
        });

        return view;
    }
}
