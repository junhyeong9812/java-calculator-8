package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationImplTest {

    Application app = new Application();

    // 1. 문자열에서 ","와 ":"를 파싱할 수 있는 기능 구현(parsingDelimiter())
    @Test
    @DisplayName("parsingDelimiter() 함수 생성")
    void createParsingDelimiter(){
        app.parsingDelimiter("1,2,3");
    }

    @Test
    @DisplayName("문자열을 받았을 때 ','나 ':'의 존재 유무를 배열에 반환")
    void recognizeDelimiter(){
        Set<String> delimiterArray=app.parsingDelimiter("1,2:3");
        Set<String> commaDelimiterArray =app.parsingDelimiter("1,2,3");
        Set<String> colonDelimiterArray =app.parsingDelimiter("1:2:3");

        assertThat(delimiterArray.size()).isEqualTo(2);
        assertThat(commaDelimiterArray.size()).isEqualTo(1);
        assertThat(colonDelimiterArray.size()).isEqualTo(1);
    }

    // 2. 파싱한 문자를 기준으로 각 숫자를 각각의 배열로 담을 수 있는 기능(addNumbersToArray())
    @Test
    @DisplayName("addNumbersToArray() 함수 생성")
    void createAddNumbersToArray() {
        Set<String> delimiterArray = new HashSet<>();
        delimiterArray.add(",");
        String inputData = "1,2,3";
        app.addNumbersToArray(delimiterArray,inputData);
    }

    @Test
    @DisplayName("addNumbersToArray() 함수에서 파싱한 문자를 기준으로 각 숫자를 각각 배열에 담을 수 있다.")
    void addNumbersToArray_shouldSplitNumbersByParseDelimiter() {

        Set<String> delimiterCommaArray = new HashSet<>();
        delimiterCommaArray.add(",");
        String inputDataComma = "1,2,3";
        List<String> resultComma=app.addNumbersToArray(delimiterCommaArray,inputDataComma);

        Set<String> delimiterColonArray = new HashSet<>();
        delimiterColonArray.add(":");
        String inputDataColon = "1:2:3";
        List<String> resultColon=app.addNumbersToArray(delimiterColonArray,inputDataColon);

        Set<String> delimiterAllArray = new HashSet<>();
        delimiterAllArray.add(",");
        delimiterAllArray.add(":");
        String inputAllData = "1,2:3";
        List<String> resultAll=app.addNumbersToArray(delimiterAllArray,inputAllData);

        assertThat(resultComma).containsExactly("1","2","3");
        assertThat(resultColon).containsExactly("1","2","3");
        assertThat(resultAll).containsExactly("1","2","3");
    }

    // 3. 배열의 합을 반환하는 기능(sumNumbersInArray())
    @Test
    @DisplayName("sumNumbersInArray() 함수 생성")
    void createsumNumbersInArray(){
        app.sumNumbersInArray(new ArrayList<>());
    }

    @Test
    @DisplayName("sumNumbersInArray()를 통해 배열의 합을 구할 수 있다.")
    void sumNumbersInArrayTest(){
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        Double result = app.sumNumbersInArray(numbers);
        assertThat(result).isEqualTo(6.0);
    }

}