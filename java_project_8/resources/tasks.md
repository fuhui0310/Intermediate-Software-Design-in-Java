Tasks for In-Class Project and Team 04<br>
-Jantira Tiyasan<br>
-Fu Hui<br>
============================================

Part A
---------
-Team meeting schedule & goals<br>
    - 6/17 Saturday 9:00-16:00 - Submits tasks description and proposal<br>
    - 6/18 Sunday 10:00-14:00 - Discuss the new features <br>
    - 6/19 Monday 19:00-23:00 - Edits the old classes from project 8<br>
    - 6/20 Tuesday 12:00-19:00 - Finishes each's features and commits to own branch<br>
    - 6/22 Thursday 12:00-14:00 - Debugs and merges to master<br>

- task 1: Fu Hui is in charge of this task<br>
          class UserInputView<br>
            -A constructor that takes in the data model as parameter.<br>
            -The inputDialog() method.<br>
            -The selectCountry() method.<br>
            -The void update() method.<br>
         will complete before 6/20 23:00<br>
         Due 6/22 to github.com repo<br>
- task 2: Jantira Tiyasan is in charge of this task<br>
          class GraphCalculator<br>
            -A constructor that takes in the Country as parameter.<br>
            -The getTotalData() method.<br>
            -The inputDialog() method.<br>
            -The toString() method.<br>
          will complete before 6/20 23:00<br>
          Due 6/22 to github.com repo<br>

 - When we are not pair programming, Jantira is responsible for searching information online,
and then she have to edit the previous classes from project 8. After Jantira starts her works,
Fu has to finish the class UserInputView, which he is in charge of. In this class, we will dialog
to let user input the numbers of country and names of country, which include a constructor,
the inputDialog() method, the selectCountry() method, and the void update() method are included.
Jantira has to finish the class GraphCalculator which create a dialog to ask input from user and
return the total for one country between the valid required period of year. That include a constructor,
the getTotalData() method, the inputDialog() method, and the toString() method.<br>
 - In order to reduce the committing problems, we agree that we will update our works on individual
branches. We will continue to review each other work, and decide whether we accept the pull requests
on each meetings.<br>



<br><br>

Part B
---------
 - When we were not pair promming, we basically follow the time table we made before. We were using email to inform
each other our progress. If we had some problem with our work, we would discuss about it on our meeting. <br>

 - Fu worked on class GraphCalculator that takes array of Country object as parameter and user's selected country, period of year then 
the graph of data model of  selected countries on the required period year will be shown once user press Enter <br>
            - The constructor of GraphCalculator class<br>
            - The inner class resultGraphView. <br>
            - The show() method.<br>
 - Fu also modified the data manage package and class GraphView.<br>
            
 - Jantira worked on class GraphSettingView that contained a constructor that takes in the data model as parameter.<br>
            -The inputDialog method.<br>
            -The getSelectedCountries() method.<br>
            -The getAnotherSelectedCountries() method.<br>
            -The isInteger() method.<br>
            -The isContinue() method.<br>
            -The getYValue1() method.<br>
            -The getTitle1() method.<br>
            -The getYValue2() method.<br>
            -The getTitle2() method.<br>
            
 - To updated individual works, we committed our work in different branches that is named our first names. That makes us have the time  to review each other work before the pull requests and merge to the master branch. It also helps us stay updated on each one work. So it's easily catch up the progress. We also shared useful information and suggested each other in our meetings.<br>


<br><br>

Extra Credit (if applicable)
-----------------------
 - We are going to present our project on Monday.

<br><br>

Extra Credit Discussion (if applicable)
-----------------------
 - When we worked on GraphSettingView, we did synchronous pair programming side-by-side. On method inputDialog(),
 Fu deigns the dialog patern likes UI design, then Jantira created statement-condition in order to satify user request
 such as the the number of country should not over country array length and how to match the name of selected countries
 with name country in array.Fu suggested what Jantira missing about Incasensitive becuase she didnt use ignore case on
 match the name of country, and Fu also suggested Jantira about typotype (misspelling). Fu suggested Jantira to have
 boolean method to check validity of user input such as type of input and range of input.<br>
 
 - When we worked on class GraphCalculator, we did synchronous pair programming side-by-side. On constustor of 
 Grapcaculate, array size of yearLabel, Jantira told Fu to use endingYear- satringYear+1 instead of endingYear-startingyear
 because the exact length needs to include this first year. On the choosing year, Jantira suggests Fu to let user chose
 starting year and ending year in stead of let user chose starting year and how many year they want because that way it
 might more complicate. On handle(KeyEvent e) method, Jantira suggest Fu to take "enter" from user input instead of
 specific letter because Enter is easy to understand and not confusing user.<br>

- Synchronous programming may not able to let both partners work at the same time, but we worked together on different
part. And clearly understand each progress because we have to finish one part before moving on to the following
class. That is useful to encourage our team work and find solution for every problem we had.<br>


<br><br>
