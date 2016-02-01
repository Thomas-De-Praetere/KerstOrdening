/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kerstordening.Person.Person;

/**
 *
 * @author Thomas De Praetere
 */
public class TextFieldListener implements InvalidationListener {
    
    private final TextArea field;
    private final ListView<Person> personList;
    private final Model model;
    
    public TextFieldListener(TextArea field, ListView<Person> personList, Model model) {
        this.field = field;
        this.personList = personList;
        this.model = model;
    }
    
    @Override
    public void invalidated(Observable observable) {
        Person p = personList.getSelectionModel().getSelectedItem();
        if (p != null && !p.getBody().equals(field.getText())) {
            p.setBody(field.getText());
        }
    }
    
}
