package com.raj.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "dept_name")
	private String departmentName;
	
	@Column(name = "dept_location")
	private String departmentLocation;
	
	@Column(name = "status")
	private String status;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private EmployeeBean employee;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<DeptContactDetail> deptContactDetail;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public Set<DeptContactDetail> getDeptContactDetail() {
		return deptContactDetail;
	}

	public void setDeptContactDetail(Set<DeptContactDetail> deptContactDetail) {
		this.deptContactDetail = deptContactDetail;
	}
}
