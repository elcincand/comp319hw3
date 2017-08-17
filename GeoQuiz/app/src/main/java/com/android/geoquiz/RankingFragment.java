package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {
    private ImageButton maddfriendrank;
    private ListView mrank;
    private String tempKeyrank;
    ArrayList<DataModelRank> dataModelsRank = new ArrayList<DataModelRank>();
    private List<String> keyarrayrank = new ArrayList<>();

    private ListAdapterRank adapterrank;

    DatabaseReference mrankRef;
    DatabaseReference mDatabaseRank;
    DatabaseReference mDatabaseFriend;

    public static String friendusernamerank;
    public static String friendnamerank;
    public static String friendsurnamerank;
    public static String friendscorerank;


    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        if (container != null) {
            container.removeAllViews();
        }

        mrank = (ListView) view.findViewById(R.id.ranklst);
        maddfriendrank = (ImageButton) view.findViewById(R.id.addfriendrank);
        displayRanks();
        return view;
    }



    public void displayRanks(){
        mrankRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/users/");

        adapterrank = new ListAdapterRank(dataModelsRank, getActivity(), RankingFragment.this);
         mrank.setAdapter(adapterrank);


       Query mrankquery = mrankRef.orderByChild("highscore").limitToLast(10);

        mrankquery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapShot : dataSnapshot.getChildren()) {

                    String rankusername = (String) childSnapShot.child("username").getValue();
                    String rankscore = (String) childSnapShot.child("highscore").getValue();
                    String rankname = (String) childSnapShot.child("name").getValue();
                    String ranklastname = (String) childSnapShot.child("surname").getValue();

                    tempKeyrank = dataSnapshot.child(childSnapShot.getKey()).getKey().toString();
                    Log.d("keditemp", tempKeyrank);

                    keyarrayrank.add(tempKeyrank);
                    Log.d("kedi", String.valueOf(keyarrayrank));


                    dataModelsRank.add(new DataModelRank(rankusername, rankscore, rankname, ranklastname));
                    adapterrank.notifyDataSetChanged();



                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }



    public <T> T getLastElement(final Iterable<T> elements) {
        Iterator<T> itr = elements.iterator();
        T lastElement = null;

        while(itr.hasNext()) {
            lastElement=itr.next();
        }

        return lastElement;
    }

    public void addFriendList(final int position){

        mrankRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String a = keyarrayrank.get(position);
                friendusernamerank = (String) dataSnapshot.child(a).child("username").getValue();
                friendnamerank = (String) dataSnapshot.child(a).child("name").getValue();
                friendsurnamerank= (String) dataSnapshot.child(a).child("surname").getValue();
                friendscorerank = (String) dataSnapshot.child(a).child("highscore").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        mDatabaseFriend = FirebaseDatabase.getInstance().getReference();


        Query lastQuery2 =mDatabaseFriend.child("users").child(String.valueOf(LogoFragment.logtext)).child("friends");

        lastQuery2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot friendslist = getLastElement(dataSnapshot.getChildren());
                int friendsnum = 0;
                if(friendslist != null){
                    friendsnum = Integer.parseInt(friendslist.getKey()) + 1;
                }
                Log.d("kedishopid", String.valueOf(friendsnum));

                String a = keyarrayrank.get(position);
                mDatabaseFriend.child("users").child(String.valueOf(LogoFragment.logtext))
                        .child("friends").child(String.valueOf(friendsnum)).child("username")
                        .setValue(friendusernamerank);

                mDatabaseFriend.child("users").child(String.valueOf(LogoFragment.logtext))
                        .child("friends").child(String.valueOf(friendsnum)).child("highscore")
                        .setValue(friendscorerank);
                mDatabaseFriend.child("users").child(String.valueOf(LogoFragment.logtext))
                        .child("friends").child(String.valueOf(friendsnum)).child("surname")
                        .setValue(friendsurnamerank);
                mDatabaseFriend.child("users").child(String.valueOf(LogoFragment.logtext))
                        .child("friends").child(String.valueOf(friendsnum)).child("name")
                        .setValue(friendnamerank);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });


    }


}
