package com.ohgiraffers.common;

import com.ohgiraffers.machine.ContextConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes={ContextConfiguration.class})
public class SnackDAOTests {

    @Autowired
    private SnackDAO snackDAO;

    @Test // (){} 메소드 생성
    public void TestReturnMoney(){

        //given, 어떤 데이터가 준비되었나요?
        int myMoney = 3000;


        //when
        // 1.
        Snack foundSnack = snackDAO.findSnackBySequence(1);
        System.out.println(foundSnack);

        // 2.
        int snackPrice = foundSnack.getPrice();
        System.out.println(snackPrice);

        // 3. 잔돈 받기
        int returnMoney = snackDAO.returnMoney(myMoney, snackPrice);
        System.out.println(returnMoney);


        //then, 이러한 결과가 나와야 한답니다.
        assertEquals(1000, returnMoney);

    }

    @DisplayName("잔돈을 올바르지 않게 반환하는지 확인...")
    @Test
    public void ReturnMoney(){

        //given
        int myMoney =500;

        //when
        Snack foundSnack = snackDAO.findSnackBySequence(2);
        System.out.println(foundSnack);

        int snackPrice = foundSnack.getPrice();
        System.out.println(snackPrice);


        //then (예외처리)
        assertThrows(IllegalArgumentException.class,
                ()->snackDAO.returnMoney(myMoney,snackPrice));





    }


}