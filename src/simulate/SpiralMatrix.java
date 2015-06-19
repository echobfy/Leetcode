package simulate;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();

		if (matrix.length == 0)
			return ans;

		int xs = 0, xe = matrix[0].length - 1;
		int ys = 0, ye = matrix.length - 1;
		int total = (xe + 1) * (ye + 1);
		System.out.println(total);

		int num = 0;
		boolean flag = false;
		while (true) {
			for (int i = xs; i <= xe; i++) {
				ans.add(matrix[ys][i]);
				if (++num == total) {
					flag = true;
					break;
				}
			}
			if (flag == true)
				break;
			ys++;
			for (int i = ys; i <= ye; i++) {
				ans.add(matrix[i][xe]);
				if (++num == total) {
					flag = true;
					break;
				}
			}
			if (flag == true)
				break;
			xe--;
			for (int i = xe; i >= xs; i--) {
				ans.add(matrix[ye][i]);
				if (++num == total) {
					flag = true;
					break;
				}
			}
			if (flag == true)
				break;
			ye--;
			for (int i = ye; i >= ys; i--) {
				ans.add(matrix[i][xs]);
				if (++num == total) {
					flag = true;
					break;
				}
			}
			xs++;
			System.out.println(ans);
			if (flag == true)
				break;

		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2 } };
		spiralOrder(mat);
	}
}
