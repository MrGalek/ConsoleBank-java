package com.github.mrgalek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDb
{
    private Map<Integer,Boolean> persones;
    private List<Client> clientList;
    private List<Staff> staffList;

    public MockDb()
    {
        persones = new HashMap<Integer,Boolean>();
        clientList = new ArrayList<>();
        staffList = new ArrayList<>();
        loadMockData();
    }

    public String getPersonName(int personNumber)
    {
        Person person;

        if(persones.get(personNumber))
        {
            person = clientList.stream().filter(x -> x.getNumber() == personNumber)
                    .findFirst()
                    .get();
        }
        else
        {
            person = staffList.stream().filter(x -> x.getNumber() == personNumber)
                    .findFirst()
                    .get();
        }

        return person.getName();
    }

    public boolean getPersonType(int personNumber)
    {
        return persones.get(personNumber);
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
        return persones.containsKey(personNumber);
    }


    public Client getClient(int personNumber)
    {
        var person = clientList.stream().filter(x -> x.getNumber() == personNumber)
                .findFirst()
                .get();

        return person;
    }

    public Staff getStaff(int personNumber)
    {
        var person = staffList.stream().filter(x -> x.getNumber() == personNumber)
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

    public int addNewClientAndReturnNumber(String newClientName)
    {
        Client newClient = new Client();
        newClient.setName(newClientName);
        newClient.setAccountStand(0);
        newClient.setType(true);

        int number = persones.size()+150;
        persones.put(number,true);

        newClient.setNumber(number);
        clientList.add(newClient);

        return number;


    }



    ///////////////////
    private void loadMockData()
    {
        for (int i = 0; i < 5; i++)
        {
            var mockClient = new Client();
            mockClient.setName("Jan Kowalski"+i);
            mockClient.setNumber(150+persones.size());
            mockClient.setType(true);
            mockClient.setAccountStand(1950*i);
            persones.put(mockClient.getNumber(),true);
            clientList.add(mockClient);
        }

        var mockStaff = new Staff();
        mockStaff.setName("Anna Nowak");
        mockStaff.setNumber(150+persones.size());
        mockStaff.setType(false);
        persones.put(mockStaff.getNumber(),false);
        staffList.add(mockStaff);
    }
}
