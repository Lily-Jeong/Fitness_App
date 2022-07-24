package project01;
import java.util.*;
import java.lang.Exception;

public class Member extends Person {
	private int id;
	private int purpose;
	private int memberType;
	
	//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	
	//정보를 입력받는 생성자
	public Member() {
		
	}
	
	public Member(int id, String name, String address, int purpose, int memberType) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.purpose = purpose;
		this.memberType = memberType;
	}
	
	//정보 저장되는 배열.
	ArrayList<Member> member = new ArrayList<Member>(30);
	
	
	public void memberRegister() {	//1-1 회원 등록.
		
		int id;
		String name;
		String address;
		int purpose;
		int memberType;
		Scanner sc = new Scanner(System.in);
		System.out.println("회원번호를 입력하세요 => ");
		id = sc.nextInt();
		System.out.println("이름을 입력하세요 => ");
		name = sc.next();
		System.out.println("주소를 입력하세요 => ");
		address = sc.next();
		System.out.println("운동 목적을 입력하세요 => ");
		System.out.println("1)체중감량, 2)근력증진, 3)지구력/체력 증진");
		purpose = sc.nextInt();
		System.out.println("회원권 타입을 입력하세요 => ");
		System.out.println("1)1개월권, 2)3개월권, 3)6개월권, 4)12개월권");
		memberType = sc.nextInt();
		
		member.add(new Member(id, name, address, purpose, memberType));
	}
	

	//이름을 검색해서 본인의 정보만 표시.
	@Override
	public void showInfo(String name) {
		System.out.println("이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		for(int i=0; i< member.size(); i++) {
			if(name.equals(member.get(i).getName())) {
					System.out.println("회원 번호 : "+member.get(i).getId()+"\n이름 : "+member.get(i).getName()
							+"\n주소 : "+member.get(i).getAddress()+"\n운동 목적 : "+member.get(i).getPurpose()
							+"\n회원권 : "+member.get(i).getMemberType());
			}
		}
	}//---------------------
	//전체 정보를 다 출력함.
	public void showAll() {
		for(int i=0; i< member.size(); i++) {
				System.out.println("회원 번호 : "+member.get(i).getId()+"\n이름 : "+member.get(i).getName()
						+"\n주소 : "+member.get(i).getAddress()+"\n운동 목적 : "+member.get(i).getPurpose()
						+"\n회원권 : "+member.get(i).getMemberType());
				System.out.println("--------------------");
		}
	}
	//회원정보 삭제.
	public void deleteInfo(String name) {
		System.out.println("삭제할 회원의 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		for(int i=0; i<member.size(); i++) {
			if(name.equals(member.get(i).getName())) {
				member.remove(member.get(i));
			}
		}
	}
	
	
	
}
