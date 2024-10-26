package covariance;

public class Animal {
	public void eat(Food food){
		System.out.println("I am eating: " + food.getClass().getName());
	}

}
