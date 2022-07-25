package MiniProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HealthClubApp {
	
	
	/**
	 * 실행하게 되면 txt 파일에 저장된 모든 정보가 출력된다.
	 * @throws IOException
	 */
	public void printAll() throws IOException{
		System.out.println("--------------");
		System.out.println("아래는 등록된 정보입니다");
		System.out.println("--------------");
		String fname="C:/java_project/informationList.txt";
		File file=new File(fname);
		
		FileInputStream fis=new FileInputStream(file);//노드 연결
		InputStreamReader fr=new InputStreamReader(fis,"UTF-8");
		
		OutputStreamWriter ow=new OutputStreamWriter(System.out,"UTF-8");
		
		int n=0;
		while((n=fr.read())!=-1) {
			ow.write(n);
			ow.flush();
		}
		fr.close();
	}//printAll()////////
	
	/**
	 * 이름을 입력하면 해당하는 정보가 출력되는 메서드
	 * 
	 * 정보가 등록되어 있는 txt 파일에
	 * 회원, 트레이너, 직원 중
	 * 입력한 이름을 가진 자의 정보가 출력된다.
	 * 
	 * 회원, 트레이너, 직원 중에 동명이인이 있다면
	 * 동명이인 모두의 정보가 출력되어 나온다.
	 * @throws IOException
	 */
	public void search() throws IOException{
		System.out.println("--------------");
		System.out.println("검색하고 싶은 이름을 입력하세요=>");
		System.out.println("--------------");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		String str = Files.readString(Paths.get("C:/java_project/informationList.txt"));
		
		String[] token = str.split("\n\n");
		
		for(int i = 0; i<token.length; i++) {
			if(token[i].contains(name)) {
				System.out.println(token[i]);
			}
		}
	}//search
	
	
	/**
	 * 정보를 삭제하는 메서드
	 * 삭제하고 싶은 이름과 id 번호를 입력하면
	 * 그에 해당하는 정보만 지운 뒤
	 * 나머지 정보를 다시 txt 파일에 저장한다.
	 * 
	 * 그럼 결과적으로 입력한 것에 해당하는 정보만 삭제된다.
	 * @throws IOException
	 * @throws IndexOutOfBoundsException
	 */
	public void remove() throws IOException, IndexOutOfBoundsException{
		
		
		System.out.println("--------------");
		System.out.println("삭제하고 싶은 이름을 입력하세요=>");
		System.out.println("--------------");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		System.out.println("삭제하고 싶은 id 번호를 입력하세요=>");
		System.out.println("--------------");
		String num = sc.next();
		
		String str = Files.readString(Paths.get("C:/java_project/informationList.txt"));
		String[] token = str.split("\n\n");
		
		File file = new File("C:/java_project/informationList.txt");		
		FileWriter fw = new FileWriter(file);
		fw.write("");
		fw.flush();
		
		ArrayList<String> tokens = new ArrayList<>(Arrays.asList(token));
		for(int i = 0; i<token.length; i++) {
			if(token[i].contains(name) && token[i].contains(num)) {
				System.out.println("이름: "+name+", 번호: "+num+"의 정보를 삭제합니다.");
				System.out.println("--------------");
			}
			else {
				String returned = tokens.get(i)+"\n\n";
				fw.write(returned);
				fw.flush();
			}
		}
		System.out.println("삭제 완료!");
		fw.close();
	}//remove
	
	

	public HealthClubApp() {
	}
	public static void main(String[] args) 
	throws IOException{
		HealthClubApp hc = new HealthClubApp();
		Person ps = new Person();
		
		System.out.println("--------------");
		System.out.println("1. 정보 등록");
		System.out.println("2. 정보 검색");
		System.out.println("3. 정보 확인");
		System.out.println("4. 정보 삭제");
		System.out.println("--------------");
		
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		if(no == 1) {
			ps.showMenu();
			ps.register();
		}else if(no == 2) {
			hc.search();
		}else if(no==3) {
			hc.printAll();
		}else if(no ==4) {
			hc.remove();
		}
		
	}//main

}//HealthClubApp
