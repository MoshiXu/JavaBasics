package javaOOP;

abstract class AA{
	int i=6;
	abstract void print();
}

class BB extends AA{
	void print() {
		System.out.println(2);
	}
}

public class AbstractDemo {

	public static void main(String[] args) {

		BB b=new BB();
		b.print();
		System.out.println(b.i);
		
	}

}
