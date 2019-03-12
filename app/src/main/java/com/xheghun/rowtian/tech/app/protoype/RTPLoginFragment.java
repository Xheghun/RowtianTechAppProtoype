package com.xheghun.rowtian.tech.app.protoype;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


/**

 */
public class RTPLoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rtp_login, container, false);

        final TextInputLayout accessCodeTextInput = view.findViewById(R.id.rtp_access_code_layout);
        final TextInputEditText accessCodeText = view.findViewById(R.id.rtp_access_code_text);

        /*
        * Not used in app Prototype
        final TextInputLayout clientNameTextInput = view.findViewById(R.id.rtp_client_name_layout);
        final TextInputEditText clientNameText = view.findViewById(R.id.rtp_client_name_text);
        */
        final MaterialButton loginButton = view.findViewById(R.id.rtp_login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!accessCodeiIsValid(accessCodeText.getText())) {
                    accessCodeTextInput.setError(getString(R.string.rtp_access_code_error));
                }else {
                    accessCodeTextInput.setError(null); //clear Error.
                    //startActivity(new Intent(getActivity(), TabLayoutFragment.class));
                    ((NavigationHost) Objects.requireNonNull(getActivity())).navigateTo(new BottomNavigationFragment(), false);
                }
            }
        });
        return view;
    }
    public boolean accessCodeiIsValid(@Nullable Editable text) {
        return text != null && text.length() >= 6;
    }

}
