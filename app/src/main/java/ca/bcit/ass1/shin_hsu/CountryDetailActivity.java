package ca.bcit.ass1.shin_hsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import ca.bcit.ass1.shin_hsu.Continent.Continents;
import ca.bcit.ass1.shin_hsu.Country.Country;

public class CountryDetailActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_country_detail );
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //county details info
        int continentIndex = (Integer) getIntent().getExtras().get( "Continent" );
        int countryIndex = (Integer) getIntent().getExtras().get( "Country" );

        switch ( continentIndex ) {
            case 0:
                getCorrespondingInfo( Continents.africaCountries.get( countryIndex ) );
                break;
            case 1:
                getCorrespondingInfo( Continents.americaCountries.get( countryIndex ) );
                break;
            case 2:
                getCorrespondingInfo( Continents.asiaCountries.get( countryIndex ) );
                break;
            case 3:
                getCorrespondingInfo( Continents.europeCountries.get( countryIndex ) );
                break;
            case 4:
                getCorrespondingInfo( Continents.oceaniaCountries.get( countryIndex ) );
                break;
            case 5:
                getCorrespondingInfo( Continents.polarCountries.get( countryIndex ) );
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Join us on this vacation.");
        return super.onCreateOptionsMenu(menu);
    }

    //option selected for non default menu item my_device onclick operation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.my_device){
            Intent intent1 = new Intent(this,DeviceDetailActivity.class);
            startActivity(intent1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setShareActionIntent(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(i);
    }

    void getCorrespondingInfo( Country country ) {

        ImageView image = findViewById( R.id.flag );

        SvgLoader.pluck().with(this).setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.getFlag(), image);

        TextView name = findViewById( R.id.name );
        name.setText( country.getName() );

        TextView capital = findViewById( R.id.capital );
        capital.setText( "capital: " + country.getCapital() );

        TextView region = findViewById( R.id.region );
        region.setText( "region: " + country.getRegion() );

        TextView population = findViewById( R.id.population );
        population.setText( "population: " + country.getPopulation() );

        TextView area = findViewById( R.id.area );
        area.setText( "area: " + String.valueOf( country.getArea() ) );

        TextView borders = findViewById( R.id.borders );
        borders.setText( "borders: " + String.valueOf( country.getBorders() ) );
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        SvgLoader.pluck().close();
    }
}
