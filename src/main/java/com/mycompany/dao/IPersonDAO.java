/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.entity.Person;
import java.util.List;

/**
 *
 * @author Arefin
 */
public interface IPersonDAO {
    List<Person> getAllPersons();

    Person getPersonById(int pid);

    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int pid);

    boolean personExists(String name, String location);
}
