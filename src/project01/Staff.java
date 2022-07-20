package project01;

public class Staff extends Person {
	private int id;
	private String dept;
	private double workYears;
	
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
	
	@Override
	public void showInfo(String name) {
		System.out.println("직원 ID : "+id+"\n이름 : "+name
				+"\n주소 : "+address+"\n	담당 업무 : "+dept
				+"\n근속연수 : "+workYears);
	}

}
