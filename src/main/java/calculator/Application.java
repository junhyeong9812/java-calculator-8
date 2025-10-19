package calculator;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        String inputData = Console.readLine();
        int result = application.calculator(inputData);
        System.out.println("결과 : " + result);

    }

    public int calculator(String inputData) {
        Set<String> delimiterArray=parsingDelimiter(inputData);
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(inputData);
        if(matcher.find()) {
            inputData = matcher.replaceAll("");
        }
        List<String> numbers = addNumbersToArray(delimiterArray,inputData);
        return sumNumbersInArray(numbers);

    }

    public Set<String> parsingDelimiter(String checkString) {
        Set<String> delimiterArray = new HashSet<>();
        String checkCustomDelimiters = extractBetweenDelimiters(checkString);
        if(!checkCustomDelimiters.isEmpty()) {
            delimiterArray.add(checkCustomDelimiters);
        }
        if(checkString.contains(",")) {
            delimiterArray.add(",");
        }
        if(checkString.contains(":")) {
            delimiterArray.add(":");
        }
        return delimiterArray;
    }

    public List<String> addNumbersToArray(Set<String> delimiterArray, String inputData) {
        for (String delimiter : delimiterArray) {
            inputData = inputData.replace(delimiter,",");
        }

        String[] numbers = inputData.split(",");
        return Arrays.asList(numbers);
    }

    public int sumNumbersInArray(List<String> numbers) {
        int sum = 0;
        for(String number: numbers){
            int value = Integer.parseInt(number);
            if (value< 0) {
                throw new IllegalArgumentException("음수는 안됩니다: "+value);
            }
            sum += value;
        }

        return sum;
    }

    public String extractBetweenDelimiters(String inputData) {
        String result="";
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(inputData);
        if(matcher.find()){
            result = matcher.group(1);

        }
        return result;
    }

}
