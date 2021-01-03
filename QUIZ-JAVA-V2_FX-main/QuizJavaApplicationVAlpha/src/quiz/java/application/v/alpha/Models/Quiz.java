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
public class Quiz {

    private int id;

    private String question;

    private String response;

    private String first_choice;
    private String second_choice;
    private String third_choice;

    private static int counter = 1;

    public Quiz(String question, String response, String first_choice, String second_choice, String third_choice) {
        setId(counter++);
        this.question = question;
        this.response = response;
        this.first_choice = first_choice;
        this.second_choice = second_choice;
        this.third_choice = third_choice;
    }

    public Quiz(String question, String response, String first_choice, String second_choice) {
        setId(counter++);
        this.question = question;
        this.response = response;
        this.first_choice = first_choice;
        this.second_choice = second_choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getFirst_choice() {
        return first_choice;
    }

    public void setFirst_choice(String first_choice) {
        this.first_choice = first_choice;
    }

    public String getSecond_choice() {
        return second_choice;
    }

    public void setSecond_choice(String second_choice) {
        this.second_choice = second_choice;
    }

    public String getThird_choice() {
        return third_choice;
    }

    public void setThird_choice(String third_choice) {
        this.third_choice = third_choice;
    }
    private static final Logger LOG = Logger.getLogger(Quiz.class.getName());

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", question=" + question + ", response=" + response + ", first_choice=" + first_choice + ", second_choice=" + second_choice + ", third_choice=" + third_choice + '}';
    }

}

