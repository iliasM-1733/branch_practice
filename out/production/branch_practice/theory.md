## Lesson 48


<details>
<summary>Многослойная архитектура в Java</summary>

# Многослойная архитектура в Java

## Цели урока

### Понять принципы многослойной архитектуры

Многослойная архитектура — это подход к разработке программного обеспечения, при котором приложение разделяется на
отдельные слои, каждый из которых имеет свои задачи и ответственность. Это помогает организовать код таким образом,
чтобы он был более управляемым, модульным и легким в тестировании и поддержке. Основные слои включают:

- **Слой представления (Presentation Layer)**: Отвечает за взаимодействие с пользователем, отображение данных и
  интерпретацию пользовательских команд.
- **Слой бизнес-логики (Business Logic Layer)**: Содержит логику обработки данных, которая определяет правила работы
  приложения.
- **Слой доступа к данным (Data Access Layer)**: Обеспечивает доступ к данным, хранящимся в базе данных или других
  хранилищах, скрывая детали реализации.

### Научиться выделять сервисы, репозитории и модели в Java-проектах

- **Модели (Models)**: Классы, представляющие структуру данных, с которыми работает приложение. Например, класс `User`
  может представлять пользователя с полями для имени, электронной почты и т.д.
- **Репозитории (Repositories)**: Интерфейсы и их реализации, которые обеспечивают абстракцию для доступа к данным,
  скрывая за собой запросы к базе данных. Это позволяет легко изменять способы хранения данных без внесения изменений в
  бизнес-логику.
- **Сервисы (Services)**: Компоненты, содержащие бизнес-логику приложения. Они работают с моделями и репозиториями для
  выполнения операций, таких как регистрация пользователя, обработка заказов и т.д.

### Применить полученные знания на практическом примере

На практике мы реализуем простое приложение, используя многослойную архитектуру. Например, приложение для управления
библиотекой, где будет необходимо:

- Определить модели для представления книг, авторов и читателей.
- Создать репозитории для обращения к базе данных для этих сущностей.
- Разработать сервисы, которые будут использовать репозитории для выполнения операций, таких как добавление новой книги
  в каталог или регистрация читателя в системе.
  Это поможет студентам понять, как применять многослойную архитектуру на практике, и увидеть преимущества такого
  подхода в реальной разработке.

## Введение

### Обзор концепции многослойной архитектуры

Многослойная архитектура — это популярный подход в разработке программного обеспечения, который предполагает разделение
приложения на отдельные слои, где каждый слой выполняет свою уникальную функцию. Этот подход облегчает разработку,
тестирование, управление и поддержку приложения за счет четкого разделения ответственности между компонентами.
Многослойная архитектура позволяет разработчикам и командам работать над разными частями приложения параллельно,
минимизируя риски и упрощая интеграцию.

### Почему многослойная архитектура важна для крупных проектов

Для крупных проектов многослойная архитектура является ключом к успешной разработке и поддержке по нескольким причинам:

- **Масштабируемость**: Легко добавлять новые функции и модули, не затрагивая существующую логику.
- **Облегченная поддержка**: Изменения в одном слое вносятся независимо, что уменьшает вероятность ошибок и упрощает
  обновления.
- **Гибкость**: Возможность заменять или модифицировать отдельные слои без влияния на остальные части системы.
- **Тестируемость**: Проще писать и поддерживать тесты для отдельных компонентов.

### Слои архитектуры: представление, бизнес-логика (сервисы), доступ к данным (репозитории)

- **Слой представления (Presentation Layer)**: Отвечает за взаимодействие с пользователем. Здесь реализуются интерфейсы
  приложения, включая веб-страницы и мобильные приложения.
- **Слой бизнес-логики (Business Logic Layer)**: Содержит основную функциональность приложения. Этот слой обрабатывает
  запросы пользователя, выполняя соответствующие операции через сервисы, такие как обработка заказов или управление
  аккаунтами.
- **Слой доступа к данным (Data Access Layer)**: Обеспечивает связь с источниками данных, такими как базы данных и
  внешние сервисы. Репозитории в этом слое инкапсулируют логику запросов к данным, предоставляя абстрактный интерфейс
  для работы с ними.

Эти слои работают вместе, чтобы создать структурированное и эффективно функционирующее приложение, где каждая часть
специализируется на выполнении своих задач и взаимодействует с другими только через строго определенные интерфейсы.

## Основные понятия

### Модель (Model)

Модель в многослойной архитектуре — это представление данных, с которыми работает приложение. Модели описывают структуру
данных через классы и объекты, включая их атрибуты и поведение. В контексте Java, модель обычно реализуется в виде
классов с приватными полями и публичными методами для доступа (getters) и изменения (setters) этих полей. Модели служат
для передачи данных между слоями приложения, позволяя, например, сервисам обрабатывать данные пользователя или
информацию о продуктах.

### Репозиторий (Repository)

Репозиторий в многослойной архитектуре — это компонент, отвечающий за доступ к данным. Он предоставляет абстракцию над
слоем хранения данных, таким как база данных, позволяя сервисному слою взаимодействовать с данными без необходимости
знать о конкретных деталях реализации доступа к данным. Репозитории содержат методы для выполнения операций с данными,
таких как создание, чтение, обновление и удаление (CRUD). Использование репозиториев способствует отделению
бизнес-логики от деталей реализации доступа к данным, упрощая разработку и поддержку приложения.

### Сервис (Service)

Сервисный слой в многослойной архитектуре содержит бизнес-логику приложения. Сервисы обрабатывают бизнес-операции,
используя модели и репозитории. Сервисный слой отвечает за выполнение бизнес-правил и обеспечивает логику, необходимую
для выполнения операций, специфичных для приложения. Например, в приложении для электронной коммерции сервис может
обрабатывать оформление заказа, включая проверку наличия товара на складе, расчет стоимости доставки и обработку
платежей. Сервисы могут взаимодействовать с одним или несколькими репозиториями для получения и сохранения данных, а
также могут вызывать другие сервисы для выполнения сложных операций.

## Разбор слоев архитектуры

### Модель

#### Определение классов модели

Классы модели в Java обычно определяются с использованием публичных классов, которые инкапсулируют данные приложения.
Эти классы содержат приватные поля для хранения данных и публичные методы для доступа и изменения этих данных (геттеры и
сеттеры). Модели могут также включать бизнес-логику, относящуюся непосредственно к данным.

#### Примеры моделей: User, Product, Order

- **User**: представляет пользователя системы с полями для имени, электронной почты и пароля.
- **Product**: описывает продукт с полями для наименования, цены и описания.
- **Order**: представляет заказ, содержащий информацию о покупателе, списке заказанных продуктов и статусе заказа.

### Репозиторий

#### Роль репозитория в архитектуре

Репозиторий служит мостом между слоем бизнес-логики и слоем хранения данных, предоставляя абстрактный интерфейс для
запросов к данным. Это позволяет изменять способы хранения данных без влияния на бизнес-логику.

#### Пример создания интерфейса репозитория и его реализации

```java
public interface UserRepository {
    User findById(Long id);

    void save(User user);
}

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(Long id) {
        // Реализация метода для поиска пользователя по ID
    }

    @Override
    public void save(User user) {
        // Реализация метода для сохранения пользователя в базе данных
    }
}
```

### Сервис

#### Задачи сервисного слоя

Сервисный слой отвечает за выполнение бизнес-логики приложения, обработку правил и операций, специфичных для бизнеса. Он
использует модели для представления данных и репозитории для их сохранения и извлечения.

#### Создание сервиса: интерфейс и реализация

```java
public interface UserService {
    User registerUser(User user);
}

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        // Логика регистрации пользователя
        userRepository.save(user);
        return user;
    }
}
```

Взаимодействие сервиса с репозиторием
Сервисный слой взаимодействует с репозиторием для выполнения операций с данными. В примере выше, `UserServiceImpl`
использует `UserRepository` для сохранения пользователя в базе данных. Это демонстрирует, как сервисы могут использовать
репозитории для доступа к данным и их манипуляции, обеспечивая при этом выполнение бизнес-правил и логики.

</details>
_____________

<details>
<summary>Рекурсия и теория Big-O</summary>
<details>
<summary>Рекурсия</summary>

## Рекурсия

## Введение в рекурсию

Рекурсия в программировании — это когда функция вызывает сама себя для решения подзадачи. Рекурсия часто используется
для решения задач, которые можно разбить на более мелкие, однотипные задачи.

### Определение рекурсии

Рекурсивная функция — это функция, которая для решения задачи вызывает сама себя с новым набором параметров.

### Примеры рекурсивных функций

- Факториал числа:  `n! = n * (n-1)! `
- Быстрое возведение в степень: `a^n = a * a^{(n-1)} `
- Вычисление чисел Фибоначчи: `F(n) = F(n-1) + F(n-2)`

### Основные компоненты рекурсивной функции

1. **Базовый случай**: условие, при котором рекурсия остановится. Без базового случая функция будет вызывать сама себя
   бесконечно.
2. **Рекурсивный случай**: вызов функции самой себя с новым набором параметров.

### Важность предотвращения бесконечной рекурсии

Бесконечная рекурсия может привести к переполнению стека и аварийному завершению программы. Чтобы избежать этого, важно
всегда иметь базовый случай и убедиться, что каждый рекурсивный вызов приближает нас к нему.

## Примеры рекурсивных задач

Рекурсия может быть использована для решения разнообразных задач в программировании. Давайте рассмотрим несколько
классических примеров.

### Факториал числа

Факториал числа  `n` , обозначаемый как `n!`, — это произведение всех положительных целых чисел от `1` до `n`.

```java
    int factorial(int n){
        if(n<=1){
        return 1; // базовый случай
        }
        return n*factorial(n-1); // рекурсивный случай
        }
```

Функция `factorial` вызывает сама себя с уменьшенным на единицу параметром, пока не достигнет базового случая.

### Числа Фибоначчи

Числа Фибоначчи — это последовательность чисел, в которой каждое число является суммой двух предыдущих.

```java
int fibonacci(int n){
    if(n<=1){
        return n; // базовые случаи
    }
    return fibonacci(n-1)+fibonacci(n-2); // рекурсивный случай
}
```

Функция `fibonacci` вызывает сама себя дважды с параметрами  `n - 1` и `n - 2` , пока не достигнет базовых случаев.

### Поиск в глубину в графе или дереве

Рекурсия также часто используется для обхода структур данных, таких как графы и деревья.

<details style="margin-left: 20px;">
<summary>Пример кода:</summary>

```java
package algorithms.lesson10trees;


import java.util.*;

// пример бинарного дерева с рекурсивным обходом в глубину
public class BinaryTree {
    public static void main(String[] params) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        System.out.println("Сумма дерева: " + Tree.sumWide(root));
        //System.out.println(root.sumRecursive(root));

        Set<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        // пример бинарного дерева с рекурсивным обходом в глубину
        public int sumRecursive(Tree root) {
            int summ = root.value;

            System.out.println(root.value);

            if (root.left != null) {
                summ += sumRecursive(root.left);
            }

            if (root.right != null) {
                summ += sumRecursive(root.right);
            }
            return summ;
        }

        // пример бинарного дерева с итеративным обходом в глубину
        public static int sumDeep(Tree root) {
            Stack<Tree> stack = new Stack<>();
            stack.push(root);

            int summ = 0;

            while (!stack.isEmpty()) {
                Tree node = stack.pop();

                System.out.println(node.value);

                summ = summ + node.value;

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return summ;
        }

        // пример бинарного дерева с итеративным обходом в ширину
        public static int sumWide(Tree root) {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);

            int summ = 0;

            while (!queue.isEmpty()) {
                Tree node = queue.remove();

                System.out.println(node.value);

                summ = summ + node.value;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return summ;
        }
    }
}
```

</details>

## Преимущества и недостатки рекурсии

Рекурсия — мощный инструмент в программировании, но, как и любой инструмент, он имеет свои преимущества и недостатки.

### Преимущества рекурсии

1. **Понятность и Чистота Кода**: Рекурсивные решения часто бывают более прямолинейными и легче для понимания, особенно
   когда задача естественным образом разделяется на подзадачи.
2. **Упрощение Сложных Задач**: Некоторые задачи сложно решить итеративно, но они становятся гораздо более управляемыми
   при использовании рекурсии.
3. **Мощь и Гибкость**: Рекурсия позволяет решать сложные задачи, такие как обход деревьев и графов, с минимальным
   объемом кода.

### Недостатки рекурсии

1. **Потребление Памяти**: Каждый рекурсивный вызов требует дополнительного пространства в стеке вызовов, что может
   привести к переполнению стека при большой глубине рекурсии.
2. **Временные Затраты**: Рекурсивные вызовы могут быть менее эффективными по сравнению с итеративными решениями из-за
   дополнительных затрат на вызов функции и возврат из нее.
3. **Сложность Отладки**: Рекурсивный код может быть сложнее отлаживать и понимать, особенно для тех, кто не привык к
   такому стилю программирования.

Как и в случае с любым инструментом в программировании, важно понимать, когда рекурсия является лучшим выбором, и когда
стоит отдать предпочтение итеративным методам.

## Оптимизация рекурсивных функций

Даже когда рекурсия предоставляет чистое и элегантное решение, важно учитывать ее потребление ресурсов и работать над
оптимизацией для предотвращения излишних затрат на время выполнения и память.

### Мемоизация

Мемоизация — это техника хранения результатов предыдущих вызовов функции для предотвращения их повторного вычисления.

```java
int fibonacci(int n,int[]memo){
        if(n<=1)return n; // базовые случаи
        if(memo[n]!=-1)return memo[n]; // возвращаем сохраненный результат, если он есть
        memo[n]=fibonacci(n-1,memo)+fibonacci(n-2,memo); // сохраняем результат перед возвратом
        return memo[n];
        }
```

Инициализируйте массив `memo` значениями -1 и передайте его в функцию. Результаты каждого вычисления будут сохранены и
повторно использованы, что существенно сократит время выполнения.

### Хвостовая рекурсия

Хвостовая рекурсия происходит, когда рекурсивный вызов является последней операцией в функции. Некоторые компиляторы и
интерпретаторы оптимизируют хвостовую рекурсию, сокращая использование стека.

```java
int factorial(int n,int accumulator=1){
        if(n<=1)return accumulator;
        return factorial(n-1,n*accumulator); // хвостовой рекурсивный вызов
        }

```

В этом примере состояние вычисления хранится в аккумуляторе, и нет необходимости сохранять предыдущие состояния функции
на стеке.

### Оценка производительности

После внесения оптимизаций важно оценить производительность рекурсивной функции, сравнив ее с итеративными аналогами и
убедившись, что она соответствует требованиям к производительности вашего приложения.

Оптимизация рекурсивных функций требует понимания их работы и того, как они взаимодействуют с системой. Правильное
применение этих техник может привести к более эффективному и быстрому коду.

<details style="margin-left: 20px;">
<summary>Пример кода:</summary>

```java
public class PerformanceComparison {

    public static void main(String[] args) {
        int number = 100; // Выберите число для вычисления факториала. Будьте осторожны с большими числами, так как это может привести к переполнению стека в рекурсивном методе.

        // Измерение времени для итеративного метода
        long startTime = System.nanoTime();
        long iterativeResult = factorialIterative(number);
        long endTime = System.nanoTime();
        long durationIterative = endTime - startTime;

        System.out.println("Итеративный метод: " + iterativeResult + ", Время выполнения: " + durationIterative + " наносекунд");

        // Измерение времени для рекурсивного метода
        startTime = System.nanoTime();
        long recursiveResult = factorialRecursive(number);
        endTime = System.nanoTime();
        long durationRecursive = endTime - startTime;

        System.out.println("Рекурсивный метод: " + recursiveResult + ", Время выполнения: " + durationRecursive + " наносекунд");
    }

    public static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
```

</details>

## Применение рекурсии

Рекурсия широко используется в программировании и может быть очень эффективной для определенных типов задач.

### Алгоритмы поиска и обхода

- **Бинарный поиск**: Рекурсивное деление массива пополам до нахождения искомого элемента.
- **Обход дерева**: Применение обхода в глубину (Depth-First Search, DFS) для деревьев и графов.

### Алгоритмы сортировки

- **Быстрая сортировка**: Рекурсивное деление массива и его сортировка.
- **Сортировка слиянием**: Рекурсивное деление массива, сортировка и последующее слияние.

### Математические задачи

- **Вычисление факториала**: `n! = n * (n-1)!`
- **Числа Фибоначчи**: `F(n) = F(n-1) + F(n-2)`

### Работа со структурами данных

- Рекурсивный обход деревьев и графов.
- Алгоритмы на графах, например, поиск кратчайшего пути.

### Алгоритмы разделения и завоевания

- Быстрая сортировка и сортировка слиянием – яркие примеры.

### Рекурсия в графических интерфейсах

- Создание фракталов и других визуальных эффектов.

### В программировании компиляторов

- Рекурсивный спуск при синтаксическом анализе.

### Игры и решение головоломок

- Алгоритмы для Ханойской башни и других головоломок.
- Алгоритмы для игр с рекурсивной логикой.

## Преимущества и недостатки рекурсии

### Преимущества:

1. **Простота и чистота кода**: Рекурсивные решения часто более лаконичны и понятны.
2. **Прямое отображение математических определений**: Многие математические формулы естественно выражаются через
   рекурсию.

### Недостатки:

1. **Эффективность**: Рекурсивные вызовы могут быть менее эффективными и тратить больше ресурсов, особенно если
   отсутствует оптимизация хвостовой рекурсии.
2. **Ограничение стека**: Глубокие рекурсивные вызовы могут привести к переполнению стека.

### Заключение

Рекурсия – мощный инструмент, но важно понимать ее ограничения и уметь определять, когда лучше использовать итеративные
методы. В некоторых случаях комбинация рекурсии и мемоизации может предложить оптимальное решение, сохраняя простоту
рекурсивного подхода и повышая производительность.
</details>

<details>
<summary>Временная Сложность и Нотация "Большое О"</summary>

# Временная Сложность и Нотация "Большое О"

## Определение

**Большое О (O-нотация)** — это математическая нотация, используемая в информатике для описания ограничения сверху на
временную сложность алгоритма как функцию от размера входных данных. Она дает верхнюю границу времени выполнения,
показывая наихудший случай выполнения алгоритма.

Примеры

- `O(1)`: Время выполнения константно. Пример: доступ к элементу массива по индексу.
- `O(log n)`: Время выполнения растет логарифмически по отношению к размеру входных данных. Пример: бинарный поиск.
- `O(n)`: Время выполнения растет линейно с увеличением размера входных данных. Пример: линейный поиск.
- `O(n log n)`: Время выполнения растет линейно-логарифмически. Пример: сортировка слиянием.
- `O(n^2)`: Время выполнения растет квадратично. Пример: сортировка пузырьком.
- `O(2^n)`: Время выполнения растет экспоненциально. Пример: рекурсивное вычисление чисел Фибоначчи.

## Зачем Это Нужно

Понимание временной сложности алгоритмов позволяет программистам делать обоснованные выборы в отношении алгоритмов и
структур данных, что в свою очередь влияет на производительность и эффективность программ.

## Рекурсия и Большое О

В случае рекурсивных алгоритмов, Большое О может помочь понять, как изменится время выполнения с увеличением размера
входных данных и глубины рекурсии. Рекурсивные алгоритмы могут иметь высокую временную сложность из-за множественных
вызовов функций и использования дополнительной памяти в стеке вызовов.

## Важные Моменты

Большое О описывает наихудший случай: Важно понимать, что Большое О дает оценку наихудшего случая выполнения, а не
среднего или наилучшего.
Константы и Меньшие Слагаемые Игнорируются: В Большом О константы и меньшие слагаемые игнорируются.
Например, `O(2n + 5)`
упрощается до `O(n)`.
Заключение
Большое О является критически важным инструментом для оценки эффективности алгоритмов. Понимание временной сложности
алгоритма помогает программистам принимать обоснованные решения при выборе алгоритмов и структур данных, что, в свою
очередь, может значительно повлиять на производительность программы.

## Математическая сложность

- Константная сложность `O(1)`
  Это означает, что время выполнения алгоритма не зависит от размера входных данных. Независимо от того, насколько
  велики или малы входные данные, алгоритм будет выполняться за одинаковое количество времени. Примером может служить
  доступ к элементу массива по индексу.

- Линейная сложность `O(n)`
  Время выполнения алгоритма пропорционально размеру входных данных. Например, если у нас есть массив из n элементов, и
  мы хотим пройтись по всем элементам и что-то с ними сделать, время выполнения будет пропорционально n. Пример: поиск
  элемента в неотсортированном массиве.

- Степенная сложность `O(n^k)`, где `k` - константа
  Время выполнения алгоритма пропорционально размеру входных данных, возведенному в степень `k`. Это более медленно, чем
  линейная сложность, и часто встречается в алгоритмах с вложенными циклами. Пример: пузырьковая сортировка имеет
  сложность O(n^2).

- Логарифмическая сложность `O(log(n))`
  Время выполнения алгоритма пропорционально логарифму от размера входных данных. Это означает, что при увеличении
  входных данных в k раз, время выполнения увеличится только на константу. Пример: бинарный поиск в отсортированном
  массиве.

- Факториальная сложность `O(n!)`
  Время выполнения алгоритма растет факториально с увеличением размера входных данных. Это одна из самых медленных форм
  роста времени выполнения, и такие алгоритмы становятся непрактичными даже при относительно небольших значениях n.
  Пример: решение задачи коммивояжера методом полного перебора всех возможных маршрутов.

Каждый из этих типов сложности описывает, как время выполнения алгоритма изменяется в зависимости от размера входных
данных, и помогает разработчикам понять, какой алгоритм лучше всего подходит для решения конкретной задачи.

![img.png](img.png)
</details>
</details>