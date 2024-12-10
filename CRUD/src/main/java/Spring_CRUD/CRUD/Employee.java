package Spring_CRUD.CRUD;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String conatact_no;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, String email, String conatact_no) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.conatact_no = conatact_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConatact_no() {
		return conatact_no;
	}
	public void setConatact_no(String conatact_no) {
		this.conatact_no = conatact_no;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", conatact_no=" + conatact_no + "]";
	}
	
}
