package ca.bcit.ass1.shin_hsu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import ca.bcit.ass1.shin_hsu.Adaptors.CountriesAdapter;
import ca.bcit.ass1.shin_hsu.Continent.Continents;
import ca.bcit.ass1.shin_hsu.Country.Country;

public class CountryActivity extends ListActivity {

    private int continentIndex;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Country.filterCountries( MainActivity.countriesList );
        setCountries();
    }

    private void setCountries() {
        continentIndex = (Integer) getIntent().getExtras().get( "Continent" );

        CountriesAdapter arrayAdapter = null;
        switch ( continentIndex ) {
            case 0:
                arrayAdapter = new CountriesAdapter( this, Continents.africaCountries );
                break;
            case 1:
                arrayAdapter = new CountriesAdapter( this, Continents.americaCountries );
                break;
            case 2:
                arrayAdapter = new CountriesAdapter( this, Continents.asiaCountries );
                break;
            case 3:
                arrayAdapter = new CountriesAdapter( this, Continents.europeCountries );
                break;
            case 4:
                arrayAdapter = new CountriesAdapter( this, Continents.oceaniaCountries );
                break;
            case 5:
                arrayAdapter = new CountriesAdapter( this, Continents.polarCountries );
                break;
        }
        ListView listCountries = getListView();
        listCountries.setAdapter( arrayAdapter );
    }

    @Override
    protected void onListItemClick( ListView l, View v, int position, long id ) {
        Intent i = new Intent( this, CountryDetailActivity.class );
        i.putExtra( "Country", (int) id );
        i.putExtra( "Continent", continentIndex );
        startActivity( i );
    }
}
