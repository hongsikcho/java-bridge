package bridge.Validator;

import bridge.Validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("입력값이 숫자가 아닐 시 false 리턴")
    @ParameterizedTest
    @ValueSource(strings = {"r","r2","2r"," ",""})
    void inputNotNumber(String input){
        assertThat(InputValidator.checkOnlyNumber(input)).isFalse();
    }

    @DisplayName("입력값이 유효범위 숫자가 아닐 시 false 리턴")
    @ParameterizedTest
    @ValueSource(strings = {"123","2",})
    void inputNotBoundaryNumber(String input){
        assertThat(InputValidator.checkBoundaryNumber(input)).isFalse();
    }

//    @DisplayName("입력값이 유효범위숫자가 아닐 시 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"123","2",""})
//    void inputBoundaryNumber(String input){
//        assertThatThrownBy(() -> InputValidator.checkBridgeSize(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("입력값이 'U' 또는 'D'가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R","F","","2"})
    void inputAnotherMoving(String input){
        assertThatThrownBy(() -> InputValidator.checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 'R' 또는 'Q'가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"D","F","","2"})
    void inputAnotherRetry(String input){
        assertThatThrownBy(() -> InputValidator.checkRetry(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
