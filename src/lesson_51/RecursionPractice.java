package lesson_51;

public class RecursionPractice {
    public static void main(String[] args) {
        int x = 10;
        while (x > 0) {
            System.out.println(x);
            x--;
        }
    }




    public static void recursion(int i) {
        System.out.println(i);
        if (i > 55 || i < 0) {
            return;
        }
        recursion(++i);
    }





}
