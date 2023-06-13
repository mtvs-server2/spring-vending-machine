package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

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


}
