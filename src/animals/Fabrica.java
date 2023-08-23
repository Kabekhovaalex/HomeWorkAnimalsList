package animals;

import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.AnimalData;

public class Fabrica {
    private String name;
    private int age;
    private double weidht;
    private String color;

    public Fabrica(String name, int age, double weidht, String color) {
        this.name = name;
        this.age = age;
        this.weidht = weidht;
        this.color = color;
    }

    public Animal created(AnimalData data) {
      switch (data) {
          case CAT: return new Cat(name, age, weidht, color);
          case DOG: return new Dog(name, age, weidht, color);
          case DUCK:return new Duck(name, age, weidht, color);
          default: System.out.println("Неверный тип животного.");
      }
        return null;
    }
}
