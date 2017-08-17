package com.android.geoquiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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




    // View lookup cache
    private static class ViewHolderRank{
        TextView txtusernamerank;
        TextView txtuserscore;
        TextView txtnamerank;
        TextView txtlastnamerank;
        ImageButton addfriendrank;

    }

    public ListAdapterRank(ArrayList<DataModelRank> data, Context context, RankingFragment fragmentranking) {
        super(context, R.layout.ranklistrow, data);
        this.dataSetRank = data;
        this.mContextRank=context;
        this.fragmentranking = fragmentranking;
    }

    @Override
    public void onClick(View v) {

        final int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModelRank dataModelRank =(DataModelRank)object;

        switch (v.getId())
        {

            case R.id.addfriendrank:

                AlertDialog.Builder adb2 = new AlertDialog.Builder(getContext());
                adb2.setTitle("Add to shopping list?");
                adb2.setMessage("Are you sure you want to add this item to the shopping list?");
                adb2.setNegativeButton("Cancel", null);
                adb2.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        fragmentranking.addFriendList(position);
                    }
                });
                adb2.show();
                break;
        }
    }

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
            viewHolderRank.txtuserscore = (TextView) convertView.findViewById(R.id.rankscore);
            viewHolderRank.txtnamerank = (TextView) convertView.findViewById(R.id.rankname);
            viewHolderRank.txtusernamerank = (TextView) convertView.findViewById(R.id.rankusername);
            viewHolderRank.txtlastnamerank = (TextView) convertView.findViewById(R.id.rankscore);

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

        viewHolderRank.txtusernamerank.setText(dataModelRank.getUsernamerank());
        viewHolderRank.txtnamerank.setText(dataModelRank.getNamerank());
        viewHolderRank.txtlastnamerank.setText(dataModelRank.getLastnamescore());
        viewHolderRank.txtuserscore.setText(dataModelRank.getScorerank());

        viewHolderRank.addfriendrank.setOnClickListener(this);
        viewHolderRank.addfriendrank.setTag(position);


        return convertView;
    }

}
