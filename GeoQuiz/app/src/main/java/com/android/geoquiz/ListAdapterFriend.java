package com.android.geoquiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by elcin on 8/16/17.
 */

public class ListAdapterFriend extends ArrayAdapter<DataModelFriend> implements View.OnClickListener{
    private FriendFragment friendfragment;
    private ArrayList<DataModelFriend> dataSetFriend;
    Context mContextFriend;
    DatabaseReference mFriendRef;


    // View lookup cache
    private static class ViewHolderFriend{
        TextView txtfriendName;
        TextView txtfriendlastname;
        TextView txtfriendusername;
        TextView txtfriendhighscore;
        ImageButton remove;
        ImageButton challenge;


    }

    public ListAdapterFriend(ArrayList<DataModelFriend> data, Context context, FriendFragment friendfragment) {
        super(context, R.layout.friendlistrow, data);
        this.dataSetFriend = data;
        this.mContextFriend=context;
        this.friendfragment = friendfragment;
    }

    @Override
    public void onClick(View v) {

        final int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModelFriend dataModel=(DataModelFriend)object;

        switch (v.getId())
        {
            case R.id.friend_remove:
                mFriendRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/users/"
                        + LogoFragment.logtext + "/friends/");
                Log.d("test", "hello");

                AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete this friend?");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        friendfragment.removeFriend(position);
                    }
                });
                adb.show();

                break;


            case R.id.friend_challenge:
                break;

        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModelFriend dataModelFriend = getItem(position);
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

            viewHolderFriend.remove = (ImageButton) convertView.findViewById(R.id.friend_remove);
            viewHolderFriend.challenge = (ImageButton) convertView.findViewById(R.id.friend_challenge);

            result=convertView;

            convertView.setTag(viewHolderFriend);

        } else {
            viewHolderFriend = (ViewHolderFriend) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolderFriend.txtfriendName.setText(dataModelFriend.getFriendName());
        viewHolderFriend.txtfriendlastname.setText(dataModelFriend.getFriendlastname());
        viewHolderFriend.txtfriendusername.setText(dataModelFriend.getFriendusername());
        viewHolderFriend.txtfriendhighscore.setText(dataModelFriend.getFriendhighscore());
        viewHolderFriend.remove.setOnClickListener(this);
        viewHolderFriend.remove.setTag(position);

        viewHolderFriend.remove.setOnClickListener(this);
        viewHolderFriend.remove.setTag(position);

        return convertView;
    }

}
