package application;

import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SceneController extends AnchorPane{
	
	@FXML
	private StackedAreaChart h2Graph;
	@FXML
	private TextField solarDNI;
	@FXML
	private TextField conFactor;
	@FXML
	private TextField trans;
	@FXML
	private TextField emiss;
	@FXML
	private TextField reflectOne;
	@FXML
	private TextField reflectTwo;
	@FXML
	private TextField aperture;
	@FXML
	private TextField recIntercept;
	@FXML
	private TextField dirtFactor;
	@FXML
	private TextField winTrans;
	@FXML
	private TextField solarToElec;
	@FXML
	private TextField heatToElec;
	@FXML
	private TextField lifting;
	@FXML
	private TextField elecToPump;
	@FXML
	private TextField solidToSolid;
	@FXML
	private TextField reducTemp;
	@FXML
	private TextField oxiTemp;
	@FXML
	private Label specHeatH2;
	@FXML
	private TextField fuelMolarMass;
	@FXML
	private TextField fuelSpecHeat;
	@FXML
	private TextField fuelPowerDensity;
	@FXML
	private TextField specHeatO2;
	@FXML
	private TextField solarToFuelEfficiency;
	@FXML
	private RadioButton higherHeatingRadio;
	@FXML
	private ToggleGroup heatRadios;
	
	private boolean[] invalidInput;
	
	public void init(){
		h2Graph.getXAxis().setLabel("delta_T (K)");
		h2Graph.getYAxis().setLabel("Solar Efficiency (%)");
		
		invalidInput = new boolean[14];
		for(int x = 0; x < invalidInput.length; x++){
			invalidInput[x] = false;
		}
	}

	// Event Listener on TextField[#solarDNI].onKeyReleased
	@FXML
	public void solarDNIKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solarDNI.getText());
			if(value < 0 || value > 1){
				solarDNI.setStyle("-fx-text-fill:red;");
				invalidInput[0] = true;
			}else{
				solarDNI.setStyle("-fx-text-fill:black;");
				invalidInput[0] = false;
			}
		}catch(Exception e){
			solarDNI.setStyle("-fx-text-fill:red;");
			invalidInput[0] = true;
		}
	}
	// Event Listener on TextField[#conFactor].onKeyReleased
	@FXML
	public void conFactorKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(conFactor.getText());
			if(value < 1800 || value > 3000){
				conFactor.setStyle("-fx-text-fill:red;");
				invalidInput[1] = true;
			}else{
				conFactor.setStyle("-fx-text-fill:black;");
				invalidInput[1] = false;
			}
		}catch(Exception e){
			conFactor.setStyle("-fx-text-fill:red;");
			invalidInput[1] = true;
		}
	}
	// Event Listener on TextField[#trans].onKeyReleased
	@FXML
	public void transKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(trans.getText());
			if(value < 0 || value > 1){
				trans.setStyle("-fx-text-fill:red;");
				invalidInput[2] = true;
			}else{
				trans.setStyle("-fx-text-fill:black;");
				invalidInput[2] = false;
			}
		}catch(Exception e){
			trans.setStyle("-fx-text-fill:red;");
			invalidInput[2] = true;
		}
	}
	// Event Listener on TextField[#emiss].onKeyReleased
	@FXML
	public void emissKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(emiss.getText());
			if(value < 0 || value > 1){
				emiss.setStyle("-fx-text-fill:red;");
				invalidInput[3] = true;
			}else{
				emiss.setStyle("-fx-text-fill:black;");
				invalidInput[3] = false;
			}
		}catch(Exception e){
			emiss.setStyle("-fx-text-fill:red;");
			invalidInput[3] = true;
		}
	}
	// Event Listener on TextField[#reflectOne].onKeyReleased
	@FXML
	public void reflectOneKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(reflectOne.getText());
			if(value < 0 || value > 1){
				reflectOne.setStyle("-fx-text-fill:red;");
				invalidInput[4] = true;
			}else{
				reflectOne.setStyle("-fx-text-fill:black;");
				invalidInput[4] = false;
			}
		}catch(Exception e){
			reflectOne.setStyle("-fx-text-fill:red;");
			invalidInput[4] = true;
		}
	}
	// Event Listener on TextField[#reflectTwo].onKeyReleased
	@FXML
	public void reflectTwo(KeyEvent event) {
		try{
			double value = Double.parseDouble(reflectTwo.getText());
			if(value < 0 || value > 1){
				reflectTwo.setStyle("-fx-text-fill:red;");
				invalidInput[5] = true;
			}else{
				reflectTwo.setStyle("-fx-text-fill:black;");
				invalidInput[5] = false;
			}
		}catch(Exception e){
			reflectTwo.setStyle("-fx-text-fill:red;");
			invalidInput[5] = true;
		}
	}
	// Event Listener on TextField[#aperture].onKeyReleased
	@FXML
	public void apertureKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(aperture.getText());
			if(value < 0 || value > 2){
				aperture.setStyle("-fx-text-fill:red;");
				invalidInput[6] = true;
			}else{
				aperture.setStyle("-fx-text-fill:black;");
				invalidInput[6] = false;
			}
		}catch(Exception e){
			aperture.setStyle("-fx-text-fill:red;");
			invalidInput[6] = true;
		}
	}
	// Event Listener on TextField[#solarToElec].onKeyReleased
	@FXML
	public void solarToElecKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solarToElec.getText());
			if(value < 0 || value > 1){
				solarToElec.setStyle("-fx-text-fill:red;");
				invalidInput[7] = true;
			}else{
				solarToElec.setStyle("-fx-text-fill:black;");
				invalidInput[7] = false;
			}
		}catch(Exception e){
			solarToElec.setStyle("-fx-text-fill:red;");
			invalidInput[7] = true;
		}
	}
	// Event Listener on TextField[#heatToElec].onKeyReleased
	@FXML
	public void heatToElecKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(heatToElec.getText());
			if(value < 0 || value > 1){
				heatToElec.setStyle("-fx-text-fill:red;");
				invalidInput[8] = true;
			}else{
				heatToElec.setStyle("-fx-text-fill:black;");
				invalidInput[8] = false;
			}
		}catch(Exception e){
			heatToElec.setStyle("-fx-text-fill:red;");
			invalidInput[8] = true;
		}
	}
	// Event Listener on TextField[#lifting].onKeyReleased
	@FXML
	public void liftingKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(lifting.getText());
			if(value < 0 || value > 1){
				lifting.setStyle("-fx-text-fill:red;");
				invalidInput[9] = true;
			}else{
				lifting.setStyle("-fx-text-fill:black;");
				invalidInput[9] = false;
			}
		}catch(Exception e){
			lifting.setStyle("-fx-text-fill:red;");
			invalidInput[9] = true;
		}
	}
	// Event Listener on TextField[#elecToPump].onKeyReleased
	@FXML
	public void elecToPumpKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(elecToPump.getText());
			if(value < 0 || value > 1){
				elecToPump.setStyle("-fx-text-fill:red;");
				invalidInput[10] = true;
			}else{
				elecToPump.setStyle("-fx-text-fill:black;");
				invalidInput[10] = false;
			}
		}catch(Exception e){
			elecToPump.setStyle("-fx-text-fill:red;");
			invalidInput[10] = true;
		}
	}
	// Event Listener on TextField[#solidToSolid].onKeyReleased
	@FXML
	public void solidToSolidKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solidToSolid.getText());
			if(value < 0 || value > 1){
				solidToSolid.setStyle("-fx-text-fill:red;");
				invalidInput[11] = true;
			}else{
				solidToSolid.setStyle("-fx-text-fill:black;");
				invalidInput[11] = false;
			}
		}catch(Exception e){
			solidToSolid.setStyle("-fx-text-fill:red;");
			invalidInput[11] = true;
		}
	}
	// Event Listener on TextField[#reducTemp].onKeyReleased
	@FXML
	public void reducTempKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(reducTemp.getText());
			if(value < 1673 || value > 1873){
				reducTemp.setStyle("-fx-text-fill:red;");
				invalidInput[12] = true;
			}else{
				reducTemp.setStyle("-fx-text-fill:black;");
				invalidInput[12] = false;
			}
		}catch(Exception e){
			reducTemp.setStyle("-fx-text-fill:red;");
			invalidInput[12] = true;
		}
	}
	// Event Listener on TextField[#oxiTemp].onKeyReleased
	@FXML
	public void oxiTempKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(oxiTemp.getText());
			if(value < 873 || value > 1673){
				oxiTemp.setStyle("-fx-text-fill:red;");
				invalidInput[13] = true;
			}else{
				oxiTemp.setStyle("-fx-text-fill:black;");
				invalidInput[13] = false;
			}
		}catch(Exception e){
			oxiTemp.setStyle("-fx-text-fill:red;");
			invalidInput[13] = true;
		}
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void onCalculate(MouseEvent event) {
		boolean calc = true;
		for(int x = 0; x < invalidInput.length; x++){
			if(invalidInput[x]){
				showInvalidInputDialog("Please replace red text with valid input.");
				calc = false;
				break;
			}
		}
		if (calc){
			// TODO: run calculations
		}
	}
	
	private void showInvalidInputDialog(String msg){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setHeaderText("Your input was invalid.");
		alert.setContentText(msg);
		alert.show();
	}
	

}
