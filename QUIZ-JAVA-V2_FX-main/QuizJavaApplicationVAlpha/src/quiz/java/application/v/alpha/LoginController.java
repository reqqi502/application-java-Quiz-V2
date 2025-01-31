/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.java.application.v.alpha;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import quiz.java.application.v.alpha.Models.Player;
import static quiz.java.application.v.alpha.QuizJavaApplicationVAlpha._Window_;

/**
 *
 * @author Amimi
 */
public class LoginController implements Initializable {

    static Player player;
    static LinkedList<Player> players_lists = new LinkedList<>();

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField age;
    @FXML
    private BorderPane rootpane;
    @FXML
    private Button start;
    @FXML
    private Label auth_status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        start.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                if (firstname.getText().trim().isEmpty() || lastname.getText().trim().isEmpty()) {
                    auth_status.setText("Fields Are Required Please Provide A Valid Infos");
                } else {
                    player = new Player(firstname.getText(), lastname.getText(), Integer.parseInt(age.getText()));
                    players_lists.add(player);
                    try {
                        rootpane = FXMLLoader.load(getClass().getResource("Level_1.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Scene scene = new Scene(rootpane);
                    scene.getStylesheets().add(LoginController.class.getResource("GlobalStyles.css").toExternalForm());

                    _Window_.setScene(scene);

                    _Window_.setTitle(
                            "Level_1 Window");
                    _Window_.show();
                }
            }
        }
        );
    }

}

