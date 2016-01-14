/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.Person;

import java.util.ArrayList;

/**
 *
 * @author Thomas De Praetere
 */
public class Person {

    private String name;
    private ArrayList<String> notBuyingFor;
    private String body;
    private String correspondence;

    public Person(String name, ArrayList<String> notBuyingFor, String body, String correspondence) {
        this.name = name;
        this.notBuyingFor = notBuyingFor;
        this.body = body;
        this.correspondence = correspondence;
    }

    public Person() {
        name = "";
        notBuyingFor = new ArrayList<>();
        body = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNotBuyingFor() {
        return notBuyingFor;
    }

    public void setNotBuyingFor(ArrayList<String> notBuyingFor) {
        this.notBuyingFor = notBuyingFor;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(String correspondence) {
        this.correspondence = correspondence;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", notBuyingFor=" + notBuyingFor.toString() + ", body=" + body + ", correspondence=" + correspondence + '}';
    }

}
