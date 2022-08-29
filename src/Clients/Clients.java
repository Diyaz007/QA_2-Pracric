package Clients;

public class Clients {
    private int id;
    private int identification_number;
    private int id_passport;
    private String full_name;
    private String gender;
    private int country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(int identification_number) {
        this.identification_number = identification_number;
    }

    public int getId_passport() {
        return id_passport;
    }

    public void setId_passport(int id_passport) {
        this.id_passport = id_passport;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
