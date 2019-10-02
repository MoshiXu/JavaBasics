package javaBasics;



public class ImmutablearrayDemo {

	public static void main(String[] args) throws CloneNotSupportedException {

		Immutable im= new Immutable(1,new int[]{1,2});
		
		Immutable im2= im.clone();
		System.out.println(im==im2);
		System.out.println(im.getArr()==im2.getArr());
	}
	

}


class Immutable implements Cloneable {
	private int id;
	private int[] arr;
	
	public Immutable(int id,int[] arr) {
		super();
		this.id = id;
		this.arr=arr.clone();
	}
	public int getId() {
		return id;
	}
	public int[] getArr() {
		return arr.clone();
	}
	public Immutable clone() throws CloneNotSupportedException {
		Immutable im= (Immutable) super.clone();
		return im;
	}
}