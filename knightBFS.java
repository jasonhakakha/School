import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Knight {
	public static int[][] directions = new int[][] { { 1, 2 }, { 1, -2 },
			{ -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

	public static Stack path(int[][]board, int[] end, int res){
		Stack<int[]> path = new Stack();
		int x = end[0];
		int y = end[1];{
		while(res != 0)
		for (int[] dir : directions) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if (nx < 0 || ny < 0 || 
					ny > 7|| nx > 7||
					board[nx][ny] != res - 1)
				continue;
			int[] temp = {nx, ny};
			path.push(temp);
			res--;
		}
		}
		return path;
	}

	public static Stack BFS(int[][] board, int[] origin, int[] end) {

		int m = board.length;
		int n = board[0].length;
		int res = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		queue.offer(origin[0] * n + origin[1]);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				visited.add(cur);
				int x = cur / n;
				int y = cur % n;
				if (x == end[0] && y == end[1])
					return path(board, end, res);

				for (int[] dir : directions) {
					int nx = x + dir[0];
					int ny = y + dir[1];
					if (nx < 0 || nx >= m || ny < 0 || ny >= n
							|| visited.contains(nx * n + ny)
							|| board[nx][ny] != 0)
						continue;
					queue.offer(nx * n + ny);
				}
			}
			res++;
		}
		return path(board, end, res - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[8][8];
		int[] origin = new int[] { 2, 0 };
		int[] end = new int[] { 3, 3 };
		Stack res = BFS(board, origin, end);
		System.out.println(res);
	}

}
