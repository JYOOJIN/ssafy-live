package com.ssafy.day1.b_array;

public class ArrayTest_20 {
    public static void main(String[] args) {

        char[][] grid = {
                { '2', '3', '1', '4' },
                { '1', 'X', '3', '2' },
                { '3', '4', 'X', 'X' },
                { 'X', '4', '1', '5' } };

        int sum = 0;

        // TODO: X로 표시된 항목의 상하좌우 숫자의 합을 구하시오.
        //  단 행과 열의 오름차순으로 접근하며 상하좌우의 순서로 탐색한다. 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
        
        int[][] visited = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[i].length; j++) {
        		if(grid[i][j] == 'X') {
        			if(j > 0 && visited[i][j-1] == 0 && grid[i][j-1] != 'X') {
        				sum += Character.getNumericValue(grid[i][j-1]);
        				visited[i][j-1] = 1;
        			}
        			if(j < grid[i].length-1 && visited[i][j+1] == 0 && grid[i][j+1] != 'X') {
        				sum += Character.getNumericValue(grid[i][j+1]);
        				visited[i][j+1] = 1;
        			}
        			if(i < grid.length-1 && visited[i+1][j] == 0 && grid[i+1][j] != 'X') {
        				sum += Character.getNumericValue(grid[i+1][j]);
        				visited[i+1][j] = 1;
        			}
        			if(i > 0 && visited[i-1][j] == 0 && grid[i-1][j] != 'X') {
        				sum += Character.getNumericValue(grid[i-1][j]);
        				visited[i-1][j] = 1;
        			}
        		}
        	}
        }
        // END
        System.out.println(sum);
    }
}
