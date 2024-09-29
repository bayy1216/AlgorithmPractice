import java.util.stream.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        List<String> books = Arrays.stream(phone_book)
            .sorted((a,b)-> b.length()-a.length())
            .collect(Collectors.toList());
        
        for(String book: books){
            if(set.contains(book)){
                return false;
            }
            for(int i=0;i<book.length();i++){
                set.add(book.substring(0,i));
            }
        }
        
        
        
        return answer;
    }
    
//     public long makeFilter(String[] phone){
        
//     }
}