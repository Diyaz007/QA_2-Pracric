package tickets;

import clients.Clients;
import connectionSQL.ClientsMethod;
import connectionSQL.CountryMethod;
import countries.Country;

import java.sql.Time;

public class Tickets {
    private int id_client;
    private int flight_number;
    private Time receiving_time;
    private int number_of_ticket;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id) {
        this.id_client = id;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public Time getReceiving_time() {
        return receiving_time;
    }

    public void setReceiving_time(Time receiving_time) {
        this.receiving_time = receiving_time;
    }

    public int getNumber_of_ticket() {
        return number_of_ticket;
    }

    public void setNumber_of_ticket(int number_of_ticket) {
        this.number_of_ticket = number_of_ticket;
    }

    @Override
    public String toString() {
        ClientsMethod clientsMethod = new ClientsMethod();
        CountryMethod countryMethod = new CountryMethod();
        Clients clients = clientsMethod.getClient(getId_client());
        Country country = countryMethod.getCountry(clients.getCountry());
        return "| id пассажира = " + getId_client() + "| ФИО = " + clients.getFull_name() + "| номер рейса = " + getFlight_number() + "| время получения = " + getReceiving_time() + "| номер билета " + getNumber_of_ticket() + "| номер билета " + getNumber_of_ticket() + "| гражданство пассажира " + country.getName_of_country() + " |\n";
    }
}
