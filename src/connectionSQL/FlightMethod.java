package connectionSQL;

import flight.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightMethod {
    Connection1 connection1 = new Connection1();

    public void addFlight(Flight flight) {
        String SQL = "INSERT INTO \"qa_2_practic\".flight " +
                " (airplane_model, departure_time, departure_place, place_of_arrival, flight_duration, number_of_seats, flight_number )" +
                " VALUES (?, current_timestamp, ?, ?, current_time, ?, ? );";
        try (Connection conn = connection1.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, flight.getAirplane_model());
            stmt.setInt(2, flight.getDeparture_place());
            stmt.setInt(3, flight.getPlace_of_arrival());
            stmt.setInt(4, flight.getNumber_of_seats());
            stmt.setInt(5, flight.getFlight_number());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Добавленно в базу! ");
        }
    }

    public void deleteFlight(int flight_number) {
        String SQL = "DELETE FROM \"qa_2_practic\".flight where flight_number = " + flight_number + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateFlight(Flight flight, int flight_number) {
        String SQL = "UPDATE \"qa_2_practic\".flight set departure_place = " + flight.getDeparture_place() + ",place_of_arrival = " + flight.getPlace_of_arrival() + " where flight_number = " + flight_number + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public Flight getFlight(int flight_number) {
        Flight flight = new Flight();
        String SQL = "SELECT * FROM \"qa_2_practic\".flight where flight_number = " + flight_number + "";
        try (Connection conn = connection1.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flight.setId(resultSet.getInt("id"));
                flight.setAirplane_model(resultSet.getString("airplane_model"));
                flight.setDeparture_time(resultSet.getTime("departure_time"));
                flight.setDeparture_place(resultSet.getInt("departure_place"));
                flight.setPlace_of_arrival(resultSet.getInt("place_of_arrival"));
                flight.setFlight_duration(resultSet.getTime("flight_duration"));
                flight.setNumber_of_seats(resultSet.getInt("number_of_seats"));
                flight.setFlight_number(resultSet.getInt("flight_number"));
            }
        } catch (SQLException e) {
            System.out.println("Запись получена! ");
        }
        return flight;
    }

    public List<Flight> getAllFlightWithCodeOfAirport(int code_of_the_airport_ot, int code_of_the_airport_do) {
        List<Flight> flights = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".flight where departure_place = " + code_of_the_airport_ot + " and place_of_arrival = " + code_of_the_airport_do + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setAirplane_model(resultSet.getString("airplane_model"));
                flight.setDeparture_time(resultSet.getTime("departure_time"));
                flight.setDeparture_place(resultSet.getInt("departure_place"));
                flight.setPlace_of_arrival(resultSet.getInt("place_of_arrival"));
                flight.setFlight_duration(resultSet.getTime("flight_duration"));
                flight.setNumber_of_seats(resultSet.getInt("number_of_seats"));
                flight.setFlight_number(resultSet.getInt("flight_number"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return flights;
    }

    public List<Flight> getAllFlight() {
        List<Flight> flights = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".flight";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setAirplane_model(resultSet.getString("airplane_model"));
                flight.setDeparture_time(resultSet.getTime("departure_time"));
                flight.setDeparture_place(resultSet.getInt("departure_place"));
                flight.setPlace_of_arrival(resultSet.getInt("place_of_arrival"));
                flight.setFlight_duration(resultSet.getTime("flight_duration"));
                flight.setNumber_of_seats(resultSet.getInt("number_of_seats"));
                flight.setFlight_number(resultSet.getInt("flight_number"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return flights;
    }
}
