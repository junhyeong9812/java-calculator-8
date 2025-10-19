package calculator;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


    };

    public Double calculator(String inputData){
        Set<String> delimiterArray=parsingDelimiter(inputData);
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(inputData);
        if(matcher.find()){
            inputData = matcher.replaceAll("");
        }
        List<String> numbers = addNumbersToArray(delimiterArray,inputData);
        Double result = sumNumbersInArray(numbers);
        return result;
    }


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
            Double value = Double.parseDouble(number);
            if (value< 0){
                throw new IllegalArgumentException("음수는 안됩니다: "+value);
            }
            sum += value;
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
