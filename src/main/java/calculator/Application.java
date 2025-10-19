package calculator;


import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


    };
    public Set<String> parsingDelimiter(String checkString){
        Set<String> delimiterArray = new HashSet<>();
        if(checkString.contains(",")){
            delimiterArray.add(",");
        }
        if(checkString.contains(":")){
            delimiterArray.add(":");
        }
        return delimiterArray;
    };


}
