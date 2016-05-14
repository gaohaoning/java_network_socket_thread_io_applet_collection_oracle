package com.test.collection;
import java.util.*;

public class Iterator_Demo
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		al.add("E");
		System.out.println(al);
		
		Iterator i=al.iterator();
		while(i.hasNext())
		{
			Object element=i.next();
			System.out.print(element+" ");
		}
		System.out.println();
		
		ListIterator li=al.listIterator();
		while(li.hasNext())
		{
			li.set(li.next()+"+");
		}
		System.out.println(al);
		
		while(li.hasPrevious())
		{
			//li.set(li.previous()+"+");
			System.out.print(li.previous());
		}
		System.out.println();
	}
}
