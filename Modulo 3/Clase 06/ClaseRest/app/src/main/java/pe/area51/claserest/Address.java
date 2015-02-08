package pe.area51.claserest;

public class Address {

    private String displayName;
    private String city;
    private String country;

    public String getDisplayName() {
        return displayName;
    }

    public Address setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }
}
