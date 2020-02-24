package com.github.mrgalek;

public class StaffTransaction extends Transaction
{
    @Override
    public boolean transferMoney()
    {
        return false;
    }

    public boolean paymentOnAccount()
    {

    }
}
