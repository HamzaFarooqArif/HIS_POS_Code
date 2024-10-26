package mvc;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Model {
	private String state = "";
	
	private Set<Observer> observers = new HashSet<Observer>(); 
	
	public void register(Observer observer){
		observers.add(observer);
		
	}
	
	public void remove(Observer observer){
		observers.remove(observer);
	}
	
	public void setState(String s){
		this.state = s;
		
		Iterator<Observer> iterator = observers.iterator();
		while(iterator.hasNext()){
			Observer observer = iterator.next();
			observer.update(this.state);
		}
			
		
	}
	
	
}
