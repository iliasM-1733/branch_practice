package lesson_49;

public class LambdaPractice {
    public static void main(String[] args) {
        MyFunctional functional1 = () -> System.out.println("hello");
        // () -> равноценно вот такой записи:
        /*
        public class functional1 implements MyFunctional {
            @Override
            public void someMethod() {
                System.out.println("hello");
            }
        }
         */

        MyFunctional functional2 = () -> System.out.println("not hello!");
        // () -> равноценно вот такой записи:
        /*
        public class functional2 implements MyFunctional {
            @Override
            public void someMethod() {
                System.out.println("not hello!");
            }
        }
         */

        MyFunctional functional3 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        };

        // () -> равноценно вот такой записи:
        /*
        public class functional3 implements MyFunctional {
            @Override
            public void someMethod() {
                for (int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
         */

        functional1.someMethod();
        functional2.someMethod();
        functional3.someMethod();
    }
}
