package project01;
import java.util.*;

public class FitnessAppTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			HealthClubApp hc = new HealthClubApp();
			hc.showMenu();

			int input = sc.nextInt();	//정수 하나 입력받기.
			if(input < 1 || input >10 || input == 5 || input==6 ||input == 7|| input== 8) {
				System.out.println("실행할 기능을 다시 확인해주세요.");
				continue;
			} else if(input ==1) {
				hc.registerMenu();
				int input1 = sc.nextInt();
				switch(input1) {
					case 1 : input1 = 1;
					//회원 등록 메뉴
					case 2 : input1 = 2;
					//트레이너 등록 메뉴
					case 3 : input1 = 3;
					//스태프 등록 메뉴
					case 4 : input1 = 4;
						continue;
					default : ;
						System.out.println("등록 할 수 없는 유형입니다. 다시 선택해주세요.");
						continue;
				}
			} else if(input == 2) {
				
			} else if(input == 3) {
				
			} else if(input == 4) {
				
			} else if(input == 9) {
				
			} 
			

		}
		
	}

}
