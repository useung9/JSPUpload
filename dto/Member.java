package dto;

public class Member {
	private int custno;
	private String custname;
	private String custphone;
	private String custaddress;
	private String custjoindate;
	private String custgrade;
	private String custcity;
	
	public Member() {
		
	}
	
	
	public Member(int custno, String custname, String custphone, String custaddress, String custjoindate,
			String custgrade, String custcity) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.custphone = custphone;
		this.custaddress = custaddress;
		this.custjoindate = custjoindate;
		this.custgrade = custgrade;
		this.custcity = custcity;
	}
	@Override
	public String toString() {
		return "Member [custno=" + custno + ", custname=" + custname + ", custphone=" + custphone + ", custaddress="
				+ custaddress + ", custjoindate=" + custjoindate + ", custgrade=" + custgrade + ", custcity=" + custcity
				+ "]";
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	public String getCustaddress() {
		return custaddress;
	}
	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}
	public String getCustjoindate() {
		return custjoindate;
	}
	public void setCustjoindate(String custjoindate) {
		this.custjoindate = custjoindate;
	}
	public String getCustgrade() {
		return custgrade;
	}
	public void setCustgrade(String custgrade) {
		this.custgrade = custgrade;
	}
	public String getCustcity() {
		return custcity;
	}
	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}
	
	
	
	}
