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
        clientList = new ArrayList<>();
        staffList = new ArrayList<>();
        loadMockData();
    }

    public void addClient(Client client)
    {
        clientList.add(client);
        personList.add(client);
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

    private void loadMockData()
    {
        for (int i = 0; i < 5; i++)
        {
            var mockClient = new Client();
            mockClient.setName("Jan Kowalski"+i);
            mockClient.setNumber(150+personList.size());
            mockClient.setType(true);
            mockClient.setAccountStand(1950*i);
            personList.add(mockClient);
            clientList.add(mockClient);
        }

        var mockStaff = new Staff();
        mockStaff.setName("Anna Nowak");
        mockStaff.setNumber(150+personList.size());
        mockStaff.setType(false);
        personList.add(mockStaff);
        staffList.add(mockStaff);
    }

    public Client getClient(int recipient)
    {
        var person = clientList.stream().filter(x -> x.getNumber() == recipient)
            .findFirst()
            .get();

        return person;
    }

    public void updateClientStand(Client client)
    {
        clientList.stream().filter(x -> x.getNumber() == client.getNumber())
                .findFirst()
                .get().setAccountStand(client.getAccountStand());
    }
}
