package com.gmail.kostamazanenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CommonContentFiles {
	private File fOne;
	private File fTwo;
	private StringBuilder contentFOne;
	private StringBuilder contentFTwo;

	public CommonContentFiles(File fOne, File fTwo) {
		super();
		this.fOne = fOne;
		this.fTwo = fTwo;
		contentFOne = getFileContent(fOne);
		contentFTwo = getFileContent(fTwo);
	}

	public StringBuilder getFileContent(File file) {
		StringBuilder sb = new StringBuilder();
		String str = new String();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (; (str = br.readLine()) != null;) {
				sb.append(str);
				sb.append(" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return sb;
	}

	public StringBuilder searchCommon() throws IndexOutOfBoundsException {
		int index;
		StringBuilder sb = new StringBuilder();
		String[] str = contentFOne.toString().split(" ");
		for (int i = 0; i < str.length; i++) {
			index = contentFTwo.indexOf(str[i]);
			if (index > 0 || index == 0) {
				sb.append(str[i] + " ");
				contentFTwo.delete(index , str[i].length() + index );
			}
		}
		return sb;
	}
	
	public void writeCommonToTheFile(File file) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(file)){
			pw.print(searchCommon().toString());
		} catch (FileNotFoundException e) {
			throw e;
		}
	}

}
