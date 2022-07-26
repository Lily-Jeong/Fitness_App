package MiniProject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.NoSuchFileException;


/**
 * 
 * 헬스장 회원/트레이너/직원 관리 프로그램에서 사용하는 회원 클래스
 *
 */
public class Member extends Person{
	private int id;
	private String purpose;
	private String memberType;
		
	/**
	 * 기본생성자
	 */
	public Member() {
	}
	
	/**
	 * 매개변수 받는 생성자
	 * @param name
	 * @param address
	 * @param id
	 * @param purpose
	 * @param memberType
	 */
	public Member(String name, String address, int id, String purpose, String memberType) {
		this.name = name;
		this.address = address;
		this.id = id;
		this.purpose = purpose;
		this.memberType = memberType;
	}
	
	/**
	 * 천번대의 숫자가 아닐 시 예외처리
	 */
	public Member(int id) throws IdException{
		if(id>=2000 || id <1000) {
			throw new IdException("회원 ID는 1000~1999의 숫자여야 합니다.");
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
	 * getPurpose
	 * @return
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * setPurpose
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/**
	 * getMemberType
	 * @return
	 */
	public String getMemberType() {
		return memberType;
	}
	/**
	 * setMemberType
	 * @param memberType
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
	/**
	 * text 파일에 저장된 정보 중,
	 * 회원 정보가 30개라면
	 * 회원 등록을 더이상 진행하지 않고
	 * 프로그램을 종료시키는 코드
	 * 
	 * 처음 프로그램을 실행시킬 때, 해당 폴더와 informationList.txt 라는 파일이 없다면
	 * NoSuchFileException라는 에러가 뜬다.
	 * 
	 * 이 에러가 뜨게되면 에러코드 출력을 하지 않고
	 * register() 메서드로 넘어갈 수 있게 try - catch 문을 사용하였다.
	 * @throws IOException
	 */
	public void thirdty() throws IOException{
		try {
			String str = Files.readString(Paths.get("src/MiniProject/informationList.txt"));
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
		}catch(NoSuchFileException e) {
			}
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
			System.out.println("id는 숫자로 입력해야 합니다.");
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
					 +"등록 기간: "+memberType+"개월\n\n";
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
}//Member////////////
