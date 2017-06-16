/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.entity.Person;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Arefin
 */
@Transactional
@Repository
public class PersonDAO implements IPersonDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Person getPersonById(int pid) {
        return hibernateTemplate.get(Person.class, pid);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getAllPersons() {
        String hql = "FROM Person as p ORDER BY p.pid";
        return (List<Person>) hibernateTemplate.find(hql);
    }

    @Override
    public void addPerson(Person person) {
        hibernateTemplate.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        Person p = getPersonById(person.getPid());
        p.setName(person.getName());
        p.setLocation(person.getLocation());
        hibernateTemplate.update(p);
    }

    @Override
    public void deletePerson(int pid) {
        hibernateTemplate.delete(getPersonById(pid));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean personExists(String name, String location) {
        String hql = "FROM Person as p WHERE p.name = ? and p.location = ?";
        List<Person> persons = (List<Person>) hibernateTemplate.find(hql, name, location);
        return persons.size() > 0 ? true : false;
    }
}
