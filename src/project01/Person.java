package project01;

import java.io.IOException;

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
	
	//추상화해서 오버라이딩 할 메서드들.
	abstract public void searchInfo() throws IOException;
	
	abstract public void showInfo() throws IOException;
	
	abstract public void deleteInfo() throws IOException;
	
}
