package com.github.mrgalek.views;

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
        System.out.println("If you want close app -> 0");
        System.out.print("Number: ");
        return keyboardInput.nextInt();

    }

    protected void showHeader()
    {
        System.out.println("Console Bank - first console friendly bank");
        System.out.println("================================================");
        System.out.println(" ");
    }

    public void showClientInfo(String name, int number, double accountStand)
    {
        showHeader();

        System.out.println(name);
        System.out.println("Client number: " + number);
        System.out.println("CASH: " + accountStand);
    }

    public int getMainUiAction()
    {
        return 0;
    }


    public int getRecipientNumberFromUi()
    {
        System.out.println("Recipient's number: ");
        return keyboardInput.nextInt();
    }

    public double getTransferAmount()
    {
        System.out.println("Transfer amount: ");
        return keyboardInput.nextDouble();
    }

    public void showTransactionFailed()
    {
        System.out.println("Transaction Failed");
    }

    public void showTransactionOk()
    {
        System.out.println("Transaction OK!");
    }

    public void showNotUserFound()
    {
        System.out.println("Person not found");
    }
}

