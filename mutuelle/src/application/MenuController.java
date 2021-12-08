package application;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MenuController {
	
	
	@FXML
    private TextField entreprise;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private TextField telephone;

    @FXML
    private RadioButton cin;

    @FXML
    private RadioButton passport;

    @FXML
    private TextField cin_passport;

    @FXML
    private DatePicker date;

    @FXML
    private TextArea adresse;

    @FXML
    private TableColumn<?, ?> entrepriseT;

    @FXML
    private TableColumn<?, ?> prenomT;

    @FXML
    private TableColumn<?, ?> nomT;

    @FXML
    private TableColumn<?, ?> cinT;

    @FXML
    private TableColumn<?, ?> telephoneT;

    @FXML
    private TableColumn<?, ?> emailT;

    @FXML
    private TableColumn<?, ?> adresseT;

    @FXML
    private TableColumn<?, ?> dateT;

    @FXML
    void enregistrer(ActionEvent event) {
    	
    	JSONObject obj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();
        try{
            FileReader file = new FileReader("clients.json");
            jrr=(JSONArray)jp.parse(file);
            System.out.println(jrr.getClass());
            
           
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error occured");
        }
        
        obj.put("Nom entreproise", entreprise.getText());
        obj.put("prenom",prenom.getText());
        obj.put("Nom", nom.getPromptText());
        obj.put("Prenom",prenom.getText());
        obj.put("Email", email.getText());
        obj.put("telephone",telephone.getText());
        obj.put("cin_passport",cin_passport.getText());
        obj.put("date", date.getValue().toString());
        obj.put("adresse",adresse.getText());
       
        jrr.add(obj);
        
       
       
        
        try{
            FileWriter file = new FileWriter("clients.json");
            file.write(jrr.toJSONString());
            file.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error occured");
        }
        JOptionPane.showMessageDialog(null,"Data Saved");;


    }

}
