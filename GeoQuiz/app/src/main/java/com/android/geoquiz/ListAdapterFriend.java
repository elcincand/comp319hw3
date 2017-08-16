package com.android.geoquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by elcin on 8/16/17.
 */

public class ListAdapterFriend extends ArrayAdapter<DataModelFriend> implements View.OnClickListener{
    private FriendFragment fragment;
    private ArrayList<DataModelFriend> dataSetFriend;
    Context mContextFriend;
    DatabaseReference mFriendRef;
    DatabaseReference mshopRef;

    @Override
    public void onClick(View view) {


    }


    // View lookup cache
    private static class ViewHolderFriend{
        TextView txtfriendName;
        TextView txtfriendlastname;
        TextView txtfriendusername;
        TextView txtfriendhighscore;


        ImageButton remove;

    }

    public ListAdapterFriend(ArrayList<DataModelFriend> data, Context context, FriendFragment fragment) {
        super(context, R.layout.friendlistrow, data);
        this.dataSetFriend = data;
        this.mContextFriend=context;
        this.fragment = fragment;
    }
/*
    @Override
    public void onClick(View v) {

        final int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModelFriend dataModel=(DataModelFriend)object;

        switch (v.getId())
        {
            case R.id.item_remove:
                mshopRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sanalmutfak-d81ad.firebaseio.com/kitchens/"
                        + LoginFragment.logkitchen + "/shoplist");

                AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete this item?");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        fragment.removeItemBasic(position);
                    }
                });
                adb.show();

                break;

            case R.id.item_addshop:

                AlertDialog.Builder adb2 = new AlertDialog.Builder(getContext());
                adb2.setTitle("Add to shopping list?");
                adb2.setMessage("Are you sure you want to add this item to the shopping list?");
                adb2.setNegativeButton("Cancel", null);
                adb2.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        fragment.addShopListBasic(position);
                    }
                });
                adb2.show();
                break;
        }
    }*/

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModelFriend dataModelbasic = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolderFriend viewHolderFriend; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolderFriend = new ViewHolderFriend();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.friendlistrow, parent, false);
            viewHolderFriend.txtfriendName = (TextView) convertView.findViewById(R.id.friendname);
            viewHolderFriend.txtfriendlastname = (TextView) convertView.findViewById(R.id.friendlastname);
            viewHolderFriend.txtfriendusername = (TextView) convertView.findViewById(R.id.friendusername);
            viewHolderFriend.txtfriendhighscore = (TextView) convertView.findViewById(R.id.friendscore);

            viewHolderFriend.remove = (ImageButton) convertView.findViewById(R.id.item_remove);

            result=convertView;

            convertView.setTag(viewHolderFriend);

        } else {
            viewHolderFriend = (ViewHolderFriend) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolderFriend.txtfriendName.setText(dataModelbasic.getFriendName());

        viewHolderFriend.remove.setOnClickListener(this);
        viewHolderFriend.remove.setTag(position);
        // Return the completed view to render on screen



        return convertView;
    }

}
