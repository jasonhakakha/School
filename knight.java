import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static int[][] a = {{ -1, -1, -1, -1, -1, -1, -1, -1}, 
						{ -1, -1, -1, -1, -1, -1, -1, -1},
						{ -1, -1, -1, -1, -1, -1, -1, -1},
						{ -1, -1, -1, -1, -1, -1, -1, -1}, 
						{ -1, -1, -1, -1, -1, -1, -1, -1}, 
						{ -1, -1, -1, -1, -1, -1, -1, -1}, 
						{ -1, -1, -1, -1, -1, -1, -1, -1},
						{ -1, -1, -1, -1, -1, -1, -1, -1},};
	
//	static int[][] a = {{-1, -2, -1, -1},
//						{-1, -2, -1, -1},
//						{-1, -1, -1, -1},
//						{-1, -1, -1, -1}};

	public static void main(String[] args) {
//		printArr();
		System.out.println(howManySteps(0, 0, 4, 4));
//		shortestPath(0, 1);
		printPath(new Cell(3, 0), new Cell(0, 0));
//		printArr();
	}
	
	static void printArr() {
		for (int[] i: a) {
			for (int j: i)
				System.out.printf("%3d", j);
			System.out.println();
		}
	}
	
	static void printPath(Cell from, Cell to) {
		shortestPath(to.i, to.j);
		printArr();
		while (to.i != from.i || to.j != from.j) {
			System.out.print("(" + from.i + "," + from.j + ") -> ");
			Cell next = new Cell(from.i, from.j);
			
			if (from.i > 0 && a[from.i - 1][from.j] >= 0)
				next = new Cell(from.i - 1, from.j);
			
			if (from.i < a.length - 1 && a[from.i + 1][from.j] >= 0) {
				if (a[next.i][next.j] > a[from.i + 1][from.j])
					next = new Cell(from.i + 1, from.j);
			}
			if (from.j > 0 && a[from.i][from.j - 1] >= 0) {
				if (a[next.i][next.j] > a[from.i][from.j - 1])
					next = new Cell(from.i, from.j - 1);
			}
			if (from.j < a[0].length - 1 && a[from.i][from.j + 1] >= 0) {
				if (a[next.i][next.j] > a[from.i][from.j + 1])
					next = new Cell(from.i, from.j + 1);
			}
			from = next;
		}
		System.out.print("(" + to.i + "," + to.j + ")");
	}
	
	static void shortestPath(int startI, int startJ) {
		Queue<Cell> queue = new LinkedList<>();
		queue.offer(new Cell(startI, startJ));
		a[startI][startJ] = 0;
		while (!queue.isEmpty()) {
			Cell from = queue.poll();
			
			if (from.i > 0 && a[from.i - 1][from.j] == -1) {
				a[from.i - 1][from.j] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i - 1, from.j));
			}
			
			if (from.i < a.length - 1 && a[from.i + 1][from.j] == -1) {
				a[from.i + 1][from.j] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i + 1, from.j));
			}
			
			if (from.j > 0 && a[from.i][from.j - 1] == -1) {
				a[from.i][from.j - 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i, from.j - 1));
			}
			
			if (from.j < a[0].length - 1 && a[from.i][from.j + 1] == -1) {
				a[from.i][from.j + 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i, from.j + 1));
			}
		}
	}

	
	static int howManySteps(int startI, int startJ, int endI, int endJ) {
		Queue<Cell> queue = new LinkedList<>();
		queue.offer(new Cell(startI, startJ));
		a[startI][startJ] = 0;
		while (!queue.isEmpty()) {
			Cell from = queue.poll();

			if (from.i == endI && from.j == endJ)
				return a[endI][endJ];
			//down + right
			if(from.i > 1 && from.j <a.length -1 && a[from.i-2][from.j+1] == -1){
				a[from.i - 2][from.j + 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i - 2, from.j + 1));
			}
			//down + left
			if(from.i > 1 && from.j > 0 && a[from.i-2][from.j-1] == -1){
				a[from.i - 2][from.j - 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i - 2, from.j - 1));
			}
			//up + right
			if(from.i < a.length - 2 && from.j <a.length -1 && a[from.i+2][from.j+1] == -1){
				a[from.i + 2][from.j + 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i + 2, from.j + 1));
			}
			//up + left
			if(from.i < a.length - 2 && from.j > 0 && a[from.i+2][from.j-1] == -1){
				a[from.i + 2][from.j - 1] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i + 2, from.j - 1));
				
			//right + down
			if(from.i > 0 && from.j <a.length - 2 && a[from.i-1][from.j+2] == -1){
					a[from.i - 1][from.j + 2] = a[from.i][from.j] + 1;
					queue.offer(new Cell(from.i - 1, from.j + 2));
			}
			//right + up
			if(from.i < a.length - 1 && from.j <a.length - 2 && a[from.i+1][from.j+2] == -1){
				a[from.i + 1][from.j + 2] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i + 1, from.j + 2));
			}
			//left + down
			if(from.i > 0 && from.j > 1 && a[from.i-1][from.j-2] == -1){
				a[from.i - 1][from.j - 2] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i - 1, from.j - 2));
			}
			//left + up
			if(from.i < a.length - 1 && from.j > 1 && a[from.i+1][from.j-2] == -1){
				a[from.i + 1][from.j - 2] = a[from.i][from.j] + 1;
				queue.offer(new Cell(from.i + 1, from.j - 2));
			}
			//down
//			if (from.i > 0 && a[from.i - 1][from.j] == -1) {
//				a[from.i - 1][from.j] = a[from.i][from.j] + 1;
//				queue.offer(new Cell(from.i - 1, from.j));
//			}
//			//up
//			if (from.i < a.length - 1 && a[from.i + 1][from.j] == -1) {
//				a[from.i + 1][from.j] = a[from.i][from.j] + 1;
//				queue.offer(new Cell(from.i + 1, from.j));
//			}
//			//left
//			if (from.j > 0 && a[from.i][from.j - 1] == -1) {
//				a[from.i][from.j - 1] = a[from.i][from.j] + 1;
//				queue.offer(new Cell(from.i, from.j - 1));
//			}
//			//right
//			if (from.j < a[0].length - 1 && a[from.i][from.j + 1] == -1) {
//				a[from.i][from.j + 1] = a[from.i][from.j] + 1;
//				queue.offer(new Cell(from.i, from.j + 1));
	}
		}
		return -1;
	}

	static class Cell {
		int i, j;
		Cell(int i, int j) { this.i = i; this.j = j; }
	}
}
