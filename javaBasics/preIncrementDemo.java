package javaBasics;

public class preIncrementDemo {

	int a=10;
	
	public void method(int a) {
		a+=1;
		System.out.println(++a);
	}
	
	public static void main(String[] args) {

		preIncrementDemo p=new preIncrementDemo();
		p.method(3);

	}

}
