package view;

import dataSet.Country;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;


/**
 * A object show a window that asks user to choose a country and specific period of year.
 * After that, it calculates and shows the total to the user.
 * If the user presses the Enter, it will show the graph of the selected information.
* @author Foothill College, Fu Hui, Nat
 */
public class GraphCalculator {
    private Country[] countries;
    private String[] countryName;
    private int[] yearLabel;
    private int startingYear;
    private int endingYear;
    private ObservableList<Choice> countryChoices;
    private Text instructions;
    private Text result;
    private ChoiceBox<Choice> countryChooser;
    private ChoiceBox<Integer> startingYearChooser;
    private ChoiceBox<Integer> endingYearChooser;
    private ChoiceBox<String> magicChooser;
    private VBox layout;
    private HBox firstRow;
    private HBox secondRow;
    private HBox thirdRow;
    private Country selectedCountry;
    private int requiredStartingYear;
    private int requiredEndingYear;
    private Text from;
    private Text to;
    private Text enter;



    /**
     * Inner class for mapping a choice to store a country object and a number.
     */
    public class Choice {
        Integer number; String name;
        Choice(Integer number, String name) { this.number = number; this.name = name; }
        @Override public String toString() { return name; }
    }
    public GraphCalculator(Country[] countries) {
        this.countries = countries;
        countryName = new String[countries.length];
        startingYear = countries[0].getMinYear();
        endingYear = countries[0].getMaxYear();
        yearLabel = new int[(endingYear - startingYear + 1)];
        for (int i = 0; i < yearLabel.length; i++) {
            yearLabel[i] = startingYear + i;
        }
        for (int i = 0; i < countries.length; i++) {
            countryName[i] = countries[i].getName();
        }
        countryChoices = FXCollections.observableArrayList();
        countryChoices.add(new Choice(null, "No selection"));
        for (int i = 0; i < countries.length; i++) {
            countryChoices.add(new Choice(i, countries[i].getName()));
        }
        instructions = new Text("Please choose a country.");
        result = new Text("");
        enter = new Text("");
        layout = new VBox(20);
        layout.setStyle("  -fx-padding: 10; -fx-font-size: 20;");
        firstRow = new HBox(50);
        secondRow = new HBox(50);
        thirdRow = new HBox(50);
        to = new Text();
        from = new Text();
        countryChooser = new ChoiceBox<>(countryChoices);
        magicChooser = new ChoiceBox<>();
        magicChooser.getItems().add(" ");
        magicChooser.setValue(" ");
        firstRow.getChildren().addAll(countryChooser);
        secondRow.getChildren().addAll(from);
        thirdRow.getChildren().addAll(to);
    }
    public void graphCalculator() {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();

        countryChooser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Choice>() {
            @Override
            public void changed(ObservableValue<? extends Choice> observableValue, Choice oldChoice, Choice newChoice) {
                secondRow.getChildren().remove(startingYearChooser);
                thirdRow.getChildren().remove(endingYearChooser);
                result.setText("");
                enter.setText("");
                to.setText("");
                from.setText("");
                if (newChoice.number == null) {
                    instructions.setText("Please choose a country :");
                    firstRow.getChildren().removeAll(countryChooser);
                    firstRow.getChildren().addAll(countryChooser);
                } else {
                    from.setText("From:");
                    startingYearChooser = new ChoiceBox<>();
                    for (int i = 0; i < yearLabel.length; i++) {
                        int current = yearLabel[i];
                        startingYearChooser.getItems().add(current);
                    }
                    if (oldChoice == null) {
                        instructions.setText("Please choose a start year.");
                        selectedCountry = countries[newChoice.number];
                        secondRow.getChildren().addAll(startingYearChooser);
                    } else {
                        if (newChoice != oldChoice) {
                            instructions.setText("Please choose a start year.");
                            selectedCountry = countries[newChoice.number];
                            secondRow.getChildren().addAll(startingYearChooser);
                        }
                    }
                    startingYearChooser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
                        @Override
                        public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                            if (newValue == null) {
                                instructions.setText("Please choose a start year.");
                            } else {
                                result.setText("");
                                enter.setText("");
                                to.setText("To :");
                                requiredStartingYear = newValue;
                                thirdRow.getChildren().remove(endingYearChooser);
                                endingYearChooser = new ChoiceBox<>();
                                for (int i = (requiredStartingYear - startingYear); i < yearLabel.length; i++) {
                                    int current = yearLabel[i];
                                    endingYearChooser.getItems().add(current);
                                }
                                if (oldValue == null) {
                                    instructions.setText("Please choose an end year.");
                                    thirdRow.getChildren().addAll(endingYearChooser);
                                } else {
                                    if (newValue != oldValue) {
                                        instructions.setText("Please choose an end year.");
                                        thirdRow.getChildren().addAll(endingYearChooser);
                                    }
                                }
                                endingYearChooser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
                                    @Override
                                    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                                        if (newValue == null) {
                                            instructions.setText("Please choose an end year.");
                                        } else {
                                            instructions.setText("Calculating Result: ");
                                            requiredEndingYear = newValue;
                                            int start = requiredStartingYear;
                                            int end = requiredEndingYear;
                                            String total = String.format("%.2f",selectedCountry.getNumDataSetForPeriod(start, end));
                                            result.setText("The total from " + requiredStartingYear + " to " + requiredEndingYear + " is " + total + " .");
                                            enter.setText("-Press Enter to draw the graph-");
                                            int startingIndex = requiredStartingYear - startingYear;
                                            int endingIndex = requiredEndingYear - startingYear;
                                            layout.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                @Override
                                                public void handle(KeyEvent e) {
                                                    if (e.getCode().equals(KeyCode.ENTER)) {
                                                        new resultGraphView(selectedCountry,startingIndex,endingIndex).show();
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }

                    });
                }
            }
        });
        enter.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        layout.getChildren().addAll(instructions, firstRow, secondRow, thirdRow, result);
        root.setCenter(layout);
        root.setBottom(enter);
        BorderPane.setAlignment(enter, Pos.CENTER);
        Scene scene = new Scene(root, 550, 350);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * A object shows the graph for the selected country.
     */
    class resultGraphView{
            private Country selectedCountry;
            private GraphView graphView;
            private int startingIndex;
            private int endingIndex;
            public resultGraphView(Country country,int startingIndex, int endingIndex){
                this.selectedCountry = country;
                this.startingIndex = startingIndex;
                this.endingIndex = endingIndex;
            }

        /**
         * Shows the window of the selected period for specific country.
         */
        public void show(){
                Stage stage = new Stage();
                Scene scene;
                graphView = new GraphView(selectedCountry,startingIndex,endingIndex);
                graphView.updateForCountry();
                scene = new Scene(graphView);
                stage.setScene(scene);
                stage.show();
            }
        }
}
