package covariance;

public class Herbivore extends Animal {

	
	public void eat(Grass grass) {
		System.out.println("I am eating: " + grass.getClass().getName());
	}
	
	public static void main(String[] args) {
		Animal animal = new Herbivore();
		Food food = new Meat();
		animal.eat(food);
	
	}

}
