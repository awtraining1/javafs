package com.amzn.demo;

import java.io.*;

public class ColoredTextDemo {

	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND
        = "\u001B[41m";
    public static final String ANSI_YELLOW = "\u001B[33m";
   
    public static void main(String[] args)
    {
    	System.out.println(ANSI_YELLOW
                + "This text is yellow"
                + ANSI_RESET);
    	
        System.out.println(ANSI_RED_BACKGROUND
                           + "The background color is red"
                           + ANSI_RESET);
    }

}
