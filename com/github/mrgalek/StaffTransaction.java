package com.github.mrgalek;

public class StaffTransaction extends Transaction
{
    @Override
    public boolean transferMoney(Client fromClinet, Client toClient)
    {
        return false;
    }

    public boolean paymentOnAccount()
    {
        return true;
    }

    public boolean withdrawalFromAccount()
    {
        return true;
    }

}
