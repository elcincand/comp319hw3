package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    EditText mnameprofile;
    EditText mlastnameprofile;
    EditText musernameprofile;
    EditText mpassprofile;
    TextView highscore;
    Button changeButton;
    private String tempKeyProfile;
    DatabaseReference mDatabase;

    DatabaseReference databaseReference;
    private List<String> infoarray = new ArrayList<>();


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        if (container != null) {
            container.removeAllViews();

            mnameprofile= (EditText) view.findViewById(R.id.profilename);
            mlastnameprofile= (EditText) view.findViewById(R.id.profilelastname);
            musernameprofile= (EditText) view.findViewById(R.id.profileusername);
            highscore= (TextView) view.findViewById(R.id.profilehighscore);
            changeButton = (Button) view.findViewById(R.id.savechange);
            mpassprofile = (EditText) view.findViewById(R.id.profilepassword);

            databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/users/"
                    + LogoFragment.logtext);

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                        String pusername = (String) dataSnapshot.child("username").getValue();
                        String pname = (String) dataSnapshot.child("name").getValue();
                        String plastname = (String) dataSnapshot.child("surname").getValue();
                        String pscore = (String) dataSnapshot.child("highscore").getValue();
                        String ppass = (String) dataSnapshot.child("password").getValue();

                        tempKeyProfile = dataSnapshot.child(dataSnapshot.getKey()).getKey().toString();
                        Log.d("keditemp", tempKeyProfile);

                        infoarray.add(tempKeyProfile);
                        Log.d("kedi", String.valueOf(infoarray));



                        musernameprofile.setText(pusername);
                        mnameprofile.setText(pname);
                        mlastnameprofile.setText(plastname);
                        highscore.setText("HighScore: "+ pscore);
                        mpassprofile.setText(ppass);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            changeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    savechanges();
                }
            });

        }        return view;
    }

    public void savechanges(){
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/");

        Query lastQuery2 =mDatabase.child("users").child(String.valueOf(LogoFragment.logtext));

        lastQuery2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String username = musernameprofile.getText().toString();
                String name = mnameprofile.getText().toString();
                String surname = mlastnameprofile.getText().toString();
                String pass = mpassprofile.getText().toString();

                mDatabase.child("users").child(String.valueOf(LogoFragment.logtext)).child("username")
                        .setValue(username);

                mDatabase.child("users").child(String.valueOf(LogoFragment.logtext)).child("highscore")
                        .setValue(name);
                mDatabase.child("users").child(String.valueOf(LogoFragment.logtext)).child("surname")
                        .setValue(surname);
                mDatabase.child("users").child(String.valueOf(LogoFragment.logtext)).child("name")
                        .setValue(pass);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });



    }

}
