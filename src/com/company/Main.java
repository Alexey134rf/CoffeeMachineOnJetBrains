package com.company;
import java.util.Scanner;

class CoffeeMachine {

    void writeLine(String line) {
    }

}

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        startProgram();
    }
    private static void startProgram() {

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        int[] arrayValues = new int [5];

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = sc.next();
            System.out.println("");
            if ("exit".equals(command)) {
                break;
            }
            switch (command) {
                case "buy":
                    arrayValues = buyCoffee(water, milk, coffeeBeans, disposableCups, money);

                    water = arrayValues[0];
                    milk = arrayValues[1];
                    coffeeBeans = arrayValues[2];
                    disposableCups = arrayValues[3];
                    money = arrayValues[4];
                    break;
                case "fill":
                    arrayValues = fillCoffeeMachine(water, milk, coffeeBeans, disposableCups);

                    water = arrayValues[0];
                    milk = arrayValues[1];
                    coffeeBeans = arrayValues[2];
                    disposableCups = arrayValues[3];
                    break;
                case "take":
                    System.out.printf("I gave you $%d\n\n", money);
                    money = 0;
                    break;
                case "remaining":
                    printStatusCoffeeMachine(water, milk, coffeeBeans, disposableCups, money);
                    break;
                default:
                    System.out.println();
            }
        }

    }

    private static void printStatusCoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n\n",
                water, milk, coffeeBeans, disposableCups, money);
    }

    private static int[] buyCoffee(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int selectedCoffee = sc.nextInt();
        int[] arrayValues = new int[5];
        switch (selectedCoffee) {
            case 1:
                if (water - 250 < 0) {
                    System.out.println("Sorry, not enough water!\n");
                }
                if (coffeeBeans - 16 < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                if (disposableCups - 1 < 0) {
                    System.out.print("Sorry, not enough disposable cups!\n");
                }

                if (water - 250 >= 0 && coffeeBeans - 16 >= 0 && disposableCups - 1 >= 0) {
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
            case 2:
                if (water - 350 < 0) {
                    System.out.println("Sorry, not enough water!\n");
                }
                if (milk - 75 < 0) {
                    System.out.println("Sorry, not enough milk!\n");
                }
                if (coffeeBeans - 20 < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                if (disposableCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                }

                if (water - 350 >= 0 && coffeeBeans - 20 >= 0 && milk - 75 >= 0 && disposableCups - 1 >= 0) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
            case 3:
                if (water - 200 < 0) {
                    System.out.println("Sorry, not enough water!\n");
                }
                if (milk - 100 < 0) {
                    System.out.println("Sorry, not enough milk!\n");
                }
                if (coffeeBeans - 12 < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                if (disposableCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                }

                if (water - 200 >= 0 && coffeeBeans - 12 >= 0 && milk - 100 >= 0 && disposableCups - 1 >= 0) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
        }

        arrayValues[0] = water;
        arrayValues[1] = milk;
        arrayValues[2] = coffeeBeans;
        arrayValues[3] = disposableCups;
        arrayValues[4] = money;
        return arrayValues;
    }

    private static int[] fillCoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups) {
        int[] arrayValues = new int[5];

        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += sc.nextInt();
        System.out.println(" ");

        arrayValues[0] = water;
        arrayValues[1] = milk;
        arrayValues[2] = coffeeBeans;
        arrayValues[3] = disposableCups;

        return arrayValues;

    }
}
