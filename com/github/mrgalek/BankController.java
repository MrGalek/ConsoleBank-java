package com.github.mrgalek;

public class BankController
{
    private BankView bankView;
    private MockDb mockDb;

    public BankController()
    {
        bankView = new BankView();
        mockDb = new MockDb();
    }

    public void startApp()
    {
        var loginId = bankView.showLoginMenu();
        if(mockDb.isPersonExist(loginId))
        {
            if(mockDb.getPersonType(loginId))
            {
                Client sessionPerson = new Client();
                sessionPerson.setAccountStand(mockDb.getClientStand(loginId));
                sessionPerson.setName(mockDb.getPersonName(loginId));
                sessionPerson.setNumber(loginId);
                sessionPerson.setType(true);

                bankView.showClientUi(sessionPerson.getName(), sessionPerson.getAccountStand(), sessionPerson.getNumber());
                var action = bankView.getClientAction();
            }
            else
            {
                Staff sessionPerson = new Staff();
                sessionPerson.setName(mockDb.getPersonName(loginId));
                sessionPerson.setNumber(loginId);
                sessionPerson.setType(true);
            }


        }
        else
        {
            bankView.showNotUserFound();
            startApp();
        }
    }


}
