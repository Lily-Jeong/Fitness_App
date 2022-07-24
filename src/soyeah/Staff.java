package MiniProject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Staff extends Person{
	private int id;
	private String dept;
	private String workYears;
		
	//기본생성자
	public Staff() {
	}
	
	//매개변수 받는 생성자
	public Staff(String name, String address,int id, String dept, String workYears) {
		this.id = id;
		this.dept = dept;
		this.workYears = workYears;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getWorkYears() {
		return workYears;
	}

	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}
	
	/**
	 * 부모클래스인 Person의 register 메소드를
	 * 오버라이딩한다.
	 */
	ArrayList<Staff> staff = new ArrayList<Staff>();
	@Override
	public void register() {
		Staff sf = new Staff();
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("직원 이름을 입력하세요=>");
		name = sc.next();
		System.out.println("-------------");
		
		System.out.println("직원 주소를 입력하세요=>");
		address = sc.next();
		System.out.println("-------------");
		
		System.out.println("직원 번호를 입력하세요=>");
		id = sc.nextInt();
		System.out.println("-------------");
		
		System.out.println("직원 부서를 입력하세요=>");
		dept = sc.next();
		sf.setDept(dept);
		System.out.println("-------------");
		
		System.out.println("직원 근속년수를 입력하세요(개월)=>");
		workYears = sc.next();
		System.out.println("-------------");
		staff.add(new Staff(name, address, id, dept, workYears));
		
		String content = "-------직원-------"+"\n"
				 +"이름: "+name+"\n"
				 +"주소: "+address+"\n"
				 +"번호: "+id+"\n"
				 +"부서: "+dept+"\n"
				 +"근속 년수: "+workYears+"\n\n";
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
	

	public void showInfo() {
		System.out.println("---직원 정보---"); //instanceOf로 나중에 바꾸기
		System.out.println("직원    이름: "+name);
		System.out.println("직원    주소: "+address);
		System.out.println("직원    번호: "+id);
		System.out.println("직원    부서: "+dept);
		System.out.println("직원 근속년수: "+workYears);
	}

}//Staff////////////
