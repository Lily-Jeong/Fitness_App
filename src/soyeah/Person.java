package MiniProject;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
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

		System.out.println("--Health App--");
		System.out.println("1. 회원");
		System.out.println("2. 트레이너");
		System.out.println("3. 직원");
		System.out.println("9. 종료");
	}
	
	public void register() {
		
		Person ps = new Person();
		Member mb = new Member();
		Trainer tn = new Trainer();
		Staff sf = new Staff();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------");
		System.out.println("선택하신 메뉴를 입력해주세요");
		System.out.println("-------------");
		while(true) {
			int bt = sc.nextInt();
			
			switch(bt) {
			case 9:
				System.out.println("시스템을 종료합니다.");
				break;
			case 1:
				System.out.println("회원 메뉴를 선택했습니다.");
				System.out.println("-------------");
				mb.register();
				break;
			case 2:
				System.out.println("트레이너 메뉴를 선택했습니다.");
				System.out.println("-------------");
				tn.register();
				break;
			case 3:
				System.out.println("직원 메뉴를 선택했습니다.");
				System.out.println("-------------");
				sf.register();
				break;
			default:
				System.out.println("메뉴 중에서 골라주세요.");
				continue;
			}break;
		}
}

		

		
		/**
		 * instanceOf를 이용하여 각 클래스의 타이틀이 출력되도록 하는 것도
		 * 추가가 필요하다.
		 * 
		 * 번호 입력에 회원, 트레이너, 직원 클래스가 각 1000, 2000, 3000 번대가 아니면 예외처리하는 것도 추가 필요
		 */
	
}
