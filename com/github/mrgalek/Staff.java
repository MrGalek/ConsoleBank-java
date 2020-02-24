package com.github.mrgalek;

public class Staff extends Person
{
    private StaffTransaction staffTransaction;

    Staff()
    {
     staffTransaction = new StaffTransaction();
    }

    public StaffTransaction getStaffTransaction()
    {
        return staffTransaction;
    }
}
