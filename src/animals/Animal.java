package animals;

public abstract class Animal implements IAnimal {
    private String name;
    private int age;
    private double weight;
    private String color;

    public Animal() {
    }

    public Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String yearsOld = ""; //Инициализируем пустой строкой
        int ageLastNumber = age % 10; //Получаем последнюю цифру от числаж
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14); // Исключение 11-14 (считаются как 5-9)
        // с 1 на конце; (21, 31 и тд.)
        if (ageLastNumber == 1) {
            yearsOld = "год";
            // от 5 до 9 и ноль тоже может быть тут; (25-30, 35-40 и т.д.)
        } else if (ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9) {
            yearsOld = "лет";
            // от 2 до 4 на конце; (2, 4, 22, 24 и т.д.)
        } else if (ageLastNumber >= 2 && ageLastNumber <= 4) {
            yearsOld = "года";
        }
        if (isExclusion) {
            yearsOld = "лет";
        }
        return "Привет! Меня зовут " + name +
                ", мне " + age + " "+ yearsOld +
                ", я вешу - " + weight + "кг "+
                ", мой цвет - " + color + ".";
    }

    @Override
    public abstract void say();
    @Override
    public void go() {
        System.out.println("Я иду");
    }

    @Override
    public void drink() {
        System.out.println("Я пью");
    }

    @Override
    public void eat() {
        System.out.println("Я ем");
    }
}

