package MiniProject;
import java.util.*;

public class Member extends Person{
	private int id;
	private String purpose;
	private String memberType;
		
	//기본생성자
	public Member() {
	}
	
	//매개변수 받는 생성자
	public Member(int id, String purpose, String memberType) {
		this.id = id;
		this.purpose = purpose;
		this.memberType = memberType;
	}
	
	/**
	 * getter, setter
	 * @return
	 */
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
	
	/**
	 * 부모클래스인 Person의 showMenu 메소드를
	 * 오버라이딩한다.
	 */
	@Override
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		Member mb = new Member();
		System.out.println("-------------");
		System.out.println("회원 번호를 입력하세요=>");
		int id = sc.nextInt();
		
		mb.setId(id);
		System.out.println("-------------");
		System.out.println("회원의 운동 목적을 입력하세요=>");
		String purpose = sc.next();
		mb.setPurpose(purpose);
		System.out.println("-------------");
		System.out.println("회원 등록 기간을 입력하세요(개월)=>");
		String memberType = sc.next();
		mb.setMemberType(memberType);
		System.out.println("-------------");
	}
	
//	@Override
	public void showInfo() {
		Member mb = new Member();
		Person ps = new Person();
		System.out.println("---회원 정보---"); //instanceOf로 나중에 바꾸기
		System.out.println("회원     이름: "+ps.getName());
		System.out.println("회원     주소: "+ps.getAddress());
		System.out.println("회원     번호: "+mb.getId());
		System.out.println("운동     목적: "+mb.getPurpose());
		System.out.println("회원 등록 기간: "+mb.getMemberType());
	}
//	//day11.ObjectTest의 id값과 name값이 같으면 true를 반환하게 하기위한 재정의
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member) {
//			Member user = (Member)obj;
//			boolean bool = user.name.equals(this.name)&& user.id == this.id;
//			return bool;
//			
//		}
//		else {
//			return false;
//		}
//	}

		
		
	}//Student////////////
