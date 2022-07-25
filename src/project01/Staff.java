package project01;
import java.util.*;
import java.lang.Exception;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Staff extends Person {
	private int id;
	private String dept;
	private double workYears;
	
	//getter & setter
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
	public Staff(int id) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("스태프번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 3000 || id < 2000) {
			throw new IDFormatException("스태프번호는 3000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
	}
	public Staff(int id, String name, String address, String dept, double workYears) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("스태프번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 4000 || id < 2000) {
			throw new IDFormatException("스태프번호는 3000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
		this.name = name;
		this.address = address;
		this.dept = dept;
		this.workYears = workYears;
	}
	//데이터를 입력 받을 배열 생성.
	ArrayList<Staff> staff = new ArrayList<Staff>();
	
	//1-3 스태프 등록.
	public void staffRegister() throws IOException {
		HealthClubApp hc = new HealthClubApp();
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
		try {
			staff.add(new Staff(id, name, address, dept, workYears));
			String title = "---------- 스태프 정보 ----------";
			String content = title+"\n이름 : "+name+"\n스태프 번호 : "+id+"\n주소 : "+address
					+"\n담당 업무 : "+dept+"\n근속 연수 : "+workYears+"\n\n";
			while(true) {
				hc.saveMenu();
				int i = sc.nextInt();
				switch(i) {
				case 1 : String fileName = "/Users/lilyjeong/Desktop/Project01_JAVA/FitnessApp/stafflist.txt";
					try {
						FileWriter fw = new FileWriter(fileName, true);
						fw.write(content);
						fw.flush();
						fw.close();
						System.out.println("스태프 정보가 정상적으로 등록되었습니다.");
						return;
					} catch(IOException e) {
						System.out.println("파일을 저장하는 중 에러가 발생했습니다."+e.getMessage());
					}
				}

			}
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}

	}
	
	//스태프 이름 검색 => 해당 정보만 출력.
	@Override
	public void searchInfo() throws IOException {
		System.out.println("트레이너 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		String str = Files.readString(Paths.get("/Users/lilyjeong/Desktop/Project01_JAVA/FitnessApp/stafflist.txt"));
		String[] token = str.split("\n\n");
		for(int i=0; i<token.length; i++) {
			if(token[i].contains(name)) {
				System.out.println(token[i]);
			}
		}
		/* for(int i=0; i< staff.size(); i++) {
			if(name.equals(staff.get(i).getName())) {
					System.out.println("스태프 번호 : "+staff.get(i).getId()+"\n이름 : "+staff.get(i).getName()
							+"\n주소 : "+staff.get(i).getAddress()+"\n담당 업무 : "+staff.get(i).getDept()
							+"\n근속연수 : "+staff.get(i).getWorkYears());
			}
		} */
		
	}
	//스태프 전체 정보 출력.
	@Override
	public void showInfo() throws IOException {
		HealthClubApp hc = new HealthClubApp();
		hc.showInfo();
		String fname = "/Users/lilyjeong/Desktop/Project01_JAVA/FitnessApp/stafflist.txt";
		File file = new File(fname);
		
		FileInputStream input = new FileInputStream(file);	//노드 연결
		InputStreamReader inputreader = new InputStreamReader(input, "UTF-8");
		OutputStreamWriter outputwriter = new OutputStreamWriter(System.out, "UTF-8");
		
		int n = 0;
		while((n=inputreader.read()) != -1) {
			outputwriter.write(n);
			outputwriter.flush();
		}
		inputreader.close();
		/* for(int i=0; i < staff.size(); i++) {
			System.out.println("스태프 번호 : "+staff.get(i).getId()+"\n이름 : "+staff.get(i).getName()+
			"\n담당 업무 : "+staff.get(i).getDept()+"\n근속연수 : "+staff.get(i).getWorkYears());
			System.out.println();
		} */
	}//----------------
	
	//스태프 정보 삭제 
	public void deleteInfo() throws IOException {
		System.out.println("삭제할 스태프의 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		System.out.println("삭제할 스태프의 번호를 입력하세요 => ");
		String num = sc.next();
		String str = Files.readString(Paths.get("/Users/lilyjeong/Desktop/Project01_JAVA/FitnessApp/stafflist.txt"));
		String[] token = str.split("\n\n");
		
		File file = new File("/Users/lilyjeong/Desktop/Project01_JAVA/FitnessApp/stafflist.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("");
		fw.flush();
		ArrayList<String> tokens = new ArrayList<>(Arrays.asList(token));
		for(int i=0; i<token.length; i++) {
			if(token[i].contains(name) && token[i].contains(num)) {
				System.out.println("스태프 번호 : "+num+", 이름 : "+name+" 스태프의 정보를 삭제합니다.");
			} else {
				String returned = tokens.get(i)+"\n\n";
				fw.write(returned);
				fw.flush();
			}
		}
		System.out.println("삭제 완료");
		fw.close();
		
		/* for(int i=0; i<staff.size(); i++) {
			if(name.equals(staff.get(i).getName())) {
				if(id == staff.get(i).getId()) {
					staff.remove(staff.get(i));
					System.out.println("스태프 번호 "+id+"번, "+name+" 직원의 정보가 삭제되었습니다.");
				} else {
					System.out.println("찾을 수 없는 스태프 정보입니다. 다시 입력해주세요.");
					return;
				}
			} 
		} */
	}

}
