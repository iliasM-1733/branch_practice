package lesson_51;

public class ChainCall {
    public static void main(String[] args) {
        one(10);
    }

    public static void one(int x) {
        System.out.println(x);
        x ++;
        two(x);
    }

    public static void two(int x) {
        System.out.println(x);
        x ++;
        three(x);
    }

    public static void three(int x) {
        System.out.println(x);
        x ++;
        four(x);

    }

    public static void four(int x) {
        System.out.println(x);
        x ++;
        five(x);
    }

    public static void five(int x) {
        System.out.println(x);
        x ++;
        six(x);

    }

    public static void six(int x) {
        System.out.println(x);
        x ++;
        seven(x);
    }

    public static void seven(int x) {
        System.out.println(x);
        x ++;

        // one(x); - пример кольцевой рекурсии, когда метод не вызывает сам себя,
        // но вызывает метод, который в последствии вызовет его

        return; // базовый случай
    }
}
