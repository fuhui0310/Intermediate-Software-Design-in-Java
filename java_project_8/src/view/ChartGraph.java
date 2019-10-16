package view;
import dataSet.TourismDataModel;
import dataSet.CellularDataModel;
import dataSet.Country;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;


/**
 * Instantiates an JavaFX application which creates a model of the data.
 * Uses the model to instantiate an object of type  javafx.scene.chart.LineChart
 * via the GraphView class. Then sets up the scene with basic modification to
 * the stage.
 *
 * @author Foothill College, Fu Hui, Nat
 */
public class ChartGraph extends Application
{
	private Button btnscene1, btnscene2, btncalculator1, btncalculator2;
	private Scene scene1, scene2;
	private BorderPane pane1, pane2;;
	private Stage thestage;
	private HBox hBox1, hBox2;
	private Country[] selectedCountries;
	private Country[] anotherSelectedCountries;

	/**
	 * Called by launch method of Application
	 * @param stage: Stage
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Data Graph");
		// Provides access to CSV data.
		// TODO: Define the data model by parsing the CSV input file(s).
		//       Provide accessor methods to your the parsed data.

		CellularDataModel cellularDataModel = new CellularDataModel();
		TourismDataModel tourismDataModel = new TourismDataModel();
		// Displays graph* of subscription rate by country.
		// TODO: Define the view such that it takes the model as input.
		//       Construct the x and y axis using a NumberAxis, label the axis.
		GraphSettingView settingView = new GraphSettingView(cellularDataModel,tourismDataModel);
		settingView.inputDialog();
		selectedCountries = settingView.getSelectedCountries();
		anotherSelectedCountries = settingView.getAnotherSelectedCountries();
		if (settingView.isContinue()) {
				GraphView firstGraph = new GraphView(selectedCountries,settingView.getTitle1(),settingView.getYValue1());
				GraphView secondGraph = new GraphView(anotherSelectedCountries,settingView.getTitle2(),settingView.getYValue2());
				firstGraph.update();
				secondGraph.update();
				thestage = stage;
				btnscene1 = new Button("Click to go to Another Data");
				btnscene2 = new Button("Click to go to Another Data");
				btncalculator1 = new Button("Click to open the graph calculator.");
				btncalculator2 = new Button("Click to open the graph calculator.");
				btnscene1.setOnAction(e -> ButtonClicked(e));
				btnscene2.setOnAction(e -> ButtonClicked(e));
				btncalculator1.setOnAction(e -> OpenCalculator1(e));
				btncalculator2.setOnAction(e -> OpenCalculator2(e));
				pane1 = new BorderPane();
				pane2 = new BorderPane();
				hBox1 = new HBox();
				hBox1.setSpacing(10);
				hBox1.getChildren().add(btnscene1);
				hBox1.getChildren().add(btncalculator1);
				hBox2 = new HBox();
				hBox2.setSpacing(10);
				hBox2.getChildren().add(btnscene2);
				hBox2.getChildren().add(btncalculator2);
				pane1.setBottom(hBox1);
				pane1.setCenter(firstGraph);
				pane2.setBottom(hBox2);
				pane2.setCenter(secondGraph);
				scene1 = new Scene(pane1, 1000, 1000);
				scene2 = new Scene(pane2, 1000, 1000);
				stage.setScene(scene1);
				stage.show();


		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Invalid Information");
			alert.setContentText("Please enter valid number and choose enough countries.");
			alert.showAndWait();
		}
	}

	public void ButtonClicked(ActionEvent e)
	{
		if (e.getSource()==btnscene1)
			thestage.setScene(scene2);
		else
			thestage.setScene(scene1);
	}

	public void OpenCalculator1(ActionEvent e)
	{
		GraphCalculator graphCalculator = new GraphCalculator(selectedCountries);
		graphCalculator.graphCalculator();
	}

	public void OpenCalculator2(ActionEvent e)
	{
		GraphCalculator graphCalculator = new GraphCalculator(anotherSelectedCountries);
		graphCalculator.graphCalculator();
	}

	/**
	 * Launches a standalone JavaFx App
	 */
	public static void main(String[] args) 
	{
		launch();
	}
}