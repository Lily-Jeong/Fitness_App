package MiniProject;
import java.util.Scanner;

//import MiniProject.Person;

/**
 * @author A0501560
 *
 */
public class Staff extends Person{
	private int id;
	private String dept;
	private String workYears;
		
	//기본생성자
	public Staff() {
	}
	
	//매개변수 받는 생성자
	public Staff(int id, String dept, String workYears) {
		this.id = id;
		this.dept = dept;
		this.workYears = workYears;
	}
	
	
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
	 * 부모클래스인 Person의 showMenu 메소드를
	 * 오버라이딩한다.
	 */
	@Override
	public void showMenu() {
		Staff sf = new Staff();
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("직원 번호를 입력하세요=>");
		int id = sc.nextInt();
		sf.setId(id);
		System.out.println("-------------");
		System.out.println("직원 부서를 입력하세요=>");
		String dept = sc.next();
		sf.setDept(dept);
		System.out.println("-------------");
		System.out.println("직원 근속년수를 입력하세요(개월)=>");
		String workYears = sc.next();
		sf.setWorkYears(workYears);
		System.out.println("-------------");
	}
	

	public void showInfo() {
		Person ps = new Person();
		Staff sf = new Staff();
		System.out.println("---직원 정보---"); //instanceOf로 나중에 바꾸기
		System.out.println("직원    이름: "+ps.getName());
		System.out.println("직원    주소: "+ps.getAddress());
		System.out.println("직원    번호: "+sf.getId());
		System.out.println("직원    부서: "+sf.getDept());
		System.out.println("직원 근속년수: "+sf.getWorkYears());
	}

		
		
	}//Staff////////////
