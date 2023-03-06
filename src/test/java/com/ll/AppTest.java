package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    @DisplayName("스캐너에 키보드 입력이 아닌 문자열을 입력으로 설정")
    public void t1() {
        Scanner sc = TestUtil.genScanner("안녕");
        String cmd = sc.nextLine().trim();
        assertThat(cmd).isEqualTo("안녕");
    }

    @Test
    @DisplayName("출력을 모니터에 하지 않고 문자열로 얻기")
    public void t2() {
        //System.out에 대한 화면 출력 금지
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        //출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();
        //System.out에 대한 화면출력 금지 끝
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }
}
