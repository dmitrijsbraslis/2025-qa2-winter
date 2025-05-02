import model.Address;
import model.Flat;
import model.House;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LearningObjects {
    @Test
    public void workingWithObjects() {
        User dmitry = new User("Dmitry", "The Tester");
//        dmitry.setFirstName("Dmitry");
//        dmitry.setLastName("The Tester");
        dmitry.setPhone("+371 2 333 4323");

        User renars = new User("Renar", "The Best");
        renars.setFirstName("Renars");
//        renars.setLastName("The Best");
        renars.setPhone("112");

        System.out.println(dmitry.getFirstName() + " " + dmitry.getLastName() +
                " " + dmitry.getPhone());

        System.out.println(renars.getFullName() + " " + renars.getPhone());
    }

    @Test
    public void workingWithFlats() {
        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1));
        flats.add(new Flat(2));
        flats.add(new Flat(3));
        flats.add(new Flat(4));
        flats.add(new Flat(5));

        Address address = new Address("Riga", "Brivibas", 13);

        House houseNr13 = new House();
        houseNr13.setAddress(address);
        houseNr13.setNr(address.getHouseNr());
        houseNr13.setFlats(flats);

        houseNr13.printHouseDetails();
    }
}
