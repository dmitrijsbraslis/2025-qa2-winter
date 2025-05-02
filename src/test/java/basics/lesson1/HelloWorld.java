package basics.lesson1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class HelloWorld {
    @Test
    public void printHelloWorld() {
        System.out.println("Hello, world!");

        byte age = 127;
        Byte bigAge = null;

        short distance = 32767;
        Short bigDistance = null;

        int userId = 2146545689;
        Integer bigUserId = 45678876;

        long id = 4567887654456L;
        Long bigId = 56789765567L;

        float price = 13.76F;
        Float bigPrice = 999.99F;

        double weight = 4.4098;
        Double bigWeight = 8888.9865;
        double secondWeight = 77.8;

        char letter = 'h';
        Character space = ' ';

        String text = "Hello, Susanna!";
        String oneChar = "h";

        boolean isLightSwitchedOn = true;
        Boolean isLecturerDead = true;

        double result = weight + secondWeight; //result = 4.4098+77.8

        BigDecimal carPrice = new BigDecimal("3456.87");
        BigDecimal secondCarPrice = new BigDecimal("66547.65");

        carPrice.add(secondCarPrice);

        //Comment
        //Comment 2

        /*
         * Multiple
         * line
         * comment
         */


    }

    @Test
    public void variablesExamples() {
        int a = 13;
        int b = 44;

        String c = "13";
        String d = "44";

        System.out.println(a + b); //57
        System.out.println(c + d); //1344

        String name = "Dmitrijs";
        String surname = "The Tester";
        System.out.println(name + " " + surname);

        System.out.println(a + c);
        System.out.println(c + a);

        int x = 12345;
        String y = "12345";

        int z = Integer.parseInt(y);
        System.out.println(z);

        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Date without time: " + date);
        System.out.println("Date with time: " + dateTime);

        System.out.println(date.plusYears(5).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY));
    }
}
