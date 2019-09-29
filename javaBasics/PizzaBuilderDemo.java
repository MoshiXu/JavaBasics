package javaBasics;

interface Pizza{
	String name="";
	String description = "";
	String getDescription();
	int getCost();
}

class PeppyPaneer implements Pizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class FarmHoust implements Pizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
}



public class PizzaBuilderDemo {

	public static void main(String[] args) {

		

	}

}
