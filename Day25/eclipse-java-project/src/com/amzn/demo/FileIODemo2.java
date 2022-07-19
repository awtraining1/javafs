package com.amzn.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class FileIODemo2 {

	// Demo reading and writing to IO streams
	public static void main(String[] args) {
		// main0(args); // read one byte at a time
		// main1(args); // read several bytes at a time
		// main2(args); // write one or several bytes at a time

		// 16C Challenge Can you write a File Copy utility
		// main3(args); // reading character streams (Reader)
		//main4(args); // reading character streams (Reader) line by line using Bffer
		// 16D challenge - given a file, can you tell how many times "India" appears in it?

		main5(args); // writing character streams (Writer)
		//17A Create 4 Farmers
		// Save the farmer details in a file(farmers.xlsx) in the format
		// Name, Age
		// Name, Age
		// ......
		//Verify the contents of farmers.xlsx by opening it in MS excel or Notepad.
	}

	public static void main5(String[] args) {
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "A.txt";
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(baseFolder + File.separator + myfile);
			fw.write(104); // write one char
			fw.write("\n");// write a line break
			
			char[] chArr= {104,106,107,108} ;
			fw.write(chArr); // write a char array
			fw.write("\n");
			
			fw.write("Today is my day!!\n kkkkkkk");
			
		} catch (IOException e) {			
			System.out.println("Caught exception "+e);
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("Caught exception "+e);
			}
		}
	}
	
	public static void main4(String[] args) {
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "A.txt";

		InputStreamReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(baseFolder + File.separator + myfile);
			br = new BufferedReader(fr);

			String line=null;
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main3(String[] args) {
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "A.txt";

		InputStreamReader fr = null;
		try {
			fr = new FileReader(baseFolder + File.separator + myfile);
			int ch = fr.read();
			System.out.printf("\n read a char %s", (char) ch);

			char[] chArray = new char[5];
			fr.read(chArray);
			System.out.printf("\n read 5 chars %s", Arrays.toString(chArray));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main2(String[] args) {
		// Reading Byte streams
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "AAA.txt";

		OutputStream fos = null;
		try {
			fos = new FileOutputStream(baseFolder + File.separator + myfile, false);
			fos.write(105);
			fos.write(101);

			byte[] bytes = { 104, 104, 104, 104 };
			fos.write(bytes);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main1(String[] args) {
		// Reading Byte streams
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "A.txt";

		InputStream fis = null;
		try {
			fis = new FileInputStream(baseFolder + File.separator + myfile);

			int availableNoOfBytes = fis.available();
			System.out.printf("availableNoOfBytes %s \n", availableNoOfBytes);

			byte[] bytes = new byte[5];
			fis.read(bytes);

			System.out.println(Arrays.toString(bytes));
			System.out.println(fis.available());// should return 6

			fis.read(bytes);

			System.out.println(Arrays.toString(bytes));
			System.out.println(fis.available());// should return 1 now

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main0(String[] args) {
		// Reading Byte streams
		String baseFolder = "C:" + File.separator + "Users" + File.separator + "home" + File.separator + "Training"
				+ File.separator + "eclipse-workspace" + File.separator + "FruitMarketManagementSystem";

		String myfile = "abc" + File.separator + "A.txt";

		InputStream fis;
		try {
			fis = new FileInputStream(baseFolder + File.separator + myfile);

			int availableNoOfBytes = fis.available();
			System.out.printf("availableNoOfBytes %s", availableNoOfBytes);

			int b = 0;
			for (int i = 0; i < availableNoOfBytes; i++) {
				b = fis.read();
				System.out.printf("\n read a byte %s", b);
			}
			;

			System.out.println();
			System.out.println(fis.available());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
