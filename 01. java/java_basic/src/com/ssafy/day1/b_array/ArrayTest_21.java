package com.ssafy.day1.b_array;

public class ArrayTest_21 {
    private static int R = 4, C = 5;
    private static char[][] map;
    private static StringBuilder output = new StringBuilder();

    private static void setup() {
        map = new char[R][C];
        // TODO: 위 배열을 알파벳 대문자 A ~ T로 초기화 하시오.
        char start = 'A';
        for(int i = 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		map[i][j] = start++;
        	}
        }
        // END
    }

    public static void main(String[] args) {
        setup();
        rowFirst();
        colFirst();
        zigzag();
        snail();
    }

    private static void rowFirst() {
        // TODO: 행우선 탐색을 작성하시오.
    	output= new StringBuilder();
    	for(int i = 0; i < R; i++) {
    		for(int j = 0; j < C; j++) {
    			output.append(map[i][j]);
    		}
    	}
        // END
        System.out.println(output.toString().equals("ABCDEFGHIJKLMNOPQRST"));
    }

    private static void colFirst() {
        // TODO: 열우선 탐색을 작성하시오.
    	output= new StringBuilder();
    	for(int i = 0; i < C; i++) {
    		for(int j = 0; j < R; j++) {
    			output.append(map[j][i]);
    		}
    	}
        // END
        System.out.println(output.toString().equals("AFKPBGLQCHMRDINSEJOT"));
    }

    private static void zigzag() {
        // TODO: zigzag 탐색을 작성하시오.
    	output= new StringBuilder();
    	int order = 0;
    	for(int i = 0; i < R; i++) {
    		if(order == 0) {
    			for(int j = 0; j < C; j++) {
        			output.append(map[i][j]);
        		}
    			order = 1;
    		}
    		else {
    			for(int j = C-1; j >= 0; j--) {
        			output.append(map[i][j]);
        		}
    			order = 0;
    		}
    	}
        // END
        System.out.println(output.toString().equals("ABCDEJIHGFKLMNOTSRQP"));
    }
    
    private static void snail() {
     // TODO: 달팽이 탐색을 작성하시오.
    	output= new StringBuilder();
    	
    	int[] dx = {0, 1, 0, -1};
    	int[] dy = {1, 0, -1, 0};
    	int[][] visited = new int[R][C];
    	
    	int row = 0; int col = 0; int index = 0;
    	while(true) {
    		output.append(map[row][col]);
    		visited[row][col] = 1;
    		
    		int curx = row + dx[index];
    		int cury = col + dy[index];
    		
    		if(!isIn(curx, cury) || visited[curx][cury] == 1) {
    			index = (index + 1) % 4;
    			
    			curx = row + dx[index];
        		cury = col + dy[index];
    			if(!isIn(curx, cury) || visited[curx][cury] == 1) {
    				break;
    			}
    			else {
    				row = curx;
    				col = cury;
    			}
    		}
    		else {
    			row = curx; col = cury;
    		}
    	}
        // END
        System.out.println(output.toString().equals("ABCDEJOTSRQPKFGHINML"));
    }
    
    private static boolean isIn(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }
    
}
