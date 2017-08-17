package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {

    private ImageButton mremovefriend;
    private ListView mfriends;
    private String tempKeyfriend;
    ArrayList<DataModelFriend> dataModelsfriend = new ArrayList<DataModelFriend>();
    private List<String> keyarrafriend = new ArrayList<>();


    private ListAdapterFriend adapterfriend;

    DatabaseReference mfriendRef;
    DatabaseReference mDatabaseFriend;

    public static String friendname;

    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
            View view = inflater.inflate(R.layout.fragment_friend, container, false);
            mfriends = (ListView) view.findViewById(R.id.friend);
           mremovefriend = (ImageButton) view.findViewById(R.id.friend_remove);


            displayFriends();

            return view;
        }


    public void displayFriends(){
        mfriendRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/users/"
                + LogoFragment.logtext + "/friends/");

        adapterfriend = new ListAdapterFriend(dataModelsfriend, getActivity(), FriendFragment.this);
        mfriends.setAdapter(adapterfriend);

        mfriendRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapShot : dataSnapshot.getChildren()) {

                    String friendusername = (String) childSnapShot.child("username").getValue();
                  //  String friendname = (String) childSnapShot.child("name").getValue();
                   // String friendlastname = (String) childSnapShot.child("surname").getValue();
                    String friendscore= (String) childSnapShot.child("highscore").getValue();


                    tempKeyfriend = dataSnapshot.child(childSnapShot.getKey()).getKey().toString();
                    Log.d("keditemp", tempKeyfriend);

                    keyarrafriend.add(tempKeyfriend);
                    Log.d("kedi", String.valueOf(keyarrafriend));


                    dataModelsfriend.add(new DataModelFriend(friendusername, friendname, null,null));
                    mfriendRef.orderByChild("friendscore");
                    adapterfriend.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    public void removeFriend(int position) {
        DataModelFriend toRemovefriend = adapterfriend.getItem(position);
        adapterfriend.remove(toRemovefriend);
        adapterfriend.notifyDataSetChanged();
        Log.d("kediremove", keyarrafriend.get(position));
        mfriendRef.child(keyarrafriend.get(position)).removeValue();
        FriendFragment fragment = new FriendFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }



    public void invitePlay(){

    }

}