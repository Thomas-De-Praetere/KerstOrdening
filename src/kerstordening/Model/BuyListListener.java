/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Model;

import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.ListView;
import kerstordening.Person.Person;

/**
 *
 * @author Thomas De Praetere
 */
public class BuyListListener implements InvalidationListener {

    private final ListView<String> field;
    private final ListView<Person> personList;
    private final Model model;

    public BuyListListener(ListView<String> field, ListView<Person> personList, Model model) {
        this.field = field;
        this.personList = personList;
        this.model = model;
    }

    @Override
    public void invalidated(Observable observable) {
        Person p = personList.getSelectionModel().getSelectedItem();
        if (p != null) {
            p.setNotBuyingFor(new ArrayList<>(field.getItems()));
            model.invalidated(observable);
        }
    }

}
