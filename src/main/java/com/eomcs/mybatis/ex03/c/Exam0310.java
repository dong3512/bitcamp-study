// update 문 실행 - Board 객체에 값을 담아 파라미터로 넘기기
package com.eomcs.mybatis.ex03.c;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/c/mybatis-config.xml")).openSession();

    // delete 문을 실행할 때는 delete() 메서드를 호출한다.
    // - 리턴 값은 executeUpdate()의 실행 결과이다.
    // - 즉 delete 된 데이터의 개수이다.

    // 예) 게시글을 입력한다.

    int count = sqlSession.delete("BoardMapper.delete", 6);
    System.out.printf("%d 개의 데이터를 삭제 했음!", count);

    sqlSession.commit();

    // 용어정리 
    sqlSession.close();
    System.out.println("실행 완료!");


  }

}


