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

public class ListAdapterRank extends ArrayAdapter<DataModelRank> implements View.OnClickListener{
    private RankingFragment fragmentranking;
    private ArrayList<DataModelRank> dataSetRank;
    Context mContextRank;
    DatabaseReference mRankRef;

    @Override
    public void onClick(View view) {

    }


    // View lookup cache
    private static class ViewHolderRank{
        TextView txtuserrank;
        TextView txtuserscore;
        ImageButton addfriendrank;

    }

    public ListAdapterRank(ArrayList<DataModelRank> data, Context context, RankingFragment fragmentranking) {
        super(context, R.layout.ranklistrow, data);
        this.dataSetRank = data;
        this.mContextRank=context;
        this.fragmentranking = fragmentranking;
    }
/*
    @Override
    public void onClick(View v) {

        final int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModelFriend dataModel=(DataModelFriend)object;

        switch (v.getId())
        {

            case R.id.addfriendrank:

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
        DataModelRank dataModelRank = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ListAdapterRank.ViewHolderRank viewHolderRank; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolderRank = new ListAdapterRank.ViewHolderRank();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ranklistrow, parent, false);
            viewHolderRank.txtuserscore = (TextView) convertView.findViewById(R.id.name);
            viewHolderRank.txtuserrank = (TextView) convertView.findViewById(R.id.tuketim);

            viewHolderRank.addfriendrank = (ImageButton) convertView.findViewById(R.id.addfriendrank);

            result=convertView;

            convertView.setTag(viewHolderRank);

        } else {
            viewHolderRank = (ListAdapterRank.ViewHolderRank) convertView.getTag();
            result=convertView;
        }


        //Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        // result.startAnimation(animation);
        lastPosition = position;

        viewHolderRank.txtuserrank.setText(dataModelRank.getUserrank());
        viewHolderRank.txtuserscore.setText(dataModelRank.getUserscore());

        viewHolderRank.addfriendrank.setOnClickListener(this);
        viewHolderRank.addfriendrank.setTag(position);


        return convertView;
    }

}
