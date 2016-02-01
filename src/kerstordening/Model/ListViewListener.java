/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Model;

import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Thomas De Praetere
 * @param <T>
 */
public class ListViewListener<T> implements InvalidationListener {

    private final ListView<T> listView;
    private final List<T> modelList;

    public ListViewListener(ListView<T> listView, List<T> modelList) {
        this.listView = listView;
        this.modelList = modelList;
    }

    @Override
    public void invalidated(Observable observable) {
        listView.setItems(FXCollections.observableArrayList(modelList));
    }

}
