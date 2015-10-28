package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.ValueAxis;
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
import javafx.scene.layout.Pane;

public class SceneController extends AnchorPane{

	@FXML
	private TextField solarDNI;
	@FXML
	private TextField conFactor;
	@FXML
	private TextField emiss;
	@FXML
	private TextField reflectOne;
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
	private TextField gasLess;
	@FXML
	private TextField gasGreat;
	@FXML
	private TextField reducTemp;
	@FXML
	private TextField thermalReduc;
	@FXML
	private TextField oxiTempLow;
	@FXML
	private TextField oxiTempHigh;
	@FXML
	private TextField fuelSpecHeat;
	@FXML
	private TextField solarToFuelEfficiency;
	@FXML
	private RadioButton higherHeatingRadio;
	@FXML
	private ToggleGroup heatRadios;
	@FXML
	private Pane graphPane;

	private boolean[] invalidInput;
	private static final int INPUT_SIZE = 16;

	public void init(){
		invalidInput = new boolean[INPUT_SIZE];
		for(int x = 0; x < invalidInput.length; x++){
			invalidInput[x] = true;
		}
	}

	// Event Listener on TextField[#solarDNI].onKeyReleased
	@FXML
	public void solarDNIKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solarDNI.getText());
			if(value < 300 || value > 1000){
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
			if(value < 1500 || value > 3500){
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
	// Event Listener on TextField[#emiss].onKeyReleased
	@FXML
	public void emissKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(emiss.getText());
			if(value < 0.7 || value > 1){
				emiss.setStyle("-fx-text-fill:red;");
				invalidInput[2] = true;
			}else{
				emiss.setStyle("-fx-text-fill:black;");
				invalidInput[2] = false;
			}
		}catch(Exception e){
			emiss.setStyle("-fx-text-fill:red;");
			invalidInput[2] = true;
		}
	}
	// Event Listener on TextField[#reflectOne].onKeyReleased
	@FXML
	public void reflectOneKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(reflectOne.getText());
			if(value < 0 || value > 1){
				reflectOne.setStyle("-fx-text-fill:red;");
				invalidInput[3] = true;
			}else{
				reflectOne.setStyle("-fx-text-fill:black;");
				invalidInput[3] = false;
			}
		}catch(Exception e){
			reflectOne.setStyle("-fx-text-fill:red;");
			invalidInput[3] = true;
		}
	}
	// Event Listener on TextField[#solarToElec].onKeyReleased
	@FXML
	public void solarToElecKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solarToElec.getText());
			if(value < 0 || value > 1){
				solarToElec.setStyle("-fx-text-fill:red;");
				invalidInput[4] = true;
			}else{
				solarToElec.setStyle("-fx-text-fill:black;");
				invalidInput[4] = false;
			}
		}catch(Exception e){
			solarToElec.setStyle("-fx-text-fill:red;");
			invalidInput[4] = true;
		}
	}
	// Event Listener on TextField[#heatToElec].onKeyReleased
	@FXML
	public void heatToElecKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(heatToElec.getText());
			if(value < 0 || value > 1){
				heatToElec.setStyle("-fx-text-fill:red;");
				invalidInput[5] = true;
			}else{
				heatToElec.setStyle("-fx-text-fill:black;");
				invalidInput[5] = false;
			}
		}catch(Exception e){
			heatToElec.setStyle("-fx-text-fill:red;");
			invalidInput[5] = true;
		}
	}
	// Event Listener on TextField[#lifting].onKeyReleased
	@FXML
	public void liftingKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(lifting.getText());
			if(value < 0 || value > 1){
				lifting.setStyle("-fx-text-fill:red;");
				invalidInput[6] = true;
			}else{
				lifting.setStyle("-fx-text-fill:black;");
				invalidInput[6] = false;
			}
		}catch(Exception e){
			lifting.setStyle("-fx-text-fill:red;");
			invalidInput[6] = true;
		}
	}
	// Event Listener on TextField[#elecToPump].onKeyReleased
	@FXML
	public void elecToPumpKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(elecToPump.getText());
			if(value < 0 || value > 1){
				elecToPump.setStyle("-fx-text-fill:red;");
				invalidInput[7] = true;
			}else{
				elecToPump.setStyle("-fx-text-fill:black;");
				invalidInput[7] = false;
			}
		}catch(Exception e){
			elecToPump.setStyle("-fx-text-fill:red;");
			invalidInput[7] = true;
		}
	}
	// Event Listener on TextField[#solidToSolid].onKeyReleased
	@FXML
	public void solidToSolidKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(solidToSolid.getText());
			if(value < 0 || value > 1){
				solidToSolid.setStyle("-fx-text-fill:red;");
				invalidInput[8] = true;
			}else{
				solidToSolid.setStyle("-fx-text-fill:black;");
				invalidInput[8] = false;
			}
		}catch(Exception e){
			solidToSolid.setStyle("-fx-text-fill:red;");
			invalidInput[8] = true;
		}
	}

	// Event Listener on TextField[#gasLess].onKeyReleased
	@FXML
	public void gasLessKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(gasLess.getText());
			if(value < 0 || value > 1){
				gasLess.setStyle("-fx-text-fill:red;");
				invalidInput[9] = true;
			}else{
				gasLess.setStyle("-fx-text-fill:black;");
				invalidInput[9] = false;
			}
		}catch(Exception e){
			gasLess.setStyle("-fx-text-fill:red;");
			invalidInput[9] = true;
		}
	}
	// Event Listener on TextField[#gasGreat].onKeyReleased
	@FXML
	public void gasGreatKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(gasGreat.getText());
			if(value < 0 || value > 1){
				gasGreat.setStyle("-fx-text-fill:red;");
				invalidInput[10] = true;
			}else{
				gasGreat.setStyle("-fx-text-fill:black;");
				invalidInput[10] = false;
			}
		}catch(Exception e){
			gasGreat.setStyle("-fx-text-fill:red;");
			invalidInput[10] = true;
		}
	}

	// Event Listener on TextField[#reducTemp].onKeyReleased
	@FXML
	public void reducTempKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(reducTemp.getText());
			if(value < 1300 || value > 1600){
				reducTemp.setStyle("-fx-text-fill:red;");
				invalidInput[11] = true;
			}else{
				reducTemp.setStyle("-fx-text-fill:black;");
				invalidInput[11] = false;
			}
		}catch(Exception e){
			reducTemp.setStyle("-fx-text-fill:red;");
			invalidInput[11] = true;
		}
	}

	// Event Listener on TextField[#thermalReduc].onKeyReleased
	@FXML
	public void thermalReducKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(thermalReduc.getText());
			if(value < 1 || value > 1000){
				thermalReduc.setStyle("-fx-text-fill:red;");
				invalidInput[12] = true;
			}else{
				thermalReduc.setStyle("-fx-text-fill:black;");
				invalidInput[12] = false;
			}
		}catch(Exception e){
			thermalReduc.setStyle("-fx-text-fill:red;");
			invalidInput[12] = true;
		}
	}
	// Event Listener on TextField[#oxiTempLow].onKeyReleased
	@FXML
	public void oxiTempLowKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(oxiTempLow.getText());
			if(value < 500 || value > 1673){
				oxiTempLow.setStyle("-fx-text-fill:red;");
				invalidInput[13] = true;
			}else{
				oxiTempLow.setStyle("-fx-text-fill:black;");
				invalidInput[13] = false;
			}
		}catch(Exception e){
			oxiTempLow.setStyle("-fx-text-fill:red;");
			invalidInput[13] = true;
		}
	}
	// Event Listener on TextField[#oxiTempHigh].onKeyReleased
	@FXML
	public void oxiTempHighKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(oxiTempHigh.getText());
			if(value < 500 || value > 1673){
				oxiTempHigh.setStyle("-fx-text-fill:red;");
				invalidInput[14] = true;
			}else{
				oxiTempHigh.setStyle("-fx-text-fill:black;");
				invalidInput[14] = false;
			}
		}catch(Exception e){
			oxiTempHigh.setStyle("-fx-text-fill:red;");
			invalidInput[14] = true;
		}
	}
	// Event Listener on TextField[#fuelSpecHeat].onKeyReleased
	@FXML
	public void fuelSpecHeatKeyReleased(KeyEvent event) {
		try{
			double value = Double.parseDouble(fuelSpecHeat.getText());
			if(value < 0 || value > 200){
				fuelSpecHeat.setStyle("-fx-text-fill:red;");
				invalidInput[15] = true;
			}else{
				fuelSpecHeat.setStyle("-fx-text-fill:black;");
				invalidInput[15] = false;
			}
		}catch(Exception e){
			fuelSpecHeat.setStyle("-fx-text-fill:red;");
			invalidInput[15] = true;
		}
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void onCalculate(MouseEvent event) {
		boolean calc = true;
		for(int x = 0; x < invalidInput.length; x++){
			if(invalidInput[x]){
				System.out.println(x);
				showInvalidInputDialog("Please replace red text with valid input.");
				calc = false;
				break;
			}
		}
		if (calc){
			String[] values = new String[INPUT_SIZE + 1];
			values[0] = solarDNI.getText();
			values[1] = conFactor.getText();
			values[2] = emiss.getText();
			values[3] = reflectOne.getText();
			values[4] = solarToElec.getText();
			values[5] = heatToElec.getText();
			values[6] = lifting.getText();
			values[7] = elecToPump.getText();
			values[8] = solidToSolid.getText();
			values[9] = gasLess.getText();
			values[10] = gasGreat.getText();
			values[11] = reducTemp.getText();
			values[12] = thermalReduc.getText();
			values[13] = oxiTempLow.getText();
			values[14] = oxiTempHigh.getText();
			values[15] = fuelSpecHeat.getText();
			if(higherHeatingRadio.isSelected()){
				values[16] = "1";
			}else{
				values[16] = "0";
			}

			/*
			HydrogenProxy proxy = new HydrogenProxy();
			String filename = proxy.calculate(values);
			File file = new File(filename);
			ArrayList<String> input = new ArrayList<String>();
			XYChart.Series series = new XYChart.Series();
	        series.setName("efficiency");
			try{
				BufferedReader fr = new BufferedReader(new FileReader(file));
				String str;
				while((str=fr.readLine())!=null){
					input.add(str);
				}
				double oxiLow = Double.parseDouble(oxiTempLow.getText().toString());
				double oxiHigh = Double.parseDouble(oxiTempHigh.getText().toString());
				double xtick = (oxiHigh - oxiLow)/20;
				double ytick = .1;
				
				for (int x = 0; x < input.size()-1; x++){
					series.getData().add(new XYChart.Data((x+oxiLow), Double.parseDouble(input.get(x))));
				}
				if(graphPane.getChildren().size() > 0)
					graphPane.getChildren().remove(0);
				NumberAxis xAxis = new NumberAxis("Oxidation Temp (C)", oxiLow, oxiHigh, xtick);
		        NumberAxis yAxis = new NumberAxis("Solar Efficiency (%)", (Double.parseDouble(input.get(0))-.1),(Double.parseDouble(input.get(input.size()-1))+.1), ytick);
				LineChart h2Graph = new LineChart(xAxis, yAxis);
				h2Graph.setMinSize(862, 478);
				h2Graph.setMaxSize(862, 478);
				graphPane.getChildren().add(h2Graph);
				h2Graph.getData().add(series);
				h2Graph.setCreateSymbols(false);
				h2Graph.setLegendVisible(false);
				fr.close();
				solarToFuelEfficiency.setText(input.get(input.size()-1));
			}catch(Exception e){
				e.printStackTrace();
			}
			 
			*/
			CalculationHandler ch = new CalculationHandler(values);
			double[] calcs = ch.runCalculations();
			XYChart.Series series = new XYChart.Series();
	        series.setName("efficiency");
	        
	        double max = calcs[0];
	        double min = calcs[0];
	        
	        for(int x = 0; x < calcs.length; x++){
	        	if(max < calcs[x]){
	        		max = calcs[x];
	        	}
	        	if(min > calcs[x]){
	        		min = calcs[x];
	        	}
	        }

			try{
				double oxiLow = Double.parseDouble(oxiTempLow.getText().toString());
				double oxiHigh = Double.parseDouble(oxiTempHigh.getText().toString());
				int tick = (int)(oxiHigh - oxiLow)/5;
				double xtick = (oxiHigh - oxiLow)/20;
				/*
				if (oxiHigh - oxiLow < 20){
					xtick = (oxiHigh - oxiLow)%20;
				}
				*/

				for (int x = 0; x < calcs.length; x++){
					series.getData().add(new XYChart.Data(x+oxiLow, calcs[x]));
				}
				if(graphPane.getChildren().size() > 0)
					graphPane.getChildren().remove(0);
				NumberAxis xAxis = new NumberAxis("Oxidation Temp (C)", oxiLow-5, oxiHigh+5, xtick);
				NumberAxis yAxis = new NumberAxis("Solar Efficiency (%)", min-.1,(max)+.1, 1);
				LineChart h2Graph = new LineChart(xAxis, yAxis);
				h2Graph.setMinSize(862, 478);
				h2Graph.setMaxSize(862, 478);
				graphPane.getChildren().add(h2Graph);
				h2Graph.getData().add(series);
				h2Graph.setCreateSymbols(false);
				h2Graph.setLegendVisible(false);
				solarToFuelEfficiency.setText(Double.toString(max));
			}catch(Exception e){
				e.printStackTrace();
			}
			
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
