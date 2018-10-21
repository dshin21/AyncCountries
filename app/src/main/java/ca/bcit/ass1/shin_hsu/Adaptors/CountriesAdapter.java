package ca.bcit.ass1.shin_hsu.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.bcit.ass1.shin_hsu.Country.Country;
import ca.bcit.ass1.shin_hsu.R;

public class CountriesAdapter extends ArrayAdapter<Country> {
    private Context context;

    public CountriesAdapter( Context context, ArrayList<Country> continents ) {
        super( context, 0, continents );
        this.context = context;
    }

    @Override
    public View getView( int position, View view, ViewGroup parent ) {
        Country country = getItem( position );
        if ( view == null )
            view = LayoutInflater.from( getContext() ).inflate( ca.bcit.ass1.shin_hsu.R.layout.list_country_layout, parent, false );

        TextView countryName = view.findViewById( ca.bcit.ass1.shin_hsu.R.id.country_name );
        countryName.setText( country.getName() );
        //Attempt on downloading flag images
       // WebView imgOnePhoto = (WebView) view.findViewById(R.id.flag);

//        if(country.getFlag()!= null){
//            new ImageDownloaderTask(imgOnePhoto).execute(country.getFlag());
//            imgOnePhoto.loadUrl(country.getFlag());
//        }

        return view;
    }
}