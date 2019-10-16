project folder:
team04-project08/

Brief description of submitted files:

src/cellularData/SubscriptionYear.java
    -one object represents the subscription on the specific year

src/cellularData/LinkedList.java
    -holds linked list of Node objects,
     that can store as many objects as the user might want to add to it.

src/cellularData/Node.java
    -holds linked list of Node objects

src/cellularData/Country.java
    -one object represents the country name and its subscription of the specific period of year

src/cellularData/CSVReader.java
    -One object will read the cellular.csv file one line at a time and set various attributes.

src/cellularData/CellularDataModel.java
    -Provides access to CSV data.

src/Int_tourismData/TourismYear.java
    -one object represents the subscription on the specific year

src/Int_tourismData/LinkedList.java
    -holds linked list of Node objects,
     that can store as many objects as the user might want to add to it.

src/Int_tourismData/Node.java
    -holds linked list of Node objects

src/Int_tourismData/Country.java
    -one object represents the country name and its subscription of the specific period of year

src/Int_tourismData/CSVReader.java
    -One object will read the cellular.csv file one line at a time and set various attributes.

src/Int_tourismData/TourismDataModel.java
    -Provides access to CSV data.

src/view/CellularCountrySelector.java
   -One object generates a random list of Country objects

src/view/TourismCountrySelector.java
   -One object generates a random list of Country objects

src/view/TourismGraphView.java
   -One object creates a data series for each Country object

src/view/CellularGraphView.java
   -One object creates a data series for each Country object

src/view/ChartGraph.java
   -Instantiates an JavaFX application which creates a model of the data.
   -Uses the model to instantiate an object of type  javafx.scene.chart.LineChart
   -via the CellularGraphView class. Then sets up the scene with basic modification to
   -the stage.

resources/International_tourism.csv
    - A CSV (Comma Separated Value) file.
    - First row contains the names of country
    - First column contains the year from 2002 - 2016
    - Lines 2 to EOF (end of file) contain the tourism data of each country of each year during 2002 - 2016

resources/cellular.csv
    - A CSV (Comma Separated Value) file.
    - First row contains the names of country
    - First column contains the year from 1960 - 2014
    - Lines 2 to EOF (end of file) contain the subscription data of each country of each year during 1960 - 2014

resources/cellular_short_oneDecade.csv
    - A CSV (Comma Separated Value) file.
    - First row contains the names of country
    - First column contains the year from 2005 - 2014
    - Lines 2 to EOF (end of file) contain the subscription data of four countries of each year during 2005 - 2014


RUN1.png
     -console output of ChartGraph.java
     -Dialog

RUN2.png
     -console output of ChartGraph.java
     -First data graph

RUN3.png
     -console output of ChartGraph.java
     -Switch to second data graph

README.txt
     -description of submitted files

task.md
     -task description
