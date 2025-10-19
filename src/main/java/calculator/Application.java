package calculator;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


    };


    public Set<String> parsingDelimiter(String checkString){
        Set<String> delimiterArray = new HashSet<>();
        String checkCustomDelimiters = extractBetweenDelimiters(checkString);
        if(!checkCustomDelimiters.equals("")){
            delimiterArray.add(checkCustomDelimiters);
        }
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

    public Double sumNumbersInArray(List<String> numbers){
        Double sum = 0.0;
        for(String number: numbers){
            sum += Double.parseDouble(number);
        }

        return sum;
    }

    public String extractBetweenDelimiters(String inputData){
        String result="";
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(inputData);
        if(matcher.find()){
            result = matcher.group(1);
        }
        return result;
    }


}
