package org.hse.example;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Приложение для работы со счастливым
 */
public class App {

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
        //Реализуем служеюный Iterable
        Iterator<MealTicket> generator = new TicketsGenerator();

        //А теперь получим результат с помощью собственного Stream!
        //TODO добавить фабрику вместо конструктора
        long count =
                LongStream
                        .range(0, 1000000)
                        .mapToObj(Ticket::new)
                        .filter(MealTicket::isMealTicket)
                        .map(MealTicket::toString)
                        .peek(System.out::println)
                        .count();

        System.out.println("Счастливых билетов " + count);
    }

}
