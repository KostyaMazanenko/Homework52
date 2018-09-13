package com.gmail.kostamazanenko;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		File fOne = new File("D:\\oopWorkspace\\Homework52\\a.txt");
		File fTwo = new File("D:\\oopWorkspace\\Homework52\\b.txt");
		File fThree = new File("D:\\oopWorkspace\\Homework52\\c.txt");
		
		CommonContentFiles ccf = new CommonContentFiles(fOne, fTwo);
		
		try {
			ccf.writeCommonToTheFile(fThree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
