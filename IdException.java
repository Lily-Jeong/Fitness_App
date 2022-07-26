package MiniProject;

/**
 * Member, Trainer, Staff에서
 * 각 id번호의 범위를 넘어가면 예외처리를 하기 위한 클래스
 * 
 * Member, Trainer, Staff 클래스에서 각각 throws IdException으로 이 클래스를 받는
 * 코드를 확인해보면
 * 
 * 멤버 클래스는 1천번대, 트레이너는 2천번대, 스태프는 3천번대의 번호가 입력되지 않으면
 * 예외처리 되고 프로그램은 종료된다.
 */
public class IdException extends Exception{

	public IdException(String msg) {
		super(msg); //예외메세지
	}

}
