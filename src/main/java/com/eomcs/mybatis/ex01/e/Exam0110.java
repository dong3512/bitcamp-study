// Mybatis 설정 파일 - 도메인 클래스의 별명을 설정하는 또 다른 방법

package com.eomcs.mybatis.ex01.e;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex01/e/mybatis-config.xml")).openSession();

    // BoardMapper.xml 파일에 보관된 select 문 실행하기
    // => SqlSession.selectList("네임스페이스명 SQL 아이디")
    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

    System.out.println(boards.size());

    sqlSession.close();
  }

}


