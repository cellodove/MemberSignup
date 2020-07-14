package codevengers.mall.dto;

public class MemberDTO {
	
	private String id;
	private String passwd;
	private String passwdk;
	private String name;
	private int	tel1;
	private int tel2;
	private int tel3;
	private String address;
	private String gender;
	private String email;
	
	private String managerId;
	private String managerpasswd;
	
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerpasswd() {
		return managerpasswd;
	} 
	public void setManagerpasswd(String managerpasswd) {
		this.managerpasswd = managerpasswd;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPasswdk() {
		return passwdk;
	}
	public void setPasswdk(String passwdk) {
		this.passwdk = passwdk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTel1() {
		return tel1;
	}
	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}
	public int getTel2() {
		return tel2;
	}
	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}
	public int getTel3() {
		return tel3;
	}
	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", passwd=" + passwd + ", passwdk=" + passwdk + ", name=" + name + ", tel1="
				+ tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", address=" + address + ", gender=" + gender
				+ ", email=" + email + "]";
	}
}
