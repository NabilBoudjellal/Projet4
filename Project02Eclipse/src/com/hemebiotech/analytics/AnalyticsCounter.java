package com.hemebiotech.analytics;


import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * This application counts the number of syndrome appearances from a text file
 * @author Nabil Boudjellal
 * @version 1.0
 * 

 */
public class AnalyticsCounter {
	
	/**
	 * This method needs a list of symptoms as argument and returns a list of symptoms with their number of appearances
	 * @param list list of the symptoms
	 * @return returning list of symptoms + number of occurrences, and without duplicates
	 */
	public static List<String> calculateOccurances(List<String> list) {
		List<String> list_2 = new ArrayList<String>(new HashSet<>(list));
		int i = 0;
		while(i < list_2.size())
		{
			list_2.set(i, list_2.get(i) +" : "+ Collections.frequency(list, list_2.get(i)));
			i++;
		}
		
		return list_2;
		
	}

	/**
	 * this method writes the contents of a list in a file, each item of the list in a new row
	 * @param list the list to write 
	 * @param outPutFileName the path of the output file
	 */
	public static void writeToFile(List<String> list, String outPutFileName) 
	{
		FileWriter writer = null;
		try {
			writer = new FileWriter (outPutFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i =0;
		try {
		while(i < list.size())
		{
				
					writer.write(list.get(i)+ "\n");

			i++;
		}
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**This is the main method of this application
	 * it reads the symptoms from a text file and returns the list of symptoms and the number of feeds in a file
	 * @param args array of string arguments
	 */
	public static void main(String[] args) {
		String symptomsFileName = "symptoms.txt";
		String outPutFileName = "result.out";
		List<String> fileList = new ArrayList<String>();
		
		ReadSymptomDataFromFile lecture = new ReadSymptomDataFromFile(symptomsFileName);
		
		fileList = lecture.GetSymptoms();
		
		List<String> list_with_occurrences = calculateOccurances(fileList);
		
		/* sort the elements of the list */
		Collections.sort(list_with_occurrences);
		
		writeToFile(list_with_occurrences,outPutFileName);
		
		
	}
	

}