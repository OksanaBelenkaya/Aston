
import java.util.*;

public class WordAnalyzer {

    public static void analyzeWords() {
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordCounts = new HashMap<>();

        String[] strings = {"Ясень", "Тис", "Клен", "Ясень", "Граб", "Рябина", "Тис", "Черешня", "Дуб", "Эвкалипт", "Клен",
            "Груша", "Дуб", "Ива", "Клен", "Тис", "Дуб", "Ольха", "Липа", "Береза"};

        for (String word : strings) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.print(word + "; ");
        }
        System.out.println();

        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
