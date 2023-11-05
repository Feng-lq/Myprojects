package com.houseRent.view;

import com.houseRent.domian.House;
import com.houseRent.service.HouseService;
import com.houseRent.utils.Utility;

public class HouseView {

    private boolean flag = true;
    private char k = ' ';
    private HouseService houseService = new HouseService(10);
    public void mainMenu() {
        while (flag) {
            System.out.println("\t\t------房屋出租系统------\t\t");
            System.out.println("\t\t\t1 新 增 房 源\t\t\t");
            System.out.println("\t\t\t2 查 找 房 屋\t\t\t");
            System.out.println("\t\t\t3 删 除 房 屋 信 息\t\t\t");
            System.out.println("\t\t\t4 修 改 房 屋 信 息\t\t\t");
            System.out.println("\t\t\t5 房 屋 列 表\t\t\t");
            System.out.println("\t\t\t6 退      出\t\t\t");
            System.out.println("\t\t\t请输入选择(1-6)\t\t\t");

            k = Utility.readChar();
            switch (k) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        }

    }

    public void listHouses() {
        System.out.println("\t\t------房屋出租系统------\t\t");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("\t\t------房屋列表显示完毕------\t\t");
    }

    public void addHouse() {
        System.out.println("\t\t------添加房屋信息------\t\t");
        System.out.print("姓名: ");
        String name = Utility.readString(10);
        System.out.print("电话: ");
        String phone = Utility.readString(11);
        System.out.print("地址: ");
        String address = Utility.readString(20);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态(已租出，未租出): ");
        String state = Utility.readString(3);

        House newHouse = new House(0, name, phone,
                address, rent, state);

        if (houseService.add(newHouse)) {
            System.out.println("\t\t------房屋添加成功------\t\t");
        } else {
            System.out.println("\t\t------房屋添加失败------\t\t");
        }

    }

    public void delHouse() {
        System.out.println("\t\t------删除房屋信息------\t\t");
        System.out.println("请输入待删除房屋的编号(-1退出): ");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("\t\t------放弃删除房屋信息------\t\t");
            return;
        }

        char choice = Utility.readConfirmSelection();
        if (choice == 'y') {
           if(houseService.del(delId)) {
               System.out.println("\t\t------删除房屋信息成功------\t\t");
           } else {
               System.out.println("\t\t----房屋编号不存在，删除失败----\t\t");
           }
        } else {
            System.out.println("\t\t------放弃删除房屋信息------\t\t");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'y') {
            flag = false;
        }
    }

    public void findHouse() {
        System.out.println("\t\t------查找房屋信息------\t\t");
        System.out.print("请输入要查找的房屋编号: ");
        int findId = Utility.readInt();

        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
            System.out.println("\t\t------查找成功------\t\t");
        } else {
            System.out.println("\t\t----房屋编号不存在，查找失败----\t\t");
        }
    }

    public void update() {
        System.out.println("\t\t------修改房屋信息------\t\t");
        System.out.print("请输入要修改的房屋编号(-1表示退出): ");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("\t\t------放弃修改------\t\t");
            return;
        }

        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("\t\t----房屋编号不存在，修改失败----\t\t");
            return;
        }

        System.out.print("姓名("+house.getName()+"): ");
        String name = Utility.readString(10,"");
        if(!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话("+house.getPhone()+"): ");
        String phone = Utility.readString(11,"");
        if(!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址("+house.getAddress()+"): ");
        String address = Utility.readString(20,"");
        if(!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("月租("+house.getRent()+"): ");
        int rent = Utility.readInt(-1);
        if(rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态("+house.getState()+"): ");
        String state = Utility.readString(3,"");
        if(!"".equals(state)) {
            house.setState(state);
        }

        System.out.println("\t\t------修改成功------\t\t");
    }
}
