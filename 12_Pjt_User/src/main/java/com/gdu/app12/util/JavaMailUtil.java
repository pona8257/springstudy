package com.gdu.app12.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/*
   google 이메일 보내기
   
   1. 구글에 로그인한다.
   2. [Google 계정] - [보안]
   3. [2단계 인증]
      - [사용]
      - [앱 비밀번호]
        - [앱 선택]   : 메일
        - [기기 선택] : Windows 컴퓨터
        - [생성]      : 16자리 앱 비밀번호 생성
 */

@PropertySource(value={"classpath:application.properties"})
@Component
public class JavaMailUtil {
  
  @Autowired
  private Environment env;
  
}
