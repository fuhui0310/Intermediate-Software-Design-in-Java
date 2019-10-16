package view;

import dataSet.CellularDataModel;
import dataSet.Country;
import dataSet.TourismDataModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A object shows dialogs to ask user to choose a data set, enter a number of countries and select country.
 * @author Foothill College, Fu Hui
 */
public class GraphSettingView {
    private Country[] countries;
    private int requiredNumber;
    private Country[] selectedCountries;
    private Country[] anotherSelectedCountries;
    private List<String> countryChoices;
    private List<String> dataChoices;
    private CellularDataModel model1;
    private TourismDataModel model2;
    private String YVaule1;
    private String title1;
    private String YVaule2;
    private String title2;
    private int choice;
    /**
     * A constructor that takes in the data model as parameter.
     * @param  model1 a CellularDataModel object
     *  @param model2 a TourismDataModel object
     */

    public GraphSettingView(CellularDataModel model1,TourismDataModel model2){
        this.model1 = model1;
        this.YVaule1 = model1.getYValue();
        this.title1 = model1.getTitle();
        this.model2 = model2;
        this.YVaule2 = model2.getYVaule();
        this.title2 = model2.getTitle();
    }

    /**
     * this method does not returns, it gets user input from keyboard ;data model, number of country that user requires, specific countries that use required
     * period of year that user requires.
     */

    public void inputDialog(){
        dataChoices = new ArrayList<>();
        dataChoices.add("Mobile Cellular Data");
        dataChoices.add("International Tourism Data");
        ChoiceDialog<String> dialog = new ChoiceDialog<>(null, dataChoices);
        dialog.setTitle("Choosing Data");
        dialog.setHeaderText("");
        dialog.setContentText("Choose your data:");
        Optional<String> data = dialog.showAndWait();
        if (data.isPresent()){
            if( data.get().equalsIgnoreCase("Mobile Cellular Data")){
                choice = 1;
                this.countries = model1.getCellularData();
                countryChoices = new ArrayList<>();
                for(int i = 0; i < countries.length; i++){
                    countryChoices.add(countries[i].getName());
                }
                TextInputDialog textInputDialogialog = new TextInputDialog("Enter here");
                textInputDialogialog.setTitle("Entering Information");
                textInputDialogialog.setHeaderText("How many country would you like to check?");
                textInputDialogialog.setContentText("Please the number between 1 to " + countries.length + ":");
                Optional<String> input = textInputDialogialog.showAndWait();
                if (input.isPresent()){
                    if(isInteger(input.get())){
                        if(Integer.parseInt(input.get()) > 0 && Integer.parseInt(input.get()) <= countries.length ){
                            requiredNumber = Integer.parseInt(input.get());
                            selectedCountries = new Country[requiredNumber];
                            for(int i = 0; i < requiredNumber; i++){
                                ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(null, countryChoices);
                                choiceDialog.setTitle("Choosing Country");
                                choiceDialog.setHeaderText("Which country would you like to check?");
                                choiceDialog.setContentText("Please a country:");
                                Optional<String> result = choiceDialog.showAndWait();
                                if (result.isPresent()){
                                    for(int j = 0; j < countries.length ; j++){
                                        if(countries[j].getName().equalsIgnoreCase(result.get())){
                                            selectedCountries[i] = countries[j];
                                        }
                                    }
                                }

                            }
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Invalid required number");
                        alert.setContentText("Please enter the number between 1 to " + countries.length + ".");
                        alert.showAndWait();
                    }
                }
            }
            if( data.get().equalsIgnoreCase("International Tourism Data")){
                choice = 2;
                this.countries = model2.getTourismData();
                countryChoices = new ArrayList<>();
                for(int i = 0; i < countries.length; i++){
                    countryChoices.add(countries[i].getName());
                }
                TextInputDialog textInputDialogialog = new TextInputDialog("Enter here");
                textInputDialogialog.setTitle("Entering Information");
                textInputDialogialog.setHeaderText("How many country would you like to check?");
                textInputDialogialog.setContentText("Please the number between 1 to " + countries.length + ":");
                Optional<String> input = textInputDialogialog.showAndWait();
                if (input.isPresent()){
                    if(isInteger(input.get())){
                        if(Integer.parseInt(input.get()) > 0 && Integer.parseInt(input.get()) <= countries.length ){
                            requiredNumber = Integer.parseInt(input.get());
                            selectedCountries = new Country[requiredNumber];
                            for(int i = 0; i < requiredNumber; i++){
                                ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(null, countryChoices);
                                choiceDialog.setTitle("Choosing Country");
                                choiceDialog.setHeaderText("Which country would you like to check?");
                                choiceDialog.setContentText("Please a country:");
                                Optional<String> result = choiceDialog.showAndWait();
                                if (result.isPresent()){
                                    for(int j = 0; j < countries.length ; j++){
                                        if(countries[j].getName().equalsIgnoreCase(result.get())){
                                            selectedCountries[i] = countries[j];
                                        }
                                    }
                                }

                            }
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Invalid required number");
                        alert.setContentText("Please enter the number between 1 to " + countries.length + ".");
                        alert.showAndWait();
                    }
                }
            }
        }
    }

    /**
     * This method checks validity of user input
     * @param input   the user input
     * @return  If it is  valid input, returns true. If it is invalid input, returns fales
     *         false     invalid input
     */

    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    /**
     * this method gets selected countries
     * @return selectedCountries    Country array of selected country's names
     */

    public Country[] getSelectedCountries() {
        return selectedCountries;
    }

    /**
     * this method gets country array of selected countries
     * @return  anotherSelectedCountries  Country array of all selected countries on chosen data model
     */

    public Country[] getAnotherSelectedCountries() {
        Country[] current;
        anotherSelectedCountries = new Country[requiredNumber];
        if(choice == 1){
            current = model2.getTourismData();
            for(int i = 0; i < requiredNumber; i++){
                String countryName = selectedCountries[i].getName();
                for(int j = 0; j < current.length ; j++){
                    if(current[j].getName().equalsIgnoreCase(countryName)){
                        anotherSelectedCountries[i] = current[j];
                    }
                }
            }
        }
        if(choice == 2){
            current = model1.getCellularData();
            for(int i = 0; i < requiredNumber; i++){
                String countryName = selectedCountries[i].getName();
                for(int j = 0; j < current.length ; j++){
                    if(current[j].getName().equalsIgnoreCase(countryName)){
                        anotherSelectedCountries[i] = current[j];
                    }
                }
            }
        }
        return anotherSelectedCountries;
    }

    /**
     * this method checks validity of required number of countries
     * @return true  when valid number of required number of country
     *                 false  when  invalid number of required number of country
     */

    public boolean isContinue() {
        if(requiredNumber> 0 && requiredNumber<= countries.length){
            for(int i = 0; i < requiredNumber; i++){
                if(selectedCountries[i] == null){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public String getYValue1() {
        if(choice == 1) {
            return YVaule1;
        }else{
            return YVaule2;
        }
    }

    public String getTitle1() {
        if(choice == 1) {
            return title1;
        }else{
            return title2;
        }
    }

    public String getYValue2() {
        if(choice == 2) {
            return YVaule1;
        }else{
            return YVaule2;
        }
    }

    public String getTitle2() {
        if(choice == 2) {
            return title1;
        }else{
            return title2;
        }
    }
}
