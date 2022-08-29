package flight;

import airport.Airports;
import connectionSQL.AirportMethod;
import connectionSQL.CountryMethod;
import countries.Country;

import java.sql.Time;

public class Flight {
    private int id;
    private String airplane_model;
    private Time departure_time;
    private int departure_place;
    private int place_of_arrival;
    private Time flight_duration;
    private int number_of_seats;
    private int flight_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirplane_model() {
        return airplane_model;
    }

    public void setAirplane_model(String airplane_model) {
        this.airplane_model = airplane_model;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public int getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(int departure_place) {
        this.departure_place = departure_place;
    }

    public int getPlace_of_arrival() {
        return place_of_arrival;
    }

    public void setPlace_of_arrival(int place_of_arrival) {
        this.place_of_arrival = place_of_arrival;
    }

    public Time getFlight_duration() {
        return flight_duration;
    }

    public void setFlight_duration(Time flight_duration) {
        this.flight_duration = flight_duration;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    @Override
    public String toString() {
        AirportMethod airportMethod = new AirportMethod();
        CountryMethod countryMethod = new CountryMethod();

        Airports airport_departure = airportMethod.getAirport(getDeparture_place());
        Country country_departure = countryMethod.getCountry(airport_departure.getCode_of_the_country());

        Airports airport_arrival = airportMethod.getAirport(getPlace_of_arrival());
        Country country_arrival = countryMethod.getCountry(airport_arrival.getCode_of_the_country());
        return "| id = " + getId() + "| модель самолёта = " + getAirplane_model() + "| время отправления  = " + getDeparture_time() + "| место отправления = " + country_departure.getName_of_country() + " | место прибытия = " + country_arrival.getName_of_country() + " | продолжительность полета = " + getFlight_duration() + " | количество мест = " + getNumber_of_seats() + " | номер рейса = " + getFlight_number() + " |\n";
    }
}
