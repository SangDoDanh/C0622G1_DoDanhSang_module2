package demo_treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Student, String> maps = new TreeMap<>((o1, o2) -> {
            if(o1.getId() > o2.getId())
                return 1;
            if(o1.getId() < o2.getId())
                return -1;
            return 0;
        });
        maps.put(new Student(1, "A"), "AA");
        maps.put(new Student(2, "B"), "DD");
        maps.put(new Student(3, "C"), "CC");

        for(Map.Entry<Student, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
