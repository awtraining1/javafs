package com.amzn.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIODemo3 {
	
	//17C
	// Given a file path, check whether it has any word "Cricket"
	// Use NIO api.

	// Java New IO (NIO)
	public static void main(String[] args) {
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myFileFolder = "abc" ;
		String myfile = "A.txt";
		
		Path myFilePath = Path.of(baseFolder,myFileFolder,myfile);
		
		// Files class is a a powerful class that provides statics method
		// like ones below
		SOP(Files.exists(myFilePath));
		
		// reading entire of the file
		try {
			List<String> allLines = Files.readAllLines(myFilePath);
			
			allLines.stream().forEach(System.out::println);
			
		} catch (IOException e1) {
		}
		
		try {
			Files.copy(myFilePath, new FileOutputStream("100.txt"));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		}
		
		// 17B How will you rename a file using NIO
		
	}
	
	public static void SOP(Object s) {
		System.out.println(s);
	}

}
