package practice.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindMart {

    public static void main(String[] args) {
        FindMart findMart = new FindMart();

        System.out.println(Arrays.deepToString(findMart.solution(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        })));

        System.out.println(Arrays.deepToString(findMart.solution(new int[][]{
                {1, 1, 1},
                {0, 0, 0},
                {1, 1, 1}
        })));
    }

    /**
     * 아파트(1) 과 마트 (0) 으로 이루어진 지도를 받아 아파트와 마트 사이의 거리를 나타내는 지도를 반환. <p/> 아파트가 위치한 곳은 해당 위치로부터 가장 가까운
     * 마트 까지의 거리를, 마트가 위치한 곳은 0을 삽입함. <p/> 입출력 예시)
     * <pre>
     *      [[0, 1, 0],         [[0, 1, 0],
     *       [1, 1, 1],    ->    [1, 2, 1],
     *       [0, 1, 1]]          [0, 1, 2]]
     *  </pre>
     *
     * @param city - 아파트(1) 과 마트 (0) 으로 이루어진 지도
     * @return map - 아파트와 마트 사이의 거리를 나타내는 지도
     */
    public int[][] solution(int[][] city) {
        int[][] map = new int[city.length][city[0].length];

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[0].length; j++) {
                if (city[i][j] == 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[0].length; j++) {
                if (city[i][j] != 0) {
                    map[i][j] = getDistance(map, i, j);
                }
            }
        }

        return map;
    }

    private int getDistance(int[][] city, int row, int col) {
        int distance = 0;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[city.length][city[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        int cachedDistance = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) {
                continue;
            }

            visited[cur[0]][cur[1]] = true;
            distance++;

            for (int[] direction : directions) {
                int nextRow = cur[0] + direction[0];
                int nextCol = cur[1] + direction[1];

                if (nextRow < 0 || nextRow >= city.length || nextCol < 0
                        || nextCol >= city[0].length) {
                    continue;
                }

                if (city[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    return distance;
                } else if (city[nextRow][nextCol] > 0) {
                    cachedDistance = city[nextRow][nextCol] + 1;
                } else {
                    queue.add(new int[]{nextRow, nextCol});
                }
            }

            if (cachedDistance > 0) {
                return cachedDistance;
            }
        }

        return distance;
    }
}
