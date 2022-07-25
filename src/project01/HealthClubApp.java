package project01;
import java.util.*;

public class HealthClubApp {
	//메인 메뉴 
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
	//등록 메뉴 
	public void registerMenu() {
			System.out.println("---------- 등록 메뉴 ----------");
			System.out.println("1. 회원 등록");
			System.out.println("2. 트레이너 등록");
			System.out.println("3. 스태프 등록");
			System.out.println("4. 상위 메뉴로");
			System.out.println("-----------------------------");
	}
	
	//확인 메뉴 
	public void confirmMenu() {
		System.out.println("---------- 확인 메뉴 ----------");
		System.out.println("1. 회원 정보 확인");
		System.out.println("2. 트레이너 정보 확인");
		System.out.println("3. 스태프 정보 확인");
		System.out.println("4. 상위 메뉴로");
		System.out.println("-----------------------------");
	}
	//검색 메뉴 
	public void searchMenu() {
		System.out.println("---------- 검색 메뉴 ----------");
		System.out.println("1. 회원 정보 검색");
		System.out.println("2. 트레이너 정보 검색");
		System.out.println("3. 스태프 정보 검색");
		System.out.println("4. 상위 메뉴로");
		System.out.println("-----------------------------");
	}
	//삭제 메뉴.
	public void deleteMenu() {
		System.out.println("---------- 삭제 메뉴 ----------");
		System.out.println("1. 회원 정보 삭제");
		System.out.println("2. 트레이너 정보 삭제");
		System.out.println("3. 스태프 정보 삭제");
		System.out.println("4. 상위 메뉴로");
		System.out.println("-----------------------------");
	}
	
	public void saveMenu() {
		System.out.println("--------------------");
		System.out.println("1. 입력 정보 저장");
		System.out.println("9. 취소 ");
		System.out.println("--------------------");
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("--------------------");
	}
	
	public void showInfo() {
		System.out.println("--------------------");
		System.out.println("아래는 저장된 정보입니다.");
		System.out.println("--------------------");
	}
}
