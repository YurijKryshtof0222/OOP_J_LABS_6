package labs.laba7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.util.*;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static TrainSchedule routeList = new TrainSchedule();

    static {
        routeList.add(new TrainRoute("Київ", "Трускавець", 6, 30));
        routeList.add(new TrainRoute("Кременчук", "Ворохта", 6, 50));
        routeList.add(new TrainRoute("Полтава", "Чернівці", 6, 50));
        routeList.add(new TrainRoute("Львів", "Рахів", 7, 37));
        routeList.add(new TrainRoute("Дніпро", "Трускавець", 8, 43));
        routeList.add(new TrainRoute("Львів", "Рівне", 9, 50));
        routeList.add(new TrainRoute("Львів", "Покровськ", 10, 40));
        routeList.add(new TrainRoute("Суми", "Івано-Франківськ", 10, 46));
        routeList.add(new TrainRoute("Ужгород", "Київ", 11, 46));
        routeList.add(new TrainRoute("Відень", "Київ", 12, 0));
    }
    public static void main(String[] args) throws IOException {
        System.out.println("------Розклад руху призначених пасажирських поїздів------");
        boolean exitState = false;
        while (!exitState) {

            System.out.println("\n0.)Вийти з програми");
            System.out.println("1.)Додати інформацію про маршрут поїзда");
            System.out.println("2.)Дізнатись про час прибуття поїзда у вокзал за певним маршрутом");
            System.out.println("3.)Видалити інформацію про маршрут поїзда");
            System.out.println("4.)Вивести весь список розкладу руху");
            System.out.print("\nВкажіть дію(лише цифру): ");

            //char inputChar = (char)input.read() // не бажано: може зчитувати \n
            char inputChar = input.readLine().charAt(0);
            switch (inputChar) {
                case '0' -> exitState = true;
                case '1' -> addRoute();
                case '2' -> getMapOfSelectedRoutes();
                case '3' -> removeRoute();
                case '4' -> printSchedule();
                default  -> System.out.println("Помилка: ви ввели невірну команду");
            }
        }

    }

    private static String input(String text) throws IOException {
        System.out.print(text);
        return input.readLine().strip();
    }

    private static void addRoute() throws IOException {
        String src, dst;
        int hour, minutes;

        try {
            System.out.println("\nВкажіть дані маршруту:");
            src = input("Місто, звідки поїзд прибуває: ");
            dst = input("Місто, куди поїзд має прибути у кінцевому рахунку: ");
            hour = Integer.parseInt(input("Година часу, коли поїзд має прибути у станцію Львів: "));
            minutes = Integer.parseInt(input("Хвилина часу, коли поїзд має прибути у станцію Львів: "));
            routeList.add(new TrainRoute(src, dst, hour, minutes));
            System.out.println("Інформація про вказаний маршрут успішна додана у розклад!");
        } catch (NumberFormatException | DateTimeException e) {
            System.out.println("Неправильно заданий час!");
        }

    }

    private static void getMapOfSelectedRoutes() throws IOException {
        System.out.println("\nВкажіть дані маршруту:");
        String src = input("Місто, звідки поїзд прибуває: ");
        String dst = input("Місто, куди поїзд має прибути у кінцевому рахунку: ");

        Map<Integer, TrainRoute> orderedRouteMap = routeList.getMap();

        System.out.println("Розклад прибуття поїздів вказаного маршруту");
        orderedRouteMap.forEach((key, value) -> {
            if (src.equals(value.getSrcStation()) && dst.equals(value.getDstStation()))
                System.out.printf("%d.) %s %n", key+1, value);
        });
    }

    public static void removeRoute() throws IOException {
        try {
            printSchedule();
            int index = Integer.parseInt(input("Яку інформацію про маршрут ви хочете вилучити(вкажіть лише порядкове число): "));
            if (index < 1 || index > routeList.size()) {
                throw new IndexOutOfBoundsException();
            }
            routeList.remove(index - 1);
            System.out.println("Інформація про вказаний успішно вилучена!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Помилка: ви ввели число яке виходить за діапазану списку!");
        } catch (NumberFormatException e) {
            System.out.println("Помилка: ви ввели не число!");
        }

    }

    public static void printSchedule() {
        Map<Integer, TrainRoute> orderedRouteMap = routeList.getMap();

        System.out.println("Розклад прибуття поїздів вказаного маршруту");
        orderedRouteMap.forEach((key, value) ->
                System.out.printf("%d.) %s %n", key + 1, value));
    }

}
