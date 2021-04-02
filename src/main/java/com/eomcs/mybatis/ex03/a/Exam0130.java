// SQL 문에 삽입할 파라미터 전달하기 -  CDATA 섹션을 사용할 때 : [!CDATA[ SQL 문 []]>

package com.eomcs.mybatis.ex03.a;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/a/mybatis-config.xml")).openSession();

    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3", 4);

    // 컬럼명과 자바 객체의 프로퍼티명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내 올 수 있다.
    for (Board b : boards) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          b.getNo(),
          b.getTitle(),
          b.getContent(),
          b.getRegisteredDate(),
          b.getViewCount());
    }

    sqlSession.close();
    System.out.println("실행완료!");
  }

}


