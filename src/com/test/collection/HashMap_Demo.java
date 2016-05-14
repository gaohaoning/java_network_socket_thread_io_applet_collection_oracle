package com.test.collection;
import java.util.*;

public class HashMap_Demo
{
	public static void main(String[] args)
	{
		HashMap hm=new HashMap();
		hm.put("Beckham", new Integer(8000));
		hm.put("Ronaldo", new Integer(9000));
		hm.put("Messi", new Integer(9800));
		hm.put("Kaka", new Integer(5000));		
		System.out.println(hm);
		
		Set es=hm.entrySet();
		System.out.println(es);
		
		Iterator i=es.iterator();
		System.out.println(i);
		
		while(i.hasNext())
		{
			Map.Entry me=(Map.Entry)i.next();
			System.out.print(me.getKey()+" : ");
			System.out.println(me.getValue());			
		}
		
		Integer val=(Integer)hm.get("Kaka");
		hm.put("Kaka", val+1111);
		System.out.println("Kaka new value : "+hm.get("Kaka"));
	}
}
