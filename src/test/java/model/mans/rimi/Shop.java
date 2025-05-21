package model.mans.rimi;

public class Shop {
    private String name;
    private String address;
    private String info;

    public Shop(String name, String address, String info) {
        this.name = name;
        this.address = address;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
