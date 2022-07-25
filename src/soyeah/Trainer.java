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
	
	//사용자 예외 클래스 생성자
		public Trainer(int id) throws IdException{
			if(id>=2000 || id <1000) {
				throw new IdException("회원 ID는 2000~2999의 숫자여야 합니다.");
			}
			this.id = id;
		}
	
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
	
	/**
	 * 부모클래스인 Person의 register 메소드를
	 * 오버라이딩한다.
	 */
	
	ArrayList<Trainer> trainer = new ArrayList<Trainer>();
	
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
			System.out.println("점수는 숫자로 입력해야 합니다.");
			return;
		}catch(IdException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("-------------");
		System.out.println("트레이너 전공을 입력하세요=>");
		type = sc.next();
		
		System.out.println("-------------");
		System.out.println("트레이너 입상 경력을 입력하세요(개월)=>");
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
						String fileName = "C:\\Users\\A0501560\\git\\multicampus_java\\Begin\\src\\MiniProject\\List.txt";
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
		
		
