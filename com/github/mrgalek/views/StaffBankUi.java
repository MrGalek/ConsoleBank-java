package com.github.mrgalek.views;

public class StaffBankUi extends BankUi
{
    public void showStaffInfo(String name, int number)
{
    showHeader();

    System.out.println("Hello " + name);
    System.out.println("Staff number: " + number);
}

    public int getMainUiAction()
    {
        System.out.println(" ");
        System.out.println("Transfer money -> [1]");
        System.out.println("Payment on account -> [2]");
        System.out.println("Withdrawing money -> [3]");
        System.out.println("Adding client -> [4]");
        System.out.println("Logout -> [Other number]");
        return keyboardInput.nextInt();
    }

    public int getSenderNumberFromUi()
    {
        System.out.println("Sender's number: ");
        return keyboardInput.nextInt();
    }

    public String getNewClientNameFromUi()
    {
        System.out.println("New client's name: ");
        return keyboardInput.nextLine();
    }
}
