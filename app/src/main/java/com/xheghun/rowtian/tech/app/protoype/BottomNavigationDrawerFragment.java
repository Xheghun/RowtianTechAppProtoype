package com.xheghun.rowtian.tech.app.protoype;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomNavigationDrawerFragment extends BottomSheetDialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false);

        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.rtp_account:
                        Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "Account",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.rtp_join_us:
                        Snackbar.make(view,"Join Us",Snackbar.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.rtp_test:
                        Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        return view;
    }

}
