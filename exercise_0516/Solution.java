package exercise.exercise_0516;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
/*
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return result;
        }
        int row_up = 0;
        int row_down = matrix.length-1;
        int col_left = 0;
        int col_right = matrix[0].length-1;
        while(row_up <= row_down && col_left <= col_right){
            for(int j=col_left; j<=col_right; j++){
                result.add(matrix[row_up][j]);
            }
            for(int i=row_up+1; i<row_down; i++){
                result.add(matrix[i][col_right]);
            }
            if(row_up != row_down){
                for(int j=col_right; j>=col_left; j--){
                    result.add(matrix[row_down][j]);
                }
            }
            if(col_left != col_right){
                for(int i=row_down-1; i>row_up; i--){
                    result.add(matrix[i][col_left]);
                }
            }
            row_up++;
            row_down--;
            col_left++;
            col_right--;
        }
        return result;
    }
}
*/

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
/*
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k = 1;//填写的数字
        int row_up = 0;
        int row_down = n-1;
        int col_left = 0;
        int col_right = n-1;
        while(row_up <= row_down && col_left <= col_right){
            for(int j=col_left; j<=col_right; j++){
                result[row_up][j] = k++;
            }
            for(int i=row_up+1; i<row_down; i++){
                result[i][col_right] = k++;
            }
            if(row_up != row_down){
                for(int j=col_right; j>=col_left; j--){
                    result[row_down][j] = k++;
                }
            }
            if(col_left != col_right){
                for(int i=row_down-1; i>row_up; i--){
                    result[i][col_left] = k++;
                }
            }
            row_up++;
            row_down--;
            col_left++;
            col_right--;
        }
        return result;
    }
}
*/

/*
62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 */
/*
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <=0 || n<=0){
            return 0;
        }
        int[][] num = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(i==0 || j==0){
                    num[i][j] = 1;
                }else{
                    num[i][j] = num[i][j-1] + num[i-1][j];
                }
            }
        }
        return num[m-1][n-1];
    }
}
*/

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length ==0 ||
                obstacleGrid[0].length==0){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] num = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(obstacleGrid[i][j] == 1){//障碍物
                    num[i][j] = 0;
                }else if(i == 0 && j == 0){
                    num[i][j] = 1;
                }else if(i == 0){
                    num[i][j] = num[i][j-1];
                }else if(j == 0){
                    num[i][j] = num[i-1][j];
                }else{
                    num[i][j] = num[i-1][j] + num[i][j-1];
                }
            }
        }
        return num[row-1][col-1];
    }
}