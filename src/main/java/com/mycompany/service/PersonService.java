/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.IPersonDAO;
import com.mycompany.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arefin
 */
@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public Person getPersonById(int pid) {
        Person obj = personDAO.getPersonById(pid);
        return obj;
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public synchronized boolean addPerson(Person person) {
        if (personDAO.personExists(person.getName(), person.getLocation())) {
            return false;
        } else {
            personDAO.addPerson(person);
            return true;
        }
    }

    @Override
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    @Override
    public void deletePerson(int pid) {
        personDAO.deletePerson(pid);
    }
}
