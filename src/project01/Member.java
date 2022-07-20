package project01;

public class Member extends Person {
	private int id;
	private String purpose;
	private String memberType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	@Override
	public void showInfo(String name) {
		System.out.println("회원 ID : "+id+"\n이름 : "+name
				+"\n주소 : "+address+"\n운동 목적 : "+purpose
				+"\n회원권 : "+memberType);
	}
	
	
	
}
