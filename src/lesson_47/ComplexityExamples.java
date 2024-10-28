package lesson_47;

import java.util.Arrays;
import java.util.List;

public class ComplexityExamples {
    static int counter = 0;

    static int[] fillList (int size) {
        // что будет, если задать размер массива отрицательным числом?
        // или при помощи Long. Почему?
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }


    public static void main(String[] args) {
        //checkO1();
        //checkO2();

        // target 17
        // [0, 1, 2, 3, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
        //  L                          M                                       R
        // logic of binary search:
        // ищем середину массива. Как? -> mid_index = arr.length / 2 (константная операция)
        // M = (R - L) / 2 -> (19 + 0) / 2 -> 9
        // проверяем равен ли элемент под индексом mid_index числу target (17)?
        // if (arr[mid_index] == target) -> return mid_index
        // else if (arr[mid_index] > target) -> ищем в левой части
        // else if (arr[mid_index] < target) -> ищем в правой части
        // продолжаем логику. Так как arr[mid_index] < target = true мы ищем в правой части.
        // L = m + 1
        // [0, 1, 2, 3, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
        //                                 L               M                    R
        // if (R > L) -> M = (R + L) / 2 -> 14
        //          else -> return (нет такого элемента в массиве)
        //
        // if - else-if -else-if ...
        // L = m + 1
        // [0, 1, 2, 3, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
        //                                                     L       M       R
        // R > L ? -> M = (L + R) / 2 = 17
        // if - else if -else if ->


        counter = 0;
        System.out.println(binarySearch(fillList(100), 88));
        System.out.println("size = 100, counter = " + counter);

        counter = 0;
        System.out.println(binarySearch(fillList(100_000), 88));
        System.out.println("size = 100_000, counter = " + counter);

        counter = 0;
        System.out.println(binarySearch(fillList(100_000), 88));
        System.out.println("size = 100_000, counter = " + counter);

        counter = 0;
        System.out.println(binarySearch(fillList(1_000_000), 88));
        System.out.println("size = 1_000_000, counter = " + counter);

        counter = 0;
        System.out.println(binarySearch(fillList(1000_000), -88));
        System.out.println("size = 1_000_000, counter = " + counter);

        counter = 0;
        System.out.println(binarySearch(fillList(2000_000), -88));
        System.out.println("size = 2_000_000, counter = " + counter);

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
    // O(n), где n - размер массива, и время увеличивается линейно - чем больше n, тем дольше выполнение
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Метод 3: Вывод всех пар в массиве
    // O(n^2) -> для 2х элементов надо 4 единицы времени, для 3 -> 9, 4 -> 16 .... n -> n^2
    public static void printAllPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
                // это константная операция.
                // То есть это та операция, которая служит единицей времени в этом алгоритме.
                // Не важно сколько она будет выполняться - 1мс или 1 час,
                // она всегда будет выполняться фиксированное время,
                // следовательно она не влияет на оценку времени выполнения этого алгоритма
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
    // O(ln N)
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }


//              7
//         /        \
//        3         12              -> сложность поиска логарифмическая O(LogN)
//    /      \    /      \
//   2       5    9       15


    private static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        counter++;
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

