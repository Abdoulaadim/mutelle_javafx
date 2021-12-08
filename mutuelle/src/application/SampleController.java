package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleController implements Initializable  {

	
	
	JSONArray jrr = new JSONArray();
	
	


	@FXML
    private TextField UserField;

    @FXML
    private TextField PasswordField;

    @FXML
    void login(ActionEvent event) throws Exception {
    	
    	//JSONParser jsonP = new JSONParser();
    	
    	//try (FileReader  reader = new FileReader("login.json")) {
    		
    		//Object  obj = jsonP.parse(reader);
    		//JSONArray emplist =(JSONArray) obj;
    		
    	/*	Object obj = jsonP.parse(reader);

    		JSONArray employeeList = (JSONArray) obj;

    		//System.out.println(employeeList);

    		for (Object o : employeeList) {

    		JSONObject employee = (JSONObject) o;
    		

    		String email = (String) employee.get("email");

    		String password = (String) employee.get("password");

    		if ((this.UserField.getText().isEmpty() || this.PasswordField.getText().isEmpty())) {

    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Dialog");
    			alert.setHeaderText(null);
    			alert.setContentText("Mot de passse ou email incorrect ");

    			alert.showAndWait();

    		break;

    		} else if (email.equals(this.UserField.getText()) && password.equals(this.PasswordField.getText())) {
    			
    			try {
    				 Parent root =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
        	         Scene  scene = new Scene(root);
        	         Stage stage =new Stage();
        	         stage.setScene(scene);
        	         stage.show();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
    			
    		}
    		
    	    //System.out.println(emplist.get(0));
    	    
    	    
    	   // ArrayList<Object> listdata = new ArrayList<Object>();   
    	    
    	 //   if (emplist != null) { 
    	    //   for (int i=0;i<emplist.size();i++){ 
    	     //   listdata.add(emplist.get(i));
    	   //    } 
    	     
    	  //  } 
    	    
    	  //(int i=0; i<listdata.size(); i++) {  
                //Printing each element of ArrayList  


    	    	// System.out.println(listdata.get(i));
              //  System.out.println(listdata.get(i));  
    	    	
    	      
            }  
    	    
    	  //  for (int i=0 ; emplist.size()>i;i++) {
    	   // 	  System.out.println(emplist.get(i));  
    	    //	}
    		
    		//JSONObject  empOBJ = (JSONObject) emplist.get("")
			
		} catch (FileNotFoundException e) {
    		e.printStackTrace();
		}
    	catch(IOException e){
    		e.printStackTrace();

    	}*/
    	
    	
    	 JSONArray jrr = new JSONArray();
         Object ob = null;
         JSONParser Jp = new JSONParser();
         try{
             FileReader file = new FileReader("login.json");
             ob=Jp.parse(file);
             jrr=(JSONArray) ob;
             file.close();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Error Occured While fetching");

             
         }
         
         JSONObject obj = new JSONObject();
         int size = jrr.size();
         obj.put("firstname", UserField.getText());
         obj.put("password",PasswordField.getText());
         
         Stage primaryStage =new Stage();
        
         for(int i=0;i<size;i++){
             if(jrr.get(i).equals(obj)){
                 
                // System.out.println(jrr);
               
               //move to next page
                 try {
                	
                	 Parent root =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
        	         Scene  scene = new Scene(root);
        	         Stage stage =new Stage();
        	         stage.setScene(scene);
        	         stage.show();
         		} catch(Exception e) {
         			e.printStackTrace();
         		}

             
                 
                 break;
             }else if(i==size-1){
            	 
                 JOptionPane.showMessageDialog(null,"Incorrect User/Password!");

                
             }
         }
    	} 
    	
    	 
    
    
    
    @FXML
    void register(ActionEvent event) {
    	
    	JSONObject obj = new JSONObject();
        JSONArray jrr = new JSONArray();
        JSONParser jp = new JSONParser();
        try{
            FileReader file = new FileReader("login.json");
            jrr=(JSONArray)jp.parse(file);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error occured");

        }
        
        obj.put("firstname", UserField.getText());
        obj.put("password",PasswordField.getText());
        jrr.add(obj);
        try{
            FileWriter file = new FileWriter("login.json");
            file.write(jrr.toJSONString());
            file.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error occured");

        }
        JOptionPane.showMessageDialog(null,"Data Saved");;



    }
    

      

    	 

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		

	}
	
}
