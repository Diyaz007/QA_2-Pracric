package connectionSQL;

import airport.Airports;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportMethod {
    Connection1 connection1 = new Connection1();

    public void addAirport(Airports airports) {
        String SQL = "INSERT INTO \"qa_2_practic\".airports " +
                " (code_of_the_airport, code_of_the_city, code_of_the_country)" +
                " VALUES (?, ?, ?);";
        try (Connection conn = connection1.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, airports.getCode_of_the_airport());
            stmt.setInt(2, airports.getCode_of_the_city());
            stmt.setInt(3, airports.getCode_of_the_country());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Добавленно в базу! ");
        }
    }

    public void deleteAirport(int code_of_the_airport) {
        String SQL = "DELETE FROM \"qa_2_practic\".airports where code_of_the_airport = " + code_of_the_airport + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateAirport(Airports airport, int code_of_the_airport) {
        String SQL = "UPDATE \"qa_2_practic\".airports set code_of_the_airport = " + airport.getCode_of_the_airport() + ",code_of_the_city = " + airport.getCode_of_the_city() + ",code_of_the_country = " + airport.getCode_of_the_country() + " where code_of_the_airport = " + code_of_the_airport + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public Airports getAirport(int code_of_the_airport) {
        Airports airport = new Airports();
        String SQL = "SELECT * FROM \"qa_2_practic\".airports where code_of_the_airport = " + code_of_the_airport + "";
        try (Connection conn = connection1.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                airport.setId(resultSet.getInt("id"));
                airport.setCode_of_the_airport(resultSet.getInt("code_of_the_airport"));
                airport.setCode_of_the_city(resultSet.getInt("code_of_the_city"));
                airport.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
            }
        } catch (SQLException e) {
            System.out.println("Запись получена! ");
        }
        return airport;
    }

    public List<Airports> getAllAirports() {
        List<Airports> airports = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".airports";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Airports airport = new Airports();
                airport.setId(resultSet.getInt("id"));
                airport.setCode_of_the_airport(resultSet.getInt("code_of_the_airport"));
                airport.setCode_of_the_city(resultSet.getInt("code_of_the_city"));
                airport.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return airports;
    }

    public List<Airports> getAllAirportsWithCodeOfAirport(int code_of_the_airport_ot, int code_of_the_airport_do) {
        List<Airports> airports = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".airports where code_of_the_airport between " + code_of_the_airport_ot + " and " + code_of_the_airport_do + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Airports airport = new Airports();
                airport.setId(resultSet.getInt("id"));
                airport.setCode_of_the_airport(resultSet.getInt("code_of_the_airport"));
                airport.setCode_of_the_city(resultSet.getInt("code_of_the_city"));
                airport.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return airports;
    }

    public List<Airports> getAllAirportsWithCodeOfCountry(int code_of_the_country_ot, int code_of_the_country_do) {
        List<Airports> airports = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".airports where code_of_the_country between " + code_of_the_country_ot + " and " + code_of_the_country_do + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Airports airport = new Airports();
                airport.setId(resultSet.getInt("id"));
                airport.setCode_of_the_airport(resultSet.getInt("code_of_the_airport"));
                airport.setCode_of_the_city(resultSet.getInt("code_of_the_city"));
                airport.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return airports;
    }
}
