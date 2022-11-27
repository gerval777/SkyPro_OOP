package Homework_1;

import java.time.LocalDate;

import Transport.Car;

public class Main {
    public static void main(String[] args) {


// Задание 1

        System.out.println("                Задание 1" + "\n");

        Human max = new Human("Максим", "Минск", -1988, "    ");
        max.printGreeting();

        Human ann = new Human("    ", "Москва", 1993, "методист образовательных программ");
        ann.printGreeting();

        Human katya = new Human("Катя", "   ", 1992, "продакт-менеджер");
        katya.printGreeting();

        Human artem = new Human("Артем", "Москва", 1995, "директор по развитию бизнеса");
        artem.printGreeting();

        Human vladimir = new Human("Владимир", "Казань", 2001, "безработный");
        vladimir.printGreeting();


// Задание 2
        System.out.println();
        System.out.println("                Задание 2" + "\n");

        Flower rose = new Flower("Роза обыкновенная", "  ", "Голландия", 35.59111, 0);

        System.out.println(rose.toString());

        Flower chrysanthemum = new Flower("Хризантема", "  ", "  ", 15, 5);
        System.out.println(chrysanthemum.toString());

        Flower pion = new Flower("Пион", "  ", "Англия", 69.9, 1);
        System.out.println(pion.toString());

        Flower gypsophila = new Flower("Гипсофила", "", "Турция", 19.5, 10);
        System.out.println(gypsophila.toString());


        // Дополнительная задача
        System.out.println();
        System.out.println("             Дополнительная задача" + "\n");


        Flower flowerBouquet = new Flower(30, 10, 15, 10);
        System.out.println(flowerBouquet.calculationCostBouquet);

        // Домашняя работа 2
        System.out.println();
        System.out.println("               Домашняя работа 2" + "\n");


        Car lada = new Car("Lada", "Granta", 1.6, "", 2019,
                "РФ", "МКПП", "Хэтчбэк", 5, "Лето", "А307  Ну051", "Y");
        System.out.println(lada.toString());

        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "Черный", 2020,
                "Германия", "МКПП", "     ", 5, "Лето", "А307НУ051", "Y");
        System.out.println(audi.toString());

        Car bmw = new Car("BMW", "Z8", 3.0, "Черный", 2021,
                "Германия", "АКПП", "Лимузин", 6, "Зима", "А307НУ051", "Y");
        System.out.println(bmw.toString());

        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "Красный", 2018,
                "Южная Корея", "Робот", "Паркетник", 7, "Лето", "А0307НУ051", "Y");
        System.out.println(kia.toString());

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "Оранжевый", 2016,
                "Южная Корея", "    ", "      ", 0, "", " ", "Y");
        System.out.println(hyundai.toString());

        Car testCar = new Car("", "  ", 0, " ", 0,
                " ", "    ", "      ", 0, "", " ", "N");
        System.out.println(testCar.toString());

// Домашняя работа 3
        System.out.println();
        System.out.println("               Домашняя работа 3" + "\n");

        Car opel = new Car("Opel", "Z8", 3.0, "Черный", 2021,
                "Германия", "АКПП", "Лимузин", 6, "Зима", "А307НУ051", "Y");
        System.out.println(opel.toString());
        Car.Key opelKey = opel.new Key ("Есть", "Нет");
        Car.Insurance opelInsurance = opel.new Insurance(LocalDate.of(2021, 2, 2), 200, "32111cs33");
        opel.setKey(opelKey);
        opel.setInsurance(opelInsurance);
        System.out.println(opel);

    }
}
