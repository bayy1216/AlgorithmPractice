class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr2[0].length;
        
        int[][] answer = new int[a][b];
        
        for(int x=0;x<a;x++){
            for(int y=0;y<b;y++){
                for (int t=0;t<arr1[0].length; t++){
                    answer[x][y] += arr1[x][t]*arr2[t][y];
                }
            }
        }
        
        return answer;
    }
}