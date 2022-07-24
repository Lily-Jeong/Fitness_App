package project01;
import java.lang.Exception;

//사용자 정의 예외 구현하는 클래스.

public class IDFormatException extends Exception{

	public IDFormatException(String message) {
		super(message);
	}
	
}
