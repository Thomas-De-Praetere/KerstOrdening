/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kerstordening.Model.Controller;
import kerstordening.Model.Model;

/**
 *
 * @author Thomas De Praetere
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        Controller c = new Controller(model);
        FXMLLoader l = new FXMLLoader(getClass().getResource("MainView.fxml"));
        l.setController(c);
        Parent root = l.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
