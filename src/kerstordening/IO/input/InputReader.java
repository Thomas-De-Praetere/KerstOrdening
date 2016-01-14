/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.IO.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kerstordening.IO.input.error.FileIsNotInRightPatternException;
import kerstordening.Person.Person;

/**
 *
 * @author Thomas De Praetere
 */
public class InputReader {

    private final String pathname;

    public InputReader(String pathname) {
        this.pathname = pathname;
    }

    public Person readFile() throws FileNotFoundException, IOException, FileIsNotInRightPatternException {
        File file = new File(pathname);
        FileReader reader = new FileReader(file);
        BufferedReader bf = new BufferedReader(reader);
        Person person = new Person();

        String line = bf.readLine();
        if (line == null) {
            throw new FileIsNotInRightPatternException("EOF is reached before expected end.");
        }
        Pattern p = Pattern.compile("^.*Verlanglijst van : ?");
        Matcher m = p.matcher(line);
        if (!m.find()) {
            throw new FileIsNotInRightPatternException("First line should be \"Verlanglijst van :\" followed by a name. ");
        }

        String name = line.substring(m.end(), line.length());

        person.setName(name);

        p = Pattern.compile("^.*NAAM[0-9]* : ?");

        String content = "";

        line = bf.readLine();
        m = p.matcher(line);

        while (line != null && !m.find() && !line.equals("Personen voor wie ik dit jaar niet wil kopen zijn (maximaal 3 namen opgeven indien gewenst) :")) {
            content += line;
            line = bf.readLine();
            m = p.matcher(line);
        }

        person.setBody(content);

        while (line != null && !m.find()) {
            line = bf.readLine();
            m = p.matcher(line);
        }
        m = p.matcher(line);
        while (line != null && m.find()) {
            String n = line.substring(m.end(), line.length());
            if (!n.equals("")) {
                person.getNotBuyingFor().add(n);
            }
            line = bf.readLine();
            m = p.matcher(line);
        }

        p = Pattern.compile("^.*Correspondentie via ");
        m = p.matcher(line);

        while (line != null && !m.find()) {
            line = bf.readLine();
            m = p.matcher(line);
        }

        if (line != null) {
            person.setCorrespondence(line.substring(m.end(), line.length()));
        }

        return person;
    }

}
