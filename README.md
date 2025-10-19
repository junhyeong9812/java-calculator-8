# java-calculator-precourse

기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,), 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를
  기준으로 분리한 각 숫자의 합을 반환한다.
  ->
    1. 문자열에서 ,와 :를 파싱할 수 있는 기능
    2. 파싱한 문자를 기준으로 각 숫자를 각각의 배열로 담을 수 있는 기능
    3. 배열의 합을 반환하는 기능
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
  커스텀 구분자는 문자열 앞부분의 "//"와 "\n"사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며,
    결과 값은 6이 반환되어야 한다.
  ->
    1. 문자열에서 "//"와 "\n"에 대해서 정규식을 통한 두 문자 사이의 문자열 파싱 기능
    -> 그렇다면 ",",":",+@인 경우 분단자를 배열에 넣을 필요성이 존재.
    -> 해당 배열의 길이만큼 순차적 분리 및 해당 숫자 배열에 대해서 숫자의 순서를 정할 필요성 존재.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    1. 문자열을 탐색하여 숫자 및 커스텀 키에 대한 유니코드가 아닐 경우 예외처리를 발생시키는 기능

구현 순서 정리:
1. 문자열에서 ","와 ":"를 파싱할 수 있는 기능 구현(parsingDelimiter())
2. 파싱한 문자를 기준으로 각 숫자를 각각의 배열로 담을 수 있는 기능(addNumbersToArray())
3. 배열의 합을 반환하는 기능(sumNumbersInArray())
4. 문자열에서 "//"와 "\n"을 정규식을 통해 가운데 문자를 가져오는 기능 구현(extractBetweenDelimiters())
5. parsingDelimiter()를 extractBetweenDilimiters()에서 추출한 연산자와 ",", ":" 연산자를 파싱하여 존재하는 구분자를 배열(DelimiterArray[])에 넣도록 리팩토링
6. addNumbersToArray()에서 DelimiterArray[]를 통해 해당 값으로 값을 구분하여 배열로 담도록 리팩토링
7. 사용자가 입력한 값이 연산자 패턴이 아니면서 파싱된 구분자 외의 양수가 아닐 경우 IllegalArgumentException를 발생시키는 구조로 함수 리팩토링

@Test
@DisplayName("calculator() 함수 생성")
void createCalculator(){
String inputData = "//;\\n1;2;3";
app.calculator(inputData);
}

public Double calculator(String inputData){

    }

