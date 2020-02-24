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

}
