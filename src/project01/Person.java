package project01;

public abstract class Person {
	
	protected String name;
	protected String address;
	
	//setter & getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	//추상화해서 자식 클래스들에서 재정의할 메뉴들 
	abstract public void showInfo(String name);

	abstract public void showAll();
	
	
}
