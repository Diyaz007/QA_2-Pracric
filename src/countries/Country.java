package countries;

public class Country {
    private int id;
    private int code_of_the_country;
    private String name_of_country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_of_the_country() {
        return code_of_the_country;
    }

    public void setCode_of_the_country(int code_of_the_country) {
        this.code_of_the_country = code_of_the_country;
    }

    public String getName_of_country() {
        return name_of_country;
    }

    public void setName_of_country(String name_of_country) {
        this.name_of_country = name_of_country;
    }

    @Override
    public String toString() {
        return "| id = " + getId() + "| код страны = " + getCode_of_the_country() + "| название страны = " + getName_of_country() + " |\n";
    }
}
