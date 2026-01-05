package oneToTen;

public class MinimumPointsVisitingAllPoints {
	/*
	 	[[1,1],[3,4],[-1,0]]
	 	return minimum steps it takes to go 1,1 to 3,4 to -1,0
	 	we can move 1 step right, 1 step left and we can move diagonal as well
	 	moving diagonal will move x and y +1 simultaneously
	*/
	public static int minimumSteps(int[][] points) {
		int steps = 0;
		for(int i = 1 ; i < points.length; i++) {
			int x1 = points[i-1][0];
			int y1 = points[i-1][1];
			int x2 = points[i][0];
			int y2 = points[i][1];
			
			int distanceX = Math.abs(x2-x1);
			int distanceY = Math.abs(y2-y1);
			
			
			steps = steps + Math.max(distanceX, distanceY);
		}
		return steps;
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,1},{3,4},{-1,0}};
		int[][] points1 = {{2,2},{2,9}};
		System.out.println(minimumSteps(points1));
	}
}
