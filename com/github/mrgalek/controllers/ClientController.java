package com.github.mrgalek.controllers;

import com.github.mrgalek.Client;
import com.github.mrgalek.MockDb;
import com.github.mrgalek.TransactionManager;
import com.github.mrgalek.views.ClientBankUi;

public class ClientController
{
    private ClientBankUi clientBankUi;
    private Client sessionClient;
    private MockDb mockDb;

    public ClientController(int clientNumber, MockDb mockDb)
    {
        sessionClient = mockDb.getClient(clientNumber);
        clientBankUi = new ClientBankUi();
        this.mockDb = mockDb;
    }

    public void serveClient()
    {
        clientBankUi.showClientInfo(sessionClient.getName(), sessionClient.getNumber(), sessionClient.getAccountStand());
        var action = clientBankUi.getMainUiAction();
        switch (action)
        {
            case 1:
                transferMoney();
                break;
            default:
                break;
        }
    }

    public void transferMoney()
    {
        var recipientNumber = clientBankUi.getRecipientNumberFromUi();
        var amount = clientBankUi.getTransferAmount();
        if(mockDb.isPersonExist(recipientNumber))
        {
            var recipient = mockDb.getClient(recipientNumber);

            TransactionManager transaction = new TransactionManager();
            if(transaction.transferMoney(sessionClient,recipient,amount))
            {
                mockDb.updateClientStand(transaction.getTmpRecipent());
                mockDb.updateClientStand(transaction.getTmpSender());

                clientBankUi.showTransactionOk();

            }else
            {
                clientBankUi.showTransactionFailed();
            }
        }
        else
        {
            clientBankUi.showTransactionFailed();
        }

        serveClient();

    }

}
