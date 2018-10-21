package ca.bcit.ass1.shin_hsu;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ca.bcit.ass1.shin_hsu.Adaptors.ContinentsAdapter;
import ca.bcit.ass1.shin_hsu.Continent.Continents;
import ca.bcit.ass1.shin_hsu.Country.Country;
import ca.bcit.ass1.shin_hsu.Utils.HttpHandler;

public class MainActivity extends AppCompatActivity {
    private ListView continents_list_view;
    public static ArrayList<Country> countriesList;

    private String TAG = MainActivity.class.getSimpleName();
    private static String API_URL = "https://restcountries.eu/rest/v2/all";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        countriesList = new ArrayList<>();
        new getJSONObject().execute();

        continents_list_view = findViewById( R.id.continents );
        setContinents();

        continents_list_view.setOnItemClickListener( ( adapterView, view, position, id ) -> {
            Intent i = new Intent( MainActivity.this, CountryActivity.class );
            i.putExtra( "Continent", (int) id );
            startActivity( i );
        } );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Continents.africaCountries = new ArrayList<>();
        Continents.africaCountries = new ArrayList<>();
        Continents.asiaCountries = new ArrayList<>();
        Continents.europeCountries = new ArrayList<>();
        Continents.oceaniaCountries = new ArrayList<>();
        Continents.polarCountries = new ArrayList<>();
    }

    private void setContinents() {
        Continents continents = new Continents();
        ContinentsAdapter adapter = new ContinentsAdapter( MainActivity.this, continents.getContinents() );
        continents_list_view.setAdapter( adapter );
    }

    private class getJSONObject extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground( Void... arg0 ) {
            HttpHandler sh = new HttpHandler();
            String jsonStr;
            jsonStr = sh.makeServiceCall( API_URL );

            if ( jsonStr != null ) {
                try {
                    JSONArray countriesJSONArray = new JSONArray( jsonStr );
                    for ( int i = 0; i < countriesJSONArray.length(); i++ ) {
                        JSONObject c = countriesJSONArray.getJSONObject( i );

                        String name = c.getString( "name" );
                        String capital = c.getString( "capital" );
                        String region = c.getString( "region" );
                        String population = c.getString( "population" );
                        String area = c.getString( "area" );
                        String borders = c.getString( "borders" );
                        String flag = c.getString( "flag" );

                        Country country = new Country();
                        country.setName( name );
                        country.setCapital( capital );
                        country.setRegion( region );
                        country.setPopulation( population );
                        country.setArea( area );
                        country.setBorders( borders );
                        country.setFlag( flag );

                        countriesList.add( country );
                    }
                } catch ( final JSONException e ) {
                    Log.e( TAG, "Json parsing error: " + e.getMessage() );
                    runOnUiThread( () -> Toast.makeText( getApplicationContext(),
                            "Json parsing error: " + e.getMessage(),
                            Toast.LENGTH_LONG )
                            .show() );
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute( Void result ) {
            super.onPostExecute( result );
        }
    }
}
