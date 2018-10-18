package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choise = 0;
        printInstruction();
        while (!quit) {
            System.out.println("Enter your choice ");
            choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
            }
        }
    }

    public static void printInstruction() {
        System.out.println("\nPress");
        System.out.println("\t0 - To print choice options");
        System.out.println("\t1 - To print the list of grocery items");
        System.out.println("\t2 - To add an item to the list");
        System.out.println("\t3 - To modify an item in the list");
        System.out.println("\t4 - To remove an item from the list");
        System.out.println("\t5 - To search an item from the list");
        System.out.println("\t6 - To quit");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current Item ");
        String itemNo = scanner.nextLine();
        System.out.print("Please enter Replacement Item ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Please enter Item name ");
        String itemNo = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Enter Item to search for ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + "in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the list");
        }
    }
}