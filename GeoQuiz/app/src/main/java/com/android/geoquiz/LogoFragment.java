package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LogoFragment extends Fragment {

     String mUserName;
        private EditText mUserView;
        private Button nextButton;



    public LogoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logo, container, false);

        mUserView = (EditText) view.findViewById(R.id.userText);
        nextButton = (Button) view.findViewById(R.id.next_button);

            nextButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    StartFragment fragment = new StartFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        return view;
    }


}
