package connectionSQL;

import airport.Airports;
import clients.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsMethod {
    Connection1 connection1 = new Connection1();

    public void addClient(Clients clients) {
        String SQL = "INSERT INTO \"qa_2_practic\".clients " +
                " (identification_number, id_passport, full_name, gender, country)" +
                " VALUES (?, ?, ?, ?, ?);";
        try (Connection conn = connection1.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, clients.getIdentification_number());
            stmt.setInt(2, clients.getId_passport());
            stmt.setString(3, clients.getFull_name());
            stmt.setString(4, clients.getGender());
            stmt.setInt(5, clients.getCountry());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Добавленно в базу! ");
        }
    }

    public void deleteClient(int id_passport) {
        String SQL = "DELETE FROM \"qa_2_practic\".clients where id_passport = " + id_passport + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateClient(Clients clients, int id_passport) {
        String SQL = "UPDATE \"qa_2_practic\".clients set identification_number = " + clients.getIdentification_number() + ", id_passport = " + clients.getId_passport() + ", full_name = \'" + clients.getFull_name() + "\', gender = \'" + clients.getGender() + "\', country = " + clients.getCountry() + " where id_passport = " + id_passport + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public Clients getClient(int id_passport) {
        Clients clients = new Clients();
        String SQL = "SELECT * FROM \"qa_2_practic\".clients where id_passport = " + id_passport + "";
        try (Connection conn = connection1.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clients.setId(resultSet.getInt("id"));
                clients.setIdentification_number(resultSet.getInt("identification_number"));
                clients.setId_passport(resultSet.getInt("id_passport"));
                clients.setFull_name(resultSet.getString("full_name"));
                clients.setGender(resultSet.getString("gender"));
                clients.setCountry(resultSet.getInt("country"));
            }
        } catch (SQLException e) {
            System.out.println("Запись получена! ");
        }
        return clients;
    }

    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".clients ";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setIdentification_number(resultSet.getInt("identification_number"));
                client.setId_passport(resultSet.getInt("id_passport"));
                client.setFull_name(resultSet.getString("full_name"));
                client.setGender(resultSet.getString("gender"));
                client.setCountry(resultSet.getInt("country"));
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return clients;
    }
}
