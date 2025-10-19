package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationImplTest {

    Application app = new Application();

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
}