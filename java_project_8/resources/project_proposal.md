Project Proposal for Project 9 and Team 04
-Jantira Tiyasan<br>
-Fu Hui<br>
================================================

 - In the project 9, we will build on top of previous projects which plots the data points from .csv.
We are going to design two user friendly features. One is that user will be able to enter how many
countries they want to show on the graphs, and then they can enter which countries they want from the
list of all country that they want to show on the graphs, which allow user to get the information they need
instead of random countries. Another is that the user can select one country to get the total data between
the valid years, which can help the user to work on some statistic.<br>



Feature 1
---------
User will be able to enter how many countries they want to show on the graphs,<br>
and then they can enter which countries they want from the list of all country that they want to show on the graphs.<br>
	- Fu Hui<br>
	- will commit to his branch on 20/6<br>
	- will merge to the master on 22/6<br>


<br><br>

Feature 2
---------
User can select one country in the graph to get the total data between the valid years<br>
	- Jantira Tiyasan<br>
	- will commit to her branch on 20/6<br>
	- will merge to thr master on 22/6<br>



<br><br>

Names of the classes
-----------------------
 - package cellular<br>
    - class Node<br>
    - class LinkedList<br>
    - class Country<br>
    - class SubscriptionYear<br>
    - class CellularDataModel<br>
    - class CSVReader<br>
 - package Int_tourismData<br>
    - class Node<br>
    - class LinkedList<br>
    - class Country<br>
    - class TourismYear<br>
    - class TourismDataModel<br>
    - class CSVReader<br>
 - package view<br>
    - class CellularCountrySelector<br>
    - class TourismCountrySelector<br>
    - class CellularGraphView<br>
    - class TourismGraphView<br>
    - class ChartGraph<br>
    - (new) class UserInputView   <--- Fu Hui<br>
        - Create a dialog to let user input the numbers of country and names of country.<br>
    - (new) class GraphCalculator   <--- Jantira Tiyasan<br>
        - return the total for one country between the valid required period of year.<br>

<br><br>

