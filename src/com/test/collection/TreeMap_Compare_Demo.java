package com.test.collection;
import java.util.*;

public class TreeMap_Compare_Demo
{
	public static void main(String[] args)
	{
		//TreeMap tm=new TreeMap();	
		TreeMap tm=new TreeMap(new My_Compararator());//此处用Comparator对象构造TreeMap
		tm.put("A Beckham",new Integer(1000));
		tm.put("B Ronaldo",new Integer(2000));
		tm.put("C Messi",new Integer(3000));
		tm.put("D Kaka",new Integer(4000));
		System.out.println(tm);
		
		//Collection col=tm.values();
		Set s=tm.entrySet();
		
		//Iterator i=col.iterator();
		Iterator i=s.iterator();
		System.out.println(i);
		
		while(i.hasNext())
		{
			Map.Entry me=(Map.Entry)i.next();
			System.out.print(me.getKey()+" : ");
			System.out.println(me.getValue());
			//System.out.println(i.next());
		}
	}
}

class My_Compararator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		String s1=(String)o1;
		String s2=(String)o2;
		return s1.compareTo(s2);
	}
}