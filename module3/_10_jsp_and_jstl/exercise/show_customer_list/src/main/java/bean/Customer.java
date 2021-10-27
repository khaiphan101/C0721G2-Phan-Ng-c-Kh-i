package bean;

public class Customer {
    String name;
    String Birthday;
    String address;
    String image;

    public Customer() {
    }

    public Customer(String name, String birthday, String address, String image) {
        this.name = name;
        Birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
