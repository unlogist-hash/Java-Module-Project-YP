import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Race race = new Race();

    for (int i = 1; i <= 3; i++) {
    String name = "";
    int speed = 0;

    while (true) {
    System.out.print("Введите название автомобиля №" + i + ": ");
    name = scanner.nextLine();
    if (!name.isEmpty()) {
    break;
    }
    System.out.println("Вы не ввели название автомобиля.");
    }

    while (true) {
    System.out.print("Введите скорость автомобиля, целое число №" + i + " (км/ч, от 1 до 250): ");
    if (scanner.hasNextInt()) {
    speed = scanner.nextInt();
    scanner.nextLine();

    if (speed > 0 && speed <= 250) {
    break;
    } else {
    System.out.println("Скорость должна быть больше 0 и не больше 250. Попробуйте ещё раз.");
    }
    } else {
    System.out.println("Вы ввели не число или дробное число. Введите целое число.");
    scanner.next();
    }
    }

    Car car = new Car(name, speed);
    race.addCar(car);
    }

    Car leader = race.getLeader();

    System.out.println("Победитель гонки: " + leader.name);
    System.out.println("Скорость: " + leader.speed + " км/ч");
    System.out.println("Дистанция за 24 часа: " + leader.getDistance() + " км");
   
    scanner.close();
    }
}

class Car {
    public String name;
    public int speed;

    public Car(String name, int speed) {
    this.name = name;
    this.speed = speed;
    }

    public int getDistance() {
    return speed * 24;
    }
}

class Race {
    Car[] cars;
    int count;

    public Race() {
    cars = new Car[3];
    count = 0;
    }

    public void addCar(Car car) {
    if (count < 3) {
    cars[count] = car;
    count = count + 1;
    }
    }

    public Car getLeader() {
    if (count == 0) {
    return null;
    }

    Car leader = cars[0];
    for (int i = 1; i < count; i++) {
    Car current = cars[i];
    
    if (current.speed * 24 > leader.speed * 24) {
    leader = current;
    }
    }
    return leader;
    }
}
