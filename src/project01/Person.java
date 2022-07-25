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
	

	
	abstract public void showInfo(String name);

	abstract public void showInfo2();
}
