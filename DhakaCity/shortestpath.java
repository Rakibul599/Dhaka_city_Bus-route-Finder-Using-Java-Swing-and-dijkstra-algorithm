package DhakaCity;

import java.util.Arrays;
import java.util.Stack;

public class shortestpath {
    static int[][] arr = new int[100][100];
    static int Node;
    static int[] value = new int[100];
    static boolean[] prossed = new boolean[100];
    static int[] parrent = new int[100];
    static int total_cost=0;


    static int minmumVertex(int value[], boolean prossed[]) {
        total_cost=0;
        int minimum = Integer.MAX_VALUE;
        int vert = -1;
        for (int i = 0; i < Node; i++) {
            if (value[i] < minimum && !prossed[i]) {
                vert = i;
                minimum = value[i];
            }
        }
        return vert;
    }

    static int[] dijkstra(int[][] arr, int src, int dst, int node, int edge) {
        Node=node;
        for (int i = 0; i < node; i++) {
            value[i] = Integer.MAX_VALUE;
            prossed[i] = false;
        }
        for (int i = 0; i < node; i++) {
            parrent[i] = -1;
        }
        parrent[src] = src;
        value[src] = 0;
        for (int i = 0; i < node - 1; i++) {
            int u = minmumVertex(value, prossed);
            prossed[u] = true;
            for (int j = 0; j < node; ++j) {
                if (arr[u][j] != 0 && !prossed[j] && value[u] != Integer.MAX_VALUE && arr[u][j] + value[u] < value[j]) {
                    value[j] = arr[u][j] + value[u];
                    parrent[j] = u;
                }
            }
        }
        System.out.println("Shortest Path");
        for (int i = 0; i < node; i++) {
            System.out.println("U>>V" + " " + parrent[i] + ">>" + i + " " + "w=" + arr[parrent[i]][i]);
        }
        System.out.println("Shortest path with destination");
        int current=dst;
        int[] res=new int[100];
        int c=0;
        while (current!=src)
        {
            res[c++]=current;
            total_cost+=arr[parrent[current]][current];
            current=parrent[current];
        }
        res[c]=src;

        return Arrays.copyOf(res,c+1);


    }
    public int GetKilomiter()
    {
        return total_cost;
    }


}
