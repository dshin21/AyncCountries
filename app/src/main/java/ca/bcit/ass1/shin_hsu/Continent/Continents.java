package ca.bcit.ass1.shin_hsu.Continent;

import java.util.ArrayList;

import ca.bcit.ass1.shin_hsu.Country.Country;

public class Continents {
    private ArrayList<Continent> continents;

    public static ArrayList<Country> africaCountries;
    public static ArrayList<Country> americaCountries;
    public static ArrayList<Country> asiaCountries;
    public static ArrayList<Country> europeCountries;
    public static ArrayList<Country> oceaniaCountries;
    public static ArrayList<Country> polarCountries;

    public Continents() {
        continents = new ArrayList<>();
        continents.add( new Continent( "Africa" ) );
        continents.add( new Continent( "Americas" ) );
        continents.add( new Continent( "Asia" ) );
        continents.add( new Continent( "Europe" ) );
        continents.add( new Continent( "Oceania" ) );
        continents.add( new Continent( "Polar" ) );
        africaCountries = new ArrayList<>();
        americaCountries = new ArrayList<>();
        asiaCountries = new ArrayList<>();
        europeCountries = new ArrayList<>();
        oceaniaCountries = new ArrayList<>();
        polarCountries = new ArrayList<>();
    }

    public ArrayList<Continent> getContinents() {
        return continents;
    }
}
