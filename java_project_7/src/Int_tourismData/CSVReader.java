package Int_tourismData;

import java.io.*;
import java.util.Scanner;


/**
 *  One object reads the .csv file one line at a time and set various attributes.
 */
public class CSVReader {
    private String[][] tourism;
    private int[] yearLabels;
    private double[][] TourismTable;
    private int numOfCountry;
    private int numOfYear;
    private String[] countryNames;
    private int startingYear;

    /**
     * Constructs a CSVReader object with the specified year labels, country names, and data from the CSV file.
     * @param fileName                  The directory path of the CSV file
     */
    public CSVReader(String fileName) {
        int count = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                count++;
                String line = input.nextLine();
                String [] linesOfText = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if(count == 2){
                    numOfCountry = Integer.parseInt(linesOfText[1]);
                }
                if(count == 3){
                    startingYear = Integer.parseInt(linesOfText[1]);
                    numOfYear = linesOfText.length - 1;
                    tourism = new String[numOfCountry][numOfYear + 1];
                }
                if(count > 3){
                    tourism[count - 4] = linesOfText;
                }
            }
            input.close();
        } catch (FileNotFoundException someobject) {
            System.out.println("File " + fileName + " not found!");
        }
        yearLabels = new int[numOfYear];
        for(int i = 0; i< numOfYear; i++){
            yearLabels[i] = startingYear + i;
        }
        countryNames = new String[numOfCountry];
        for(int i = 0; i< numOfCountry; i++){
            countryNames[i] = tourism[i][0];
        }
        TourismTable = new double[numOfCountry][yearLabels.length];
        for(int i = 0; i< numOfCountry; i++){
            for(int j = 0; j< yearLabels.length; j++){
                TourismTable[i][j] = Double.parseDouble(tourism[i][j+1]);
            }
        }
    }

    /**
     * Accessor method returns the names of all countries read from the CSV file.
     * @return the one dimensional array of country name.
     */
    public String [] getCountryNames() {
        return countryNames;
    }

    /**
     * Accessor method returns the year number read from the CSV file.
     * @return the one dimensional array of year label.
     */
    public int[] getYearLabels() {
        return yearLabels;
    }

    /**
     * Accessor method returns all data from the CSV file, where the row represents a country,
     * and the column represents the number of tourist for a specific year.
     * @return the two dimensional array of data.
     */
    public double[][] getParsedTable() {
        return TourismTable;
    }

    /**
     * * Accessor method returns the number of year in the file.
     * @return the total number of year.
     */
    public int getNumberOfYears() {
        return yearLabels.length;
    }
}