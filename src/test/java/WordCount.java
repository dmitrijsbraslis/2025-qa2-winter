import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

public class WordCount {
    @Test
    public void countUniqueWords() {
        String text = "This is some text to pares and to count unique words!";
        text = text.replaceAll("!", "");
        String[] words = text.split(" ");

        HashMap<String, Integer> uniqueWords = new HashMap<>();
        for (String w : words) {
            uniqueWords.put(w, 0);
        }

        System.out.println(uniqueWords.size());
    }

    @Test
    public void someDataTimeManipulations() {
        LocalDateTime dateTime = LocalDateTime.now();
        String dataTimeAsString = dateTime.toString();
        System.out.println(dataTimeAsString);
    }
}
