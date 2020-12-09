package algorithm06_20;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * You have a map that marks the location of a treasure island. Some of the map
 * area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
 * There are other explorers trying to find the treasure. So you must figure out
 * a shortest route to the treasure island.
 * 
 * Assume the map area is a two dimensional grid, represented by a matrix of
 * characters. You must start from the top-left corner of the map and can move
 * one block up, down, left or right at a time. The treasure island is marked as
 * X in a block of the matrix. X will not be at the top-left corner. Any block
 * with dangerous rocks or reefs will be marked as D. You must not enter
 * dangerous blocks. You cannot leave the map area. Other areas O are safe to
 * sail in. The top-left corner is always safe. Output the minimum number of
 * steps to get to the treasure.
 * 
 * Example:
 * 
 * Input: [['O', 'O', 'O', 'O'], ['D', 'O', 'D', 'O'], ['O', 'O', 'O', 'O'],
 * ['X', 'D', 'D', 'O']]
 * 
 * Output: 5 Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3,
 * 0) The minimum route takes 5 steps.
 **/
public class TreasureIsland {
	int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	class Node {
		int r;
		int c;

		public Node() {
		}

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public int minRouteStep(char[][] routes) {
		Queue<Node> queue = new LinkedList<Node>();
		routes[0][0] = 'D';
		queue.add(new Node(0, 0));
		int steps = 0;

		while (!queue.isEmpty()) {
			steps++;
			for (int i = queue.size(); i >0; i--) {
				Node node = queue.poll();
				for (int[] d : directions) {
					int r = node.r + d[0];
					int c = node.c + d[1];
					if (!isSafe(routes, r, c)) {
						continue;
					}

					if (routes[r][c] == 'X') {
						return steps;
					}
					routes[r][c] = 'D';
					queue.add(new Node(r, c));
				}
			}
		}
		return -1;
	}

	public int minRouteStep2(char[][] grid) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0));
		grid[0][0] = 'D'; // mark as visited
		for (int steps = 1; !q.isEmpty(); steps++) {
			for (int sz = q.size(); sz > 0; sz--) {
				Node p = q.poll();

				for (int[] dir : directions) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];

					if (isSafe(grid, r, c)) {
						if (grid[r][c] == 'X')
							return steps;
						grid[r][c] = 'D';
						q.add(new Node(r, c));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isSafe(char[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
	}

	public static void main(String[] args) {
		char[][] routes = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
		TreasureIsland island = new TreasureIsland();
		int steps = island.minRouteStep(routes);
		System.out.println("Steps: " + steps);
	}
}
