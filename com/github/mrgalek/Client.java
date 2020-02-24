package com.github.mrgalek;

public class Client extends Person
{
    private double accountStand;
    private ClientTransaction clientTransaction;

    Client()
    {
        super();
        clientTransaction = new ClientTransaction();
    }

    public double getAccountStand()
    {
        return accountStand;
    }

    public void setAccountStand(double accountStand)
    {
        this.accountStand = accountStand;
    }

    public void addMoney(double moneyToBeAdded)
    {
        accountStand +=moneyToBeAdded;
    }

    public void deductMoney(double moneyToBeDeducted)
    {
        accountStand -=moneyToBeDeducted;
    }

    public ClientTransaction getClientTransaction()
    {
        return clientTransaction;
    }
}
