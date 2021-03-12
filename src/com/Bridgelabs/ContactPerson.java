import java.util.Comparator;

public class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private long phoneNumber;
    private long zip;

    public ContactPerson(String firstName, String lastName, String address, String city, String state, long zip, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static Comparator<ContactPerson> firstNameSorting = (contact1, contact2) -> {
        String firstName = contact1.getfirstName();
        String firstName2 = contact2.getfirstName();
        return firstName.compareToIgnoreCase(firstName2);
    };

    public static Comparator<ContactPerson> CitySorting = (contact1, contact2) -> {
        String CityName = contact1.getCity();
        String CityName2 = contact2.getCity();
        return CityName.compareToIgnoreCase(CityName2);
    };
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Address: " + address + ", City: " + city + ",State: " + state + ",Phone: " + phoneNumber + ",Pin Code: " + zip + " | ";
    }
}