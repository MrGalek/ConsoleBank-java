package com.github.mrgalek;

public class Client extends Person
{
    private double accountStand;

    public double getAccountStand()
    {
        return accountStand;
    }

    public void addMoney(double moneyToBeAdded)
    {
        accountStand +=moneyToBeAdded;
    }

    public void deductMoney(double moneyToBeDeducted)
    {
        accountStand -=moneyToBeDeducted;
    }
}
