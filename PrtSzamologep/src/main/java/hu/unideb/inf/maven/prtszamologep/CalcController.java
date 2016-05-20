package hu.unideb.inf.maven.prtszamologep;

import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class CalcController implements Initializable {
    
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
    private Button calcbutton;
    @FXML
    private Button clearbutton;
    @FXML
    private Button zero;
    @FXML
    private Button add;
    @FXML
    private Button sub;
    @FXML
    private Button multi;
    @FXML
    private Button divide;
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
    @FXML
    private void addAction(ActionEvent event){                
        elso.setText(elso.getText() + "+");        
    }
    @FXML
    private void subAction(ActionEvent event){       
        elso.setText(elso.getText() + "-");      
    }
    @FXML
    private void multiAction(ActionEvent event){       
        elso.setText(elso.getText() + "*");        
    }
    @FXML
    private void divAction(ActionEvent event){
        elso.setText(elso.getText() + "/");        
    }
    
    @FXML
    private void setCalcMode(ActionEvent event){
        for (Toggle t : szamrendszer.getToggles()) {  
                    if (t instanceof RadioButton) {  
                        ((RadioButton) t).setDisable(true);  
                    }
        }
        reverse.setDisable(true);
        add.setDisable(false);
        sub.setDisable(false);
        multi.setDisable(false);
        divide.setDisable(false);
        clearbutton.fire();
    }
    @FXML
    private void setConvertMode(ActionEvent event){
        for (Toggle t : szamrendszer.getToggles()) {  
                    if (t instanceof RadioButton) {  
                        ((RadioButton) t).setDisable(false);  
                    }
        }
        reverse.setDisable(false);
        add.setDisable(true);
        sub.setDisable(true);
        multi.setDisable(true);
        divide.setDisable(true);       
        clearbutton.fire();
    }
    
    @FXML
    private void calculate(ActionEvent event) {        
        String method = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();
        CalculatorService service = new CalculatorService(em);
        try{    
            if(convert.isSelected()) {
                method = "Convert";   
                if(binbut.isSelected() == true) setNum(2);
                if(oktbut.isSelected() == true) setNum(8);
                if(hexbut.isSelected() == true) setNum(16); 
                masodik.setText(Calculate.converting(getNum(),reverse.isSelected(),elso.getText()));           
            }

            if(calculate.isSelected()){
                method = "Calculate";
                masodik.setText(Calculate.calculate(Calculate.chopping(elso.getText())));
            }
        }catch(Exception e) {
            method = "Calculate";
            masodik.setText("Hiba: Nem megfelelő karakter(ek)!");
        }
        
       service.createCalculator( elso.getText(), masodik.getText(), method, LocalDateTime.now().toString());
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calcbutton.setDefaultButton(true);
        binbut.setToggleGroup(szamrendszer);
        binbut.setSelected(true);
        oktbut.setToggleGroup(szamrendszer);
        hexbut.setToggleGroup(szamrendszer);
        calculate.setToggleGroup(mode);
        convert.setToggleGroup(mode);
        convert.setSelected(true);
        add.setDisable(true);
        sub.setDisable(true);
        multi.setDisable(true);
        divide.setDisable(true);                               
    }    
}
