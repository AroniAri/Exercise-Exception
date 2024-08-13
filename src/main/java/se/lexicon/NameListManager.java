package se.lexicon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NameListManager {
    private List<String> names = new ArrayList<>();

    public void addName(String name) throws DuplicateNameException {
        if (names.contains(name)) {
            throw new DuplicateNameException("Duplicate name: " + name);
        }
        names.add(name);
        System.out.println("Name added: " + name);
    }

    public String findName(String name) throws NameNotFoundException {
        if (!names.contains(name)) {
            throw new NameNotFoundException("Name not found: " + name);
        }
        return name;
    }

    public static void main(String[] args) {
        NameListManager manager = new NameListManager();

        try {
            manager.addName("Arta");
            manager.addName("Bob");
            manager.addName("Alice"); // This will trigger the DuplicateNameException
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Found: " + manager.findName("Arta"));
            System.out.println("Found: " + manager.findName("Charlie")); // This will trigger the NameNotFoundException
        } catch (NameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



    public class WriteToFileDemo {
        public static void main(String[] args) {
            String content = "This is a sample text to be written to the file.";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write(content);
                System.out.println("File written successfully.");
            } catch (IOException e) {
                System.out.println("Error: An I/O error occurred.");
            }
        }
    }

}
