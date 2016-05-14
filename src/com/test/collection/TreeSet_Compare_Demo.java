package com.test.collection;
import java.util.*;

public class TreeSet_Compare_Demo
{
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet();		
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");
		ts.add("F");
		ts.add("G");		
		System.out.println(ts);		
		//=======================================================		
		Set<Person> s=new TreeSet<Person>();
		
		s.add(new Person("(1) Beckham", 35));
		s.add(new Person("(2) Ronaldo", 35));
		s.add(new Person("(3) Zidane", 38));
		s.add(new Person("(4) Figo", 38));
		s.add(new Person("(5) Xavi", 30));
		s.add(new Person("(6) Iniesta", 30));
		s.add(new Person("(6) Iniesta", 30));
		
		System.out.println(s);		
	}
}
