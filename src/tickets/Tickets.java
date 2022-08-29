package tickets;

import java.sql.Time;

public class Tickets {
    private int id;
    private int flight_number;
    private Time receiving_time;
    private int number_of_ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
