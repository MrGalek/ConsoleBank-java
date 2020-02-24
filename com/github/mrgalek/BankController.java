package com.github.mrgalek;


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
        var loginId = bankUi.showLoginMenu();
        if(mockDb.isPersonExist(loginId))
        {
            if(mockDb.getPersonType(loginId))
            {
                Client sessionPerson = new Client();

                sessionPerson.setAccountStand(mockDb.getClientStand(loginId));
                sessionPerson.setName(mockDb.getPersonName(loginId));
                sessionPerson.setNumber(loginId);
                sessionPerson.setType(true);

                restoreClientMenu(sessionPerson);


            }
            else
            {
                Staff sessionPerson = new Staff();

                sessionPerson.setName(mockDb.getPersonName(loginId));
                sessionPerson.setNumber(loginId);
                sessionPerson.setType(false);

                bankUi.showStaffMainUi(sessionPerson.getName(), sessionPerson.getNumber());
                var action = bankUi.getStaffMainUiAction();

                switch (action)
                {
                    case 1:
                        transferMoney();
                        break;
                    case 2:
                        paymentOnAccount();
                        break;
                    case 3:
                        WithdrawingMoney();
                        break;
                    case 4:
                        addingClient();
                        break;
                    default:
                        startApp();
                }
            }


        }
        else
        {
            bankUi.showNotUserFound();
            startApp();
        }
    }

    private void WithdrawingMoney()
    {
    }

    private void restoreClientMenu(Client client)
    {
        bankUi.showClientMainUi(client.getName(), client.getAccountStand(), client.getNumber());
        var action = bankUi.getClientMainUiAction();
        switch (action)
        {
            case 1:
                transferMoney(client);
                break;
            default:
                startApp();
        }
    }

    private void paymentOnAccount()
    {
    }

    private void addingClient()
    {
    }

    private void transferMoney(Client client)
    {
        var recipientNumber = bankUi.getRecipientNumberFromUi();
        var amount = bankUi.getTransferAmount();
        if(mockDb.isPersonExist(recipientNumber))
        {
            var recipient = mockDb.getClient(recipientNumber);


            TransactionManager transaction = new TransactionManager();
            if(transaction.transferMoney(client,recipient,amount))
            {
                mockDb.updateClientStand(transaction.getTmpRecipent());
                mockDb.updateClientStand(transaction.getTmpSender());

                bankUi.showTransactionOk();
                restoreClientMenu(client);

            }else
            {
                bankUi.showTransactionFailed();
            }
        }
        else
        {
            bankUi.showTransactionFailed();
        }

    }

    private void transferMoney()
    {
        var senderNumber = bankUi.getSenderNumberFromUi();
        var recipientNumber = bankUi.getRecipientNumberFromUi();
        var amount = bankUi.getTransferAmount();

        var recipient = mockDb.getClient(recipientNumber);
        var sender = mockDb.getClient(senderNumber);

        TransactionManager transaction = new TransactionManager();
        if(transaction.transferMoney(sender,recipient,amount))
        {
            mockDb.updateClientStand(transaction.getTmpRecipent());
            mockDb.updateClientStand(transaction.getTmpSender());

            bankUi.showTransactionOk();

        }else
        {
            bankUi.showTransactionFailed();
        }
        startApp();
    }

}
