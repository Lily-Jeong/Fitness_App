package MiniProject;
//사용자정의 예외 클래스 만들기
//[1] Exception을 상속받는다.
//[2] 생성자를 구성해서 생성자안에서 super("예외메시지")를 호출해서 예외 메시지를 등록한다.
public class IdException extends Exception{

	public IdException(String msg) {
		super(msg); //예외메세지
	}

}
