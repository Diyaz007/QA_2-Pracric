package airport;

import connectionSQL.CountryMethod;
import countries.Country;

public class Airports {
    private int id;
    private int code_of_the_airport;
    private int code_of_the_city;
    private int code_of_the_country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_of_the_airport() {
        return code_of_the_airport;
    }

    public void setCode_of_the_airport(int code_of_the_airport) {
        this.code_of_the_airport = code_of_the_airport;
    }

    public int getCode_of_the_city() {
        return code_of_the_city;
    }

    public void setCode_of_the_city(int code_of_the_city) {
        this.code_of_the_city = code_of_the_city;
    }

    public int getCode_of_the_country() {
        return code_of_the_country;
    }

    public void setCode_of_the_country(int code_of_the_country) {
        this.code_of_the_country = code_of_the_country;
    }

    @Override
    public String toString() {
        CountryMethod countryMethod = new CountryMethod();
        Country country = countryMethod.getCountry(getCode_of_the_country());
        return "| id = " + getId() + "| код аэропорта = " + getCode_of_the_airport() + "| код города = " + getCode_of_the_city() + "| название страны = " + country.getName_of_country() + " |\n";
    }
}
