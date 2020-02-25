package com.github.mrgalek.controllers;

import com.github.mrgalek.MockDb;
import com.github.mrgalek.Staff;
import com.github.mrgalek.TransactionManager;
import com.github.mrgalek.views.ClientBankUi;
import com.github.mrgalek.views.StaffBankUi;

public class StaffController
{
    private StaffBankUi staffBankUi;
    private Staff sessionStaff;
    private MockDb mockDb;

    public StaffController(int staffNumber, MockDb mockDb)
    {
        sessionStaff = mockDb.getStaff(staffNumber);
        staffBankUi = new StaffBankUi();
        this.mockDb = mockDb;
    }

    public void serveStaff()
    {
        staffBankUi.showStaffInfo(sessionStaff.getName(), sessionStaff.getNumber());
        var action = staffBankUi.getMainUiAction();

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
                break;
        }
    }

    private void transferMoney()
    {
        var senderNumber = staffBankUi.getSenderNumberFromUi();
        var recipientNumber = staffBankUi.getRecipientNumberFromUi();
        var amount = staffBankUi.getTransferAmount();

        var recipient = mockDb.getClient(recipientNumber);
        var sender = mockDb.getClient(senderNumber);

        TransactionManager transaction = new TransactionManager();
        if(transaction.transferMoney(sender,recipient,amount))
        {
            mockDb.updateClientStand(transaction.getTmpRecipent());
            mockDb.updateClientStand(transaction.getTmpSender());

            staffBankUi.showTransactionOk();

        }else
        {
            staffBankUi.showTransactionFailed();
        }
        serveStaff();
    }

    private void WithdrawingMoney()
    {
        var clientNumber = staffBankUi.getSenderNumberFromUi();
        var amount = staffBankUi.getTransferAmount();

        var client = mockDb.getClient(clientNumber);

        TransactionManager transaction = new TransactionManager();
        if(transaction.withdrawingMoney(client,amount))
        {
            mockDb.updateClientStand(transaction.getTmpSender());
            staffBankUi.showTransactionOk();
        }
        else
        {
            staffBankUi.showTransactionFailed();
        }
        serveStaff();
    }


    private void paymentOnAccount()
    {
        var clientNumber = staffBankUi.getSenderNumberFromUi();
        var amount = staffBankUi.getTransferAmount();

        var client = mockDb.getClient(clientNumber);

        TransactionManager transaction = new TransactionManager();
        if(transaction.paymentOnAccount(client,amount))
        {
            mockDb.updateClientStand(transaction.getTmpSender());
            staffBankUi.showTransactionOk();
        }
        else
        {
            staffBankUi.showTransactionFailed();
        }
        serveStaff();
    }

    private void addingClient()
    {
        var newClientName = staffBankUi.getNewClientNameFromUi();
        var newClientNumber = mockDb.addNewClientAndReturnNumber(newClientName);

        staffBankUi.showClientInfo(newClientName,newClientNumber,0);
    }
}
