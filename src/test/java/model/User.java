package model;

public class User {
    //----------------ATTRIBUTES--------------------
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;
    private Address address;

    //--------------CONSTRUCTOR---------------------
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("New object " + firstName + " created!");
    }

    public User() {}

    //---------------GETTERS/SETTERS----------------
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.replaceAll(" ", "");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //-----------------CUSTOM METHODS----------------------
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
