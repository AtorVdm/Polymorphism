package vdm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void print(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		Main main = new Main();
		
		print("Parametric polymorphism:");
		String[] array = new String[] {"A","B","C"};
		List<String> list = main.arrayToList(array);
		print(Arrays.toString(array) + " - " + array.getClass().getSimpleName());
		print(list.toString() + " - " + list.getClass().getSimpleName());
		
		print("Ad hoc polymorphism:");
		print(""+main.add(1, 2));
		print(main.add('a', 'b'));
		print(main.add("AAA", "BBB"));
		
		print("Subtype polymorphism:");
		print(main.write(new Cat()));
		print(main.write(new Dog()));
	}
	/*
	 * Parametric polymorphism
	 */
	public <T> List<T> arrayToList(T[] array) {
		List<T> arrayList = new ArrayList<T>(); 
		for (T element : array) {
			arrayList.add(element);
		}
		return arrayList;
	}
	
	/*
	 * Ad hoc polymorphism
	 */
	public int add(int a, int b) {
		return a + b;
	}
	
	public String add(char a, char b) {
		return (((new StringBuilder()).append(a)).append(b)).toString();
	}
	
	public String add(String a, String b) {
		return a.concat(b);
	}
	
	/*
	 * Subtype polymorphism
	 */
	static abstract class Animal {
	    abstract String talk();
	}
	 
	static class Cat extends Animal {
	    String talk() { return "Meow!"; }
	}
	 
	static class Dog extends Animal {
	    String talk() { return "Woof!"; }
	}
	
	public String write(Animal a) {
        return a.talk();
    }
}