package com.hemebiotech.analytics;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This application counts the number of syndrome appearances from a text file
 * @author Nabil Boudjellal
 * @version 1.0
 * 

 */
public class AnalyticsCounter {
	

	/**This is the main method of this application
	 * it reads the symptoms from a text file and returns the list of symptoms and the number of feeds in a file
	 * @param args array of string arguments
	 */
	public static void main(String[] args) {
		
		String symptomsFilePath = "symptoms.txt";
		String outPutFilePath = "result.out";
		
		List<String> listLines = new ArrayList<String>();
		Map<String, Integer> mapSymptomsOccurances = new TreeMap<String, Integer>(); 
		
		ReadSymptomDataFromFile lecture = new ReadSymptomDataFromFile(symptomsFilePath);
		CalculateSymptomsOccurances Calulator= new CalculateSymptomsOccurances(listLines);
		WriterResultToFile writer = new WriterResultToFile(mapSymptomsOccurances,outPutFilePath);
		
		listLines = lecture.getSymptoms();
		mapSymptomsOccurances = Calulator.calculateOccurances();

		writer.writeToFile();
		
	}
}