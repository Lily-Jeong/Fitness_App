package MiniProject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Member extends Person{
	private int id;
	private String purpose;
	private String memberType;
		
	//기본생성자
	public Member() {
	}
	
	//매개변수 받는 생성자
	public Member(String name, String address, int id, String purpose, String memberType) {
		this.name = name;
		this.address = address;
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
	 * 부모클래스인 Person의 register 메소드를
	 * 오버라이딩한다.
	 */
	ArrayList<Member> member = new ArrayList<Member>(30);
	
	@Override
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("회원 이름을 입력하세요=>");
		name = sc.next();
		System.out.println("-------------");
		System.out.println("회원 주소를 입력하세요=>");
		address = sc.next();
		System.out.println("-------------");
		System.out.println("회원 번호를 입력하세요=>");
		id = sc.nextInt();
		System.out.println("-------------");
		System.out.println("회원의 운동 목적을 입력하세요=>");
		purpose = sc.next();
		System.out.println("-------------");
		System.out.println("회원 등록 기간을 입력하세요(개월)=>");
		memberType = sc.next();
		System.out.println("-------------");
		member.add(new Member(name, address, id, purpose, memberType));
		String content = "-------회원-------"+"\n"
				 +"이름: "+name+"\n"
				 +"주소: "+address+"\n"
				 +"번호: "+id+"\n"
				 +"목적: "+purpose+"\n"
				 +"유형: "+memberType+"\n\n";
		while(true) {

			System.out.println("-------------");
			System.out.println("1. 정보 저장");
			System.out.println("9. 종료");

			System.out.println("--------------");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("--------------");
			int sv = sc.nextInt();
			switch(sv){
				case 1:
					String fileName = "C:\\Users\\A0501560\\git\\multicampus_java\\Begin\\src\\MiniProject\\List.txt";
					try {
						FileWriter fw = new FileWriter(fileName, true);
						fw.write(content);
						fw.flush();
						fw.close();
						System.out.println(fileName+"에 저장 완료!");
					}catch(IOException ex) {
						System.out.println("파일 쓰기 중 에러: "+ex.getMessage());
					}
					break;
				case 9:
					System.out.println("시스템을 종료합니다.");
					break;
				default:
					System.out.println("메뉴 중에서 선택해주세요.");
					continue;
			}break;
		}
	}
		
}//Member////////////
