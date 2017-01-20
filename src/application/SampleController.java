package application;

import java.net.URL;
import java.util.ResourceBundle;

import bean.River;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	
	private Model m = new Model();
	
	public void setModel(Model m){
		this.m=m;
		River r = comboFiume.getValue();
    	if(comboFiume.getValue()==null){
    		txtRisult.appendText("Seleziona un fiume!\n");
    		return;
    	}
    	
    	txtPrima.setText(String.valueOf(m.getPrima(r)));
    	txtUltima.setText(String.valueOf(m.getUltima(r)));
    	txtNMisure.setText(String.valueOf(m.getSommaMis(r)));
    	txtFMed.setText(String.valueOf(m.getMedia(r)));

	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> comboFiume;

    @FXML
    private TextField txtPrima;

    @FXML
    private TextField txtUltima;

    @FXML
    private TextField txtNMisure;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtFattore;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtRisult;

    @FXML
    void doSimula(ActionEvent event) {
    	txtRisult.clear();
//    	River r = comboFiume.getValue();
//    	if(comboFiume.getValue()==null){
//    		txtRisult.appendText("Seleziona un fiume!\n");
//    		return;
//    	}
//    	
//    	txtPrima.setText(String.valueOf(m.getPrima(r)));
//    	txtUltima.setText(String.valueOf(m.getUltima(r)));
//    	txtNMisure.setText(String.valueOf(m.getSommaMis(r)));
//    	txtFMed.setText(String.valueOf(m.getMedia(r)));

    }

    @FXML
    void initialize() {
        assert comboFiume != null : "fx:id=\"comboFiume\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtPrima != null : "fx:id=\"txtPrima\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtUltima != null : "fx:id=\"txtUltima\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtNMisure != null : "fx:id=\"txtNMisure\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtFattore != null : "fx:id=\"txtFattore\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtRisult != null : "fx:id=\"txtRisult\" was not injected: check your FXML file 'Sample.fxml'.";

        comboFiume.getItems().clear();
        comboFiume.getItems().addAll(m.getfiumi());

    }
}
