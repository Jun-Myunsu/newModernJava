package org.example.filepath;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
ByteBuffer만이 Direct Buffer가 가능!
ByteBuffer.allocateDirect()메소드를 사용해야 Direct Buffer가 생성됨!

1.2 ByteBuffer의 네 가지 포인터
- position : 현재 읽을 위치나 쓸 위치를 가르킴
- limit : 현재 ByteBuffer의 유효한 쓰기 위치나 유효한 읽기 위치를 나타냄.
- capacity : ByteBuffer의 용량을 나타냄, 따라서 항상 ByteBuffer의 맨 마지막을 가르킴
- mark : 사용자가 마음대로 지정할 수 있음, 특별히 위치를 기억하고 있다가 다음에 되돌아가야할 때 사용

2. NIO의 Channel 클래스
- Channel은 직접 인스턴스화 할 수기 없다.
- OutputStream/InputStream에서 만들어야 한다.

ps) RandomAccessFile
 */

public class JavaNioFile {
    public static void main(String... ars) throws IOException {
//        1.1. ByteBuffer 생성 방법!
//        ByteBuffer buf1 = ByteBuffer.allocate(10);          // direct buffer를 이용하는 것이 아님.
//        ByteBuffer buf2 = ByteBuffer.allocateDirect(10);    // 커널 버퍼를 직접 다루는 버퍼!
//        buf2.clear();

        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("output.txt");
        ByteBuffer buf = ByteBuffer.allocateDirect(10);
        FileChannel cin = fis.getChannel();
        FileChannel cout = fos.getChannel();
        cin.read(buf); // channel에서 읽어 buf에 저장!
        buf.flip();
        cout.write(buf); // buf의 내용을 channel에 저장!

        cout.close();
        cin.close();
        fos.close();
        fis.close();

        RandomAccessFile raf = new RandomAccessFile("sample.txt", "rw");
        FileChannel channel = raf.getChannel();
        buf.clear();
        raf.seek(10); // 파일의 10째 바이트로 파일포인터 이동
        channel.read(buf); // channel에서 읽어 buf에 저장!buf.flip();
        raf.seek(40);    // 파일의 40째 바이트로 파일포인터 이동
        channel.write(buf); // buf의 내용을 channel에 저장!
        channel.close();
        raf.close();
    }
}
