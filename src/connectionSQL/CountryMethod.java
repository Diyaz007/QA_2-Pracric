package connectionSQL;

import countries.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryMethod {
    Connection1 connection1 = new Connection1();

    public void addCountry(Country country) {
        String SQL = "INSERT INTO \"qa_2_practic\".countries" +
                " (code_of_the_country,name_of_country)" +
                " VALUES (?, UPPER (?)); ";
        try (Connection conn = connection1.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, country.getCode_of_the_country());
            stmt.setString(2, country.getName_of_country());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            System.out.println("Добавленно в базу! ");
        }
    }

    public void deleteNews(int code_of_the_country) {
        String SQL = "DELETE FROM \"qa_2_practic\".countries where code_of_the_country = " + code_of_the_country + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись удаленна!!");
        }
    }

    public void updateCountry(Country country, int code_of_the_country) {
        String SQL = "UPDATE \"qa_2_practic\".countries set code_of_the_country = " + country.getCode_of_the_country() + ",name_of_country = UPPER (\'" + country.getName_of_country() + "\') where code_of_the_country = " + code_of_the_country + "";
        try (Connection conn = connection1.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            System.out.println("Запись обновлена!!");
        }
    }

    public Country getCountry(int code_of_the_country) {
        Country country = new Country();
        String SQL = "SELECT * FROM \"qa_2_practic\".countries where code_of_the_country = " + code_of_the_country + "";
        try (Connection conn = connection1.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                country.setId(resultSet.getInt("id"));
                country.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                country.setName_of_country(resultSet.getString("name_of_country"));
            }
        } catch (SQLException e) {
            System.out.println("Запись получена! ");
        }
        return country;
    }


    public List<Country> getAllCountry() {
        List<Country> countries = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".countries";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                country.setName_of_country(resultSet.getString("name_of_country"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return countries;
    }

    public List<Country> getAllCountryWithCodeOfCountry(int code_of_the_country_ot, int code_of_the_country_do) {
        List<Country> countries = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".countries where code_of_the_country between " + code_of_the_country_ot + " and " + code_of_the_country_do + "";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                country.setName_of_country(resultSet.getString("name_of_country"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return countries;
    }

    public List<Country> getAllCountryWithName(String name_of_country) {
        List<Country> countries = new ArrayList<>();
        String SQL = "select * from \"qa_2_practic\".countries where name_of_country like UPPER (\'%" + name_of_country + "%\')";
        try (Connection conn = connection1.connect();
             PreparedStatement statement = conn.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCode_of_the_country(resultSet.getInt("code_of_the_country"));
                country.setName_of_country(resultSet.getString("name_of_country"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Записи получены! ");
        }
        return countries;
    }

}
