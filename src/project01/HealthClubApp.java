package project01;
import java.util.*;

public class HealthClubApp {

	public void showMenu() {
			System.out.println("========== FITNESS CLUB APP v1.1 ==========");
			System.out.println("1. 정보 등록");
			System.out.println("2. 정보 확인");
			System.out.println("3. 정보 검색");
			System.out.println("4. 정보 삭제");
			System.out.println("9. 종    료");
			System.out.println("-------------------------------------------");
			System.out.println("입력하세요 => ");
			System.out.println("-------------------------------------------");
	}
	
	public void registerMenu() {
			System.out.println("---------- 등록 메뉴 ----------");
			System.out.println("1. 회원 등록");
			System.out.println("2. 트레이너 등록");
			System.out.println("3. 스태프 등록");
			System.out.println("4. 상위 메뉴로");
			System.out.println("-----------------------------");
	}
	
	
	public void confirmMenu() {
		System.out.println("---------- 확인 메뉴 ----------");
		System.out.println("1. 회원 정보 확인");
		System.out.println("2. 트레이너 정보 확인");
		System.out.println("3. 스태프 정보 확인");
		System.out.println("4. 상위 메뉴로");
		System.out.println("-----------------------------");
	}
	
}
