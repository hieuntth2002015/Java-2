package ss1.vd4;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> programLanguages = new ArrayList<>();
        programLanguages.add("C");
        programLanguages.add("C++");
        programLanguages.add("Java");
        programLanguages.add("Kotlin");
        programLanguages.add("Python");
        programLanguages.add("Perl");
        programLanguages.add("Ruby");

        System.out.println("Initial List: " + programLanguages);
        programLanguages.remove(5);
        System.out.println("After remove(5) : " + programLanguages);

        boolean isRemoved = programLanguages.remove("kotlin");
        System.out.println("After remove(\"Kotlin\"):" + programLanguages );

        List<String> scriptingLanguages  =new ArrayList<>();
        scriptingLanguages.add("Python");
        scriptingLanguages.add("Ruby");
        scriptingLanguages.add("Perl");

        programLanguages.removeAll(scriptingLanguages);
        System.out.println("After removeAll(scroptingLanguages): " + programLanguages);

        programLanguages.removeIf(n -> (n.charAt(0) == 'T'));
        System.out.println("After Removing all elements that start with \"C\": " + programLanguages);
        programLanguages.clear();
        System.out.println("After clear():" + programLanguages);
    }
}
