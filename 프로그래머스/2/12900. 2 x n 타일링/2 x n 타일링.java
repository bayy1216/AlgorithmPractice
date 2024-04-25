class Solution {
    public int solution(int n) {
        int ary[] = new int[n+1];
        ary[1] = 1;
        ary[2] = 2;
        for(int i=3;i<=n;i++){
            ary[i] = (ary[i-2] + ary[i-1]) % 1_000_000_007;
        }
        return ary[n];
    }
}