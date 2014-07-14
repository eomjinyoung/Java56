package exam.annotation.step01;

import java.lang.annotation.Annotation;

/* 애노테이션 정보 추출
 * => 클래스 파일에 들어 있는 애노테이션 정보 가져오기
 */
public class Test02 {

  public static void main(String[] args) throws Exception {
    //1. 클래스를 로딩 (인스턴스 생성, Class.forName(), 스택틱 변수 또는 메서드 사용)
    Class clazz = Class.forName("exam.annotation.step01.MyClass");
    
    //2. 클래스 정보에서 특정 애노테이션만을 추출한다.
    //=> getAnnotation(애노테이션 타입 정보)
    //=> 애노테이션 타입 정보? Class.forName("....Component")의 리턴값 => Class 객체
    /* 방법1
    Class annoTypeInfo = Class.forName("exam.annotation.step01.Component"); 
    Component compAnno = (Component)clazz.getAnnotation(annoTypeInfo);
    */
    /* 방법2 */
    Component compAnno = (Component)clazz.getAnnotation(Component.class);
    
    //3. 애노테이션 정보 출력
    System.out.println("name=" + compAnno.name());
    System.out.println("count=" + compAnno.count());
    System.out.println("type=" + compAnno.type());
    System.out.println("url=" + compAnno.url());
    
  }

}







