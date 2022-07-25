package MiniProject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Member extends Person{
	private int id;
	private String purpose;
	private String memberType;
		
	//기본생성자
	public Member() {
	}
	
	//매개변수 받는 생성자
	public Member(String name, String address, int id, String purpose, String memberType) {
		this.name = name;
		this.address = address;
		this.id = id;
		this.purpose = purpose;
		this.memberType = memberType;
	}
	
	//사용자 예외 클래스 생성자
	public Member(int id) throws IdException{
		if(id>=2000 || id <1000) {
			throw new IdException("회원 ID는 1000~1999의 숫자여야 합니다.");
		}
		this.id = id;
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
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
	/**
	 * text 파일에 저장된 정보 중,
	 * 회원 정보가 30개라면
	 * 회원 등록을 더이상 진행하지 않고
	 * 프로그램을 종료시키는 코드
	 * @throws IOException
	 */
	public void thirdty() throws IOException{
		String str = Files.readString(Paths.get("C:/Users/A0501560/git/multicampus_java/Begin/src/MiniProject/List.txt"));
		String[] token = str.split("\n\n");
		int count=0;
		String c = "-회원-";
		ArrayList<String> tokens = new ArrayList<>(Arrays.asList(token));
		for(int i = 0; i<token.length; i++) {
			if(token[i].contains(c)) {
				count+=1;
				if(count==30){
					System.out.println("회원수가 이미 30명입니다. 등록하지 못합니다.");
					System.exit(0);
				}
			}
		}
	}
	
	
	/**
	 * 부모클래스인 Person의 register 메소드를
	 * 오버라이딩한다.
	 */
	ArrayList<Member> member = new ArrayList<Member>(30);
	
	@Override
	public void register() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------");
		System.out.println("회원 이름을 입력하세요=>");
		name = sc.next();
		System.out.println("-------------");
		System.out.println("회원 주소를 입력하세요=>");
		address = sc.next();
		System.out.println("-------------");
		System.out.println("회원 번호를 입력하세요=>");
		try {
			id = sc.nextInt();
			member.add(new Member(id));
		}
		catch(InputMismatchException e) {
			System.out.println("점수는 숫자로 입력해야 합니다.");
			return;
		}catch(IdException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("-------------");
		System.out.println("회원의 운동 목적을 입력하세요=>");
		purpose = sc.next();
		System.out.println("-------------");
		System.out.println("회원 등록 기간을 입력하세요(개월)=>");
		memberType = sc.next();
		System.out.println("-------------");
		member.add(new Member(name, address, id, purpose, memberType));
		
		Member mb = new Member();
		String title;
		if(mb instanceof Person) {
			title = "-------회원-------";
			String content = title+"\n"
					 +"이름: "+name+"\n"
					 +"주소: "+address+"\n"
					 +"번호: "+id+"\n"
					 +"목적: "+purpose+"\n"
					 +"유형: "+memberType+"\n\n";
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
		
}//Member////////////
