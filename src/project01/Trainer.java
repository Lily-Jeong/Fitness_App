package project01;

import java.util.ArrayList;
import java.util.Scanner;


public class Trainer extends Person {
	private int id;
	private String type;
	private String award;
	
	//getter & setter
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

	public Trainer() {
		
	}
	public Trainer(int id) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("트레이너번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 3000 || id < 2000) {
			throw new IDFormatException("트레이너번호는 2000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
	}
	public Trainer(String name) {
		this.name = name;
	}
	public Trainer(int id, String name, String address, String type, String award) throws IDFormatException {
		if(id == 0) {
			throw new IDFormatException("트레이너번호는 0번일 수 없습니다. 다시 입력해주세요.");
		} else if(id > 3000 || id < 2000) {
			throw new IDFormatException("트레이너번호는 2000번대로만 지정 가능합니다. 다시 입력해주세요.");
		}
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.award = award;
	}

	//트레이너 정보 입력받을 배열 생성.
	ArrayList<Trainer> trainers = new ArrayList<Trainer>();
	public void trainerRegister() {	//1-2 트레이너 등록.
		int id;
		String name;
		String address;
		String type;
		String award;
		Scanner sc = new Scanner(System.in);
		System.out.println("트레이너번호를 입력하세요 => ");
		id = sc.nextInt();
//		try {
//			trainers.add(new Trainer(id));
//		} catch (IDFormatException e) {
//			System.out.println(e.getMessage());
//			return;
//		}
		System.out.println("이름을 입력하세요 => ");
		name = sc.next();
		System.out.println("주소를 입력하세요 => ");
		address = sc.next();
		System.out.println("전문 분야를 입력하세요 => ");
		type = sc.next();
		System.out.println("수상경력을 입력하세요 => ");
		award = sc.next();
		try {
			trainers.add(new Trainer(id, name, address, type, award));
		} catch(IDFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//트레이너 이름 검색 = > 해당 트레이너 정보만 출력.
	@Override
	public void showInfo(String name) {
		System.out.println("트레이너 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		for(int i=0; i< trainers.size(); i++) {
			if(name.equals(trainers.get(i).getName())) {
					System.out.println("트레이너 번호 : "+trainers.get(i).getId()+"\n이름 : "+trainers.get(i).getName()
							+"\n주소 : "+trainers.get(i).getAddress()+"\n전분 분야 : "+trainers.get(i).getType()
							+"\n수상 이력 : "+trainers.get(i).getAward());
			}
		}
	}
	
	//트레이너 전체 정보 출력.
	public void showAll() {
		for(int i=0; i < trainers.size(); i++) {
			System.out.println("트레이너 번호 : "+trainers.get(i).getId()+"\n이름 : "+trainers.get(i).getName()+
			"\n전문 분야 : "+trainers.get(i).getType()+"\n수상경력 : "+trainers.get(i).getAward());
			System.out.println();
		}
	}//----------------------
	//트레이너 정보 삭제 
	public void deleteInfo() {
		System.out.println("삭제할 트레이너의 이름을 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		System.out.println("삭제할 트레이너 번호를 입력하세요 => ");
		id = sc.nextInt();
		for(int i=0; i<trainers.size(); i++) {
			if(name.equals(trainers.get(i).getName())) {
				if(id == trainers.get(i).getId()) {
					trainers.remove(trainers.get(i));
					System.out.println("트레이너 번호 "+id+"번, "+name+" 트레이너의 정보가 삭제되었습니다.");
				} else {
					System.out.println("찾을 수 없는 트레이너 정보입니다. 다시 입력해주세요.");
					return;
				}
			} 
		}
	}

	
}
