import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String x= br.readLine();
        var st = new StringTokenizer(x);
        int dap = 0;
        while (st.hasMoreTokens()){
            var xa = st.nextToken();
            dap++;
        }
        System.out.println(dap);
    }
}
