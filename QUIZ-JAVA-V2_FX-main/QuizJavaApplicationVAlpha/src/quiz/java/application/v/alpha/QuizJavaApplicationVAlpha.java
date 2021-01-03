/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.java.application.v.alpha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Amimi
 */
public class QuizJavaApplicationVAlpha extends Application {
    static Stage _Window_;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        _Window_ = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(QuizJavaApplicationVAlpha.class.getResource("GlobalStyles.css").toExternalForm());
        _Window_.setScene(scene);
        _Window_.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}





