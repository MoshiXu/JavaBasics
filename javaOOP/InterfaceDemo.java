package javaOOP;

/*
1) We can’t instantiate an interface in java. That means we cannot create the object of an interface

2) Interface provides full abstraction as none of its methods have body. On the other hand abstract class provides partial 
abstraction as it can have abstract and concrete(methods with body) methods both.

3) implements keyword is used by classes to implement an interface.

4) While providing implementation in class of any method of an interface, it needs to be mentioned as public.

5) Class that implements any interface must implement all the methods of that interface, else the class should be declared 
abstract.

6) Interface cannot be declared as private, protected or transient.

7) All the interface methods are by default abstract and public.

8) Variables declared in interface are public, static and final by default.
*/

/*
9) Interface variables must be initialized at the time of declaration otherwise compiler will throw an error.

10) Inside any implementation class, you cannot change the variables declared in interface because by default, 
they are public, static and final.
*/

interface A{
	int i = 0;
	void print();
}

interface B{
	int j = 0;

	void print();
}
/*
A Java class can only extend one parent class. 
Multiple inheritance (extends) is not allowed. 
Interfaces are not classes, however, and a class can implement more than one interface.
*/
class C implements A,B{

	public void draw() {
		
	}

	@Override
	public void print() {
		
	}
	
}



	
	
	



public class InterfaceDemo {

	public static void main(String[] args) {

		
	}

}
