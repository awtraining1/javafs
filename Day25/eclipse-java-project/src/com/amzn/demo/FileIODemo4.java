package com.amzn.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.amzn.people.Retailer;

public class FileIODemo4 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// main0(args);// writing object
		main1(args);// reading object
	}

	// Reading Objects
	@SuppressWarnings("resource")
	public static void main1(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = null;
		ois = new ObjectInputStream(new FileInputStream("rajan-retailer.txt"));
		Retailer retailer1 = (Retailer) ois.readObject();

		System.out.println(retailer1.getName() + ", " + retailer1.getAge());
		
		Retailer retailer2 = (Retailer) ois.readObject();
		System.out.println(retailer2.getName() + ", " + retailer2.getAge());
	}

	// Writing Objects
	public static void main0(String[] args) {
		Retailer r1 = new Retailer("Rajan", (short) 26);
		r1.setName("Vivek");
		r1.setAge((short) 1002);
		Retailer r2 = new Retailer("Shaji", (short) 86);

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("rajan-retailer.txt"));
			oos.writeObject(r1);
			oos.writeObject(r2);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
