package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {

    private ImageButton madd;
    private ListView mfood;
    private String tempKey2;
    ArrayList<DataModelFriend> dataModelsfriend = new ArrayList<DataModelFriend>();
    private List<String> keyarray = new ArrayList<>();

    private ListAdapterFriend adapterfriend;

    DatabaseReference mbasicRef;
    DatabaseReference mDatabaseShop;
    public static String sname;

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
            mfood = (ListView) view.findViewById(R.id.food);
            // mbozuk = (ListView) view.findViewById(R.id.bozuk);
        //    madd = (ImageButton) view.findViewById(R.id.foodAddButton);




           // displayFood();

            return view;
        }

/*

    public void displayFood(){
        mbasicRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sanalmutfak-d81ad.firebaseio.com/kitchens/"
                + LogoFragment.logkitchen + "/foods/");
        mbasicRef.orderByChild("skt");

        adapterbasic = new ListAdapterBasic(dataModelsBasic, getActivity(), BasicFragment.this);
        mfood.setAdapter(adapterbasic);

        mbasicRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapShot : dataSnapshot.getChildren()) {

                    String bname = (String) childSnapShot.child("foodname").getValue();
                    String bskt = (String) childSnapShot.child("skt").getValue();
                    // String but = (String) childSnapShot.child("ut").getValue();

                    tempKey2 = dataSnapshot.child(childSnapShot.getKey()).getKey().toString();
                    Log.d("keditemp", tempKey2);

                    keyarray.add(tempKey2);
                    Log.d("kedi", String.valueOf(keyarray));


                    dataModelsBasic.add(new DataModelBasic(bname, bskt));
                    mbasicRef.orderByChild("skt");
                    adapterbasic.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    public void removeItemBasic(int position) {
        DataModelBasic toRemovebasic = adapterbasic.getItem(position);
        adapterbasic.remove(toRemovebasic);
        adapterbasic.notifyDataSetChanged();
        Log.d("kediremove", keyarray.get(position));
        mbasicRef.child(keyarray.get(position)).removeValue();
        BasicFragment fragment = new BasicFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public <T> T getLastElement(final Iterable<T> elements) {
        Iterator<T> itr = elements.iterator();
        T lastElement = null;

        while(itr.hasNext()) {
            lastElement=itr.next();
        }

        return lastElement;
    }

    public void addShopListBasic(final int position){

        mbasicRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String a = keyarray.get(position);
                sname = (String) dataSnapshot.child(a).child("foodname").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        mDatabaseShop = FirebaseDatabase.getInstance().getReference();


        Query lastQuery2 =mDatabaseShop.child("kitchens").child(String.valueOf(LoginFragment.logkitchen)).child("shoplist");

        lastQuery2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot shoplist = getLastElement(dataSnapshot.getChildren());
                int shopid = 0;
                if(shoplist != null){
                    shopid = Integer.parseInt(shoplist.getKey()) + 1;
                }
                Log.d("kedishopid", String.valueOf(shopid));

                String a = keyarray.get(position);
                mDatabaseShop.child("kitchens").child(String.valueOf(LoginFragment.logkitchen))
                        .child("shoplist").child(String.valueOf(shopid)) //child("foodname")
                        .setValue(sname);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });


    }
*/
}