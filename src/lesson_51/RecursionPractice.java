package lesson_51;

public class RecursionPractice {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
//        while (x > 0) {
//            System.out.print(x + ", ");
//            x--;
//        }

        System.out.println("============================");
        x = Integer.MAX_VALUE;
        recursionCounter(x);
    }

    public static void recursionCounter(int x) {
        // базовый случай - обязательное условие в рекурсивных методах,
        // чтобы не провалиться в бесконечные вызовы.
        // ВСЕГДА написание начинается с определения логики базового случая!
        if (x <= 0){
            return;
        }
        // логика того, что должен сделать этот рекурсивный метод
        System.out.print(x + ", ");

        //обязательная часть изменения входных данных!
        x--;

        // рекурсивный вызов. Метод вызывает сам себя с новым значением х:
        recursionCounter(x);
    }

    public static void recursion(int i) {
        System.out.println(i);
        if (i > 55 || i < 0) {
            return;
        }
        recursion(++i);
    }





}
