package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	private int[][] map = null;
	private int[] inQueue = null;
	private int[] ans = null;
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new int[numCourses][numCourses];
        inQueue = new int[numCourses];
        ans = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
        	if (map[prerequisites[i][1]][prerequisites[i][0]] == 0) {
        		map[prerequisites[i][1]][prerequisites[i][0]] = 1;
        		inQueue[prerequisites[i][0]]++;
        	}
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
        	if (inQueue[i] == 0) {
        		queue.add(i);
        	}
        }
        
        int runTime = 0;
        while (!queue.isEmpty()) {
        	Integer front = queue.poll();
        	ans[runTime++] = front;
        	for (int j = 0; j < numCourses; j++) {
        		if (map[front][j] == 1) {
        			if (--inQueue[j] == 0)
        				queue.add(j);
        		}
        	}
        }
        
        
        if (runTime == numCourses) {
        	return ans;
        } else {
        	return new int[0];
        }
    }
    
    public static void main(String[] args) {
    	CourseScheduleII a = new CourseScheduleII();
    	int[] ans = a.findOrder(2, new int[][]{{0, 1},{1, 0}});
    	System.out.println(Arrays.toString(ans));
    }
}
