package com.amzn.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String sourceText = "Jack went to the bill to take a bill."
				+ "\n He returned home from mill to fill at 11pm \n along with Bill.";
		System.out.printf("sourceText :\n %s \n", sourceText);

		// check if hill is present in the text?
		int position = sourceText.indexOf("bill");
		System.out.println("hill was found at position " + position);

		position = sourceText.indexOf("hillo");
		System.out.println("hillo was found at position " + position);

		System.out.println();
		System.out.println("text start with Jack " + sourceText.startsWith("Jack"));
		System.out.println("text start with Jacky " + sourceText.startsWith("Jacky"));

		System.out.println();
		System.out.println("text ends with 11pm." + sourceText.endsWith("11pm."));
		System.out.println("text ends with 1120pm. " + sourceText.endsWith("1120pm."));

		// Does any am or pm is there and is it at the end?
		// check if email@some.com

		Pattern pattern = Pattern.compile("bill");
		Matcher matcher = pattern.matcher(sourceText);

		System.out.println();

		while (matcher.find()) {
			String str = "bill was found at position %s  and ending at %s \n";
			System.out.printf(str, matcher.start(), matcher.end());
		}
		;

		// match one or other
		pattern = Pattern.compile("[bf]ill"); // will match bill and fill
		matcher = pattern.matcher(sourceText);
		System.out.println();
		while (matcher.find()) {
			System.out.printf("bill/fill was found at position %s  and ending at %s \n", matcher.start(),
					matcher.end());
		}
		;

		// match a range [b-m]ill = [bcdefghijklm]ill
		pattern = Pattern.compile("[b-m]ill"); // will match bill cill dill fill ... mill
		matcher = pattern.matcher(sourceText);
		System.out.println();
		while (matcher.find()) {
			System.out.printf("bill/cill/.../mill was found at position %s  and ending at %s \n", matcher.start(),
					matcher.end());
		}
		;

		// match a range [c-em-p] = [cdemnop]
		pattern = Pattern.compile("[c-em-p]ill");
		matcher = pattern.matcher(sourceText);
		System.out.println();
		while (matcher.find()) {
			System.out.printf("cill/dill/eill /mill/nill/oill/pill was found at position %s  and ending at %s \n",
					matcher.start(), matcher.end());
		}
		;

		// match two ranges and one another [c-em-pB] = [cdemnop]
		pattern = Pattern.compile("[c-em-pB]ill");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "[c-em-pB]ill");
		while (matcher.find()) {
			System.out.printf("cill/dill/eill /mill/nill/oill/pill Bill was found at position %s  and ending at %s \n",
					matcher.start(), matcher.end());
		}
		;

		System.out.printf("sourceText :\n %s \n", sourceText);

		// match does not contain hill
		pattern = Pattern.compile("[^fb]ill");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "[^fb]ill");
		while (matcher.find()) {
			System.out.printf(" ill but not hill found as %s at position %s  and ending at %s \n", matcher.group(),
					matcher.start(), matcher.end());
		}
		;

		// New Text
		sourceText = "will and bill ids are 1010 and 2010 and" + " total 10102225 aabbc 101010 10101010";
		System.out.printf("\n sourceText :\n %s \n", sourceText);

		// match repeaters (Quantifiers)
		pattern = Pattern.compile("(10){1}");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "(10){1}");
		while (matcher.find()) {
			System.out.printf("10 found as %s at position %s  and ending at %s \n", matcher.group(), matcher.start(),
					matcher.end());
		}
		;

		pattern = Pattern.compile("(10){2}");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "(10){2}");
		while (matcher.find()) {
			System.out.printf("1010 found as %s at position %s  and ending at %s \n", matcher.group(), matcher.start(),
					matcher.end());
		}
		;

		pattern = Pattern.compile("(10){2,4}");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "(10){2,4}");
		while (matcher.find()) {
			System.out.printf("1010 or 101010 10101010 found as %s at position %s  and ending at %s \n",
					matcher.group(), matcher.start(), matcher.end());
		}
		;

		pattern = Pattern.compile("(10){4}|(10){2}");
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "(10){4}|(10){2}");
		while (matcher.find()) {
			System.out.printf("1010 or 10101010 found as %s at position %s  and ending at %s \n", matcher.group(),
					matcher.start(), matcher.end());
		}
		;

		System.out.printf("\n sourceText :\n %s \n", sourceText);

		// Match 1010 as a single word.
		// Here we can use \s which is metacharacter for whitespace
		pattern = Pattern.compile("\s(10){2}\s"); // 1010 but not 101010 or 101010
		matcher = pattern.matcher(sourceText);
		System.out.println("\n Pattern " + "(10){2}s");
		while (matcher.find()) {
			System.out.printf("1010 found as %s at position %s  and ending at %s \n", matcher.group(), matcher.start(),
					matcher.end());
		}
		;

		// 23A How will you match Indian mobile numbers ( start with 7-9 and totally
		// have 10 digits)
		String sourceText1 = "7864556464 is my number 982424612 also and also 453553500";
		pattern = Pattern.compile("\\b[7-9](\\d){9}\\b");
		matcher = pattern.matcher(sourceText1);
		System.out.println("\n Pattern " + "\b[7-9](\\d){9}\b");
		while (matcher.find()) {
			System.out.printf("Phone no found as %s at position %s  and ending at %s \n", matcher.group(),
					matcher.start(), matcher.end());
		}
		;

		// 23b How many valid US mobile numbers are there ( ddd-ddd-dddd)
		sourceText1 = "786-455-6464 is my number 982-a42-4612 also and also 453-553-5001";
		pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
		matcher = pattern.matcher(sourceText1);
		System.out.println("\n Pattern " + "(\\d{3})-(\\d{3})-(\\d{4})");
		while (matcher.find()) {
			System.out.printf("US Phone no found as %s at position %s  and ending at %s \n", matcher.group(),
					matcher.start(), matcher.end());
			
			System.out.println("Group count:"+ matcher.groupCount());
			System.out.println("Group 1:"+ matcher.group(1));
			System.out.println("Group 2:"+ matcher.group(2));
			System.out.println("Group 3:"+ matcher.group(3));
		}
		;
		
		// 23C IP address are in the form A.B.C.D 
		// where A B C and D are numbers from 0 to 255
		// How many valid IP address are there in the txt below.
		String sourceText2 = "78.5.23.1 127.0.0.1 192.168.0.11 2.267.1.0";

		// check end of something use $
		pattern = Pattern.compile("11pm.$");
		matcher = pattern.matcher(sourceText);
		boolean found = matcher.find();
		System.out.println();
		System.out.println(" text ends with 11pm. " + found);

		// text ends with 11am.?
		pattern = Pattern.compile("11am.$");
		matcher = pattern.matcher(sourceText);
		found = matcher.find();
		System.out.println();
		System.out.println(" text ends with 11am. " + found);
	}

}
