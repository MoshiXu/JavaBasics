package javaBasics;

/*
 * byte 8 bit
 * short 16 bit
 * int 32 bit
 * long 64 bit
 * float 32 bit
 * double 64 bit
 * 
 * char 16 bit
 */


public class TypecastingDemo {

	public static void main(String[] args) {

		byte b;
		int i=258;
		double d=325.59;
		
		//int 32,byte 8
		b=(byte)i;
		//System.out.println(b);

		i=(int)d;
		//System.out.println(i);
		
		b=(byte)d;
		System.out.println(b);
	}

}
