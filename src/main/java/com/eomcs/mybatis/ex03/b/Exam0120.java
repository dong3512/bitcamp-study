// SQL 문에 삽입할 파라미터 전달하기 - 일반 객체를 이용하여 여러 개의 값 넘기기
package com.eomcs.mybatis.ex03.b;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/b/mybatis-config.xml")).openSession();
    // selectList()/selectOne(),insert(),update(),delete()
    // - selectList(SQL ID)
    // - selectList(SQL ID, 파라미터)
    // - 위와 같이 SQL을 실행할 때 오직 한개의 파라미터만 넘길 수 있다.
    // - 여러 개의 파라미터를 넘기고 싶다면 객체에 담아서 넘겨라!

    // 예) 특정 범위의 번호에 해당하는 게시글을 가져온다.
    //
    Board board = new Board();
    board.setTitle("제목입니다.2");
    board.setContent("내용입니다.");

    // insert 문을 실행할 때는 insert() 메서드를 호출한다.
    // - 리턴 값은 executeUpdate()의 실행 결과이다.
    // - 즉 insert 된 데이터의 개수이다.

    // 예) 게시글을 입력한다.

    int count = sqlSession.insert("BoardMapper.insert", board);
    System.out.printf("%d 개의 데이터를 입력 했음!", count);

    // sqlSessionFactory의 openSession()을 통해 SqlSession 얻을 때는
    // autocommit이 기본으로 false 이다.
    // autocommit?
    // - insert/update/delete 과 같이 데이터를 변경하는 작업은
    //   위험하기 때문에 DBMS의 임시 메모리에 그 작업 결과를 보관한다.
    // - 클라이언트에서 최종적으로 변경 사항에 대해 확정해줘야만 진짜 테이블에 값을 반영한다.

    // 현재 SqlSession 객체가 수동 commit 상태이기 때문에
    // 데이터 변경을 수행한 후 commit을 반드시 실행 해야 한다.
    sqlSession.commit();
    // commit 명령을 내리지 않으면 insert/update/delete 을 통해 수행한 데이터 변경 작업을
    // 실제 테이블에 반영하지 않는다
    // close() 할 때 자동으로 취소된다.

    // 용어정리 
    sqlSession.close();
    System.out.println("실행 완료!");


  }

}


