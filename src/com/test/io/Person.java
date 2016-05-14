package com.test.io;

import java.io.Serializable;

public class Person implements Serializable
{
	public String name="Fello";
	public int age=25;
	
	public Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public String toString()
	{
		return "name: "+this.name+" age: "+this.age;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}

}
