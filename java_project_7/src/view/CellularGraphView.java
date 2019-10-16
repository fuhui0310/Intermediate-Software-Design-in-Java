package view;

import cellularData.Country;
import cellularData.SubscriptionYear;
import cellularData.LinkedList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import cellularData.CellularDataModel;


/**
 * One object creates a data series for each Country object
 */
public class CellularGraphView extends LineChart {
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private CellularDataModel model;
    private final int REQUESTED_SIZE = 5;

    /**
     * A constructor that takes in the data model as parameter.
     * @param model
     */
    public CellularGraphView(CellularDataModel model) {
        super(new NumberAxis(), new NumberAxis());
        this.model = model;
        super.setTitle(model.getTitle());
        this.xAxis = (NumberAxis) getXAxis();
        this.yAxis = (NumberAxis) getYAxis();
        xAxis.setLabel("Year");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel(model.getYVaule());
    }

    /**
     * Takes a Country object as parameter and returns a Series<Number, Number> object.
     * The series should be based on the SubscriptionYear information of the current country.
     * Set the name of the series to the name of the country.
     * @param country
     * @return  series of country
     */
    public Series<Number, Number> seriesFromCountry(Country country) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(country.getName());
            LinkedList<SubscriptionYear> subscriptions;
            subscriptions = country.getSubscriptions();
            java.util.Iterator<SubscriptionYear> iterator = subscriptions.iterator();
            while (iterator.hasNext()) {
                SubscriptionYear current = iterator.next();
                Number X = current.getYear();
                Number Y = current.getSubscriptions();
                series.getData().add(new XYChart.Data(X, Y));
            }
        return series;
    }

    /**
     *  Goes through the list of Country objects and creates a series from each element.
     */
    public void update() {
        Country current[] = model.getCellularData();
        CellularCountrySelector cellularCountrySelector = new CellularCountrySelector(current, REQUESTED_SIZE);
        LinkedList<Country> selectedCountries = cellularCountrySelector.selectCountries();
        for (Country currentCountry : selectedCountries) {
            Series<Number, Number> someSeries = this.seriesFromCountry(currentCountry);
            this.getData().add(someSeries);
        }
    }
}

