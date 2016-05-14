package com.test.collection;

//�Զ�����಻֪��������򣬶������ڵ������ʵ�� Comparable�ӿڣ���д compareTo����
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
			return this.name.compareTo(p.name);//���������ͬ�������String��� compareTo����
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

