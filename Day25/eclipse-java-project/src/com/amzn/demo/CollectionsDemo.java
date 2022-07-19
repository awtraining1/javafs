package com.amzn.demo;

import java.util.*;
import java.util.Map.Entry;

import com.amzn.exceptions.UnsuitableFarmerAgeException;
import com.amzn.exceptions.UnsuitableFarmerNameException;
import com.amzn.fruits.Mango;
import com.amzn.people.Farmer;
import com.amzn.people.Wholesaler;

public class CollectionsDemo {

	public static void main(String[] args) throws UnsuitableFarmerAgeException, UnsuitableFarmerNameException {
		// Objective: Create some 4 farmers

		Farmer farmer1 = null, farmer2 = null, farmer3 = null, farmer4 = null;
		try {
			System.out.println("Creating farmers 1 2 3 4  in the try block ");
			farmer4 = new Farmer("Lokesh4", (short) 25);
			farmer1 = new Farmer("Lokesh1", (short) 31);
			farmer2 = new Farmer("Lokesh2", (short) 24);
			farmer3 = new Farmer("Lokesh3", (short) 35);

		} catch (UnsuitableFarmerAgeException ex) {
			System.out.printf("\n Failed creating farmer %s \n", ex.getMessage());
		} catch (UnsuitableFarmerNameException ex) {
			System.out.printf("\n Failed creating farmer %s \n", ex.getMessage());
		}

		List<Farmer> farmers = new LinkedList<Farmer>(); // OR new ArrayList<Farmer>()
		farmers.add(farmer4);
		farmers.add(farmer4);
		farmers.add(farmer1);
		farmers.add(farmer2);
		farmers.add(new Farmer("Samuel", (short) 25));

		// Loop through the collection
		for (Farmer f : farmers) {
			System.out.printf("\n Farmer name:%s and age:%s", f.getName(), f.getAge());
		}

		Farmer f0 = farmers.get(0);// farmer4
		System.out.printf("\n\n Farmer at index 0 is %s %s", f0.getName(), f0.getAge());

		// Let's remove farmer at index 2 (farmer1)
		farmers.remove(2);
		// Loop through the updated collection
		System.out.println("\n\n After removing farmer1 ");
		for (Farmer f : farmers) {
			System.out.printf("\n Farmer name:%s and age:%s", f.getName(), f.getAge());
		}

		// remove farmer based on object ref
		farmers.remove(farmer4);
		System.out.println("\n\n After removing farmer4 ");
		System.out.println(farmers);

		// How many farmers are there?
		int noOfFarmers = farmers.size();
		System.out.printf("\n\n No of farmers: %s ", noOfFarmers);

		// To sort a collection of objects we need to pass a Comparator object
		// Let's create one.
		Comparator<Farmer> farmerAgeComparator = new Comparator<Farmer>() {

			@Override
			public int compare(Farmer o1, Farmer o2) {
				return o1.getAge() - o2.getAge();

			}

		};

		farmers.sort(farmerAgeComparator);
		System.out.printf("\n\n ### Farmer list after sorting them based on age");
		for (Farmer f : farmers) {
			System.out.printf("\n Farmer name:%s and age:%s", f.getName(), f.getAge());
		}

		// Sort based on farmer name
		Comparator<Farmer> farmerNameComparator = new Comparator<Farmer>() {

			@Override
			public int compare(Farmer o1, Farmer o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return (s1.compareTo(s2));

			}

		};

		farmers.sort(farmerNameComparator);
		System.out.printf("\n\n ### Farmer list after sorting them based on name");
		for (Farmer f : farmers) {
			System.out.printf("\n Farmer name:%s and age:%s", f.getName(), f.getAge());
		}

		// farmers.clear(); // farmers list will empty

		boolean farmerExist = farmers.contains(farmer1);
		System.out.printf("\n\n ### farmer1 exists in the current list : %s", farmerExist);

		farmerExist = farmers.contains(farmer4);
		System.out.printf("\n\n ### farmer4 exists in the current list : %s", farmerExist);

		// Deriving array from a List
		Farmer[] farmerArr = farmers.toArray(new Farmer[0]);
		System.out.printf("\n\n No of Farmers in the array :%s ", farmerArr.length);

		// Set collection
		System.out.printf("\n\n ### SET COLLECTION ###");
		boolean added = false;
		Set<Farmer> farmerSet = new TreeSet<Farmer>(farmerNameComparator);
		added = farmerSet.add(farmer4);
		System.out.printf("\n added farmer4 :%s ", added);
		added = farmerSet.add(farmer4);
		System.out.printf("\n added farmer4 :%s ", added);
		added = farmerSet.add(farmer1);
		System.out.printf("\n added farmer1:%s ", added);
		farmerSet.add(farmer2);
		farmerSet.add(new Farmer("Samuel", (short) 25));
		farmerSet.add(new Farmer("Samuel", (short) 25)); // will be accepted since age is same

		// How many farmers are there?
		int noOfFarmersInTheSet = farmerSet.size();
		System.out.printf("\n\n No of farmers: %s ", noOfFarmersInTheSet);

		// Loop through the collection
		for (Farmer f : farmerSet) {
			System.out.printf("\n Farmer name:%s and age:%s", f.getName(), f.getAge());
		}

		// All operations that we did with List farmers above are valid for the set
		// farmersSet as well.
		System.out.println();
		System.out.println(farmerSet.contains(farmer3));

		// HashSet computes hash of the objects added and
		// therefore the order of adding may not be preserved.
		// LinkedHashSet preserve
		Set<Integer> intSet = new LinkedHashSet<Integer>();// new HashSet<Integer>();
		Integer i1 = Integer.valueOf(10);
		Integer i2 = new Integer(13);
		Integer i3 = 340; // Boxing and Unboxing
		Integer i4 = Integer.valueOf("140");
		intSet.add(i1);
		intSet.add(i4);
		intSet.add(i2);
		intSet.add(i3);

		// Loop through the collection
		for (Integer i : intSet) {
			System.out.printf("\n Integer value :%s", i.intValue());
			// System.out.printf("\n Integer reverse value :%s", Integer.reverse(i));
		}

		// Loop through the collection 
		// Get the value by Unboxing of wrapper classes
		for (Integer i : intSet) {
			System.out.printf("\n Integer value :%s", i);
			// System.out.printf("\n Integer reverse value :%s", Integer.reverse(i));
		}
		
		// Loop through the collection using an iterator
		System.out.printf("\n\n **Loop through the collection using an iterator");
		Iterator<Integer> iterator = intSet.iterator();
		while(iterator.hasNext()) {
			System.out.printf("\n Integer value :%s", iterator.next());
		}
		
		// Loop through the collection using forEach method
		intSet.forEach(element -> System.out.println(element));
		
		// Set of mixed datatypes
		// In this case do not use Generics
		Set mixedSet = new HashSet();
		mixedSet.add(farmer1);
		mixedSet.add(i1);
		mixedSet.add("Hello");
		
		// ASSIGMENT 13a
//		Look at WholeSaler class. 
//		Is there a place where you can use collection class?
		
		// Further Ref : Stack, Queue
		Stack<Mango> mangoStack = new Stack<Mango>();
		Mango m1= new Mango("Raspuri","yellow",120);
		Mango m2= new Mango("Dasheri","green",110);
		Mango m3= new Mango("Neelam","red",104);
		Mango m4= new Mango("Totapuri","yellow",160);
		mangoStack.push(m1);
		mangoStack.push(m2);
		mangoStack.push(m3);
		mangoStack.push(m4);
		
		System.out.println("*** Print the mangoStack");
		for (Mango m : mangoStack) {
			System.out.printf("\n Mango :%s %s", m.name,m.getColor());
		}
		
		System.out.println("\n ** Pop from mangoStack");
		Mango poppedMango = mangoStack.pop();
		System.out.printf("\n\n Popped Mango: %s",poppedMango.name,poppedMango.getColor());

		// Queue FIFO
//		Q.add Q.offer
//		Q.remove Q.poll()
		
		Queue<Farmer> farmerQ = new LinkedList<Farmer>();
		farmerQ.offer(farmer1);// farmerQ.add(farmer1);
		farmerQ.offer(farmer2);
		farmerQ.offer(farmer3);
		farmerQ.offer(farmer4);
		
		// Loop through the Queue
		System.out.println("\n ** Looping  farmerQ");
		for (Farmer f : farmerQ) {
			System.out.printf("\n Farmer name:%s and age:%s",
							f.getName(), f.getAge());
		}
		
		System.out.println("\n ** Polling from farmerQ");
		
		Farmer polledFarmer1 = farmerQ.poll();// farmer1
		Farmer polledFarmer2 = farmerQ.poll();// farmer2
		
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer1.getName(), polledFarmer1.getAge());
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer2.getName(), polledFarmer2.getAge());
		
		
		Queue<Farmer> farmerPQ = new PriorityQueue<Farmer>(farmerNameComparator);
		farmerPQ.offer(farmer1);// farmerQ.add(farmer1);
		farmerPQ.offer(farmer2);		
		farmerPQ.offer(farmer4);
		farmerPQ.offer(farmer3);
		
		// Loop through the PriorityQueue
		System.out.println("\n ** Looping  farmerPQ");
		for (Farmer f : farmerPQ) {
			System.out.printf("\n FarmerPQ name:%s and age:%s",
									f.getName(), f.getAge());
		}
		
		System.out.println("\n ** Polling from farmerPQ");
		
		Farmer polledFarmer1PQ = farmerPQ.poll();// 
		Farmer polledFarmer2PQ = farmerPQ.poll();// 
		Farmer polledFarmer3PQ = farmerPQ.poll();// 
		Farmer polledFarmer4PQ = farmerPQ.poll();// 
		
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer1PQ.getName(), polledFarmer1PQ.getAge());
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer2PQ.getName(), polledFarmer2PQ.getAge());
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer3PQ.getName(), polledFarmer3PQ.getAge());
		System.out.printf(
				"\n Farmer name:%s and age:%s",
				polledFarmer4PQ.getName(), polledFarmer4PQ.getAge());
		
		
		// Map collection - stores pair of objects key,value
		// Let have a map of Farmer and his phone number
		System.out.println("\n\n ** Map demo");
		Map<Integer,Farmer > farmerPhoneMap =  new HashMap<>();
		farmerPhoneMap.put(76554321,farmer1 );
		farmerPhoneMap.put(76554321,farmer4 );
		farmerPhoneMap.put(765415623,farmer1);
		farmerPhoneMap.put(256735367,farmer3 );
		
		Farmer farmr1 = farmerPhoneMap.get(76554321);
		System.out.printf(
				"\n Farmer name:%s and age:%s for phone no 256735367",
				farmr1.getName(), farmr1.getAge());
		
		//Looping through the Entries
		System.out.println("\n\n ** Map demo - Looping through the Entry Set");
		for(Entry<Integer,Farmer> entryOfPhoneFarmer :farmerPhoneMap.entrySet()) {
			System.out.printf("Key: %s",entryOfPhoneFarmer.getKey());
			Farmer f = entryOfPhoneFarmer.getValue();
			System.out.printf("\t Farmer name:%s ",f.getName());
			System.out.println();
		}
		
		// 13B Create a Map that associates farmer name with Farmer object.
		Map<String,Farmer > farmerNameMap =  new HashMap<>();
		farmerNameMap.put(farmer1.getName(),farmer1 );
		farmerNameMap.put(farmer2.getName(),farmer4 );
		farmerNameMap.put(farmer3.getName(),farmer1);
		farmerNameMap.put(farmer4.getName(),farmer3 );
		
		Farmer farmr2 = farmerNameMap.get("Lokesh1");
		if(farmr2!=null) {
		System.out.printf(
				"\n\n farmerNameMap Farmer name:%s and age:%s for name Lokesh1",
				farmr2.getName(), farmr2.getAge());
		}
		
		
		System.out.println("\n\n ** Map demo - Looping through the Key Set");
		for(String key : farmerNameMap.keySet()) {
			System.out.printf("Key %s ", key);
		}
		
		// Looping through all values (Value Set)
		for(Farmer val : farmerNameMap.values()) {
			System.out.printf("Farmer name %s ", val.getName());
		}
		
		// We can also check for certain key existance
		// If it exist then we can retrieve the value object
		String someKey = "Lokesh1";
		boolean keyExist =  farmerNameMap.containsKey(someKey);
		if(keyExist) {
			Farmer farmr3 = farmerNameMap.get("Lokesh1");
			System.out.printf(
					"\n\n farmerNameMap Farmer name:%s and age:%s for name %s",
					farmr3.getName(), farmr3.getAge(), someKey);
			}else {
				System.out.printf("\n\n no such farmer with the key %s",someKey);
			}
		
		// Further reference 
		//Sorting using Collections class
		Collections.sort(farmers, farmerAgeComparator);
		// Creating a IMMULTABLE list 
		List<Integer> listInt = List.of(1,3,6);
		System.out.println("\n\n List.of printing");
		listInt.clear(); .remove .add	// will fail!	
		System.out.println(listInt);
		
		
	}
	
	

}
