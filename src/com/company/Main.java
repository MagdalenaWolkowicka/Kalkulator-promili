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
        double bodyWeight = scanner.nextDouble();
        System.out.println("Podaj płeć. Mężczyzna - M, Kobieta - F");
        String maleFemale = scanner.next();

        switch (maleFemale) {

            case "M":
            case "m":
                double genderIndex = 0.7;
                double alcoholEliminationFactor = 0.28;
                String notDrunk = "Jesteś trzeźwy";
                calculateAlcoholLevel(amountOfDrink, alcoholicStrenght, time, bodyWeight, genderIndex, alcoholEliminationFactor, notDrunk);
                break;

            case "F":
            case "f":
                genderIndex = 0.6;
                alcoholEliminationFactor = 0.24;
                notDrunk = "Jesteś trzeźwa";
                calculateAlcoholLevel(amountOfDrink, alcoholicStrenght, time, bodyWeight, genderIndex, alcoholEliminationFactor, notDrunk);
                break;
        }
    }

    private static void calculateAlcoholLevel(int amountOfDrink, double alcoholicStrenght, double time, double bodyWeight, double genderIndex, double alcoholEliminationFactor, String notDrunk) {

        double amountOfAlcohol = (alcoholicStrenght * amountOfDrink) / 100;
        double alcoholLevel = (amountOfAlcohol / (bodyWeight * genderIndex)) - time * alcoholEliminationFactor;
        double alcoholLevelRounded = Math.round(alcoholLevel * 100);

        double numberOfHours = alcoholLevel / alcoholEliminationFactor;
        numberOfHours = Math.round(numberOfHours * 10);

        if (alcoholLevelRounded / 100 > 0) {
            System.out.println("W chwili zakończenia picia masz " + alcoholLevelRounded / 100 + " promila alkoholu we krwi");
            System.out.println("Wytrzeźwiejesz po mniej więcej " + numberOfHours / 10 + " h");
        } else
            System.out.println(notDrunk);
    }
}
