package view;

import Int_tourismData.Country;
import Int_tourismData.TourismYear;
import Int_tourismData.LinkedList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import Int_tourismData.TourismDataModel;


/**
 * One object creates a data series for each Country object
 */
public class TourismGraphView extends LineChart {
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private TourismDataModel model;
    private final int REQUESTED_SIZE = 5;

    /**
     * A constructor that takes in the data model as parameter.
     * @param model
     */
    public TourismGraphView(TourismDataModel model) {
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
            LinkedList<TourismYear> subscriptions;
            subscriptions = country.getNumberOfTourist();
            java.util.Iterator<TourismYear> iterator = subscriptions.iterator();
            while (iterator.hasNext()) {
                TourismYear current = iterator.next();
                Number X = current.getYear();
                Number Y = current.getTourists();
                series.getData().add(new XYChart.Data(X, Y));
        }
        return series;
    }

    /**
     *  Goes through the list of Country objects and creates a series from each element.
     */
    public void update() {
        Country current[] = model.getTourismData();
        TourismCountrySelector tourismCountrySelector = new TourismCountrySelector(current, REQUESTED_SIZE);
        LinkedList<Country> selectedCountries = tourismCountrySelector.selectCountries();
        for (Country currentCountry : selectedCountries) {
            Series<Number, Number> someSeries = this.seriesFromCountry(currentCountry);
            this.getData().add(someSeries);
        }
    }
}
