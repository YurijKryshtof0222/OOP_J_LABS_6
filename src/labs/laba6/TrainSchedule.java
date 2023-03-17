package labs.laba6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainSchedule {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static Map<String, String> routeMap = new HashMap<>();

    static {
        routeMap.put("Київ Трускавець",         "06:30");
        routeMap.put("Кременчук Ворохта",       "06:50");
        routeMap.put("Полтава Чернівці",        "06:50");
        routeMap.put("Львів Рахів",             "07:37");
        routeMap.put("Дніпро Трускавець",       "08:43");
        routeMap.put("Львів Рівне",             "09:50");
        routeMap.put("Львів Покровськ",         "10:40");
        routeMap.put("Суми Івано-Франківськ",   "10:46");
        routeMap.put("Ужгород Київ",            "11:23");
        routeMap.put("Відень Київ",             "11:23");
    }
    public static void main(String[] args) throws IOException {
        System.out.println("------Розклад руху призначених пасажирських поїздів------\n");
        System.out.println("0.)Вийти з програми");
        System.out.println("1.)Додати інформацію про маршрут поїзда");
        System.out.println("2.)Дізнатись про час прибуття поїзда у вокзал за певним маршрутом");
        System.out.println("3.)Видалити інформацію про маршрут поїзда");
        System.out.println("4.)Вивести весь список розкладу руху");

        boolean exitState = false;
        while (!exitState) {
            System.out.print("\nВкажіть дію(лише цифру): ");
            //char inputChar = (char)input.read() // не бажано: може зчитувати \n
            char inputChar = input.readLine().charAt(0);
            switch (inputChar) {
                case '0' -> exitState = true;
                case '1' -> addRoute();
                case '2' -> getDateOfArriving();
                case '3' -> removeRoute();
                case '4' -> printSchedule();
                default  -> System.out.println("Помилка: ви ввели невірну команду");
            }
        }

    }

    private static String enterStation(String text) throws IOException {
        System.out.print(text);
        return input.readLine().strip();
    }

    public static void addRoute() throws IOException {
        String from, to;
        int hour, minutes;

        System.out.println("\nВкажіть дані маршруту:");
        from = enterStation("Місто, звідки поїзд прибуває: ");
        to = enterStation("Місто, куди поїзд має прибути у кінцевому рахунку: ");
        System.out.print("Година часу, коли поїзд має прибути у станцію Львів: ");
        hour = Integer.parseInt(input.readLine());
        System.out.print("Хвилина часу, коли поїзд має прибути у станцію Львів: ");
        minutes = Integer.parseInt(input.readLine());

        if ((hour < 0 || hour > 23) || (minutes < 0 || minutes >= 60)) {
            System.out.println("Неправильно заданий час!");
            return;
        }

        routeMap.put(from + " " + to, String.format("%d:%d", hour, minutes));
    }

    public static void getDateOfArriving() throws IOException {
        System.out.println("\nВкажіть дані маршруту:");
        String from = enterStation("Місто, звідки поїзд прибуває: ");
        String to = enterStation("Місто, куди поїзд має прибути у кінцевому рахунку: ");
        String route = from + " " + to;
        String result = routeMap.get(route);
        if (result == null) {
            System.out.println("Інформацію про цей маршрут не знайдено.");
        } else {
            System.out.printf("%s - %s%n", route, result);
        }
    }

    public static void removeRoute() throws IOException {
        System.out.println("\nВкажіть дані маршруту:");
        String from = enterStation("Місто, звідки поїзд прибуває: ");
        String to = enterStation("Місто, куди поїзд має прибути у кінцевому рахунку: ");
        String route = from + " " + to;
        String result = routeMap.get(route);
        if (result == null) {
            System.out.println("Інформацію про цей маршрут не знайдено.");
        } else {
            routeMap.remove(route);
            System.out.println("Інформація про цей маршрут успішно видалена.");
        }
    }

    public static void printSchedule() {
        List<Map.Entry<String, String>> list = new ArrayList<>(routeMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("\nРозклад маршруртів поїздів");
        for (Map.Entry<String, String> e: list) {
            System.out.printf("%s - %s%n", e.getKey(), e.getValue());
        }
    }

}