package com.company.design;

import com.company.design.strategy.*;

// 전략 패턴
// 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아니라 전략만 변경, 유연하게 확장
// OCP와 DIP을 따른다.

// NormalStrategy, Base64Strategy, AppendStrategy : 전략 메서드를 가진 전략 객체
// Encoder : 전략 객체를 사용하는 컨텍스트
// Main : 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트

public class StrategyMain {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        //base64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }
}
