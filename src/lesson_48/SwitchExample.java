package lesson_48;

import java.time.DayOfWeek;
import java.util.Spliterator;

public class SwitchExample {
    public static void main(String[] args) {
        useSwitch(DayOfWeek.TUESDAY);
        useIfElse(DayOfWeek.TUESDAY);
    }

    private static void useSwitch(DayOfWeek day) {
        switch (day) {
            case MONDAY:
                System.out.println("Сегодня понедельник");
                break;
            case TUESDAY:
                System.out.println("Сегодня вторник");
                break;
            case WEDNESDAY:
                System.out.println("Сегодня среда");
                break;
            case THURSDAY:
                System.out.println("Сегодня четверг");
                break;
            case FRIDAY:
                System.out.println("Сегодня пятница");
                break;
            case SATURDAY:
                System.out.println("Сегодня суббота");
                break;
            case SUNDAY:
                System.out.println("Сегодня воскресенье");
        }
    }

    private static void useIfElse(DayOfWeek day) {
        if (day == DayOfWeek.MONDAY) {
            System.out.println("Сегодня понедельник");
        } else if (day == DayOfWeek.TUESDAY) {
            System.out.println("Сегодня вторник");
        } else if (day == DayOfWeek.WEDNESDAY) {
            System.out.println("Сегодня среда");
        } else if (day == DayOfWeek.THURSDAY) {
            System.out.println("Сегодня четверг");
        } else if (day == DayOfWeek.FRIDAY) {
            System.out.println("Сегодня пятница");
        } else if (day == DayOfWeek.SATURDAY) {
            System.out.println("Сегодня суббота");
        } else if (day == DayOfWeek.SUNDAY) {
            System.out.println("Сегодня воскресенье");
        }

        }
    }



}
