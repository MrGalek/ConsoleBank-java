package com.github.mrgalek;

import java.util.Scanner;

public class BankUi
{
    Scanner keyboardInput;

    public BankUi()
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

    protected void showHeader()
    {
        System.out.println("Console Bank - first console friendly bank");
        System.out.println("================================================");
        System.out.println(" ");
    }

    protected void clearConsole()
    {
        System.out.print("\033[H\033[2J");
    }

    public void showNotUserFound()
    {
        clearConsole();
        System.out.println("Person not found");
    }

    public int getRecipientNumberFromUi()
    {
        System.out.println("Recipient's number: ");
        return keyboardInput.nextInt();
    }

    public double getTransferAmount()
    {
        System.out.println("Transfer amount: ");
        return keyboardInput.nextInt();
    }

    public void showClientMainUi(String name, double accountStand, int number)
    {
        clearConsole();
        showHeader();

        System.out.println("Hello " + name);
        System.out.println("Client number: " + number);
        System.out.println("CASH: " + accountStand);
    }

    public int getClientMainUiAction()
    {
        System.out.println(" ");
        System.out.println("Transfer money -> [1]");
        System.out.println("Close app -> [Other number]");
        return keyboardInput.nextInt();
    }

    public void showStaffMainUi(String name, int number)
    {
        clearConsole();
        showHeader();

        System.out.println("Hello " + name);
        System.out.println("Staff number: " + number);
    }

    public int getStaffMainUiAction()
    {
        System.out.println(" ");
        System.out.println("Transfer money -> [1]");
        System.out.println("Payment on account-> [2]");
        System.out.println("Withdrawing money -> [3]");
        System.out.println("Adding client-> [5]");
        System.out.println("Close app-> [Other number]");
        return keyboardInput.nextInt();
    }

    public int getSenderNumberFromUi()
    {
        System.out.println("Sender's number: ");
        return keyboardInput.nextInt();
    }

    public void showTransactionFailed()
    {
        clearConsole();
        System.out.println("Transaction Failed");
    }

    public void showTransactionOk()
    {
        clearConsole();
        System.out.println("Transaction OK!");
    }
}

