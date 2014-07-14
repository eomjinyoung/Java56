package exam.annotation.step01;

import java.lang.annotation.Annotation;

/* 애노테이션 정보 추출
 * => 클래스 파일에 들어 있는 애노테이션 정보 가져오기
 */
public class Test01 {

  public static void main(String[] args) throws Exception {
    //1. 클래스를 로딩 (인스턴스 생성, Class.forName(), 스택틱 변수 또는 메서드 사용)
    Class clazz = Class.forName("exam.annotation.step01.MyClass");
    
    //2. 클래스 정보에서 애노테이션을 추출한다.
    // => getAnnotations() : 클래스에 들어 있는 모든 애노테이션들의 정보를 배열로 리턴한다.
    Annotation[] annos = clazz.getAnnotations();

    //3. 애노테이션 정보 출력
    Component compAnno = null;
    for (Annotation anno : annos) {
      System.out.println("=>" + anno);
      if (anno instanceof Component) {
        compAnno = (Component)anno;
        System.out.println("name=" + compAnno.name());
        System.out.println("count=" + compAnno.count());
        System.out.println("type=" + compAnno.type());
        System.out.println("url=" + compAnno.url());
      }
    }
    
  }

}







