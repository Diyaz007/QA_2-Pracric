package connectionSQL;

import airport.Airports;
import clients.Clients;
import tickets.Tickets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsMethod {
    Connection1 connection1 = new Connection1();

    public void addTicket(Tickets ticket) {
        String SQL = "INSERT INTO \"qa_2_practic\".tickets " +
                " (id_clients, flight_number, receiving_time, number_of_ticket)" +
                " VALUES (?, ?, current_time, ?);";
        try (Connection conn = connection1.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, ticket.getId_client());
            stmt.setInt(2, ticket.getFlight_number());
            stmt.setInt(3, ticket.getNumber_of_ticket());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Добавленно в базу! ");
        }
    }

    public void deleteTicket(int number_of_ticket) {
        String SQL = "DELETE FROM \"qa_2_practic\".tickets where number_of_ticket = " + number_of_ticket + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateTicket(Tickets ticket, int number_of_ticket) {
        String SQL = "UPDATE \"qa_2_practic\".tickets set id_clients = " + ticket.getId_client() + ",flight_number = " + ticket.getFlight_number() + ",receiving_time = current_time " + ",number_of_ticket = " + ticket.getNumber_of_ticket() + " where number_of_ticket = " + number_of_ticket + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public Tickets getTicket(int number_of_ticket) {
        Tickets tickets = new Tickets();
        String SQL = "SELECT * FROM \"qa_2_practic\".tickets where number_of_ticket = " + number_of_ticket + "";
        try (Connection conn = connection1.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.setId_client(resultSet.getInt("id_clients"));
                tickets.setFlight_number(resultSet.getInt("flight_number"));
                tickets.setReceiving_time(resultSet.getTime("receiving_time"));
                tickets.setNumber_of_ticket(resultSet.getInt("number_of_ticket"));
            }
        } catch (SQLException e) {
            System.out.println("Запись получена! ");
        }
        return tickets;
    }

    public List<Tickets> getAllTickets() {
        List<Tickets> tickets = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".tickets";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tickets ticket = new Tickets();
                ticket.setId_client(resultSet.getInt("id_clients"));
                ticket.setFlight_number(resultSet.getInt("flight_number"));
                ticket.setReceiving_time(resultSet.getTime("receiving_time"));
                ticket.setNumber_of_ticket(resultSet.getInt("number_of_ticket"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return tickets;
    }

    public List<Tickets> getAllTicketsWithFlight(int flight_number) {
        List<Tickets> tickets = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".tickets where flight_number = " + flight_number + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tickets ticket = new Tickets();
                ticket.setId_client(resultSet.getInt("id_clients"));
                ticket.setFlight_number(resultSet.getInt("flight_number"));
                ticket.setReceiving_time(resultSet.getTime("receiving_time"));
                ticket.setNumber_of_ticket(resultSet.getInt("number_of_ticket"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return tickets;
    }
    public List<Tickets> getAllTicketsWithIdClient(int id_clients_ot, int id_clients_do) {
        List<Tickets> tickets = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".tickets where id_clients between " + id_clients_ot + " and " + id_clients_do + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tickets ticket = new Tickets();
                ticket.setId_client(resultSet.getInt("id_clients"));
                ticket.setFlight_number(resultSet.getInt("flight_number"));
                ticket.setReceiving_time(resultSet.getTime("receiving_time"));
                ticket.setNumber_of_ticket(resultSet.getInt("number_of_ticket"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return tickets;
    }
}
