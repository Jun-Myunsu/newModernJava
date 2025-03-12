package org.example.filepath;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
java.nio.file.Paths
String .toSring()
Path .getRoot() : Root 주소를 가진 Path 객체 생성
Path .getParent() : 부모 주소를 가진 Path 객체 생성
Path .getNameCount() : 루트주소 다음부터 몇 개의 계층으로 이루어져 있는지 갯수 반환
Path .normalize() : 정규화된 경로를 가진 Path 객체 생성
 */

public class JavaPath {
    public static void main(String... ars) {
        // Paths.get() 메소드 사용
        Path dir1 = Paths.get("C:\\JAVA\\FirstStudy\\FisrtStudy\\input.txt");
        Path dir2 = Paths.get("C:", "JAVA", "FirstStudy", "FisrtStudy", "input.txt");
        Path dir3 = Paths.get("C:\\JAVA\\FirstStudy", "FisrtStudy", "input.txt");
    }
}
