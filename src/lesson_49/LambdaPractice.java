package lesson_49;

import java.io.File;
import java.util.function.Function;

public class LambdaPractice {
    // подсказки по управлению IntellijIdea:
    // shift + shift -> быстрое окно поиска
    // mac command (win cntrl) + курсор на тип данных и левой кнопкой клик -> переход к этому классу

    public static void main(String[] args) {
        System.out.println("Пример использования функционального интерфейса без аргументов");

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


        System.out.println("Пример использования функционального интерфейса с аргументами");

        MyFunctionalWithArguments functionalWithArguments1 = ((x, y) -> {
            System.out.println(Math.pow(x, y));
        });

        // (x, y) -> равноценно вот такой записи:
        /*
        public class functionalWithArguments1 implements MyFunctionalWithArguments {
            @Override
            public void methodWithArguments(int x, int y) {
                System.out.println(Math.pow(x, y));
            }
        }
         */

        MyFunctionalWithArguments functionalWithArguments2 = ((a, b) -> {
            for (int i = 0; i < a; i++) {
                System.out.print(b);
            }
            System.out.println();
        });
        // (a, b) -> равноценно вот такой записи:
        /*
        public class functionalWithArguments2 implements MyFunctionalWithArguments {
            @Override
            public void methodWithArguments(int a, int b) {
                for (int i = 0; i < a; i++) {
                    System.out.print(b);
                }
            }
        }
         */

        // использование функциональных интерфейсов
        // тк это просто "экземпляры"функционального интерфейса MyFunctionalWithArguments у каждого из которых
        // своя собственная реализация абстрактного метода, без корректного вызова метода methodWithArguments
        // результат мы не получим
        functionalWithArguments1.methodWithArguments(10, 2);
        functionalWithArguments2.methodWithArguments(3, -2);
        functionalWithArguments2.methodWithArguments(33, 8);

        //один из стандартных функциональных интерфейсов Java
        // тк Function - дефолтный, уже определенный в джава функциональный интерфейс,
        // который принимает в качестве аргумента один (любой) тип данных (T t), а возвращает другой (R) (любой другой),
        // то хорошей практикой будет определить их перед использованием Function ->
        // Function<T, R> -> Function<String, File>
        // также, тк Function - это слишком общий функциональный интерфейс, хорошей практикой будет дать
        // "говорящее", осмымсленное название переменной
        Function<String, File> fileCreatorByPath = (path) -> {
            // тк Function имеет лишь один абстрактный метод:
            // R apply(T t);
            // после реализации мы обязаны вернуть переменную типа данных (R), которую мы определили при создании
            // экземпляра Function, в нашем случае это переменная типа File.

            return new File(path);
        };
    }
}
