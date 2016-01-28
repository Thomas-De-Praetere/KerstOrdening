/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import kerstordening.Person.Person;

/**
 *
 * @author Thomas De Praetere
 */
public class Model implements Observable {

    private final List<Person> persons;

    private final Set<InvalidationListener> listeners;

    public Model() {
        persons = new ArrayList<>();
        listeners = new HashSet<>();
    }

    public void addPerson(Person p) {
        if (!persons.contains(p)) {
            persons.add(p);
            listeners.stream().forEach((o) -> {
                o.invalidated(this);
            });
        }
    }

    public List<Person> getPerson() {
        return persons;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

}
