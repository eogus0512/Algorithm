import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void floydWarshall() {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i!=j) {
                    for (int k=1;k<=n;k++) {
                        if (j!=k && i!=k && distance[j][i]!=INF && distance[i][k]!=INF) {
                            if (distance[j][k] > distance[j][i] + distance[i][k]) {
                                distance[j][k] = distance[j][i] + distance[i][k];
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int min = INF;
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        distance = new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int i=0;i<m;i++) {
            String[] str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            if (distance[a][b]>c) {
                distance[a][b] = c;
            }
        }
        floydWarshall();
        for (int i=1;i<=n;i++) {
            for (int j=0;j<n;j++) {
                if (i!=j && distance[i][j]!=INF && distance[j][i]!=INF) {
                    if (min > distance[i][j] + distance[j][i]) {
                        min = distance[i][j] + distance[j][i];
                    }
                }
            }
        }
        if (min == INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}