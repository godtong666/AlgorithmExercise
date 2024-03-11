package com.godtong.matrix.p54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        //定义上下左右的边界
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            //向右移动直到最右
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }

            //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            if (++u > d) break;

            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }

            //重新设定有边界
            if (--r < l) break;

            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }

            //重新设定有边界
            if (--d < u) break;

            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }

            //重新设定有边界
            if (++l > r) break;
        }
        return res;
    }
}
