package com.mycompany.fxproba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
/*import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;*/

public class FXMLController implements Initializable {
    
    private int num;
    @FXML
    ToggleGroup szamrendszer = new ToggleGroup();
    @FXML
    ToggleGroup mode = new ToggleGroup();
    @FXML
    private RadioButton calculate;
    @FXML
    private RadioButton convert;
    @FXML
    private Label label;
    @FXML
    private Button calcbutton;
    @FXML
    private Button clearbutton;
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private TextField elso = new TextField();
    @FXML
    private TextField masodik = new TextField();
    @FXML
    private RadioButton binbut = new RadioButton();
    @FXML
    private RadioButton oktbut = new RadioButton();
    @FXML
    private RadioButton hexbut = new RadioButton();
    @FXML
    private CheckBox reverse = new CheckBox();
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        masodik.clear();
        if(binbut.isSelected() == true) setNum(2);
        if(oktbut.isSelected() == true) setNum(8);
        if(hexbut.isSelected() == true) setNum(16); 
        calculate(getNum(),reverse.isSelected());
    }
    
    @FXML
    private void clearAction(ActionEvent event){
    
        elso.clear();
        masodik.clear();
    }
    
    @FXML
    private void oneAction(ActionEvent event){
    
        elso.setText(elso.getText() + "1");
    }
    @FXML
    private void twoAction(ActionEvent event){
    
        elso.setText(elso.getText() + "2");
    }
    @FXML
    private void threeAction(ActionEvent event){
    
        elso.setText(elso.getText() + "3");
    }
    @FXML
    private void fourAction(ActionEvent event){
    
        elso.setText(elso.getText() + "4");
    }
    @FXML
    private void fiveAction(ActionEvent event){
    
        elso.setText(elso.getText() + "5");
    }
    @FXML
    private void sixAction(ActionEvent event){
    
        elso.setText(elso.getText() + "6");
    }
    @FXML
    private void sevenAction(ActionEvent event){
    
        elso.setText(elso.getText() + "7");
    }
    @FXML
    private void eightAction(ActionEvent event){
    
        elso.setText(elso.getText() + "8");
    }
    @FXML
    private void nineAction(ActionEvent event){
    
        elso.setText(elso.getText() + "9");
    }
    @FXML
    private void zeroAction(ActionEvent event){
    
        elso.setText(elso.getText() + "0");
    }
    
    private void calculate(int numb,boolean vissza){
    
        if(vissza){           
            masodik.setText(Integer.toString(Integer.parseInt(elso.getText(),numb)));
        }
        else{            
            masodik.setText(Integer.toString(Integer.parseInt(elso.getText()),numb));                
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        binbut.setToggleGroup(szamrendszer);
        binbut.setSelected(true);
        oktbut.setToggleGroup(szamrendszer);
        hexbut.setToggleGroup(szamrendszer);
        calculate.setToggleGroup(mode);
        convert.setToggleGroup(mode);
        convert.setSelected(true);
        
    }    
}
