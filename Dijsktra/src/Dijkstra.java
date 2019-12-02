import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Dijkstra {

    private static final int POSITIVE_INFINITY = 99999999;  //代表无穷大

    public static void main(String[] args) throws IOException {
        File inFile = new File("data.in");

        Scanner Scan = new Scanner(inFile);
        int n = Scan.nextInt();  //读取点的个数
        //初始化二维数组
        int graph[][] = new int[n+1][n+1];
        int path[] = new int[n+1];  //存当前序号对应节点路径的前面节点
        int cost[] = new int[n+1];  //从开始点到该点的距离
        int result_cost[] = new int[n+1]; //最终的距离
        int min_cost = POSITIVE_INFINITY;
        int min_pos = 1;  //最小节点的序号
        int start = Scan.nextInt();  //开始的节点

        //读取邻接矩阵表示法的矩阵
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int x = Scan.nextInt();
                if (x != -1){    //x=-1指的是两点之间没有连线
                    graph[i][j] = x;
                }
                else graph[i][j] = POSITIVE_INFINITY;
            }
        }


        //从节点start开始，初始化cost
        for (int i = 1; i <= n; i++) {
            cost[i] = graph[start][i];
            if (cost[i] != POSITIVE_INFINITY) {
                path[i] = start;
            }
        }
        graph = rewrite(graph, n, start);

        while (!AllDone(cost, n)) {
            min_cost = POSITIVE_INFINITY;
            //找到当前节点中最小耗散值的点
            for (int i = 1; i <= n; i++) {
                if (cost[i] < min_cost) {
                    min_cost = cost[i];
                    min_pos = i;
                }
            }
            result_cost[min_pos] = cost[min_pos];  //把当前最短路径存距离到result数组里
            cost[min_pos] = POSITIVE_INFINITY;

            graph = rewrite(graph, n, min_pos);
            //更新距离
            for (int i = 1; i <= n ; i++) {
                if (graph[min_pos][i] != POSITIVE_INFINITY ) {
                    if (cost[i] == POSITIVE_INFINITY) {
                        cost[i] = min_cost + graph[min_pos][i];
                        path[i] = min_pos;
                    }
                    else if ((min_cost + graph[min_pos][i]) < cost[i]) {
                        cost[i] = min_cost + graph[min_pos][i];
                        path[i] = min_pos;
                    }
                }
            }

        }

        for (int i = 1; i < n + 1; i++) {
            if (i == start) continue;
            System.out.println();
            if (path[i] == 0) {
                System.out.println("无从" + start + "到" + i + "的最短路径");
            }
            else {
                //通过栈将路径存下来
                Stack<Integer>result_path = new Stack<>();
                int pos = i;
                while (path[pos] != start) {
                    result_path.push(path[pos]);
                    pos = path[pos];
                }
                result_path.push(start);
                System.out.print("从" + start + "到" + i + "的最短路径：");
                while (!result_path.empty()){
                    System.out.print(result_path.pop() + " -> ");
                }
                System.out.println(i);
                System.out.println("最短路径距离：" + result_cost[i]);
            }
        }
    }

    //对于已经遍历的节点，把它做为边的终点的值设为无穷大
    private static int [][]rewrite(int graph[][], int n, int y) {
        for (int i = 1; i < n + 1; i++) {
            graph[i][y] = POSITIVE_INFINITY;
        }
        return graph;
    }

    //判断是否全部路径已经遍历完成
    private static boolean AllDone (int cost[], int n){
        for (int i = 1; i < n +1; i++) {
            if (cost[i] != -1 && cost[i] !=POSITIVE_INFINITY) {
                return false;
            }
        }
        return true;
    }
}
