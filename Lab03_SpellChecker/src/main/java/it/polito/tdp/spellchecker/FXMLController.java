/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController { 
	long start;
	long end;
	private Dictionary dizionario;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> Checklingua;

    @FXML
    private TextArea txtGeneric;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtError;

    @FXML
    private TextField txtNum;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtTime;

    @FXML
    void doClearText(ActionEvent event) {
  
    	txtGeneric.clear();
    	txtError.clear();
    	txtNum.clear();
    	txtTime.clear();
    	dizionario.reset();
   
    }

    public Dictionary getDizionario() {
		return dizionario;
	}

	public void setDizionario(Dictionary dizionario) {
		this.dizionario = dizionario;
	}

	public void setChecklingua(ChoiceBox<String> checklingua) {
		Checklingua = checklingua;
	}

	public void setBtnSpell(Button btnSpell) {
		this.btnSpell = btnSpell;
	}

	public void setBtnReset(Button btnReset) {
		this.btnReset = btnReset;
	}

	@FXML
    void doSpellCheck(ActionEvent event) {
		start=System.nanoTime();
    	String contenuto=txtGeneric.getText();
    	dizionario.loadDictionary(Checklingua.getValue());
    	String ris=dizionario.spellCheckText(contenuto.toLowerCase());
    	txtError.setText(ris);
    	txtNum.setText("The text contains "+ dizionario.conta()+" error");
    	end=System.nanoTime();
    	txtTime.setText("Il tempo impiegato e' "+ (end-start)/1e9 + " secondi.");
    }

    @FXML
    void initialize() {
        assert Checklingua != null : "fx:id=\"Checklingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGeneric != null : "fx:id=\"txtGeneric\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNum != null : "fx:id=\"txtNum\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        Checklingua.getItems().addAll("Italian","English");
        Checklingua.setValue("Italian");
        dizionario=new Dictionary();
    }
}




