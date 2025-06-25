package com.yedam.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class EncriptTest {

    @Test
	public void test() {
        String rawPw = "1111";
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		String encodePw = scpwd.encode(rawPw);
		log.info(encodePw);

        boolean result = scpwd.matches(rawPw, encodePw);
        assertEquals(result, true);
	}
}