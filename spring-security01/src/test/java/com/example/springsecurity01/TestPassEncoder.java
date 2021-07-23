package com.example.springsecurity01;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/7/23 23:57
 **/
public class TestPassEncoder {

    @Test
    void testBcrypt() {
        String hashpw = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(hashpw);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("123456", hashpw));
    }
}
