package Homework_1;

import java.text.DecimalFormat;

public class Flower {
    DecimalFormat df = new DecimalFormat("#.##");
    String flowerType;
    private String flowerColor;
    private String country;
    private double cost;
    int lifeSpan;

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        if (flowerColor == null || flowerColor.trim().isEmpty()) {
            this.flowerColor = "Белый";
        } else {
            this.flowerColor = flowerColor;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            this.country = "Россия";
        } else {
            this.country = country;
        }
    }

    public String getCost() {
        String result = df.format(cost);
        return result;

    }

    public void setCost(double cost) {
        if (cost <= 0) {
            this.cost = 1;
        } else {
            this.cost = cost;
        }
    }

    public Flower(String flowerType, String flowerColor, String country, double cost, int lifeSpan) {

        setFlowerColor(flowerColor);
        setCountry(country);
        setCost(cost);

        this.flowerType = flowerType;
        if (lifeSpan > 0) {
            this.lifeSpan = lifeSpan;
        } else {
            this.lifeSpan = 3;
        }
    }

    @Override
    public String toString() {
        return "Название цветка: " + flowerType +
                ", цвет: " + getFlowerColor() +
                ", страна происхождения: " + getCountry() +
                ", стоимость: " + getCost() +
                " (срок стояния: " + lifeSpan + " суток).";
    }

    //// Дополнительная задача
    double initialCostBouquet;
    double finalCostBouquet;
    double costRose = 35.59;
    double costChrysanthemum = 15;
    double costPeon = 69.9;
    double costGypsophila = 19.5;
    String calculationCostBouquet;
    int lifeSpanBouquet;
    int lifeSpanRose = 3;
    int lifeSpanChrysanthemum = 5;
    int lifeSpanPeon = 1;
    int lifeGypsophila = 10;

    public Flower(int numberRoses, int numberChrysanthemums, int numberPeonies, int numberGypsophiles) {

        if (numberRoses < 0 || numberChrysanthemums < 0 || numberPeonies < 0 || numberGypsophiles < 0) {
            System.out.println("Ошибка в выборе количства цветов. Укажите корректные данные");
        } else {
            initialCostBouquet = (numberRoses * costRose) + (numberChrysanthemums * costChrysanthemum)
                    + (numberPeonies * costPeon) + (numberGypsophiles * costGypsophila);
            finalCostBouquet = initialCostBouquet + (initialCostBouquet*0.1);
        }

        if (numberPeonies > 0) {
            lifeSpanBouquet = lifeSpanPeon;
        } else if (numberRoses > 0) {
            lifeSpanBouquet = lifeSpanRose;
        } else if (numberChrysanthemums > 0) {
            lifeSpanBouquet = lifeSpanChrysanthemum;
        } else {
            lifeSpanBouquet = lifeGypsophila;
        }

        calculationCostBouquet = "Букет в котором есть: роза обыкновенная — " + numberRoses +
                " шт., хризантема — " + numberChrysanthemums +
                " шт., гипсофила — " + numberGypsophiles +
                " шт., пион — " + numberPeonies +
                " шт., будет стоить " + df.format(finalCostBouquet) + " рублей и простоит " + lifeSpanBouquet + " суток.";
    }
}

