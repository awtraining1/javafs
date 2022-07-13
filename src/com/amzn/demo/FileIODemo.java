package com.amzn.demo;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileIODemo {
	
	//File.se

	public static void main(String[] args) {
		// File is abstraction of a file on the disk
		
		String baseFolder = "C:"+File.separator + "Users"
		+File.separator +"home"
		+File.separator +"Training"
		+File.separator +"eclipse-workspace"
		+File.separator +"FruitMarketManagementSystem";
		
		String myfile = "a.txt";// "abc" +File.separator  + "ASSIGNMENT.txt";

		//File f = new File(myfile);
		//OR
		File f = new File(baseFolder, myfile);
		
		System.out.println("FILE Related");
		System.out.println("File exists: "+ f.exists());
		System.out.println("File is file?: "+ f.isFile());
		System.out.println("File length: "+ f.length());
		System.out.println("File modified last time at: "+ new Date(f.lastModified()));
		System.out.printf("\n File is hidden: %s ", f.isHidden());
		System.out.printf("\n File is readable: %s ", f.canRead());
		System.out.printf("\n File is writeable: %s ", f.canWrite());
		System.out.printf("\n File is executableable: %s ", f.canExecute());
		// f.renameTo(new File("ASSIGNMENT.txt"));
		//System.out.println("File modified last time at: "+ f.renameTo(f)
		// 16A : What other method of interest are there in File class.
		// Try atleast 2 of them
		System.out.printf("\n File path: %s ", f.getPath());
		System.out.printf("\n File absolute path: %s ", f.getAbsolutePath());
		f.delete();
		System.out.println("\n File exists: "+ f.exists());
		
		//String myfolder = "C:\\Users\\home\\Training\\eclipse-workspace\\FruitMarketManagementSystem";
		File projectDir = new File(baseFolder);
		System.out.println("\n\n DIR Related");
		System.out.println("Dir exists: "+ projectDir.exists());
		System.out.println("Dir is a folder?: "+ projectDir.isDirectory());
		
		// 16B : What other method of interest for folder are there in File class.
		// Try atleast 2 of them
		if(projectDir.exists() && projectDir.isDirectory()) {
			File[] dirContentList = projectDir.listFiles();
			
			System.out.println("\n\n Contents of projectDir:");
			for(File f1: dirContentList) {
				System.out.printf("\n %s ", f1.getName());
			};
			
			//We can also use Streams API to output the file names
			System.out.println();
			Arrays.stream(dirContentList).forEach(elem -> System.out.println(elem.getName()));
			
			//16C Challenge
			// Given a folder, can you list only files in it that are more
			// than 10MB in size
		}
		
		
		
	}

}
