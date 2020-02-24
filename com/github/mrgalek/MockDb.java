package com.github.mrgalek;

import java.util.ArrayList;
import java.util.List;

public class MockDb
{
    private List<Person> personList;
    private List<Client> clientList;
    private List<Staff> staffList;

    public MockDb()
    {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        personList.add(person);
    }

    public String getPersonName(int personNumber)
    {
        var person = personList.stream().filter(x -> x.getNumber() == personNumber)
                .findFirst()
                .get();

        return person.getName();
    }

    public boolean getPersonType(int personNumber)
    {
        var person = personList.stream().filter(x -> x.getNumber() == personNumber)
                .findFirst()
                .get();

        return person.isType();
    }

    public double getClientStand(int personNumber)
    {
        var person = clientList.stream().filter(x -> x.getNumber() == personNumber)
                .findFirst()
                .get();

        return person.getAccountStand();
    }

    public boolean isPersonExist(int personNumber)
    {
        return personList.stream().anyMatch(x -> x.getNumber() == personNumber);
    }

}
