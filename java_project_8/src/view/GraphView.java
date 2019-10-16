package view;

import dataSet.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


/**
 * One object creates a data series for each Country object
 */
public class GraphView extends LineChart {
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private Country selectedCountry;
    private int startingIndex;
    private int endingIndex;
    private Country[] selectedCountries;

    /**
     * A constructor that takes in the data model as parameter.
     * @param
     */
    public GraphView(Country[] selectedCountries, String title, String YValue) {
        super(new NumberAxis(), new NumberAxis());
        super.setTitle(title);
        this.xAxis = (NumberAxis) getXAxis();
        this.yAxis = (NumberAxis) getYAxis();
        xAxis.setLabel("Year");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel(YValue);
        this.selectedCountries = selectedCountries;
    }


    public GraphView(Country country, int startingIndex, int endingIndex){
        super(new NumberAxis(), new NumberAxis());
        selectedCountry = country;
        super.setTitle(selectedCountry.getName());
        this.xAxis = (NumberAxis) getXAxis();
        this.yAxis = (NumberAxis) getYAxis();
        xAxis.setLabel("Year");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel("Data Rate");
        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
    }

    /**
     * Takes a Country object as parameter and returns a Series<Number, Number> object.
     * The series should be based on the DataPerYear information of the current country.
     * Set the name of the series to the name of the country.
     * @param country
     * @return  series of country
     */
    public Series<Number, Number> seriesFromCountry(Country country) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(country.getName());
            LinkedList<DataPerYear> subscriptions;
            subscriptions = country.getDataSet();
            java.util.Iterator<DataPerYear> iterator = subscriptions.iterator();
            while (iterator.hasNext()) {
                DataPerYear current = iterator.next();
                Number X = current.getYear();
                Number Y = current.getData();
                series.getData().add(new XYChart.Data(X, Y));
            }
        return series;
    }

    public Series<Number, Number> seriesFromCountryForRequiredPeriod(Country country) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(country.getName());
        LinkedList<DataPerYear> subscriptions;
        subscriptions = country.getDataSet();
        java.util.Iterator<DataPerYear> iterator = subscriptions.iterator();

        for (int i = 0 ; iterator.hasNext() ;i++) {
            DataPerYear current = iterator.next();
            if(i >= startingIndex && i <= endingIndex) {
                Number X = current.getYear();
                Number Y = current.getData();
                series.getData().add(new XYChart.Data(X, Y));
            }
        }
        return series;
    }

    /**
     *  Goes through the list of Country objects and creates a series from each element.
     */
    public void update() {
        for (Country country : selectedCountries){
            Series<Number, Number> someSeries = this.seriesFromCountry(country);
            this.getData().add(someSeries);
        }
    }

     /**
     *  Creates a series for a country..
     */
    public void updateForCountry(){
        Series<Number, Number> someSeries = this.seriesFromCountryForRequiredPeriod(selectedCountry);
        this.getData().add(someSeries);
    }
}

