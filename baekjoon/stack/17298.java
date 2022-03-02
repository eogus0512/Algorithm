import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        str = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for(int i=0;i<N;i++) {
            while(!stack.empty() && arr[stack.peek()]<arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            arr[stack.pop()] = -1;
        }
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}