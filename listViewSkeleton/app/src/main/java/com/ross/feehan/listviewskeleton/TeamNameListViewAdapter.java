package com.ross.feehan.listviewskeleton;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 03/12/2015.
 * Copyright Ross Feehan
 */
public class TeamNameListViewAdapter extends ArrayAdapter<String> {

    private Context ctx;
    private int resourceLayoutID;
    private List<String> teamNames;
    private TypedArray teamBadges;

   //Constructor
    public TeamNameListViewAdapter(Context context, int resource,  List<String>teamsNames, TypedArray teamBadges) {
        super(context, resource);
        this.ctx = context;
        this.resourceLayoutID = resource;
        this.teamNames = teamsNames;
        this.teamBadges = teamBadges;
    }

     /*Set each row of the list view
	 * @Params Int position - the number of the row that is being inflated
	 * @Params View convertView  - the row
	 * @Params ViewGroup parent - The rootview
	 * @Return View row - the row that has been inflated
	 * (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
     @Override
     public View getView(int position, View convertView, ViewGroup parent){

         View row = convertView;
         TeamsHolder holder = null;

         if(row == null){
             LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
             row = inflater.inflate(R.layout.team_custom_listview, parent, false);

             holder = new TeamsHolder(row);
         }
         else{
             holder = (TeamsHolder)row.getTag();
         }

         holder.teamNameTV.setText(teamNames.get(position));
         holder.teamBadgeIV.setImageDrawable(teamBadges.getDrawable(position));

         //when the row is clicked
         row.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View vRow) {
                 TeamsHolder teamsHolder = (TeamsHolder)vRow.getTag();
                 Toast.makeText(ctx, teamsHolder.teamNameTV.getText().toString(), Toast.LENGTH_SHORT).show();
             }
         });
         row.setTag(holder);
         return row;
     }

    @Override
    public int getCount(){
        return teamNames.size();
    }

    /* Class that holds the layout of the view that we are inflating
	 *
	 */
     static class TeamsHolder{

        @Bind(R.id.teamBadgeIV) ImageView teamBadgeIV;
        @Bind(R.id.teamNameTV) TextView teamNameTV;

        public TeamsHolder(View view){
            ButterKnife.bind(this, view);
        }
    }


}
