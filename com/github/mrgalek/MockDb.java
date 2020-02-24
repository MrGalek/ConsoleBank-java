package com.github.mrgalek;

import java.util.ArrayList;
import java.util.List;

public class MockDb
{
    private List<Person> personList;

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

}
