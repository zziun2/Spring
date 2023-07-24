package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;

public class FacadeMain {
    public static void main(String[] args) {
        // 퍼사드 이용 x
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWriter();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        writer.fileDisConnect();
        reader.fileDisConnect();
        ftpClient.disConnect();

        // 퍼사드 이용 O
        SftpClient sftpClient = new SftpClient("www.facade.co.kr", 22, "/home/etc", "facade.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();



    }
}
