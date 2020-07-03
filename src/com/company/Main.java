package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Podaj ilość wypitego alkoholu w ml");
        Scanner scanner = new Scanner(System.in);
        int amountOfDrink = scanner.nextInt();
        System.out.println("Ile % miał wypity alkohol?");
        double alcoholicStrenght = scanner.nextDouble();
        System.out.println("Ile czasu (w godzinach) trwało picie?");
        double time = scanner.nextDouble();
        System.out.println("Podaj masę ciała w kg");
        int bodyWeight = scanner.nextInt();
        System.out.println("Podaj płeć. Mężczyzna - M, Kobieta - F");
        String maleFemale = scanner.next();

        switch (maleFemale) {

            case "M":
                double v = 0.7;
                double v2 = 0.28;
                String s = "Jesteś trzeźwy";
                calculateAlcoholLevel(amountOfDrink, alcoholicStrenght, time, bodyWeight, v, v2, s);
                break;

            case "F":
                v = 0.6;
                v2 = 0.24;
                s = "Jesteś trzeźwa";
                calculateAlcoholLevel(amountOfDrink, alcoholicStrenght, time, bodyWeight, v, v2, s);
                break;
        }
    }

    private static void calculateAlcoholLevel(int amountOfDrink, double alcoholicStrenght, double time, int bodyWeight, double v, double v2, String s) {

        double amountOfAlcohol = (alcoholicStrenght * amountOfDrink) / 100;
        double alcoholLevel = (amountOfAlcohol / (bodyWeight * v)) - time * v2;
        double alcoholLevelRounded = Math.round(alcoholLevel * 100);

        double numberOfHours = alcoholLevel / v2;
        numberOfHours = Math.round(numberOfHours * 10);

        if (alcoholLevelRounded / 100 > 0) {
            System.out.println("W chwili zakończenia picia masz " + alcoholLevelRounded / 100 + " promila alkoholu we krwi");
            System.out.println("Wytrzeźwiejesz po mniej więcej " + numberOfHours / 10 + " h");
        } else
            System.out.println(s);
    }
}
