package com.github.mrgalek;

public class ClientTransaction extends Transaction
{
    @Override
    public boolean transferMoney()
    {
        return false;
    }
}
