Tasks for In-Class Project and Team 04<br>
-Jantira Tiyasan<br>
-Fu Hui<br>
============================================

Part A
---------
-Team meeting schedule & goals<br>
    - 6/10 Saturday 9:00-16:00 - Submits tasks description<br>
    - 6/11 Sunday 10:00-14:00 - Finishes class skeleton<br>
    - 6/12 Monday 19:00-23:00 - Finishes class GraphView & reviews each's works<br>
    - 6/13 Tuesday 12:00-19:00 - Finishes additional statistics<br>
    - 6/16 Thursday 12:00-14:00 - Debugging<br>

- task 1: Fu Hui is in charge of this task<br>
          Class GraphView<br>
            -A constructor that takes in the data model as parameter.<br>
            -The seriesFromCountry(Country) method.<br>
            -The void update() method.<br>
         will complete before 6/12 23:00<br>
         Due 6/13 to github.com repo<br>
- task 2: Jantira Tiyasan is in charge of this task<br>
          Looking for new data set<br>
            -A class which parses your data.<br>
            -A class that stores the data for a particular series.<br>
            -A class that generates a random linked list of your data type.<br>
          will complete before 6/13 23:00<br>
          Due 6/14 to github.com repo<br>

 - When we are not pair programming, Jantira is responsible for looking for the new data set,
and then she have to model the data as we have done for the cellular data and plot the data via
a line chart. Before Jantira starts her works, Fu have to finish the class GraphView, which he
is in charge of. In this class, we will create a data series for each Country object. a constructor,
the seriesFromCountry(Country) method and the void update() method are included. For the extra
credit opportunity, we decide to consider it if we can finish our tasks earlier. If we are able to
afford it, we will discuss how to divide our work on the following meeting<br>
 - In order to reduce the committing problems, we agree that we will update our works on individual
branches. We will continue to review each other work, and decide whether we accept the pull requests
on each meetings.<br>



<br><br>

Part B
---------

 - When we were not pair promming, we basically follow the time table we made before. We were using email to
inform each other our progress. If we had some problem with our work, we would discuss it on our meeting.
Fu worked on class GraphView and class ChartGraph to create a dialog that allow user to choose the data they wanted,
and a button that allow user switch between two different data graphs.<br>
 - Jantira worked on the package for the new data set which is included class CSVReader, class Country, class LinkedList,
 class Node, class TourismYear, class TourismDataModel, and International_tourism.csv.<br>
 - In order to work efficiently, we both committed our work in different branches that is named our first names.
We had to review the pull requests before merge to the master branch. This helped us to track on partner's works,
and easily catch up the progress. We also shared useful information and suggested each other in our meetings.<br>

list of what features each person worked on:<br>

Fu Hui<br>
- class GraphView<br>
	-constructor<br>
	- method Series<Number, Number> seriesFromCountry(Country country)<br>
	- method update()<br>
- class ChartGraph<br>
	- method start(Stage stage)<br>
	- ButtonClicked(ActionEvent e)<br>

Jantira Tiyasan<br>
-Package Int_tourismData<br>
	-class Country<br>
	-class CSVReader<br>
	-class LinkedList<br>
	-class Node<br>
	-class TourismYear<br>
	-class TourismDataModel<br>
	-International_tourism.csv<br>

<br><br>

Extra Credit (if applicable)
-----------------------
Enable the user to switch between the two different data sets. 

Fu Hui<br>
 - ButtonClicked(ActionEvent e)<br>

Jantira Tiyasan<br>
 - borderpane<br>
<br><br>

Extra Credit Discussion (if applicable)
-----------------------

 - When we worked on class GraphView, we were doing synchronous pair programming side-by-side.
 On the method Series<Number, Number> seriesFromCountry(Country country), Fu designed it to be
 based on the SubscriptionYear information of the current country. However, after Jantira made the
 new data package, we have to do the additional statistics with the new data set, which means
 it could not be only able to take information from the class SubscriptionYear anymore. So Jantira
 suggested that we could declare the type of the data on the constructor. We made two constructors for
 two different type of DataMode for two data sets. If there is CellularDataModel, it will be set to 1.
 If there is DataModel, it will be set to 2. Then, Fu used if-statement to recognize the type of
 data on this method. But we finally decided to separate the class GraphView to two calsses to make
 the program more readable.
 - We were also doing synchronous pair programming side-by-side on the extra credit portion.
 On this portion, we have to let the user be able to switch the graph between two different data.
 At first, Fu made a dialog on class ChartGraph that allow user to choose the data they wanted.
 After that, Fu tried to made a button that with show another state that is another graph, but that was
 not able to switch the graph successfully. We found that there should at least have two buttons that will
 show one screen and be able to switch to another screen. Jantira designed the borderpane for the buttons
 and graph, that will show one button and graph each time, and then Fu finished the class
 ButtonClicked(ActionEvent e). 
 - Synchronous programming may not able to let both partners work at the same time, but we worked together
 on different part. And clearly understand each progress because we have to finish one part before moving on
 to the following class. That is useful to encourage team work and find solution for every problem we had.



<br><br>
