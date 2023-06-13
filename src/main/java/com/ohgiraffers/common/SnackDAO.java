package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.HashMap;

@Repository
public class SnackDAO {
    private final HashMap<Integer, Snack> snackMap;

    public SnackDAO(){
        this.snackMap = new HashMap<>();

        this.snackMap.put(1, new Snack(1, "초코", 2000));
        this.snackMap.put(2, new Snack(2, "바닐라", 2000));
        this.snackMap.put(3, new Snack(3, "딸기", 2000));
        this.snackMap.put(4, new Snack(4, "사브레", 2000));
    }



    public Snack findSnackBySequence(int sequence) {
        return snackMap.get(sequence);
    }

    public int returnMoney(int myMoney, int snackPrice) {
        if (myMoney < snackPrice){
            throw new IllegalArgumentException("돈이 부족합니다...");
        }
        return myMoney - snackPrice;
    }
}

    // 간식 번호를 받아 이름 반환
    //유효하지 않은 번호일시 예외처리(ArithmeticException)
    public String findSnackbyNumber(int number){
        // 키값이 5 이상일때
        try {
            if (number > 4 || number < 1) {
                throw new ArithmeticException("1~4 사이의 번호를 입력해주세요");
            }
            else
               return snackMap.get(number).getSnackName();
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
            throw new ArithmeticException();
        }
    }
}

