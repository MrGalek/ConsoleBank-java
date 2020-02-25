package com.github.mrgalek.views;

public class ClientBankUi extends BankUi
{
    public int getMainUiAction()
    {
        System.out.println(" ");
        System.out.println("Transfer money -> [1]");
        System.out.println("Close app -> [Other number]");
        return keyboardInput.nextInt();
    }
}
