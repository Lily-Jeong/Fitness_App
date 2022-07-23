package project01;
import java.util.*;

public class Staff extends Person {
	private int id;
	private String dept;
	private double workYears;
	
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
	public double getWorkYears() {
		return workYears;
	}
	public void setWorkYears(double workYears) {
		this.workYears = workYears;
	}
	
	//생성자 
	public Staff() {
		
	}
	
	public Staff(int id, String name, String address, String dept, double workYears) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dept = dept;
		this.workYears = workYears;
	}
	
	ArrayList<Staff> staff = new ArrayList<Staff>();
	public void staffRegister() {	//1-3 스태프 등록.
		int id;
		String name;
		String address;
		String dept;
		double workYears;
		Scanner sc = new Scanner(System.in);
		System.out.println("스태프 번호를 입력하세요 => ");
		id = sc.nextInt();
		System.out.println("이름을 입력하세요 => ");
		name = sc.next();
		System.out.println("주소를 입력하세요 => ");
		address = sc.next();
		System.out.println("담당 업무를 입력하세요 => ");
		dept = sc.next();
		System.out.println("근속연수를 입력하세요 => ");
		workYears = sc.nextDouble();
		
		staff.add(new Staff(id, name, address, dept, workYears));
	}
	
	//스태프 이름 검색 => 해당 정보만 출력.
	@Override
	public void showInfo(String name) {
		System.out.println("트레이너 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		for(int i=0; i< staff.size(); i++) {
			if(name.equals(staff.get(i).getName())) {
					System.out.println("스태프 번호 : "+staff.get(i).getId()+"\n이름 : "+staff.get(i).getName()
							+"\n주소 : "+staff.get(i).getAddress()+"\n담당 업무 : "+staff.get(i).getDept()
							+"\n근속연수 : "+staff.get(i).getWorkYears());
			}
		}
		
	}
	//스태프 전체 정보 출력.
	public void showAll() {
		for(int i=0; i < staff.size(); i++) {
			System.out.println("스태프 번호 : "+staff.get(i).getId()+"\n이름 : "+staff.get(i).getName()+
			"\n담당 업무 : "+staff.get(i).getDept()+"\n근속연수 : "+staff.get(i).getWorkYears());
			System.out.println();
		}
	}//----------------
	
	public void deleteInfo(String name) {
		System.out.println("삭제할 스태프의 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		for(int i=0; i<staff.size(); i++) {
			if(name.equals(staff.get(i).getName())) {
				staff.remove(staff.get(i));
			}
		}
			
	}

}
