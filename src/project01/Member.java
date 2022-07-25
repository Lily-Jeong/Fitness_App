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
	public Member(int id) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("회원번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 2000 || id < 1000) {
			throw new IDFormatException("회원번호는 1000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
	}
	public Member(int id, String name, String address, int purpose, int memberType) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("회원번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 2000 || id < 1000) {
			throw new IDFormatException("회원번호는 1000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
		this.name = name;
		this.address = address;
		this.purpose = purpose;
		this.memberType = memberType;
	}
	
	//정보 저장되는 배열.
	ArrayList<Member> member = new ArrayList<Member>(30);
	
	
	//1-1 회원 등록.
	public void memberRegister() {	
		
		int id;
		String name;
		String address;
		int purpose;
		int memberType;
		Scanner sc = new Scanner(System.in);
		System.out.println("회원번호를 입력하세요 => ");
		id = sc.nextInt();
		/* 마지막에 회원 정보 전체를 arraylist에 추가하도록 되어있기 때문에,
		 * 이 지점에서 try ~ catch 문을 사용하면, id번호만 입력된 배열이 추가되버림.
		 */
//		try {
//			member.add(new Member(id));
//		} catch (IDFormatException e) {
//			System.out.println(e.getMessage());
//			return;
//		}
		System.out.println("이름을 입력하세요 => ");
		name = sc.next();
		System.out.println("주소를 입력하세요 => ");
		address = sc.next();
		System.out.println("운동 목적을 입력하세요 => ");
		System.out.println("1)체중감량, 2)근력증진, 3)지구력/체력 증진");
		purpose = sc.nextInt();
		if (purpose > 3) {
			System.out.println("보기에 없는 선택지입니다. 다시 입력해주세요.");
			return;
		} else if (purpose < 1) {
			System.out.println("보기에 없는 선택지입니다. 다시 입력해주세요.");
			
		} else {
			System.out.println("회원권 타입을 입력하세요 => ");
			System.out.println("1)1개월권, 2)3개월권, 3)6개월권, 4)12개월권");
			memberType = sc.nextInt();
			if (memberType > 4) {
				System.out.println("보기에 없는 선택지입니다. 다시 입력해주세요.");
				return;
			} else if (memberType < 1) {
				System.out.println("보기에 없는 선택지입니다. 다시 입력해주세요.");
				return;
			} else {
				try {
					member.add(new Member(id, name, address, purpose, memberType));
				} catch (IDFormatException e) {
					System.out.println(e.getMessage());
				}
			}
		}
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
