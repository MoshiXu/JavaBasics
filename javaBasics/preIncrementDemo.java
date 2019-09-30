package javaBasics;

public class preIncrementDemo {

	int a=10;
	
	public void method(int a) {
		a+=1;
		System.out.println(++a);
	}
	
	public static void main(String[] args) {

		preIncrementDemo p=new preIncrementDemo();
		//p.method(3);

		
		int x=2;
		int y=4;
		/*
		System.out.println(y<3&&x++>2);//false
		System.out.println(x);
		System.out.println(y);
		System.out.println(x>2||y>5);//false
		*/
		System.out.println(x++);
		//System.out.println(x);
		
		
		int a=5;
		int b=10;
		int c=b<a++?a*b:a+b;
		System.out.println(c);
	
	}

}
