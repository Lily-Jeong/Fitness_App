package project01;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer extends Person {
	private int id;
	private String type;
	private String award;
	
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
	public Trainer(int id, String name, String address, String type, String award) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
		this.award = award;
	}

	
	/*
	 * 트레이너의 각 요소 정보들을 각각 입력받아서
	 * 하나의 트레이너 정보로 만든 다음,
	 * 그 트레이너의 정보 전체를 ArrayList 에 추가하는 메서드 만들기!
	 * 
	 */
	
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
		System.out.println("이름을 입력하세요 => ");
		name = sc.next();
		System.out.println("주소를 입력하세요 => ");
		address = sc.next();
		System.out.println("전문 분야를 입력하세요 => ");
		type = sc.next();
		System.out.println("수상경력을 입력하세요 => ");
		award = sc.next();
		
		trainers.add(new Trainer(id, name, address, type, award));
	}
	
	//트레이너의 경우 전체 정보를 모두 출력함.
	@Override
	public void showInfo(String name) {
		
	}
	
	public void showInfo2() {
		for(int i=0; i < trainers.size(); i++) {
			System.out.println("트레이너 ID : "+trainers.get(i).getId()+"\n이름 : "+trainers.get(i).getName()+
			"\n전문 분야 : "+trainers.get(i).getType()+"\n수상경력 : "+trainers.get(i).getAward());
			System.out.println();
		}
	}//----------------------
	
}
