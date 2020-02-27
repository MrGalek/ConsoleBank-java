package com.github.mrgalek;

public class TransactionManager
{
    private Client tmpSender;
    private Client tmpRecipent;
    private double amountOfMoney;

    private boolean transferPossible()
    {
        var standAfterTransaction = tmpSender.getAccountStand() - amountOfMoney;

        if(standAfterTransaction >= 0) return true;
        else return false;
    }

    public boolean transferMoney(Client sender, Client recipent, double amountOfMoney)
    {
       tmpSender = sender;
       tmpRecipent = recipent;
       this.amountOfMoney = amountOfMoney;

       if(transferPossible())
       {
           tmpSender.setAccountStand(tmpSender.getAccountStand() - amountOfMoney);
           tmpRecipent.setAccountStand(tmpRecipent.getAccountStand() + amountOfMoney);
           return true;
       }
       else return false;
    }

    public Client getTmpSender()
    {
        return tmpSender;
    }

    public Client getTmpRecipent()
    {
        return tmpRecipent;
    }

    public boolean withdrawingMoney(Client client, double amount)
    {
        tmpSender = client;
        amountOfMoney = amount;

        if(transferPossible())
        {
            tmpSender.setAccountStand(tmpSender.getAccountStand() - amountOfMoney);
            return true;
        }
        else return false;
    }

    public boolean paymentOnAccount(Client client, double amount)
    {
        tmpSender = client;
        amountOfMoney = amount;

        try
        {
            tmpSender.setAccountStand(tmpSender.getAccountStand() + amountOfMoney);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
