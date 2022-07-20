package project01;

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
	
	@Override
	public void showInfo(String name) {
		System.out.println("트레이너 ID : "+id+"\n이름 : "+name
				+"\n주소 : "+address+"\n트레이닝 분야 : "+type
				+"\n수샹경력 : "+award);
	}

}
