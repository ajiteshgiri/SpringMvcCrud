package com.ajitesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eid")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="esal")
	private Double empSal;
	@Column(name="edept")
	private String empDept;
	@Column(name="ehra")
	private Double empHra;
	@Column(name="ta")
	private Double Ta;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public Double getEmpHra() {
		return empHra;
	}
	public void setEmpHra(Double empHra) {
		this.empHra = empHra;
	}
	public Double getTa() {
		return Ta;
	}
	public void setTa(Double ta) {
		Ta = ta;
	}
	
	
	
	
	
}
