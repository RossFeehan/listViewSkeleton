package com.ross.feehan.listviewskeleton;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.teamListView) ListView teamListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        List<String> teamNames = Arrays.asList(getResources().getStringArray(R.array.premierLeagueTeams));
        TypedArray teamBadges = getResources().obtainTypedArray(R.array.teamBadges);

        TeamNameListViewAdapter teamNameLVAdapter = new TeamNameListViewAdapter(this, R.layout.team_custom_listview, teamNames, teamBadges);
        teamListView.setAdapter(teamNameLVAdapter);
    }


}
