package com.example;

public class Employee {

	private int eId;
	private String eName;
	private String eDept;
	private int eSal;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteDept() {
		return eDept;
	}
	public void seteDept(String eDept) {
		this.eDept = eDept;
	}
	public int geteSal() {
		return eSal;
	}
	public void seteSal(int eSal) {
		this.eSal = eSal;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eDept=" + eDept + ", eSal=" + eSal + "]";
	}	
}
