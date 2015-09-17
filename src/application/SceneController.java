package application;

import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class SceneController extends AnchorPane{
	
	@FXML
	private StackedAreaChart h2Graph;
	
	public void init(){
		h2Graph.getXAxis().setLabel("delta_T (K)");
		h2Graph.getYAxis().setLabel("Solar Efficiency (%)");
	}

}
