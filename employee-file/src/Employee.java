import java.io.Serializable;

public class Employee implements Serializable {
	
	private int empno;
	private String ename;
	private long phoneno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public Employee(int empno, String ename, long phoneno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.phoneno = phoneno;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", phoneno=" + phoneno + "]";
	}
	
	
	}
