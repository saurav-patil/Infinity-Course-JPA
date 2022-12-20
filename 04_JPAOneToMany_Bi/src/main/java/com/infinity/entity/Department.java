package com.infinity.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//one to many relation from department perspective
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name = "DEPARTMENTS")
public class Department {
	@Id
	@Column (name = "DEPARTMENT_ID")
	private int departmentId;
	@Column (name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "department")
	private List<Student> students = new ArrayList<Student>();
	
	public void addStudent(Student stu) {
		students.add(stu);
	}
	

	public Department() {
		
	}
	
	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
		
}
