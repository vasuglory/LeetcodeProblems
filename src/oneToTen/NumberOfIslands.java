package oneToTen;

import java.util.ArrayDeque;
import java.util.Deque;


public class NumberOfIslands {
	/*
	 Given a 2d gird of 0's and 1's
	 0 is water
	 1 is land
	 count the number of islands
	 An island is connection of all lands till water
	 
	 input: 
	 1 1 0 0 0
	 1 1 0 0 0
	 0 0 1 0 0
	 0 0 0 1 1
	 
	 output:
	 total 3 islands
	 */
	private int[][] grid;
	private boolean[][] visited;
	private int rows;
	private int cols;
	public int numberOfIslandsUsingBFS(int[][] grid) {
		//{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}}
		int count = 0;
		this.grid = grid;
		this.rows = grid.length;
		this.cols = grid[0].length;
		this.visited = new boolean[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					count+=1;
				}
			}
		}
		return count;
		
	}
	
	public void bfs(int row, int col) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited[row][col] = true;
		deque.add(new int[]{row,col});
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!deque.isEmpty()) {
			int[] point = deque.removeFirst();
			int r = point[0];
			int c = point[1];
			
			for(int[] d : directions) {
				int nr = r + d[0];
				int nc = c + d[1];
				if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == 1 && !visited[nr][nc]) {
					deque.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,0,0},{0,0,0,1,1}};
		NumberOfIslands n = new NumberOfIslands();
		int count = n.numberOfIslandsUsingBFS(grid);
		System.out.println(count);	
		
//		boolean[][] visit = new boolean[2][3];
//		System.out.println(visit[0][0]);
	}
	
	
	
	
	
	
	
	
	
	
	
}
