package cellularData;

/**
 *  Tests the CellularData class by reading in one dimensional arrays of countries.
 *  Given a country name and a range of years, computes the total number of subscriptions
 *  during that period.
 *
 *  @author Foothill College, Bita M, Fu Hui
 */
public class TestCellularData 
{
	public static void main(String[] args) 
	{
		// Part 1: Testing with partial data for a country --------------------
		System.out.println("Testing with Partial Data:");
		final double[] canadaPartial = {0,0,0.046433382,0.229211886,0.370663166,0.752880479,1.264765577};
		final double[] mexicoPartial = {0,0,0,0,0,0.001815204,0.010079818};
		final double[] usaPartial = {0,0.038253436,0.140659444,0.279060364,0.498659917,0.829863407,1.39281703};

		int startingYear = 1983;

		CellularData datatable;
		int numRows = 3;
		int numColumns = canadaPartial.length;

		// TODO: Create a CellularData object with the given number of rows, 
		// 		 columns, and starting year.
		datatable = new CellularData(numRows, numColumns, startingYear);
		// TODO: Add a country and its associated data to the table.
		datatable.addCountry("Canada", canadaPartial);
		datatable.addCountry("Mexico", mexicoPartial);
		datatable.addCountry("United States", usaPartial);
		// TODO: Return a string representation of the data table. This string will
		//       contain newlines and be terminated with one.
		System.out.println(datatable);
		// the output is:
		/*
		Testing with Partial Data:
		Country	Year	1983	1984	1985	1986	1987	1988	1989	
		Canada			0	0	0.04	0.22	0.37	0.75	1.26	
		Mexico			0	0	0	0	0	-0.00	0.01	
		United States		0	0.03	0.14	0.27	0.49	0.82	1.39	
		 */
		// Note: As long as your output is easily readable,
		//       then the alignment (i.e. tabs and white-space) of your output need not match mine.


		// TODO: Get the total number of cellular subscriptions for a given country and time period.
		double totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("United States",1983,1989);
		System.out.printf("United States (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "usa", subscriptions from 1983 to 1989
		// the output is: 
		// United States (1983 to 1989): 3.18 

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Mexico",1983,1989);
		System.out.printf("Mexico (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "mexico", subscriptions from 1983 to 1989
		// the output is:
		// Mexico (1983 to 1989): 0.01 

		// testing out-of-bounds data
		// NOTE: Your implementation should check for invalid requested year ranges. 
		//		 For example, the user's request for starting year 1890 is invalid.
		// 		 Here, you have two options for your returning a result:
		//		 option 1: Display a message and return -1 if either start or 
		//				   end year of requested period is invalid.
		//		 option 2 (recommended): Display a message and return the 
		//				   total number of subscriptions for the valid sub-period.
		//				
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Canada",1890, 2000);
		System.out.printf("Canada (1890 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Illegal Argument Request of start year 1890. Valid period for Canada is 1890 to 2000.
		// Canada (1890 to 2000): -1.00 


		// Part 2: Testing with all data for a country --------------------------------------------
		System.out.println("\n\nTesting with All Data:");
		final double[] canada = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.046433382,
				0.229211886,0.370663166,0.752880479,1.264765577,2.110674786,2.769888481,3.621301434,
				4.648371087,6.435664704,8.840378661,11.82226558,14.04583637,17.73689555,22.72196984,
				28.42909462,34.36625958,37.94941948,42.07126881,47.06386648,52.75959279,57.49320536,
				61.47310755,66.20487722,70.54830532,75.676078,77.82549309,79.56833775,80.61008074,
				81.0393165};
		final double[] mexico = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.001815204,
				0.010079818,0.074266061,0.183067275,0.348322481,0.421293924,0.608553991,0.721767371,
				1.051320868,1.758956617,3.326889843,7.556565917,13.55289414,20.65462731,24.29476815,
				27.85371761,35.15321825,42.56115672,49.40875353,58.62729509,65.49948112,71.45817512,
				77.51826326,79.24118294,83.35070827,87.26062913,82.22000923};
		final double[] usa = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.038253436,0.140659444,
				0.279060364,0.498659917,0.829863407,1.39281703,2.075802366,2.939643902,4.249049037,
				6.103716586,9.104921407,12.6047249,16.23815248,20.14238484,24.89063952,30.57610298,
				38.46809105,44.69057874,48.85103822,54.84681409,62.54719598,68.31769507,76.29353842,
				82.06414479,85.20916517,88.62364611,91.31165202,94.44042596,96.01037609,97.07773939,
				110.2041935};


		// NOTE: Your program should be able to handle a variety of ranges of years (i.e. start year to end year). 
		//        So, do *not* assume that the data will always start from 1960 or end in on a particular year.
		startingYear = 1960;

		numRows = 3;
		numColumns = canada.length;

		datatable = new CellularData(numRows, numColumns, startingYear);

		datatable.addCountry("Canada", canada);
		datatable.addCountry("Mexico", mexico);
		datatable.addCountry("United States", usa);

		System.out.println(datatable);
		// the output is:
		/*
		Testing with All Data:
        Country,Year      1960      1961      1962      1963      1964      1965      1966      1967      1968      1969      1970      1971      1972      1973      1974      1975      1976      1977      1978      1979      1980      1981      1982      1983      1984      1985      1986      1987      1988      1989      1990      1991      1992      1993      1994      1995      1996      1997      1998      1999      2000      2001      2002      2003      2004      2005      2006      2007      2008      2009      2010      2011      2012      2013      2014    
              Canada         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.05      0.23      0.37      0.75      1.26      2.11      2.77      3.62      4.65      6.44      8.84     11.82     14.05     17.74     22.72     28.43     34.37     37.95     42.07     47.06     52.76     57.49     61.47     66.20     70.55     75.68     77.83     79.57     80.61     81.04    
              Mexico         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.00      0.01      0.07      0.18      0.35      0.42      0.61      0.72      1.05      1.76      3.33      7.56     13.55     20.65     24.29     27.85     35.15     42.56     49.41     58.63     65.50     71.46     77.52     79.24     83.35     87.26     82.22    
       United States         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0         0      0.04      0.14      0.28      0.50      0.83      1.39      2.08      2.94      4.25      6.10      9.10     12.60     16.24     20.14     24.89     30.58     38.47     44.69     48.85     54.85     62.55     68.32     76.29     82.06     85.21     88.62     91.31     94.44     96.01     97.08    110.20    
		 */
		// Note: As long as your output is easily readable,
		//       then the alignment (i.e. tabs and white-space) of your output need not match mine.

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("United States",1983,1989);
		System.out.printf("United States (1983 to 1989): %.2f \n", totalSubscriptions);
		// the output is:
		// United States (1983 to 1989): 3.18

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Mexico",1960,2000);
		System.out.printf("Mexico (1960 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Mexico (1960 to 2000): 29.62

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Canada",1890, 2000);
		System.out.printf("Canada (1890 to 2000): %.2f \n", totalSubscriptions);
		// the output is:
		// Illegal Argument Request of start year 1890. Valid period for Canada is 1890 to 2000.
		// Canada (1890 to 2000): -1.00 


		// TODO: For full credit, include test cases in addition to those provided.
		//
		// TODO: Also, make sure to test for other invalid requests.
		//
		System.out.println("\n\nTesting with first addition Data:");
		final double[] afghanistan = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0.112598381,0.865196277,2.498055472,4.826865367,9.833164022,17.71624331,
                29.22037376,37.89493697,45.77817474,60.32631999,65.45219346,70.66135885,74.88284241};
		final double[] albania = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0.068840778,0.099059921,0.168397958,0.331772024,0.901406013,11.94887288,26.07553141,
                33.95706284,39.16395669,47.87802749,60.06734238,73.35038415,58.91235149,78.1845877,
                85.468247,98.29153459,110.6865316,116.1572081,105.4699657};
		final double[] bahrain = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.142563513,0.381286664,
                0.620306327,0.883522952,1.037818786,1.442965201,1.852315921,2.120546339,3.207749877,4.895960832,
                6.913956774,9.799631738,14.90809458,20.82466731,30.78644018,42.87476619,53.10146463,
                57.39322693,79.19074229,87.21698081,95.42373897,108.1005238,129.0979339,117.6607732,
                125.2084477,131.009991,161.1670576,165.9088811,173.2739335};
		final double[] hongKongSAR = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.018689957,0.081258922,
                0.182245465,0.504218653,0.908356275,1.55856424,2.311204939,3.238869715,3.947248663,4.872216207,
                8.020962705,12.99329905,21.70170873,34.67552508,48.15693696,63.49747283,79.69431046,83.80339232,
                92.52968608,106.4079144,119.1029016,123.8892854,136.6602462,155.0398371,166.1936237,179.7816019,
                195.6692192,215.5038098,229.2446254,237.3518775,233.6151774};
		final double[] britishVirginIslands = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		startingYear = 1961;
		numRows = 5;
		numColumns = afghanistan.length;
		datatable = new CellularData(numRows, numColumns, startingYear);
		datatable.addCountry("Afghanistan", afghanistan);
		datatable.addCountry("Albania", albania);
		datatable.addCountry("Bahrain", bahrain);
		datatable.addCountry("Hong Kong SAR", hongKongSAR);
		datatable.addCountry("BritishVirginIslands", britishVirginIslands);
		System.out.println(datatable);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Afghanistan",1961,2014);
		System.out.printf("Afghanistan (1961 to 2014): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Albania",1983,1999);
		System.out.printf("Albania (1983 to 1999): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Bahrain",1938,1989);
		System.out.printf("Bahrain (1938 to 1989): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Hong Kong SAR",1996,2012);
		System.out.printf("Hong Kong SAR (1996 to 2012): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("BritishVirginIslands",1960,2014);
		System.out.printf("BritishVirginIslands (1960 to 2014): %.2f \n", totalSubscriptions);

		System.out.println("\n\nTesting with second addition Data:");
		final double[] thailand = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.001548962,0.010893994,
                0.031957866,0.07152718,0.111735514,0.216057464,0.434581425,0.712174554,1.26050362,2.200303493,
                3.096979262,3.660549703,3.246072667,3.796302633,4.901883807,11.97100258,27.35185035,33.52064989,
                41.42975138,46.46198345,60.90324472,80.17018406,93.43030345,99.50960309,108.0177685,116.331131,
                127.2920547,140.0511818,144.4387195};
		final double[] togo = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0.066492152,0.162312718,0.358576107,1.027801412,1.902959101,3.22303878,4.632345279,6.161062986,
                7.827044226,12.45197504,20.40031837,25.87965477,35.59849145,41.26668606,41.64413476,49.86113051,
                62.53490181,64.57824151};
		final double[] tonga = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.312734551,
                0.313870586,0.124257046,0.134033055,0.143653098,0.183744717,0.239584179,3.385040824,11.23471527,
                16.34785036,29.58795563,29.5728077,45.48387412,49.02716932,51.17954363,52.16238544,52.60439581,
                53.36331844,54.59396333,64.28314836};
		final double[] turkey = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.000727281,0.009969069,
                0.018888992,0.029408771,0.058911441,0.087100576,0.109996968,0.148443728,0.303364973,0.746945781,
                1.356502457,2.666464566,5.718854527,13.04791761,25.53785046,30.53479924,35.86941403,42.29340126,
                51.92193776,64.3740778,76.73832278,89.17829733,93.54864342,88.12268708,85.62758012,89.41002295,
                91.46374843,92.96497103,94.7933028};
		final double[] turkmenistan = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0.057656946,0.068254835,0.089899216,0.166614128,0.17955684,0.177667308,0.197653332,
                1.06666644,2.211532447,4.516582511,7.85614367,23.08368224,42.83804536,63.41981696,103.7858737,
                114.0552619,116.893432,135.7804374};
		final double[] tuvalu = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,5.18349575,13.41035692,16.4406083,18.4350676,0,10.19575856,16.28167294,21.63754571,
                28.39756592,34.42689348,38.40711542};
		startingYear = 1960;
		numRows = 6;
		numColumns = thailand.length;
		datatable = new CellularData(numRows, numColumns, startingYear);
		datatable.addCountry("Thailand", thailand);
		datatable.addCountry("Togo", togo);
		datatable.addCountry("Tonga", tonga);
		datatable.addCountry("Turkey", turkey);
		datatable.addCountry("Turkmenistan", turkmenistan);
		datatable.addCountry("Tuvalu", tuvalu);
		System.out.println(datatable);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Thailand",1960,2014);
		System.out.printf("Thailand (1960 to 2014): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Thailand",2013,2013);
		System.out.printf("Thailand (2013 to 2013): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Thailand",2011,1989);
		System.out.printf("Thailand (2011 to 1989): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Togo",1996,2012);
		System.out.printf("Togo (1996 to 2012): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Turkey",1988,2000);
		System.out.printf("Turkey (1988 to 2000): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Turkmenistan",1977,2010);
		System.out.printf("Turkmenistan (1977 to 2010): %.2f \n", totalSubscriptions);
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("Tuvalu",1969,2015);
		System.out.printf("Tuvalu (1969 to 2015): %.2f \n", totalSubscriptions);

	}
}
