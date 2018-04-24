/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcpractica6;

import ipcpractica6.controller.FXMLDocumentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author thepuar
 */
public class App extends Application {
    
    final int NBRACKETS  = 10;
    int hist[] = new int[NBRACKETS];
    private Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLDocument.fxml"));
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
    
    public void poblate(){
        for(int i = 0; i<hist.length;i++){
            hist[i]=0;
        }
        for(int i = 0; i<1000;i++){
            double value = Math.random() * NBRACKETS;
            hist[(int)value]++;
        }
    }
    
    public int[] getHist(){
        return hist;
    }
    public int getHistIndex(int value){
        return hist[value];
    }
    
}
