package hu.unideb.inf.maven.prtszamologep;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HistoryController implements Initializable {
    @FXML
    Button backbutton;
    @FXML
    TableView<Calculator> historytable;
    @FXML
    TableColumn<Calculator, Integer> idcol;
    @FXML
    TableColumn<Calculator, String> exprcol;
    @FXML
    TableColumn<Calculator, String> rescol;
    @FXML
    TableColumn<Calculator, String> metcol;
    @FXML
    TableColumn<Calculator, String> datcol;
    
    @FXML
    public void back(ActionEvent event) {
        try {
            Stage stage;
            Parent root;
            stage = (Stage) backbutton.getScene().getWindow();            
            FXMLLoader fl1 = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
            root = fl1.load();
            Scene scene = new Scene(root);            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CalcController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();
        CalculatorService service = new CalculatorService(em);
        List<Calculator> calc = service.findAllCalculator();
        ObservableList<Calculator> obs = FXCollections.observableArrayList();
        obs.addAll(calc);
        historytable.setItems(obs);
        idcol.setCellValueFactory(new PropertyValueFactory<Calculator, Integer>("id"));
        exprcol.setCellValueFactory(new PropertyValueFactory<Calculator, String>("expression"));
        metcol.setCellValueFactory(new PropertyValueFactory<Calculator, String>("method"));
        rescol.setCellValueFactory(new PropertyValueFactory<Calculator, String>("result"));
        datcol.setCellValueFactory(new PropertyValueFactory<Calculator, String>("date"));
       
        em.close();
        emf.close();
    }    
    
}
