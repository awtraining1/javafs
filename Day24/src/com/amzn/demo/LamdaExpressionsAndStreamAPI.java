package com.amzn.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.amzn.exceptions.UnsuitableFarmerAgeException;
import com.amzn.exceptions.UnsuitableFarmerNameException;
import com.amzn.logistics.GovtIdentity;
import com.amzn.logistics.PayTM;
import com.amzn.logistics.Payment;
import com.amzn.logistics.Tractor;
import com.amzn.logistics.Transport;
import com.amzn.people.Farmer;

public class LamdaExpressionsAndStreamAPI {

	public static void main(String[] args) throws UnsuitableFarmerAgeException, UnsuitableFarmerNameException {

		Transport tractor1 = new Tractor();
		tractor1.ride(); // Tractor ride..

		Transport transportVehicle2 = () -> System.out.println(" Vehicle ride.. ");
		transportVehicle2.ride();

		Transport car1 = () -> System.out.println(" Car ride.. ");
		car1.ride();

		Transport bicycle = () -> System.out.println(" Bicycle ride.. ");
		bicycle.ride();

		// Demo of a lamda expression that accepts 2 arguments

		Farmer f1 = new Farmer("Suresh", (short) 100);
//		Payment paytm1 = new PayTM();
//		paytm1.pay(f1, 1000);

		Payment myPaymentGateWay = (Farmer f, float amt) -> System.out.println("Paying thru my gateway.. ");
		myPaymentGateWay.pay(f1, 1000);

		// Demo of a lamda expression that has multiple statements body
		// and usage of local variables.
		// We can IGNORE they ARGUMENT TYPES in the method parameter list
		Payment myPaymentGateWay2 = (f, amt) -> {
			float x = amt + 20;
			System.out.println("Welcome to my gateway 2.. ");
			System.out.println("Paying thru my gateway 2.. ");
			System.out.printf("\n Paying %s ", x);
		};
		myPaymentGateWay2.pay(f1, 1000);

		// 14A: Create a new Functional Interface GovtIdentity that has one
		// abstract method that takes ONE argument only
		GovtIdentity govtId1 = aad_no -> System.out.printf("\n\n authenicating  %s", aad_no);
		govtId1.Authenticate(19929L);

		Function<Integer, Integer> lamdaExp1 = i -> i * i;

		/// afterr 10000 lines of code
		int result = lamdaExp1.apply(10);
		System.out.println("\n\n Applying Lamda function lamdaExp1 on 10");
		System.out.println(result);

		// STREAMS API
		// Objective: Create some 4 farmers and iterate them using forEach

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
		
		System.out.println("Printing farmers 1 2 3 4  in forEach lambda exp ");
		farmers.forEach(f -> System.out.println(f.getName()));
		
		// Objective : Create a stream of farmers from the list
		Stream<Farmer> farmerStream = farmers.stream();
		System.out.println("Printing all farmers from the stream");
		farmerStream.forEach(
				f->System.out.println(f.getName() + " "+ f.getAge())
				);
		
		Stream<Farmer> farmerStreamWithAgeLess25V1 =
				farmers.stream().filter(f -> f.getAge()<25);	
		
		System.out.println("Printing all farmers with age < 25 from the stream");
		farmerStreamWithAgeLess25V1.forEach(
				f->System.out.println(f.getName() + " "+ f.getAge())
				);
		
		// We can define lambda exp and then pass it the filter.
		Predicate<Farmer> ageLess25 = f -> f.getAge()<25;
		Stream<Farmer> farmerStreamWithAgeLess25V2 =
				farmers.stream().filter(ageLess25);
		
		System.out.println("V2: Printing all farmers with age < 25 from the stream");
		farmerStreamWithAgeLess25V2.forEach(
				f->System.out.println(f.getName() + " "+ f.getAge())
				);
		
		// Collecting the filtered stream in another collection class;
		List<Farmer> farmersWithAgeLessThan25AndNameStartsWithS =
				farmers.stream()
				.filter(ageLess25)
				.filter(f -> f.getName().startsWith("s"))
				.collect(Collectors.toList());
					
		System.out.println("V3: Printing all farmers with age < 25 from the list collected from a stream");
		for(Farmer f: farmersWithAgeLessThan25AndNameStartsWithS) {
			System.out.println(f.getName() + " "+ f.getAge());
		}
		
		// 14B
//		Add a method applyBonus in your WholeSaler class 
//		that will give bonus of Rs 1000 to all those farmers whose 
//		name is between 5 and 6 chars. 
//		If name is exactly four chars give him 10000.
		
		// Just know the count
		long farmerCountWithLT25 = farmers.stream().filter(ageLess25).count();
		System.out.printf("\n\n No of farmers with age less than 25 %s",farmerCountWithLT25  );
		
		// 
		Optional<Farmer> exist =  farmers.stream().filter(ageLess25).findAny();
		Farmer farmerLT25 = exist.get();
		System.out.print("Farmer with less than age 25 exist: "+farmerLT25);
		
		//Using Method references
		System.out.print("\n\n");
		System.out.println("Printing farmers list  in forEach lambda exp without method refs ");
		farmers.forEach(f -> System.out.println(f));
		
		System.out.println("Printing farmers list  in forEach lambda exp with method refs ");
		farmers.forEach(System.out::println);
		
		//Method References Example 2
		farmers.stream().forEach(f -> System.out.println(f.getAge()));
		List<String> farmersNames = farmers.stream().map(f -> f.getName()).collect(Collectors.toList());
		System.out.println("Printing farmer names collected in the above map operation");
		farmersNames.forEach(System.out::println);
		
		List<Integer> farmersAges = farmers.stream().map(f -> f.getAge()).collect(Collectors.toList());
		System.out.println("Printing farmer ages collected using map");
		farmersAges.forEach(System.out::println);
		
		//Simplifying the above map to use method refs
		List<Integer> farmersAges2 = 
				farmers.stream()
				.map(Farmer::getAge)
				.collect(Collectors.toList());
		System.out.println("Printing farmer ages collected using map and method ref inside the map ");
		farmersAges2.forEach(System.out::println);
		
		// 15A
		// Given a farmer list. Stream, map and collect so that 
		// finally we see Name and Age printed for each farmer.
		List<String> farmersNamesAndAges = 
				farmers.stream()
				.map(f -> f.getName() +", "+ f.getAge())
				.collect(Collectors.toList());
		farmersNamesAndAges.forEach(System.out::println);
		
		// grouping 
		System.out.println("Printing farmer sublist based on age");
		Map<Integer, List<Farmer>> farmerMap = 
				farmers.stream()
				.collect(Collectors.groupingBy(Farmer::getAge));
		
		System.out.println(farmerMap);
		
		int testAge = 25;
		System.out.println("Farmers with age " + testAge);
		System.out.println(farmerMap.get(testAge));
		
		//15B Implement applyBonus from yesterdays using stream's groupingBy operation.
		// For this purpose write another function applyBonus2
		
		Map<Integer, List<Farmer>> farmerMapGroupedByNameLength = 
				farmers.stream()
				.collect(Collectors.groupingBy(f-> f.getName().length()));
		
		int testNameLength = 6;
		System.out.println("Farmers list with name length " + testNameLength);
		List<Farmer> farmesWithNameLength6 = farmerMapGroupedByNameLength.get(testNameLength);
		System.out.println(farmesWithNameLength6);
		
		// Approach 2
		Map<Integer, List<String>> farmerNamesMapGroupedByNameLength2 = 
				farmers.stream()
				.map(Farmer::getName)
				.collect(Collectors.groupingBy(String::length));
		
	};

}
