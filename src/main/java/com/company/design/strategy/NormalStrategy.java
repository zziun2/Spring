package com.company.design.strategy;

import java.util.Base64;

public class NormalStrategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return text;
    }
}
