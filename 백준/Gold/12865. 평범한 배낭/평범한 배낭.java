import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        var br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        Bag[] bags = new Bag[N];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            arr = input.split(" ");
            int weight = Integer.parseInt(arr[0]);
            int money = Integer.parseInt(arr[1]);
            bags[i] = new Bag(weight, money);
        }

        solution(N, K, bags);
    }

    public static void solution(int N, int K, Bag[] bags) {
        int[][] dp = new int[N+1][K+1];

        for(int bagIndex=0; bagIndex<=N; bagIndex++){
            for(int weight=0;weight<=K;weight++){

                if(bagIndex==0 || weight ==0){
                    dp[bagIndex][weight] = 0;
                }else if(bags[bagIndex-1].weight <= weight){ //현재 짐을 다룰수 있을때

                    int currWeight = bags[bagIndex-1].weight;

                    int prev = weight-currWeight >=0  // outOfIndex
                        ? dp[bagIndex-1][weight-currWeight]
                        : 0;

                    int select = prev + bags[bagIndex-1].money;;
                    int notSelect = dp[bagIndex-1][weight];

                    dp[bagIndex][weight] = Math.max(notSelect, select);
                }else{ //이전 짐까지의 가격 그대로
                    dp[bagIndex][weight] = dp[bagIndex-1][weight];
                }
            }
        }


        int answer = dp[N][K];
        System.out.println(answer);
    }

    public static class Bag {
        int weight;
        int money;

        public Bag(int weight, int money) {
            this.weight = weight;
            this.money = money;
        }
    }
}