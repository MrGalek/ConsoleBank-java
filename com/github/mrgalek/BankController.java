package com.github.mrgalek;

public class BankController
{
    private BankView bankView;
    private MockDb mockDb;

    public BankController()
    {
        bankView = new BankView();
    }

    public void startApp()
    {
        bankView.showLoginMenu();
    }
}
