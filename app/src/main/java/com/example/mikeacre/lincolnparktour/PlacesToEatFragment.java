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

public class PlacesToEatFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Keno Sushi", "Best Sushi in town", "https://www.google.com/maps/place/Wexford+Inn/@40.923624,-74.3054903,17z",R.drawable.color_black));
        locations.add(new Location("Anthony Francos", "Best Pizza place", "https://www.google.com/maps/place/Grasshopper+Too/@40.9237366,-74.3733413,12z",R.drawable.color_red));
        locations.add(new Location("Franks Pizza", "Sit down italian restaurant", "https://www.google.com/maps/place/Mothers+Ale+House/@40.9146487,-74.2670644,17z",R.drawable.color_white));


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
