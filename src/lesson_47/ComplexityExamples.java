package lesson_47;

import java.util.Arrays;
import java.util.List;

public class ComplexityExamples {

    static int[] fillList (int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        //checkO1();
        checkO2();
    }

    // проверка константного big-O (O(1))
    public static void checkO1() {
        // инициализация переменных
        // проверяем скорость работы для массивов разного размера
        int[] arr1 = fillList(100_000);
        int[] arr2 = fillList(200_000);
        int[] arr3 = fillList(300_000);
        int[] arr4 = fillList(400_000);
        int[] arr5 = fillList(500_000);
        int[] arr6 = fillList(600_000);

        // начало первой операции в наносекундах от 1.01.1970 (? уточнить)
        long startTime1 = System.nanoTime();
        getElement(arr1, 34_567);
        long finishTime1 = System.nanoTime() - startTime1;

        long startTime2 = System.nanoTime();
        getElement(arr2, 109_678);
        long finishTime2 = System.nanoTime() - startTime2;

        long startTime3 = System.nanoTime();
        getElement(arr3, 234_876);
        long finishTime3 = System.nanoTime() - startTime3;

        long startTime4 = System.nanoTime();
        getElement(arr4, 334_876);
        long finishTime4 = System.nanoTime() - startTime4;

        long startTime5 = System.nanoTime();
        getElement(arr5, 434_876);
        long finishTime5 = System.nanoTime() - startTime5;

        long startTime6 = System.nanoTime();
        getElement(arr6, 523_234);
        long finishTime6 = System.nanoTime() - startTime6;

        System.out.println("время в нс на поиск элемента в массиве arr1, состоящем из 100_000 элементов = " + finishTime1);
        System.out.println("время в нс на поиск элемента в массиве arr2, состоящем из 200_000 элементов = " + finishTime2);
        System.out.println("время в нс на поиск элемента в массиве arr3, состоящем из 300_000 элементов = " + finishTime3);
        System.out.println("время в нс на поиск элемента в массиве arr4, состоящем из 400_000 элементов = " + finishTime4);
        System.out.println("время в нс на поиск элемента в массиве arr5, состоящем из 500_000 элементов = " + finishTime5);
        System.out.println("время в нс на поиск элемента в массиве arr6, состоящем из 600_000 элементов = " + finishTime6);

    }

    // проверка константного big-O (O(1))
    public static void checkO2() {
        // инициализация переменных
        // проверяем скорость работы для массивов разного размера
        int[] arr1 = fillList(100_000);
        int[] arr2 = fillList(1_000_000);
        int[] arr3 = fillList(10_000_000);
        int[] arr4 = fillList(50_000_000);
        int[] arr5 = fillList(100_000_000);
        int[] arr6 = fillList(1_000_000_000);

        // начало первой операции в наносекундах от 1.01.1970 (? уточнить)
        long startTime1 = System.nanoTime();
        linearSearch(arr1, -1);
        long finishTime1 = System.nanoTime() - startTime1;

        long startTime2 = System.nanoTime();
        linearSearch(arr2, -1);
        long finishTime2 = System.nanoTime() - startTime2;

        long startTime3 = System.nanoTime();
        linearSearch(arr3, -1);
        long finishTime3 = System.nanoTime() - startTime3;

        long startTime4 = System.nanoTime();
        linearSearch(arr4, -1);
        long finishTime4 = System.nanoTime() - startTime4;

        long startTime5 = System.nanoTime();
        linearSearch(arr5, -1);
        long finishTime5 = System.nanoTime() - startTime5;

        long startTime6 = System.nanoTime();
        linearSearch(arr6, -1);
        long finishTime6 = System.nanoTime() - startTime6;

        System.out.println("время в нс на поиск элемента в массиве arr1, состоящем из 100_000 элементов = " + finishTime1);
        System.out.println("время в нс на поиск элемента в массиве arr2, состоящем из 1_000_000 элементов = " + finishTime2);
        System.out.println("время в нс на поиск элемента в массиве arr3, состоящем из 10_000_000 элементов = " + finishTime3);
        System.out.println("время в нс на поиск элемента в массиве arr4, состоящем из 50_000_000 элементов = " + finishTime4);
        System.out.println("время в нс на поиск элемента в массиве arr5, состоящем из 100_000_000 элементов = " + finishTime5);
        System.out.println("время в нс на поиск элемента в массиве arr6, состоящем из 1_000_000_000 элементов = " + finishTime6);
    }

    // Метод 1: Прямой доступ к элементу массива
    public static int getElement(int[] array, int index) {
        return array[index];
    }



    // Метод 2: Линейный поиск
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Метод 3: Вывод всех пар в массиве
    public static void printAllPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    // Метод 4: Рекурсивное вычисление чисел Фибоначчи
    // пропущено
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Метод 5: Бинарный поиск
    // пропущено
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(array, target, low, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, high);
        }
    }

    // Метод 6: Проход по двум разным массивам
    public static void twoArrays(int[] arrayA, int[] arrayB) {
        for (int i : arrayA) {
            System.out.println(i);
        }
        for (int i : arrayB) {
            System.out.println(i);
        }
    }

    // Метод 7: Генерация всех перестановок строки
    public static void generatePermutations(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                generatePermutations(str, start + 1, end);
                str = swap(str, start, i); // backtrack
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    // Метод 8: Умножение матриц
    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Матрицы несовместимы для умножения");
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Метод 9: Рекурсивное вычисление чисел Фибоначчи с кэшированием и копирование массива
    public static int fibonacci(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
        return cache[n];
    }

    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // Метод 10: Проход по массиву и сортировка
    public static void arrayTraversalAndSorting(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        Arrays.sort(array);
    }
}

