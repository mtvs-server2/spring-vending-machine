package com.ohgiraffers.common;

import com.ohgiraffers.machine.ContextConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class SnackDAOTests {

    @Autowired
    private SnackDAO snackDAO;

    @DisplayName("숫자 입력받았을 때 해당 간식 이름 출력")
    @Test
    public void testGetSnackNamebyNumber() {
        int number = 1;
        String name = snackDAO.findSnackbyNumber(number);

        assertEquals("초코", name);
    }

    @DisplayName("유효하지 않은 번호 입력 시 예외처리")
    @Test
    public void testExceptionWrongNumber() {
        int number = 5;

        assertThrows(ArithmeticException.class, () -> snackDAO.findSnackbyNumber(number));
    }

}
