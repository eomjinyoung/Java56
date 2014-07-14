package exam.annotation.step01;

/* 애노테이션 사용
 * @애노테이션이름 (속성명=값, 속성명=값, ...)
 * 
 * 속성의 타입이 배열이면 : 
 * 1) 값을 한개만 설정할 때 => 속성명=값
 * 2) 값을 여러 개 설정할 때 => 속성명={값, 값, 값, ...}
 * 
 * value 속성
 * => "value" 속성 값을 설정할 때
 * @애노테이션(값) : value 속성 이름을 생략할 수 있다. 단, value 속성 값만 설정할 때!
 *               값이 두 개 이상일 때는 생략 불가!
 * @애노테이션(값, 속성명=값) <== 오류!
 */

@Component(
    name="comp1",
    count=10,
    url={"url1", "url2"}
)
public class MyClass {

}
