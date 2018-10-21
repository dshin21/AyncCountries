package ca.bcit.ass1.shin_hsu.Country;

import java.util.ArrayList;

import ca.bcit.ass1.shin_hsu.Continent.Continents;

public class Country {

    private String name;

    private String capital;

    private String region;

    private String population;

    private String area;

    private String borders;

    private String flag;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital( String capital ) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion( String region ) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation( String population ) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea( String area ) {
        this.area = area;
    }

    public String getBorders() {
        return borders;
    }

    public void setBorders( String borders ) {
        this.borders = borders;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag( String flag ) {
        this.flag = flag;
    }

    public static void filterCountries( ArrayList<Country> countryList ) {
        for ( int i = 0; i < countryList.size(); ++i )
            switch ( countryList.get( i ).getRegion() ) {
                case "Africa":
                    Continents.africaCountries.add( countryList.get( i ) );
                    break;
                case "Americas":
                    Continents.americaCountries.add( countryList.get( i ) );
                    break;
                case "Asia":
                    Continents.asiaCountries.add( countryList.get( i ) );
                    break;
                case "Europe":
                    Continents.europeCountries.add( countryList.get( i ) );
                    break;
                case "Oceania":
                    Continents.oceaniaCountries.add( countryList.get( i ) );
                    break;
                case "Polar":
                    Continents.polarCountries.add( countryList.get( i ) );
                    break;
            }
    }
}
