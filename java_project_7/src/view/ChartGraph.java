package view;

import Int_tourismData.TourismDataModel;
import cellularData.CellularDataModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Instantiates an JavaFX application which creates a model of the data.
 * Uses the model to instantiate an object of type  javafx.scene.chart.LineChart
 * via the CellularGraphView class. Then sets up the scene with basic modification to
 * the stage.
 *
 * @author Foothill College, Fu Hui, Jantira Tiyasan
 */
public class ChartGraph extends Application
{
	private Button btnscene1, btnscene2;
	private Label lblscene1, lblscene2;
	private Scene scene1, scene2;
	private BorderPane pane1, pane2;;
	private Stage thestage;
	private HBox hBox1, hBox2;
	/**
	 * Called by launch method of Application
	 * @param stage: Stage
	 */
	@Override
	public void start(Stage stage) 
	{
		stage.setTitle("Data Graph");
		// Provides access to CSV data.
		// TODO: Define the data model by parsing the CSV input file(s).
		//       Provide accessor methods to your the parsed data.
		CellularDataModel cellularDataModel = new CellularDataModel();
		TourismDataModel tourismDataModel = new TourismDataModel();
		// Displays graph* of subscription rate by country.
		// TODO: Define the view such that it takes the model as input.
		//       Construct the x and y axis using a NumberAxis, label the axis.
		CellularGraphView cellularGraphViewCellularData = new CellularGraphView(cellularDataModel);
		TourismGraphView tourismGraphView = new TourismGraphView(tourismDataModel);
		// TODO: Define update of the model such that:
		//       - Gets all the data** from the model
		//       - Creates a random list of elements from the data.
		//       - Traverses each element and creates a series (i.e. line)
		//       - Adds the series** to it's Observablelist.

		//   * Here, displays graph of subscription rate by country.
		//  ** Here, our data is composed of Country objects.
		//
		// *** Gets an instance of javafx.collections.ObservableList via a call
		//     to getData() method.
		// https://docs.oracle.com/javafx/2/api/javafx/scene/chart/XYChart.html#getData()
		cellularGraphViewCellularData.update();
		tourismGraphView.update();

		final ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Mobile Cellular Data","International Tourism Data");
		choiceDialog.setTitle("Choosing Data");
		choiceDialog.setHeaderText("");
		choiceDialog.setContentText("Choose your data:");
		final Optional<String> opt = choiceDialog.showAndWait();
		String rtn;
		try{
			rtn = opt.get();
		}catch(final NoSuchElementException ex){
			rtn =null;
		}
		if(rtn == null){
			System.out.println("Please choose your data.");
		}else{
			thestage = stage;
			btnscene1=new Button("Click to go to Another Data");
			btnscene2=new Button("Click to go to Another Data");
			btnscene1.setOnAction(e-> ButtonClicked(e));
			btnscene2.setOnAction(e-> ButtonClicked(e));
			lblscene1=new Label("Scene 1");
			lblscene2=new Label("Scene 2");
			pane1=new BorderPane();
			pane2=new BorderPane();
			hBox1 = new HBox();
			hBox1.setSpacing(10);
			hBox1.getChildren().add(btnscene1);
			hBox2 = new HBox();
			hBox2.setSpacing(10);
			hBox2.getChildren().add(btnscene2);
			pane1.setBottom(hBox1);
			pane1.setCenter(cellularGraphViewCellularData);
			pane2.setBottom(hBox2);
			pane2.setCenter(tourismGraphView);
			scene1 = new Scene(pane1, 1000, 1000);
			scene2 = new Scene(pane2, 1000, 1000);
			if(rtn.equalsIgnoreCase("Mobile Cellular Data")){
				stage.setScene(scene1);
				stage.show();
			}
			if(rtn.equalsIgnoreCase("International Tourism Data")) {
				stage.setScene(scene2);
				stage.show();
			}
		}

	}

	public void ButtonClicked(ActionEvent e)
	{
		if (e.getSource()==btnscene1)
			thestage.setScene(scene2);
		else
			thestage.setScene(scene1);
	}

	/**
	 * Launches a standalone JavaFx App
	 */
	public static void main(String[] args) 
	{
		launch();
	}
}