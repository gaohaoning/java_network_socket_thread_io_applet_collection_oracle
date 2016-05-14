package com.test.collection;

//自定义的类不知道如何排序，对象所在的类必须实现 Comparable接口，覆写 compareTo方法
public class Person implements Comparable<Person>
{
	public String name;
	public int age;
	
	public Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public String toString()
	{
		return "name: "+this.name+" age: "+this.age;
	}
	
	public int compareTo(Person p)
	{
		if(this.age>p.age)
			return 1;
		else if(this.age<p.age)
			return -1;
		else
			return this.name.compareTo(p.name);//如果年龄相同，则调用String类的 compareTo方法
	}
	//==================================================================	
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

