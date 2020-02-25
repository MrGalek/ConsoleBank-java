package com.github.mrgalek.controllers;


import com.github.mrgalek.MockDb;
import com.github.mrgalek.views.BankUi;

public class BankController
{
    private BankUi bankUi;
    private MockDb mockDb;

    public BankController()
    {
        bankUi = new BankUi();
        mockDb = new MockDb();
    }

    public void startApp()
    {
        var personNumber = bankUi.showLoginMenu();
        if(personNumber!=0)
        {
            if (mockDb.isPersonExist(personNumber))
            {
                if (mockDb.getPersonType(personNumber))
                {
                    ClientController clientController = new ClientController(personNumber, mockDb);
                    clientController.serveClient();
                } else
                {
                    StaffController staffController = new StaffController(personNumber, mockDb);
                    staffController.serveStaff();
                }
            } else
            {
                bankUi.showNotUserFound();
            }
            startApp();
        }
    }
}
