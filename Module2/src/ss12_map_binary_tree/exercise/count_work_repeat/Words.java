package ss12_map_binary_tree.exercise.count_work_repeat;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words;

        System.out.println("Enter words: ");
        words = sc.nextLine();
        countCountRepeat(words);
    }

    /**
     * Đếm và hiển thị số lần suất hiện của mỗi từ trong một chuỗi
     * @param str đếm từ trong này
     */
    static void countCountRepeat(String str) {
        str = str.toLowerCase();
        String[] words = str.split("\\s");
        Map<String, Integer> wordsMap = new TreeMap<>();
        boolean isFindWord;

        for (String word : words) {
            isFindWord = wordsMap.containsKey(word);
            if (!isFindWord) {
                wordsMap.put(word, 1);
            } else {
                int countRepeat = wordsMap.get(word);
                countRepeat += 1;
                wordsMap.put(word, countRepeat);
            }
        }

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.printf("%s:\t%d\n", entry.getKey(), entry.getValue());
        }
    }
}
