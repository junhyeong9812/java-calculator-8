package calculator;


import java.util.*;

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

    public List<String> addNumbersToArray(Set<String> delimiterArray, String inputData){
        for (String delimiter : delimiterArray){
            inputData = inputData.replace(delimiter,",");
        }

        String[] numbers = inputData.split(",");
        return Arrays.asList(numbers);
    }


}
