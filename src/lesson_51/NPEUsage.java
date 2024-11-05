package lesson_51;

import java.util.Optional;
import java.util.Scanner;

public class NPEUsage {
    public static void main(String[] args) {
        Optional<Scanner> optionalScanner = Optional.empty(); // == null;
        // Optional<Scanner> optionalScanner = Optional.of(new Scanner(System.in)); // not null

        if (optionalScanner.isPresent()) {
            Scanner scanner = optionalScanner.get();
        }

        Scanner scanner = optionalScanner.orElseGet(() -> new Scanner(System.in));

//        строка выше равносильна записи ниже:

//        if (optionalScanner.isPresent()) {
//            Scanner scanner = optionalScanner.get();
//        } else {
//            Scanner scanner = new Scanner(System.in);
//        }
    }


    public static void npeExample() {
        Scanner scanner = null;
        if (scanner != null) {
            scanner.hasNext();
        }

        try {
            scanner.hasNext();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


}
