package abstractClasses;

public abstract class Animal {
	abstract void sound();
	abstract void eat();
	abstract void sleep();
}
 class Lion extends Animal{
	@Override
	void sound() {
		System.out.println("Growlllll");
		}
	@Override
	void eat() {
		System.out.println("I eat between 5kg and 7kg of meat a day!");
	}
	@Override
	void sleep() {	
		System.out.println("I sleep up to 21 hours each day, so I am a very lazy guy");
	}
	}
 class Tiger extends Animal{
	 @Override
	 void sound() {
		 System.out.println("Roarrrrr");
		 }
	@Override
	void eat() {
		System.out.println("I consume between 10 and 25 pounds of prey a day (4-7% of my body weight)!!");
	}
	@Override
	void sleep() {
		System.out.println("I sleep 18-20 hours every single day, I am a lazy guy");
	}
 	}
 class Deer extends Animal{
		@Override
		void sound() {
			System.out.println("Buuuuccckkkkk");
		}
		@Override
		void eat() {
			System.out.println("I am just eating grasses, sedges, the leaves and shoots of trees and other woody plants, buck");
		}
		@Override
		void sleep() {
			System.out.println("I only sleep 4.5 hours a day");
		}
 	}
