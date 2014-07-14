package exam.annotation.step01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** 애노테이션 정의
 * => 컴파일러나 JVM에게 전달할 특별한 정보
 * => 문법 형태는 자바 인터페이스와 유사
 * @interface 애노테이션이름 { }
 * 
 * => 멤버 선언은 메서드 선언과 유사 -> 멤버의 이름은 속성 이름처럼 작성한다.
 * 타입 이름();
 * 타입 이름() default 기본값; 
 *
 */

/* 애노테이션 유지 정책
 * => SOURCE : 컴파일 후에 제거됨(일반 주석과 동일). *.class 파일에는 없음.
 *    예) @Override => 컴파일할 때만 참조. 컴파일 후에 버린다.
 * => CLASS : 컴파일러가 참조. *.class 파일에 존재함.
 * => RUNTIME : JVM이 참조. *.class 파일에 존재함.
 *    예) @Deprecated => JVM이 참조하는 주석.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String name(); // 필수 입력 항목
  int count(); // 필수 입력 항목
  String type() default "general"; // 선택 입력 항목
  String[] url(); // 필수 입력 항목
}











