package com.ssafy.model.dto;

/**
 * Member(부모) 클래스를 상속받은 자식 클래스
 * Member <--- GeneralMember
 * 부모의 모든 멤버가 자식에게 자동으로 상속 이루어짐
 * 단, private 멤버는 접근 권한으로 자식 클래스도 접근 불가능
 * 부모의 생성자는 자식의 생성자에서 명시적으로 지정 가능
 * 만약, 자식의 생성자에서 부모의 생성자를 지정하지 않으면 javac가 자동으로 부모의 기본생성자로 지정함
 * 따라서 부모 클새스에는 기본 생성자가 존재해야 함
 * 부모클래스에 기본생성자가 존재하지 않을 경우 자식의 생성자에서 명시적으로 부모의 특정 생성자를 지정해야함
 * 
 * this 참조변수
 * -- 현재 객체를 지칭하는 참조변수
 * this
 * this.멤버변수
 * this(params) -> 생성자의 첫번째 수행문에 위치해야 함
 * 
 * super 참조변수
 * -- 현재 객체의 부모 객체를 지정하는 참조변수
 * super
 * super.멤버, super.부모의메소드()
 * super(params) -> 부모의 생성자 지정 ( 생성자의 첫번째 수행문에 위치해야 함 )
 * 					따라서 this()와 super()은 동시 사용이 불가능
 */
public class GeneralMember extends Member {
	private int mileage;

	public GeneralMember() {};
	
	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append(", ");
		builder.append(mileage);
		
		return builder.toString();
	}
	
	
	
}
