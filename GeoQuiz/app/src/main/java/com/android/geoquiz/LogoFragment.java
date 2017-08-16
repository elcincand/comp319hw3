package com.android.geoquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LogoFragment extends Fragment {

    private EditText mUserView;
    private EditText mUserPass;
    public static String logtext;
    TextView doyou;

    Button log;



    public LogoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logo, container, false);

        mUserView = (EditText) view.findViewById(R.id.userText);
        mUserPass = (EditText) view.findViewById(R.id.passwordText);

        log = (Button) view.findViewById(R.id.loglog);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        doyou = (TextView) view.findViewById(R.id.doyou);


        doyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpFragment fragment = new SignUpFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer2, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        });


        return view;
    }

    public void loginUser() {

        DatabaseReference mlogRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/users/");
        mlogRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                logtext = mUserView.getText().toString();
                String logpass = mUserPass.getText().toString();

                if (dataSnapshot.child(logtext).exists()) {

                    if (dataSnapshot.child(logtext).child("password").getValue().toString().equals(logpass)) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);

                    }else {

                        Toast.makeText(getActivity(), "Wrong password!",
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "This user does not exist!",
                            Toast.LENGTH_LONG).show();


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }


}
