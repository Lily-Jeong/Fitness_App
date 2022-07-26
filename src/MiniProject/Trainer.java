package MiniProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Trainer extends Person{
	private int id;
	private String type;
	private String award;
		
	//기본생성자
	public Trainer() {
	}
	
	//매개변수 받는 생성자
	public Trainer(String name, String address,int id, String type, String award) {
		this.name = name;
		this.address = address;
		this.id = id;
		this.type = type;
		this.award = award;
	}
	
	/**
	 * 2천번대의 숫자가 아닐 시 예외처리
	 */
	//사용자 예외 클래스 생성자
		public Trainer(int id) throws IdException{
			if(id>=2000 || id <1000) {
				throw new IdException("회원 ID는 2000~2999의 숫자여야 합니다.");
			}
			this.id = id;
		}
	
		
	//getter, setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	
	
	ArrayList<Trainer> trainer = new ArrayList<Trainer>();
	
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
	@Override
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("트레이너 이름을 입력하세요=>");
		name = sc.next();
		System.out.println("-------------");
		System.out.println("트레이너 주소를 입력하세요=>");
		address = sc.next();
		System.out.println("-------------");
		System.out.println("트레이너 번호를 입력하세요=>");
		try {
			id = sc.nextInt();
			trainer.add(new Trainer(id));
		}
		catch(InputMismatchException e) {
			System.out.println("id는 숫자로 입력해야 합니다.");
			return;
		}catch(IdException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("-------------");
		System.out.println("트레이너 전공을 입력하세요=>");
		type = sc.next();
		
		System.out.println("-------------");
		System.out.println("트레이너 입상 경력을 입력하세요=>");
		award = sc.next();
		System.out.println("-------------");
		
		trainer.add(new Trainer(name, address, id, type, award));
		
		Trainer tn = new Trainer();
		String title;
		if(tn instanceof Person) {
			title = "-------트레이너-------";
			String content = title+"\n"
					 +"이름: "+name+"\n"
					 +"주소: "+address+"\n"
					 +"번호: "+id+"\n"
					 +"전공: "+type+"\n"
					 +"입상 경력: "+award+"\n\n";
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
						String fileName = "C:/java_project/informationList.txt";
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
}//트레이너////////////
		
		
