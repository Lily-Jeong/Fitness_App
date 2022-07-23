package project01;
import java.util.*;

//예외 설정
//instanceof 활용 아직 못함.
//하지만 기본적인 기능은 실행할 수 있는 상태.

public class FitnessAppTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member m1 = new Member();
		Trainer t1 = new Trainer();
		Staff s1 = new Staff();
		HealthClubApp hc = new HealthClubApp();
		
		while(true) {
			hc.showMenu();
			int input = sc.nextInt();	//정수 하나 입력받기.
			if(input ==1) {
				hc.registerMenu();
				int input1 = sc.nextInt();
				switch(input1) {
					case 1 : input1 = 1;	//회원 등록 메뉴
						m1.memberRegister();
						continue;
					case 2 : input1 = 2;	//트레이너 등록 메뉴
						t1.trainerRegister();
						continue;
					case 3 : input1 = 3;	//스태프 등록 메뉴
						s1.staffRegister();
						continue;
					case 4 : input1 = 4;
						continue;
					default : ;
						System.out.println("등록 할 수 없는 유형입니다. 다시 선택해주세요.");
						continue;
				}
			} else if(input == 2) {
				hc.confirmMenu();
				int input2 = sc.nextInt();
				switch(input2) {
				case 1 : input2 = 1;	//회원 전체 정보를 보여주는 메뉴.
					m1.showAll();
					continue;
				case 2 : input2 = 2;	// 트레이너 전체 정보를 보여주는 메뉴.
					t1.showAll();
					continue;
				case 3 : input2 = 3;	// 스태프 전체 정보를 보여주는 메뉴.
					s1.showAll();
					continue;
				case 4 : input2 = 4;
					continue;
				default : ;
					System.out.println("메뉴에 없는 선택지입니다. 다시 선택해주세요.");
					continue;
				}
				
			} else if(input == 3) {
				hc.searchMenu();
				int input3 = sc.nextInt();
				switch(input3) {
				case 1 : input3 = 1;	// 회원 이름 검색 => 해당 정보만 출력.
					m1.showInfo(null);
					continue;
				case 2 : input3 = 2;	// 트레이너 이름 검색 => 해당 정보만 출력.
					t1.showInfo(null);
					continue;
				case 3 : input3 = 3;	// 스태프 이름 검색 => 해당 정보만 출력.
					s1.showInfo(null);
					continue;
				case 4 : input3 = 4;
					continue;
				default : ;
					System.out.println("메뉴에 없는 선택지입니다. 다시 선택해주세요.");
					continue;
				}
				
			} else if(input == 4) {
				hc.deleteMenu();
				int input4 = sc.nextInt();
				switch(input4) {
				case 1 : input4 = 1;
					m1.deleteInfo(null);
					continue;
				case 2 : input4 = 2;
					t1.deleteInfo(null);
					continue;
				case 3 : input4 = 3;
					s1.deleteInfo(null);
					continue;
				case 4 : input4 = 4;
					continue;
				}
			} else if(input == 9) {
				break;
			} else {
				System.out.println("메뉴에 없는 기능입니다. 다시 선택해주세요.");
				continue;
			}
		}
		
	}

}
