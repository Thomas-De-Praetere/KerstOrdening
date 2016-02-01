/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Model;

import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import kerstordening.Person.Person;

/**
 *
 * @author Thomas De Praetere
 */
public class Controller implements InvalidationListener {

    private ListViewListener<String> currentListener;
    @FXML
    private ListView<Person> listView;
    @FXML
    private Label nameLabel;
    @FXML
    private TextArea listText;
    @FXML
    private ListView<String> doesNotBuyForList;

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void initialize() {
        listView.getSelectionModel().selectedItemProperty().addListener(this);
        listText.textProperty().addListener(new TextFieldListener(listText, listView, model));
        doesNotBuyForList.itemsProperty().addListener(new BuyListListener(doesNotBuyForList, listView, model));
        model.addListener(new ListViewListener<>(listView, model.getPerson()));

    }

    public void fromFile() {
        System.out.println("fromFile");
    }

    public void fromFolder() {
        System.out.println("fromFolder");
    }

    public void addFile() {
        model.addPerson(new Person("A", new ArrayList<>(), "text", "ss@s.com"));
    }

    public void removeFile() {
        Person p = listView.getSelectionModel().getSelectedItem();
        if (p != null) {
            model.removePerson(p);
        }
    }

    public void addPerson() {
        System.out.println("addPerson");
    }

    public void removePerson() {
        System.out.println("removePerson");
    }

    public void generateList() {
        System.out.println("generateList");
    }

    @Override
    public void invalidated(Observable observable) {
        Person p = listView.getSelectionModel().getSelectedItem();
        if (p == null) {
            nameLabel.setText("");
            listText.setText("");
            model.removeListener(currentListener);
            doesNotBuyForList.setItems(FXCollections.observableArrayList());
        } else {
            if (!p.getName().equals(nameLabel.getText())) {
                nameLabel.setText(p.getName());
            }
            if (!p.getBody().equals(listText.getText())) {
                listText.setText(p.getBody());
            }
            doesNotBuyForList.setItems(FXCollections.observableArrayList(p.getNotBuyingFor()));
            model.addListener(new ListViewListener<>(doesNotBuyForList, p.getNotBuyingFor()));
        }
    }
}
