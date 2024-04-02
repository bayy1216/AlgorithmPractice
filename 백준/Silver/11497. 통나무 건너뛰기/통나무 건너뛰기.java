import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine());
            var list = new ArrayList<Integer>();
            for(int x=0;x<n;x++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            System.out.println(solve(n, list));
        }
    }
    public static int solve(int n, List<Integer> ary){
        Deque<Integer> deque = new ArrayDeque<>();
        Collections.sort(ary);
        int dap = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                deque.addFirst(ary.get(i));
            }else{
                deque.addLast(ary.get(i));
            }
        }


        int first = deque.pop();
        int prev = first;

        for(int i=0;i<n-1;i++){
            int curr = deque.pop();
            dap = Math.max(dap, Math.abs(prev-curr));
            prev = curr;
        }
        dap = Math.max(dap, Math.abs(first-prev));




        return dap;
    }
}
