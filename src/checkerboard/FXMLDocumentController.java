/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jonathan
 */
public class FXMLDocumentController implements Initializable, Startable {
    
    private Stage stage;
    public CheckerboardClass checkerboard;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuItem sixteen;
    
    @FXML
    private MenuItem ten;
    
    @FXML
    private MenuItem eight;
    
    @FXML
    private MenuItem three;
    
    @FXML
    private MenuItem red;
    
    @FXML
    private MenuItem blue;
    
    @FXML
    private void handleSize(ActionEvent event) {
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch (menuItem.getId()){
            case "sixteen" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), 16, 16, this.checkerboard.getLightColor(), this.checkerboard.getDarkColor()));
                break;
            case "ten" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), 10, 10, this.checkerboard.getLightColor(), this.checkerboard.getDarkColor()));
                break;
            case "eight" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), 8, 8, this.checkerboard.getLightColor(), this.checkerboard.getDarkColor()));
                break;
            case "three" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), 3, 3, this.checkerboard.getLightColor(), this.checkerboard.getDarkColor()));
                break;
        }
    }
    
    @FXML
    private void handleColor(ActionEvent event) {
        MenuItem menuItem = (MenuItem)event.getSource();
        
        switch (menuItem.getId()){
            case "red" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), checkerboard.getNumRows(), checkerboard.getNumCols(), Color.RED, Color.BLACK));
                break;
            case "blue" :
                newBoard(new CheckerboardClass(stage.getScene().getWidth(), stage.getScene().getHeight() - menuBar.getHeight(), checkerboard.getNumRows(), checkerboard.getNumCols(), Color.SKYBLUE, Color.DARKBLUE));
                break;
        }
    }
    
    public void newBoard(CheckerboardClass checkerboard){        
        checkerboard.build();
        vbox.getChildren().remove(anchorPane);
        anchorPane = checkerboard.getBoard();
        vbox.getChildren().add(anchorPane);
        this.checkerboard = checkerboard;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        ChangeListener<Number> lambdaChangeListener = ((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            newBoard(new CheckerboardClass(stage.getScene().getWidth(),stage.getScene().getHeight() - menuBar.getHeight(), this.checkerboard.getNumRows(), this.checkerboard.getNumCols(), this.checkerboard.getLightColor(),this.checkerboard.getDarkColor()));
        });
        
        newBoard(new CheckerboardClass(anchorPane.getWidth(), anchorPane.getHeight(), 8, 8, Color.RED, Color.BLACK));
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
}
