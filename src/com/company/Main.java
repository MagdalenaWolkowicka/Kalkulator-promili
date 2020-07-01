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
        System.out.println("Podaj płeć. Mężczyzna - 1, Kobieta - 2");
        int maleFemale = scanner.nextInt();

        if (maleFemale == 1) {
            double amountOfAlcohol = (alcoholicStrenght * amountOfDrink) / 100;

            double alcoholLevel = (amountOfAlcohol / (bodyWeight * 0.7)) - time * 0.28;
            double alcoholLevelRounded = Math.round(alcoholLevel * 100);

            double numberOfHours = alcoholLevel / 0.28;
            numberOfHours = Math.round(numberOfHours * 10);

            if (alcoholLevelRounded / 100 > 0) {
                System.out.println("W chwili zakończenia picia masz " + alcoholLevelRounded / 100 + " promila alkoholu we krwi");
                System.out.println("Wytrzeźwiejesz po mniej więcej " + numberOfHours / 10 + " h");
            } else
                System.out.println("Jesteś trzeźwy ;)");

        } else if (maleFemale == 2) {
            double amountOfAlcohol = (alcoholicStrenght * amountOfDrink) / 100;

            double alcoholLevel = (amountOfAlcohol / (bodyWeight * 0.6)) - time * 0.24;
            double alcoholLevelRounded = Math.round(alcoholLevel * 100);

            double numberOfHours = alcoholLevel / 0.24;
            numberOfHours = Math.round(numberOfHours * 10);

            if (alcoholLevelRounded / 100 > 0) {
                System.out.println("W chwili zakończenia picia masz " + alcoholLevelRounded / 100 + " promila alkoholu we krwi");
                System.out.println("Wytrzeźwiejesz po mniej więcej " + numberOfHours / 10 + " h");
            } else {
                System.out.println("Jesteś trzeźwa ;)");
            }
        }
    }
}
