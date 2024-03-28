package com.ssafy.ws04.step2;

public class Movie {

	/** 영화 번호 */
	public int id;
	/** 영화 이름 */
	public String title;
	/** 영화 감독 */
	public String director;
	/** 영화 장르 */
	public String genre;
	/** 영화 상영시간 */
	public int runningTime;
	
	public Movie() {
		
	}
	
	public Movie (int id,String title, String director, String genre, int runningTime) {
	
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
