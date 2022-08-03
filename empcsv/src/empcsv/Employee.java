package empcsv;




	import java.io.Serializable;

	public class Employee implements Serializable {
	private Integer id;
	private String name;
	private String phone;
	private String dept;

	public Employee() {
	super();
	}

	public Employee(Integer id, String name, String phone, String dept) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.dept = dept;
	}

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getPhone() {
	return phone;
	}

	public void setPhone(String phone) {
	this.phone = phone;
	}

	public String getDept() {
	return dept;
	}

	public void setDept(String dept) {
	this.dept = dept;
	}

	@Override
	public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", dept=" + dept + "]";
	}

	}


