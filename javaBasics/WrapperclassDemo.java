package javaBasics;

import java.util.ArrayList;

public class WrapperclassDemo {

	
	
	public static void main(String[] args) {

		int i=9;
		Integer a=i;
		//System.out.println(a);
		
		char ch='a';
		Character b=ch;
		//System.out.println(b);
		
		
		ArrayList<Integer>arraylist=new ArrayList<>();
		arraylist.add(24);
		arraylist.add(432);
		int num=arraylist.get(1);
		//System.out.println(num);
		
		
		//unboxing
		Character chh='a';
		char c=chh;
		System.out.println(c);
	}

}
