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
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    Button sign;
    TextView dontyou;
    EditText musernamefield;
    EditText mnamefield;
    EditText mlastnamefield;
    EditText mpasswordfield;
    private DatabaseReference mDatabase;
    int currID;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        sign = (Button) view.findViewById(R.id.signsign);
        musernamefield= (EditText) view.findViewById(R.id.signusername);
        mnamefield= (EditText) view.findViewById(R.id.signusername);
        mlastnamefield= (EditText) view.findViewById(R.id.signusername);

        mpasswordfield = (EditText) view.findViewById(R.id.signpass);


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //createUser();
                LogoFragment fragment = new LogoFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer2, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        dontyou = (TextView) view.findViewById(R.id.dontyou);

        dontyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoFragment fragment = new LogoFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer2, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        });
        return view;
    }

    public <T> T getLastElement(final Iterable<T> elements) {
        Iterator<T> itr = elements.iterator();
        T lastElement = null;

        while(itr.hasNext()) {
            lastElement=itr.next();
        }

        return lastElement;
    }
   /* public void createUser() {
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/");


        Query lastQuery = mDatabase.child("users").orderByKey();
        lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot lastKitchen = getLastElement(dataSnapshot.getChildren());
                currID = 0;
                if(lastKitchen != null){
                    currID = Integer.parseInt(lastKitchen.getKey()) + 1;
                }
                Log.d("kedi", String.valueOf(currID));
                String username = musernamefield.getText().toString();
                String name = mnamefield.getText().toString();
                String surname = mlastnamefield.getText().toString();
                String pass = mpasswordfield.getText().toString();

                User users = new User(username, name, surname, pass);
                mDatabase.child("kitchens").child(String.valueOf(currID)).setValue(users);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });


    }*/

}
