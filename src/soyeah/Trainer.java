package MiniProject;
//import MiniProject.Person;

import java.util.Scanner;

public class Trainer extends Person{
	private int id;
	private String type;
	private String award;
		
	//기본생성자
	public Trainer() {
	}
	
	//매개변수 받는 생성자
	public Trainer(int id, String type, String award) {
		this.id = id;
		this.type = type;
		this.award = award;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	
	/**
	 * 부모클래스인 Person의 showMenu 메소드를
	 * 오버라이딩한다.
	 */
	@Override
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		Trainer tn = new Trainer();
		System.out.println("-------------");
		System.out.println("트레이너 번호를 입력하세요=>");
		int id = sc.nextInt();
		tn.setId(id);
		System.out.println("-------------");
		System.out.println("트레이너 전공을 입력하세요=>");
		String type = sc.next();
		tn.setType(type);
		System.out.println("-------------");
		System.out.println("트레이너 입상 경력을 입력하세요(개월)=>");
		String award = sc.next();
		tn.setAward(award);
		System.out.println("-------------");
	}
	
	
	public void showInfo() {
		Person ps = new Person();
		ps.setName(name);
		ps.setAddress(address);
		System.out.println("---트레이너 정보---"); //instanceOf로 나중에 바꾸기
		System.out.println("직원     이름: "+ps.getName());
		System.out.println("직원     주소: "+ps.getAddress());
		System.out.println("트레이너     번호: "+id);
		System.out.println("트레이너     이름: "+name);
		System.out.println("트레이너 등록 기간: "+award);
	}

		
		
	}//트레이너////////////