package hu.unideb.inf.maven.prtszamologep;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;



public class CalcController implements Initializable {
    
    private int num;
    private String first;
    private String second;
    private String sign;
    private List<String> signs;
    private List<String> numbers;
    
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
    private int elsoLength;
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

    public int getElsoLength() {
        return elsoLength;
    }

    public void setElsoLength() {
        this.elsoLength = elso.getText().length();
    }
        
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
    
    
    @FXML
    private void clearAction(ActionEvent event){
    
        elso.clear();
        masodik.clear();
        setElsoLength();
        setSign("");
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
        numbers.add(elso.getText().substring(elsoLength));
        signs.add("+");
        elso.setText(elso.getText() + "+");
        setElsoLength();
    }
    @FXML
    private void subAction(ActionEvent event){
        numbers.add(elso.getText().substring(elsoLength));
        signs.add("-");
        elso.setText(elso.getText() + "-");
        setElsoLength();
    }
    @FXML
    private void multiAction(ActionEvent event){
        numbers.add(elso.getText().substring(elsoLength));
        signs.add("*");
        elso.setText(elso.getText() + "*");
        setElsoLength();
    }
    @FXML
    private void divAction(ActionEvent event){
        numbers.add(elso.getText().substring(elsoLength));
        signs.add("/");
        elso.setText(elso.getText() + "/");
        setElsoLength();
    }
    
    private void converting(int numb,boolean vissza){
        
            if(vissza){ 
              try{
                    //masodik.setText(Integer.toString(Integer.parseInt(elso.getText(),numb)));
                 BigInteger input = new BigInteger(elso.getText(),numb);
                 masodik.setText(input.toString()); 
               }catch(NumberFormatException e){
                    masodik.setText("Hiba: Nem megfelelő karakter(ek)");
               }
            }
        
         else{ 
                
              //masodik.setText(Integer.toString(Integer.parseInt(elso.getText()),numb));    
              BigInteger input = new BigInteger(elso.getText());
              masodik.setText(input.toString(numb)); 
              
        }
         
        
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
       // elso.clear();
       // masodik.clear();
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
       // elso.clear();
       // masodik.clear();
        clearbutton.fire();
    }
    
    @FXML
    private void listing() {
    
        
    
    }
    
    @FXML
    private void calculate(ActionEvent event) {
        masodik.clear();
        BigInteger input;
        switch(getSign()){
            
            case "+":
                setSecond(elso.getText().substring(first.length()+1));
                input = new BigInteger(first);
                masodik.setText(input.add(new BigInteger(second)).toString());
                break;
            
            case "-":
                setSecond(elso.getText().substring(first.length()+1));
                input = new BigInteger(first);
                masodik.setText(input.subtract(new BigInteger(second)).toString());
                break;
            
            case "*":
                setSecond(elso.getText().substring(first.length()+1));
                input = new BigInteger(first);
                masodik.setText(input.multiply(new BigInteger(second)).toString());
                break;
            
            case "/":
                try{                
                    setSecond(elso.getText().substring(first.length()+1));
                    input = new BigInteger(first);
                    masodik.setText(input.divide(new BigInteger(second)).toString());
                    break; 
                }catch (ArithmeticException e){
                     masodik.setText("Hiba: 0-val nem osztunk!");
                     break;
                }
               
                
            default:   
                if(binbut.isSelected() == true) setNum(2);
                if(oktbut.isSelected() == true) setNum(8);
                if(hexbut.isSelected() == true) setNum(16); 
                converting(getNum(),reverse.isSelected());
                break;
        }
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
        setElsoLength();
        setSign("");
        
        
    }    
}
