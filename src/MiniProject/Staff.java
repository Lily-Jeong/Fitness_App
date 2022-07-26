package MiniProject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * 
 * 헬스장 회원/트레이너/직원 관리 프로그램에서 사용하는 직원 클래스
 */
public class Staff extends Person{
	private int id;
	private String dept;
	private String workYears;
		
	/**
	 * 기본생성자
	 */
	public Staff() {
	}
	
	/**
	 * 매개변수 받는 생성자
	 * @param name
	 * @param address
	 * @param id
	 * @param dept
	 * @param workYears
	 */
	public Staff(String name, String address,int id, String dept, String workYears) {
		this.id = id;
		this.dept = dept;
		this.workYears = workYears;
	}
	
	/**
	 * 3천번대의 숫자가 아닐 시 예외처리
	 */
		public Staff(int id) throws IdException{
			if(id>=4000 || id <3000) {
				throw new IdException("직원 ID는 3000~3999의 숫자여야 합니다.");
			}
			this.id = id;
		}
	
	/**
	 * getId
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * setId
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getDept
	 * @return
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * setDept
	 * @param dept
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * getWorkYears
	 * @return
	 */
	public String getWorkYears() {
		return workYears;
	}

	/**
	 * setWorkYears
	 * @param workYears
	 */
	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}
	
	/**
	 * 부모클래스인 Person의 register 메소드를 오버라이딩한다.
	 * 등록하고자 하는 정보들을 입력하고
	 * 지정해둔 경로의 txt 파일에 정보를 저장한다.
	 * 
	 * 이 때, id를 숫자로 입력하지 않거나, 1000번대가 아닌 숫자를 입력하게 되면
	 * 예외처리로 인해 프로그램이 종료된다.
	 * 
	 * 정보를 다 입력하고 나면
	 * 정보를 저장할 것인지, 종료할 것인지 뜨게 되는데
	 * 정보를 저장하는 것을 선택(1 입력)하면 지정한 경로의 텍스트 파일에
	 * 정보가 순차적으로 저장된다.
	 * 
	 * instanceof를 사용하여 정보가 저장될 때 타이틀이 저장되도록했다.
	 */
	ArrayList<Staff> staff = new ArrayList<Staff>();
	@Override
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("직원 이름을 입력하세요=>");
		name = sc.next();
		System.out.println("-------------");
		
		System.out.println("직원 주소를 입력하세요=>");
		address = sc.next();
		System.out.println("-------------");
		System.out.println("직원 번호를 입력하세요=>");
		try {
			id = sc.nextInt();
			staff.add(new Staff(id));
		}catch(InputMismatchException e) {
			System.out.println("id는 숫자로 입력해야 합니다.");
			return;
		}catch(IdException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("-------------");
		
		System.out.println("직원 부서를 입력하세요=>");
		dept = sc.next();
		System.out.println("-------------");
		
		System.out.println("직원 근속년수를 입력하세요(개월)=>");
		workYears = sc.next();
		System.out.println("-------------");
		staff.add(new Staff(name, address, id, dept, workYears));
		
		Staff sf = new Staff();
		String title;
		if (sf instanceof Person) {
			title = "-------직원-------";
			
			String content = title+"\n"
					 +"이름: "+name+"\n"
					 +"주소: "+address+"\n"
					 +"번호: "+id+"\n"
					 +"부서: "+dept+"\n"
					 +"근속 월수: "+workYears+"개월\n\n";
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
						String fileName = "src/MiniProject/informationList.txt";
						try {
							FileWriter fw = new FileWriter(fileName, true);
							fw.write(content);
							fw.flush();
							fw.close();
							System.out.println("저장 완료!");
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
	}
}//Staff////////////
