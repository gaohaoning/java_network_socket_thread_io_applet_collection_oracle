package com.test.collection;
import java.util.*;

public class ArrayList_Demo
{
	public static void main(String[] args)
	{
		ArrayList al=new ArrayList();
		
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		al.add("E");
		
		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		
		System.out.println(al);
		System.out.println("ArrayList size : "+al.size());
		
		al.add(1, "AB");
		al.add(3, "CD");		
		
		System.out.println(al);
		System.out.println("ArrayList size : "+al.size());
		
		al.remove(2);
		al.remove(4);
		
		System.out.println(al);
		System.out.println("ArrayList size : "+al.size());
		
		Object a[]=al.toArray();
		System.out.println(a);
		
		Object str[]=al.subList(0, 5).toArray();		
		for (int i = 0; i < str.length; i++)
		{
			System.out.print(str[i]+" ");
		}
		
		Object ii[]=al.subList(5, 8).toArray();
		for (int i = 0; i < ii.length; i++)
		{
			System.out.print(ii[i]+" ");
		}
		
	}
}
