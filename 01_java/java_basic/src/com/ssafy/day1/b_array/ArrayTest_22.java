package com.ssafy.day1.b_array;

public class ArrayTest_22 {
    private static int R = 4, C = 5;
    private static char[][] map;
    // TODO: deltas 계열의 변수를 초기화 하시오.

    // END

    private static void setup() {
        map = new char[R][C];
        char alpha = 'A';
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] = alpha++;
            }
        }
    }

    public static void main(String[] args) {
        setup();
        checkCross();
        checkX();
        straight();
        moveHorse();
    }

    private static void checkCross() {
        int sum = 0;
        // TODO: 자음의주변을 +로 탐색하고 요소의 합을 출력하시오.A=0, B=1,..
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int i= 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		if(map[i][j] == 'A' || map[i][j] == 'E' || map[i][j] == 'I' || map[i][j] == 'O' || map[i][j] == 'U') {
        			continue;
        		}
        		else {
        			for(int k = 0; k < 4; k++) {
        				int curx = i + dx[k];
        				int cury = j + dy[k];
        				
        				if(isIn(curx, cury)) {
        					sum += map[curx][cury] - 'A';
        				}
        			}
        		}
        	}
        }
        
        // END
        System.out.println(sum == 498);
    }

    private static void checkX() {
        int sum = 0;
        // TODO: 모음의 주변을 X로 탐색하고 요소의 합을 출력하시오.(A=0, B=1, ...)
        
        int[] dx = {1, -1, 1, -1};
        int[] dy = {1, 1, -1, -1};
        
        for(int i= 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		if(map[i][j] == 'A' || map[i][j] == 'E' || map[i][j] == 'I' || map[i][j] == 'O' || map[i][j] == 'U') {
        			for(int k = 0; k < 4; k++) {
        				int curx = i + dx[k];
        				int cury = j + dy[k];
        				
        				if(isIn(curx, cury)) {
        					sum += map[curx][cury] - 'A';
        				}
        			}
        		}
        	}
        }
        // END
        System.out.println(sum == 72);
    }

    private static void straight() {
        int sum = 0;
        // TODO: 'K'의 사방으로 영역 내에서 모음을 만나기 전까지 모든 자음들을 합해서 출력하세요.('A'=0, 'B'=1, ...)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int i= 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		if(map[i][j] == 'K') {
        			for(int k = 0; k < 4; k++) {
        				int curx = i + dx[k];
        				int cury = j + dy[k];
        				
        				while(isIn(curx, cury)) {
        					if(map[curx][cury] == 'A' || map[curx][cury] == 'E' || map[curx][cury] == 'I' || map[curx][cury] == 'O' || map[curx][cury] == 'U') {
        						break;
        					}
        					else {
        						sum += map[curx][cury] - 'A';
            					curx += dx[k];
            					cury += dy[k];
        					}
        				}
        			}
        		}
        	}
        }
        // END
        System.out.println(sum == 56);
    }

    private static void moveHorse() {
        char maxChar = 'A';
        int maxSum = 0;
        // TODO: 모음에서 장기의 말(馬)이동 했을 때 만나는 지점의 합이 가장 큰 알파벳과 그때의 합은? 합이 같다면 큰 알파벳
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        
        for(int i= 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		if(map[i][j] == 'A' || map[i][j] == 'E' || map[i][j] == 'I' || map[i][j] == 'O' || map[i][j] == 'U') {
        			int sum = 0;
        			for(int k = 0; k < 8; k++) {
        				int curx = i + dx[k];
        				int cury = j + dy[k];
        				
        				if(isIn(curx, cury)) {
        					sum += map[curx][cury] - 'A';
        				}
        			}
        			
        			if(sum > maxSum) {
        				maxChar = map[i][j];
        				maxSum = sum;
        			}
        		}
        	}
        }
        
        // END
        System.out.println(maxChar == 'I' && maxSum == 48);
    }
    
    private static boolean isIn(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

}
