package ca.bcit.ass1.shin_hsu.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.bcit.ass1.shin_hsu.Continent.Continent;
import ca.bcit.ass1.shin_hsu.R;


public class ContinentsAdapter extends ArrayAdapter<Continent> {
    private Context context;

    public ContinentsAdapter( Context context, ArrayList<Continent> continents ) {
        super( context, 0, continents );
        this.context = context;
    }

    @Override
    public View getView( int position, View view, ViewGroup parent ) {
        Continent continent = getItem( position );

        if ( view == null )
            view = LayoutInflater.from( getContext() ).inflate( R.layout.list_continents_layout, parent, false );

        TextView continentName = view.findViewById( R.id.continent );
        continentName.setText( continent.getName() );

        return view;
    }
}
