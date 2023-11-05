package com.houseRent.service;

import com.houseRent.domian.House;

public class HouseService {

    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];

        houses [0] = new House(1,"lihua", "12356",
                "fzu", 2000,"未出租");
    }

    public House[] list () {
        return houses;
    }

    public boolean add (House newHouse) {
        if(houseNums == houses.length) {
            System.out.println("\t\t房源已满，不可继续添加\t\t");
            return false;
        }

        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;

    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }

        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;

        return true;
    }
    
    public House findById(int findId) {
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;
    }
}
