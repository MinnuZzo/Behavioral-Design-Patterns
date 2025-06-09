package example;

import java.util.*;

public class IteratorPattern {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ann");
        names.add("John");

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
