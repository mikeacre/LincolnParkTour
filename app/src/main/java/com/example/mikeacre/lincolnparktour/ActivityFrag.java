package com.example.mikeacre.lincolnparktour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mikeacre on 11/12/2016.
 */

public class ActivityFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Lanes Workout", "Follow the loop to have a good workout", "https://www.google.com/maps/place/Wexford+Inn/@40.923624,-74.3054903,17z",R.drawable.family_grandfather));
        locations.add(new Location("LP Lake", "Fish, Swim, Boat!!", "https://www.google.com/maps/place/Grasshopper+Too/@40.9237366,-74.3733413,12z",R.drawable.family_grandmother));
        locations.add(new Location("Shop-Rite", "People come form all over to shop here.", "https://www.google.com/maps/place/Mothers+Ale+House/@40.9146487,-74.2670644,17z",R.drawable.family_son));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Location location = locations.get(position);

                Uri uri = Uri.parse(location.getGeoLocation());
                Intent openMap = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(openMap);
            }
        });

        return rootView;
    }
}
