package org.stock.project;

//import org.ui.project.UISetup;

/** This is project that analyzes Stock Market (DowJones) Performance
 * @author U146576
 * @version 1.0
 * @since 0.5
 *
 */
public class StockAnalyzer {
	
	/* Command Line argument -df stands for Data File; defines location
	 * of the data file.  Otherwise, JFileChooser is used.
	 * */
	
	public static void main(String[] args) {
		
		LoadDataStore storeData = new LoadDataStore();
		DataAnalytics aData;
		MarketData[] md;
		
		System.out.println("Sourcing Data....");
		storeData.sourceData(args);		//Read the Data into our application.

		/*Get the MarketData Array -- Pass it to DataAnalytics */
		
		md=storeData.getMarketData();
		System.out.println("Market Data is Loaded....");	
		
		/*Start Analyzing the data*/
		aData=new DataAnalytics(md);	//Use the Constructor to pass in the data
		System.out.println("Analytical Engine Up ....");
		
		
		//Lets bring up the GUI
		UISetup uiset = new UISetup(aData);
		System.out.println("User Inferace Up...");
		System.out.println("System is Ready!");
	}

}

