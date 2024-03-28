
public class StringTest {

	public static void main(String[] args) {
		String msg1 = "안녕광주5반";	//heap literal pool
		String msg2 = "안녕광주5반";	//heap literal pool
		String msg3 = new String("안녕광주5반");	//heap 새로운 영역 생성
		String msg4 = new String("안녕광주5반");	//heap 새로운 영역 생성
		String msg5 = msg1;
		
//		for(int i=1;i<=10;i++) {
//			msg1 = msg1+i;	//안녕광주5반1
//		}
		
		//같은 문자열 비교 : 반드시 .equals (-> 값을 가지고 비교) 비교해야함
		if(msg1 == msg2)
			System.out.println("A");
		else if(msg1 == msg3)
			System.out.println("B");
		else if(msg1.equals(msg4))
			System.out.println("C");
		else
			System.out.println("D");
		
		System.out.println("문자열비교를 == 기호를 이용하면 문자열 생성방법에 따라 달라지는 문제발생!!!");
		System.out.println(msg1 == msg2);
		System.out.println(msg1==msg3);
		System.out.println(msg1==msg4);
		System.out.println(msg1==msg5);
		
		System.out.println("중요!!! 문자열 비교는 반드시 equals()를 이용할것!!!");
		System.out.println(msg1.equals(msg2));
		System.out.println(msg1.equals(msg3));
		System.out.println(msg1.equals(msg4));
		System.out.println(msg1.equals(msg5));
	}

}
