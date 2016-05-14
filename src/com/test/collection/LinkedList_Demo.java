package com.test.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedList_Demo
{
	public static void main(String[] args)
	{
		LinkedList ll=new LinkedList();
		
		ll.add("E");
		ll.add("F");
		ll.add("G");
		
		System.out.println(ll+" size : "+ll.size());
		
		ll.addFirst("A");
		ll.addLast("Z");
		
		System.out.println(ll+" size : "+ll.size());
		
		ll.set(2, ll.get(2)+" changed ");
		System.out.println(ll+" size : "+ll.size());		
	}
}
