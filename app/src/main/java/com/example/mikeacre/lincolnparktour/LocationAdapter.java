package com.example.mikeacre.lincolnparktour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by mikeacre on 11/12/2016.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, ArrayList<Location> locations){
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_view, parent, false);
        }

        Location currLocation = getItem(position);

        ImageView currentImage =  (ImageView) listItemView.findViewById(R.id.locimage);
        if(currLocation.hasImage())
            currentImage.setImageResource(currLocation.getResImage());
        else
            currentImage.setVisibility(View.GONE);

        TextView currTitle = (TextView) listItemView.findViewById(R.id.loctitle);
        currTitle.setText(currLocation.getTitle());

        TextView currDesc = (TextView) listItemView.findViewById(R.id.locdescription);
        currDesc.setText(currLocation.getDescription());


        return listItemView;
    }
}
