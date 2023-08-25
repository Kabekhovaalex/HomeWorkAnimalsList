import animals.Animal;
import animals.Fabrica;
import data.AnimalData;
import data.CommandsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListAnimals {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        String input = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду add/list/exit");
            input = scanner.nextLine().trim().toUpperCase();
            CommandsData commands;
            try {
                commands = CommandsData.valueOf(input);
                //IllegalArgumentException используется для того, чтобы избежать передачи некорректных значений аргументов.
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда! Попробуйте еще раз!");
                continue;
            }
            switch (commands) {
                case ADD:
                    String type;
                    while (true) {
                        System.out.println("Введите животное cat/dog/duck");
                        type = scanner.nextLine().trim().toUpperCase();
                        if (!type.equals("CAT") && !type.equals("DOG") && !type.equals("DUCK")) {
                            System.out.println("Неверный тип животного! Попробуйте еще раз!");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Введите имя животного");
                    String name = scanner.nextLine().trim();


                    int age;
                    while (true) {
                        try {
                            System.out.println("Введите возраст животного");
                            age = Integer.parseInt(scanner.nextLine());
                            if (age < 0) {
                                System.out.println("Неверно указан возраст. Пожалуйста, введите положительное число.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный ввод. Попробуйте еще раз!");
                        }
                    }

                    double weight;
                    while (true) {
                        try {
                            System.out.println("Введите вес животного");
                            weight = Double.parseDouble(scanner.nextLine());
                            if (weight < 0) {
                                System.out.println("Неверный вес. Пожалуйста, введите положительное число.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный ввод. Попробуйте еще раз!");
                        }
                    }

                    System.out.println("Введите цвет животного");
                    String color = scanner.nextLine().trim();

                    AnimalData data;
                    try {
                        data = AnimalData.valueOf(type);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный тип животного! Попробуйте еще раз!");
                        continue;
                    }

                    Animal el = new Fabrica(name, age, weight, color).created(data);
                    animals.add(el);
                    el.say();

                    break;

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("Список животных пуст! Добавьте животное через команду add!");
                    } else {
                        for (Animal a : animals) {
                            System.out.println(a.toString());
                        }
                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход из программы.");
                    System.exit(0);
            }
        }
    }
}

