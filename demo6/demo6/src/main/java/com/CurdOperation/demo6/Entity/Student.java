package com.CurdOperation.demo6.Entity;



import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="student_detail")
public class Student {
	
	@Id
    private int rollNo;
    private String name;
    private String street;
	private String city;
    private String  courses;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getCourses() {
		return courses;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", street=" + street + ", city=" + city + ", courses="
				+ courses + "]";
	}
   
   
    
}
