package converters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTests {
    private static Stream<Arguments> intsToConvert() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(6, "VI"),
                Arguments.of(10, "X"),
                Arguments.of(42, "XLII"),
                Arguments.of(58, "LVIII"),
                Arguments.of(101, "CI"),
                Arguments.of(2022, "MMXXII")
        );
    }

    @ParameterizedTest
    @MethodSource("intsToConvert")
    void convert_int_should_return_its_roman_representation(int number, String expected) {
        assertThat(RomanNumerals.convertToRoman(number))
                .isEqualTo(expected);
    }
}