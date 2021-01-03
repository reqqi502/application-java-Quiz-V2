/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.java.application.v.alpha.Models;

import java.util.logging.Logger;

/**
 *
 * @author Amimi
 */
public final class Player {

    private int id;

    private String firstname;
    private String lastname;
    private int age;

    private static int counter = 1;

    public Player() {
    }

    public Player(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        setId(counter++);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Player.counter = counter;
    }

   
    private static final Logger LOG = Logger.getLogger(Player.class.getName());

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + '}';
    }

   

}



