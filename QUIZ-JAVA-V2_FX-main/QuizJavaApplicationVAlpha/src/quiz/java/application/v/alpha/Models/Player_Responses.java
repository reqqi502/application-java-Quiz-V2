/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.java.application.v.alpha.Models;

/**
 *
 * @author Amimi
 */
public final class Player_Responses {
    
    private int id;
    
    private int idPlayer;
    
    private int idQuiz;
    
    private String response;
    
    private boolean correct;
    
    private static int counter = 1;
    
    public Player_Responses(int idPlayer, int idQuiz, String response, boolean correct) {
        setId(counter++);
        setIdPlayer(idPlayer);
        setIdQuiz(idQuiz);
        setResponse(response);
        setCorrect(correct);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdPlayer() {
        return idPlayer;
    }
    
    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }
    
    public int getIdQuiz() {
        return idQuiz;
    }
    
    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }
    
    public String getResponse() {
        return response;
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    
    public boolean isCorrect() {
        return correct;
    }
    
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
    @Override
    public String toString() {
        return "Player_Responses{" + "id=" + id + ", idPlayer=" + idPlayer + ", idQuiz=" + idQuiz + ", response=" + response + ", correct=" + correct + '}';
    }
    
}

