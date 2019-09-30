package javaBasics;

public class FloatDemo {

	public static void main(String[] args) {

		float[] a= {100f,76.5f,98.4f,87.4f,76.2f};
		print();
		System.out.println("END");
		/*
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		for(float f:a) {
			System.out.println(f);
		}
		*/
		/*
		for(int i=0;i<a.length;i++) {
			if(i%2==0) {
				//System.out.println(a[i]);
				continue;
			}
			System.out.println(a[i]);
		}
		*/
		
		
	}
	
	static void print() {
		float[] a= {100f,76.5f,98.4f,87.4f,76.2f};

		for(int i=0;i<a.length;i++) {
			if(i%2==0) {
				//System.out.println(a[i]);
				return;
			}
			System.out.println(a[i]);
		}
	}

}
