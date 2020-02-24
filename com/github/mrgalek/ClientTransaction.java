package com.github.mrgalek;

public class ClientTransaction extends Transaction
{
    @Override
    public boolean transferMoney(Client fromClient, Client toClient)
    {
        return false;
    }
}
