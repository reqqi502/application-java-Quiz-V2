/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.java.application.v.alpha;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import static quiz.java.application.v.alpha.LoginController.player;
import quiz.java.application.v.alpha.Models.Player_Responses;
import quiz.java.application.v.alpha.Models.Quiz;
import static quiz.java.application.v.alpha.QuizJavaApplicationVAlpha._Window_;

/**
 * FXML Controller class
 *
 * @author Amimi
 */
public class Final_LevelController implements Initializable {

    int tentative_nbr = 2;

    LinkedList<Quiz> _listsL1Quizes = new LinkedList<>();
    LinkedList<RadioButton> lists_toggle = new LinkedList<>();
    LinkedList<Player_Responses> lists_players_Responses = new LinkedList<>();

    LinkedList<RadioButton> correctRadioButtonsIds = new LinkedList<>();
    LinkedList<RadioButton> incorrectRadioButtonsIds = new LinkedList<>();

    ToggleGroup group_1 = new ToggleGroup();
    ToggleGroup group_2 = new ToggleGroup();
    ToggleGroup group_3 = new ToggleGroup();
    ToggleGroup group_4 = new ToggleGroup();
    ToggleGroup group_5 = new ToggleGroup();

    @FXML
    private BorderPane finalrootpane;
    @FXML
    private Label score_result;
    @FXML
    private Label counter_results;
    @FXML
    private Button check_button;
    @FXML
    private TextArea Q1;
    @FXML
    private RadioButton Q1rd1;
    @FXML
    private RadioButton Q1rd3;
    @FXML
    private RadioButton Q1rd2;
    @FXML
    private TextArea Q2;
    @FXML
    private RadioButton Q2rd1;
    @FXML
    private RadioButton Q2rd2;
    @FXML
    private TextArea Q3;
    @FXML
    private RadioButton Q3rd2;
    @FXML
    private RadioButton Q3rd1;
    @FXML
    private TextArea Q4;
    @FXML
    private RadioButton Q4rd1;
    @FXML
    private RadioButton Q4rd2;
    @FXML
    private TextArea Q5;
    @FXML
    private RadioButton Q5rd1;
    @FXML
    private RadioButton Q5rd2;
    @FXML
    private RadioButton Q5rd3;
    @FXML
    private ImageView heart_2;
    @FXML
    private ImageView heart_1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final_Level();
    }

    private void getAlert(String game_over) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(game_over);
        alert.show();
    }

    private void final_Level() {
        Quiz quiz1 = new Quiz("calculerSalaire(int) calculerSalaire(int, double)La méthode calculerSalaire est:", "surchargée", "aucun des choix", "surchargée", "redéfinie");
        Quiz quiz2 = new Quiz("Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.", "vrai", "vrai", "faux");
        Quiz quiz3 = new Quiz("Est-ce qu’une classe peut implémenter plusieurs interfaces?", "vrai", "vrai", "faux");
        Quiz quiz4 = new Quiz("La déclaration d'une méthode suivante :public void traitement() throws IOExceptionprécise que la méthode propage une exception contrôlée", "vrai", "vrai", "faux");
        Quiz quiz5 = new Quiz("class Test{public static void main (String[] args) {try {int a =10;System.out.println (\"a = \" + a );int b = 0 / a;System.out.println (\"b = \" + b);}catch(ArithmeticException e){System.out.println (\"diviser par 0!\"); }finally{System.out.println(\"je suis à l’intérieur de finally\");}}}", "a=10 b=0 Je suis à l’intérieur de finally", "aucun des choix", "a=10 b=0 Je suis à l’intérieur de finally", "a=10 b=0 diviser par 0! je suis à l’intérieur de finally");

        _listsL1Quizes.add(quiz1);
        _listsL1Quizes.add(quiz2);
        _listsL1Quizes.add(quiz3);
        _listsL1Quizes.add(quiz4);
        _listsL1Quizes.add(quiz5);

        populateTheUI();

        check_button.setOnAction((ActionEvent event) -> {
            if (checkAllToggleGroups()) {
                displaySelectedResponses();
                checkCorrectAnswers();
                _CorrectionToValidateTheLevel();
                correctWrongAnswers();
            } else {
                getAlert("All Must Filled Out");
            }
        });
    }

    // show the Plaer The correct  & the incorrect Answers
    private void correctWrongAnswers() {
        for (int i = 0; i < correctRadioButtonsIds.size(); i++) {
            RadioButton get = correctRadioButtonsIds.get(i);
            get.getStyleClass().add("correct_");
            System.out.println("radiobutton ids for the correct answers" + get);
        }
        for (int i = 0; i < incorrectRadioButtonsIds.size(); i++) {
            RadioButton get_ = incorrectRadioButtonsIds.get(i);
            get_.getStyleClass().add("incorrect_");
            System.out.println("radiobutton ids for the incorrect answers" + get_);
        }
    }

    // get the selected answers 
    private void displaySelectedResponses() {

        RadioButton selectedOne = (RadioButton) group_1.getSelectedToggle();
        RadioButton selectedTwo = (RadioButton) group_2.getSelectedToggle();
        RadioButton selectedThree = (RadioButton) group_3.getSelectedToggle();
        RadioButton selectedFour = (RadioButton) group_4.getSelectedToggle();
        RadioButton selectedFive = (RadioButton) group_5.getSelectedToggle();

        lists_toggle.add(selectedOne);
        lists_toggle.add(selectedTwo);
        lists_toggle.add(selectedThree);
        lists_toggle.add(selectedFour);
        lists_toggle.add(selectedFive);

        for (int i = 0; i < lists_toggle.size(); i++) {
            RadioButton items = lists_toggle.get(i);
            System.out.println(items);
        }
    }

    // should i procced to the nextlevel or i have the chance to try again
    private void _CorrectionToValidateTheLevel() {
        if (score() >= 80) {
            score_result.setText("Score : " + score());
            check_button.setDisable(true);
            loadNext_Level();
        } else {
            System.out.println("you loose in this level :( ");
            score_result.setText("Score : " + score());
            check_button.setDisable(true);
            retryAgain();
        }
    }

    private void checkCorrectAnswers() {
//        player.getId();
//        if (lists_toggle.get(0).getText().equals(_listsL1Quizes.get(0).getResponse()) && lists_toggle.get(1).getText().equals(_listsL1Quizes.get(1).getResponse()) && lists_toggle.get(2).getText().equals(_listsL1Quizes.get(2).getResponse()) && lists_toggle.get(3).getText().equals(_listsL1Quizes.get(3).getResponse()) && lists_toggle.get(4).getText().equals(_listsL1Quizes.get(4).getResponse())) {
//            System.out.println("responses correct");
//        } else {
//
//        }
        for (int i = 0; i < _listsL1Quizes.size(); i++) {
            boolean correctOrNot;
            if (lists_toggle.get(i).getText().equals(_listsL1Quizes.get(i).getResponse())) {
                // System.out.println(lists_toggle.get(i) + " responses correct ");
                correctOrNot = true;
                correctRadioButtonsIds.add(lists_toggle.get(i));
            } else {
                // System.out.println(lists_toggle.get(i).getId() + " responses incorrect ");
                correctOrNot = false;
                incorrectRadioButtonsIds.add(lists_toggle.get(i));
            }
            Player_Responses player_Responses = new Player_Responses(player.getId(), _listsL1Quizes.get(i).getId(), lists_toggle.get(i).getText(), correctOrNot);
            lists_players_Responses.add(player_Responses);
//            for (int j = 0; j < lists_players_Responses.size(); j++) {
//            Player_Responses player_Responses_ = lists_players_Responses.get(i);
//            System.out.println(player_Responses_.toString());
//            }
        }
    }

    private int score() {
        int score_reward = 0;
        for (int i = 0; i < lists_players_Responses.size(); i++) {
            if (lists_players_Responses.get(i).isCorrect()) {
                score_reward += 20;
            }
            score_reward += 0;
        }
        return score_reward;
    }

    private boolean checkAllToggleGroups() {
        if (group_1.getSelectedToggle() == null || group_2.getSelectedToggle() == null || group_3.getSelectedToggle() == null || group_4.getSelectedToggle() == null || group_5.getSelectedToggle() == null) {
            return false;
        }
        return true;
    }

    private void populateTheUI() {

        Q1.setText(_listsL1Quizes.get(0).getQuestion());
        Q1rd1.setText(_listsL1Quizes.get(0).getFirst_choice());
        Q1rd2.setText(_listsL1Quizes.get(0).getSecond_choice());
        Q1rd3.setText(_listsL1Quizes.get(0).getThird_choice());
        Q1rd1.setToggleGroup(group_1);
        Q1rd2.setToggleGroup(group_1);
        Q1rd3.setToggleGroup(group_1);

        Q2.setText(_listsL1Quizes.get(1).getQuestion());
        Q2rd1.setText(_listsL1Quizes.get(1).getFirst_choice());
        Q2rd2.setText(_listsL1Quizes.get(1).getSecond_choice());
        Q2rd1.setToggleGroup(group_2);
        Q2rd2.setToggleGroup(group_2);

        Q3.setText(_listsL1Quizes.get(2).getQuestion());
        Q3rd1.setText(_listsL1Quizes.get(2).getFirst_choice());
        Q3rd2.setText(_listsL1Quizes.get(2).getSecond_choice());
        Q3rd1.setToggleGroup(group_3);
        Q3rd2.setToggleGroup(group_3);

        Q4.setText(_listsL1Quizes.get(3).getQuestion());
        Q4rd1.setText(_listsL1Quizes.get(3).getFirst_choice());
        Q4rd2.setText(_listsL1Quizes.get(3).getSecond_choice());
        Q4rd1.setToggleGroup(group_4);
        Q4rd2.setToggleGroup(group_4);

        Q5.setText(_listsL1Quizes.get(4).getQuestion());
        Q5rd1.setText(_listsL1Quizes.get(4).getFirst_choice());
        Q5rd2.setText(_listsL1Quizes.get(4).getSecond_choice());
        Q5rd3.setText(_listsL1Quizes.get(4).getThird_choice());
        Q5rd1.setToggleGroup(group_5);
        Q5rd2.setToggleGroup(group_5);
        Q5rd3.setToggleGroup(group_5);

    }

    private void loadNext_Level() {
        System.out.println("YOU JUSTE WIN THIS GAME CONCRATULATIONS ");
//        next_level.setOnAction((ActionEvent event) -> {
        try {
            finalrootpane = FXMLLoader.load(getClass().getResource("Congratulation.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Level_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(finalrootpane);
        scene.getStylesheets().add(LoginController.class.getResource("GlobalStyles.css").toExternalForm());

        _Window_.setScene(scene);

        _Window_.setTitle(
                "Final_Level Window");
        _Window_.show();
//        });
    }

    private void retryAgain() {
        dialog_Confirmation();
    }

    private void dialog_Confirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Juste Loose The Game :(");
        alert.setContentText(" Do You Wan To Try Again ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("OK I wan To Try");
            // clear All The LinkedLists In This Level And Then Populate The new Level
            tentative_nbr--;
            heart_2.setVisible(false);

            _listsL1Quizes.clear();
            lists_toggle.clear();
            lists_players_Responses.clear();
            correctRadioButtonsIds.clear();
            incorrectRadioButtonsIds.clear();

            System.out.println("Lists Quiz : " + _listsL1Quizes);
            System.out.println("Lists Radio Buttons Toggles  : " + lists_toggle);
            System.out.println("Lists Players Responses : " + lists_players_Responses);
            System.out.println("Lists Correct Radio Buttons Toggles  : " + correctRadioButtonsIds);
            System.out.println("Lists inCorrect Radio Buttons Toggles : " + incorrectRadioButtonsIds);
            check_button.setDisable(false);
            final_Level();
            if (tentative_nbr == 0) {
                correctWrongAnswers();
                System.out.println("You Loose The Game Sorry");
                System.exit(0);
            }

        } else {
            System.out.println("OH NOOOOO");
        }
    }

}


