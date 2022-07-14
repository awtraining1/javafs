package com.amzn.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String text = "Jack went to the bill. He returned home from fill at 11pm.";
		
		// check if hill is present in the text?
		int position = text.indexOf("hill");
		System.out.println("hill was found at position "+ position);
		
		position = text.indexOf("hillo");
		System.out.println("hillo was found at position "+ position);
		
		System.out.println();
		System.out.println("text start with Jack "+ text.startsWith("Jack"));
		System.out.println("text start with Jacky "+ text.startsWith("Jacky"));
		
		System.out.println();
		System.out.println("text ends with 11pm."+ text.endsWith("11pm."));
		System.out.println("text ends with 1120pm. "+ text.endsWith("1120pm."));
		
		// Does any am or pm is there and is it at the end?
		// check if email@some.com
		
		Pattern pattern = Pattern.compile("hill");
		Matcher matcher = pattern.matcher(text);
		
		boolean found = matcher.find();
		System.out.println();
		System.out.println("hill was found  "+ found);
		
		// match one or other
		pattern = Pattern.compile("[hm]ill"); // will match hill and mill
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println("hill or mill or both was found  "+ found);
		
		// match a range [b-m]ill = [bcdefghijklm]ill
		pattern = Pattern.compile("[b-m]ill"); // will match bill cill dill fill ... mill
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println("hill or mill or both was found  "+ found);
		
		// match a range [c-e] = [cde]
		pattern = Pattern.compile("[c-e]ill"); // will match cill dill eill only
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println("cill dill eill or all was found  "+ found);
		
		// match a range [c-em-p] = [cdemnop]
		pattern = Pattern.compile("[c-em-p]ill"); 
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println("cill dill eill mill nill oill pill or all was found  "+ found);
		
		// match does not contain hill
		pattern = Pattern.compile("[^h]ill"); 
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println(" text does not contain hill " + found);
		
		// check end of something use $
		pattern = Pattern.compile("11pm.$"); 
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println(" text ends with 11pm. " + found);
		
		
		// text ends with 11am.?
		pattern = Pattern.compile("11am.$"); 
		matcher = pattern.matcher(text);
		found = matcher.find();
		System.out.println();
		System.out.println(" text ends with 11am. " + found);
	}

}
