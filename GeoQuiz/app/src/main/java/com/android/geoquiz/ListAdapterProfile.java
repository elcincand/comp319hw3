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

public class ListAdapterProfile extends ArrayAdapter<DataModelProfile> implements View.OnClickListener{
    private ProfileFragment fragmentprofile;
    private ArrayList<DataModelProfile> dataSetProfile;
    Context mContextProfile;
    DatabaseReference mProfileRef;
    DatabaseReference mshopRef;

    @Override
    public void onClick(View view) {

    }


    // View lookup cache
    private static class ViewHolderProfile{
        TextView txtname;
        TextView txtlastname;
        TextView txtusername;
        TextView txthighscore;
        ImageButton remove;

    }

    public ListAdapterProfile(ArrayList<DataModelProfile> data, Context context, ProfileFragment fragmentprofile) {
        super(context, R.layout.profilelistrow, data);
        this.dataSetProfile = data;
        this.mContextProfile=context;
        this.fragmentprofile = fragmentprofile;
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

        }
    }*/

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModelProfile dataModelProfile = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ListAdapterProfile.ViewHolderProfile viewHolderProfile; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolderProfile = new ListAdapterProfile.ViewHolderProfile();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.profilelistrow, parent, false);
            viewHolderProfile.txtname = (TextView) convertView.findViewById(R.id.name);
            viewHolderProfile.txtlastname = (TextView) convertView.findViewById(R.id.tuketim);
            viewHolderProfile.txtusername = (TextView) convertView.findViewById(R.id.tuketim);
            viewHolderProfile.txthighscore = (TextView) convertView.findViewById(R.id.tuketim);

            viewHolderProfile.remove = (ImageButton) convertView.findViewById(R.id.item_remove);

            result=convertView;

            convertView.setTag(viewHolderProfile);

        } else {
            viewHolderProfile = (ListAdapterProfile.ViewHolderProfile) convertView.getTag();
            result=convertView;
        }


        //Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        // result.startAnimation(animation);
        lastPosition = position;

        viewHolderProfile.txtname.setText(dataModelProfile.getName());
        viewHolderProfile.txtlastname.setText(dataModelProfile.getLastname());
        viewHolderProfile.txtusername.setText(dataModelProfile.getUsername());
        viewHolderProfile.txthighscore.setText(dataModelProfile.getHighscore());

        viewHolderProfile.remove.setOnClickListener(this);
        viewHolderProfile.remove.setTag(position);



        return convertView;
    }

}
