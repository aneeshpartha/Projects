package Model;

public class Customers {
	
	private int Cust_id;
	private String Cust_fname;
	private String Cust_lname;
	private int Cust_phno;
	private String Cust_email;
	private String Cust_address;
	private static Customers customer = new Customers();
	public static Customers getCustomer() {
		return customer;
	}
	public static void setCustomer(Customers customer) {
		Customers.customer = customer;
	}
	public int getCust_id() {
		return Cust_id;
	}
	public void setCust_id(int cust_id) {
		Cust_id = cust_id;
	}
	public String getCust_fname() {
		return Cust_fname;
	}
	public void setCust_fname(String cust_fname) {
		Cust_fname = cust_fname;
	}
	public String getCust_lname() {
		return Cust_lname;
	}
	public void setCust_lname(String cust_lname) {
		Cust_lname = cust_lname;
	}
	public int getCust_phno() {
		return Cust_phno;
	}
	public void setCust_phno(int cust_phno) {
		Cust_phno = cust_phno;
	}
	public String getCust_email() {
		return Cust_email;
	}
	public void setCust_email(String cust_email) {
		Cust_email = cust_email;
	}
	public String getCust_address() {
		return Cust_address;
	}
	public void setCust_address(String cust_address) {
		Cust_address = cust_address;
	}


}
