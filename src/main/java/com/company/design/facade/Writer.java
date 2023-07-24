package com.company.design.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Writer %s로 연결합니다.", fileName);
        System.out.println(msg);
    }
    public void fileWriter() {
        String msg = String.format("Writer %s로 파일 쓰기를 합니다.", fileName);
        System.out.println(msg);
    }
    public void fileDisConnect() {
        String msg = String.format("Writer %s로 연결합니다.", fileName);
        System.out.println(msg);
    }
}
