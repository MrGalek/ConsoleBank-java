package com.github.mrgalek;

import java.util.Scanner;

public class BankView
{
    Scanner keyboardInput;

    public BankView()
    {
        keyboardInput = new Scanner(System.in);
    }

    public int showLoginMenu()
    {
        showHeader();

        System.out.println("Write client or staff number");
        System.out.print("Number: ");
        return keyboardInput.nextInt();

    }

    private void showHeader()
    {
        System.out.println("Console Bank - first console friendly bank");
        System.out.println("================================================");
        System.out.println(" ");
    }

    private void clearConsole()
    {
        System.out.print("\033[H\033[2J");
    }

    public void showNotUserFound()
    {
        clearConsole();
        System.out.println("Person not found");
    }


    public void showClientUi(String name, double accountStand, int number)
    {
        clearConsole();
        showHeader();

        System.out.println("Hello " + name);
        System.out.println("Client number: " + number);
        System.out.println("CASH: "+accountStand);
    }

    public int getClientAction()
    {
        System.out.println("Transfer money -> [1]");
        System.out.println("Close app -> [Other number]");
        return keyboardInput.nextInt();
    }

    public void showStaffUi(String name, int number)
    {
        clearConsole();
        showHeader();

        System.out.println("Hello " + name);
        System.out.println("Staff number: " + number);
    }

    public int getStaffAction()
    {
        System.out.println("Withdrawing money -> [1]");
        System.out.println("Payment on account-> [2]");
        System.out.println("Adding client-> [3]");
        System.out.println("Close app-> [4]");
        return keyboardInput.nextInt();
    }
}
