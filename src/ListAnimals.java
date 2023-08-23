import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListAnimals {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        Animal el;
        String input = null;
        Scanner scanner = new Scanner(System.in);

        while (input != "EXIT") {
            System.out.println("Введите команду add/list/exit");
            input = scanner.nextLine().trim().toUpperCase();
            Commands commands;
            try {
                commands = Commands.valueOf(input);
                //IllegalArgumentException используется для того, чтобы избежать передачи некорректных значений аргументов.
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда! Попробуйте еще раз!");
                continue;
            }
            switch (commands) {
                case ADD:
                    System.out.println("Введите животное cat/dog/duck");
                    String type = scanner.nextLine().trim().toLowerCase();
                    if (!type.equals("cat") && !type.equals("dog") && !type.equals("duck")) {
                        System.out.println("Неверный тип животного! Попробуйте еще раз!");
                        break;
                    }

                    System.out.println("Введите имя животного");
                    String name = scanner.nextLine().trim();

                    System.out.println("Введите возраст животного");
                    int age = 0;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверно указан возраст. Попробуйте еще раз!");
                        continue;
                    }

                    System.out.println("Введите вес животного");
                    double  weight = 0;
                    try {
                        weight = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверно указан вес. Попробуйте еще раз!");
                        continue;
                    }

                    System.out.println("Введите цвет животного");
                    String color = scanner.nextLine().trim();

                    switch (type) {
                        case "cat":
                            animals.add(new Cat(name,age,weight,color));
                            new Cat(name, age, weight, color).say();
                            break;
                        case "dog":
                            animals.add(new Dog(name,age,weight,color));
                            new Dog(name,age,weight,color).say();
                            break;
                        case "duck":
                            animals.add(new Duck(name,age,weight,color));
                            new Duck(name,age,weight,color).say();
                            break;
                        default:
                            System.out.println("Неверный тип животного.");
                    }
                    break;

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("Список животных пуст! Добавьте животное через команду add!");
                    } else {
                        for (Animal a : animals) {
                            System.out.println(a.toString());
                        }
                    }  break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход из программы.");
                    System.exit(0);
            }
        }
    }
}

