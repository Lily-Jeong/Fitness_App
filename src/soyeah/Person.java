package MiniProject;
import java.util.*;

public class Person extends HealthClubApp{
	String name;
	String address;
	
	void showInfo() {
	}
	
	/**
	 * setter, getter
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 정보를 입력할 사람의 기본적인 정보인
	 * 이름과 주소를 입력하기 위한 메소드
	 * if문에 따라 Member, Trainer, Staff 클래스로 넘어간다.
	 */
	public void showMenu() {
		Person ps = new Person();
		Person ps_m = new Member();
		Person ps_t = new Trainer();
		Person ps_s = new Staff();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------");
		System.out.println("이름을 입력하세요=>");
		String name = sc.next();
		ps.setName(name);

		System.out.println("-------------");
		System.out.println("주소를 입력하세요=>");
		String address = sc.next();
		ps.setName(address);
		
		System.out.println("-------------");
		System.out.println("선택하신 메뉴를 입력해주세요");
		System.out.println("-------------");
		int bt = sc.nextInt();
		
		if (bt == 9) {
			System.out.println("시스템을 종료합니다.");
		}
		else if(bt ==1) {
			System.out.println("회원 메뉴를 선택했습니다.");
			((Member)ps_m).showMenu();
		}else if(bt ==2) {
			System.out.println("트레이너 메뉴를 선택했습니다.");
			((Trainer)ps_t).showMenu();
		}else if(bt ==3) {
			System.out.println("직원 메뉴를 선택했습니다.");
			((Staff)ps_s).showMenu();
		}else {
			System.out.println("메뉴 중에서 골라주세요.");
		}
		System.out.println("-------------");

		
		/**
		 * 아래의 두 while 문은 현재 continue 때문에 1,2,3,9 가 아닌 숫자를 입력하면
		 * 무한 루프 때문에 메뉴 중에서 골라주세요 라는 문구가 무한으로 생성된다.
		 * 그래서 일단 위와 같이 구성해놨고,
		 * 1,2,3,9 이외의 숫자를 입력했을 때
		 * 다시 선택한 메뉴를 입력해달라고 하는 문구가 떠야한다.
		 * 배웠는데 지금 기억이 나지 않으니 나중에 처리해보도록하겠다.
		 * 
		 * instanceOf를 이용하여 각 클래스의 타이틀이 출력되도록 하는 것도
		 * 추가가 필요하다.
		 * 
		 * 번호 입력에 회원, 트레이너, 직원 클래스가 각 1000, 2000, 3000 번대가 아니면 예외처리하는 것도 추가 필요
		 */
//		while(true) {
//
//			if (bt == 9) {
//				System.out.println("시스템을 종료합니다.");
//			}
//			else if(bt ==1) {
//				System.out.println("회원 메뉴를 선택했습니다.");
//				((Member)ps_m).showMenu();
//			}else if(bt ==2) {
//				System.out.println("트레이너 메뉴를 선택했습니다.");
//				((Trainer)ps_t).showMenu();
//			}else if(bt ==3) {
//				System.out.println("직원 메뉴를 선택했습니다.");
//				((Staff)ps_s).showMenu();
//			}else {
//				System.out.println("메뉴 중에서 골라주세요.");
//				continue;
//			}
//			System.out.println("-------------");
//		}
		
//		while(true) {
//			switch(bt){
//			case 9:
//				System.out.println("시스템을 종료합니다.");
//				break;
//			case 1:
//				System.out.println("회원 메뉴를 선택했습니다.");
//				((Member)ps_m).showMenu();
//				break;
//			case 2:
//				System.out.println("트레이너 메뉴를 선택했습니다.");
//				((Trainer)ps_t).showMenu();
//				break;
//			case 3:
//				System.out.println("직원 메뉴를 선택했습니다.");
//				((Staff)ps_s).showMenu();
//				break;
//			default:
//				System.out.println("메뉴 중에서 골라주세요.");
//				return;
//			}System.out.println("============");
		
		}
		
	
	public static void main(String[] args) {
		
	}
}
