package MiniProject;
import java.util.*;
public class HealthClubApp {

	public HealthClubApp() {
	}
	public static void main(String[] args) {
		
		System.out.println("--Health App--");
		System.out.println("1. 회원");
		System.out.println("2. 트레이너");
		System.out.println("3. 직원");
		System.out.println("9. 종료");

		HealthClubApp hc = new Person();
		((Person)hc).showMenu();
		
		
	}

}
