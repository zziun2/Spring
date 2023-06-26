package com.company.design.adapter;

// alt + enter = 자동 오버라이드
public class AirConditioner implements Electronic220V{

    @Override
    public void connect() {
        System.out.println("에어컨 220v on");
    }
}
