package com.ssafy.ws04.step2;

public class MovieTest {

	public static void main(String[] args) {
		
	
		Movie movie1 = new Movie(1, "인턴", "낸시 마이어스", "코미디, 오피스", 121 );
		
		Movie movie2 = new Movie();
		
		movie2.id = 2;
		movie2.title = "위시";
		movie2.director = "크리스 벅, 폰 비라선손";
		movie2.genre = "판타지, 애니메이션, 뮤지컬";
		movie2.runningTime = 95;

	}

}
