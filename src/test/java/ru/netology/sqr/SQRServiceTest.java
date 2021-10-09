package ru.netology.sqr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SQRServiceTest<two, one> {
    @ParameterizedTest
    @CsvSource(value = {"'another limits',100,250,6",
            "'increased limits not include range 10-99',10000,290000,0",
            "'decreased limits not include range 10-99',1,99,0",
            "'limits include all range 10-99',100,10000,90",
            "'limits include only one value',200,225,1",
            "'small limit',200,201,0",
            "'zero limits',0,0,0"})
    void shouldCalculate(String testName, int one, int two, int expected) {
        SQRService service = new SQRService();

        int actual = service.sqrtCount(one, two);


        assertEquals(expected, actual);
    }
}