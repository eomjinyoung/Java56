package exam.annotation.step02;

/* 기본 사용 */
// 배열 값 설정: 값을 한 개 줄 때, 중괄호 생략 가능!
//@Component(value="my1")

// 배열 값 설정: 값을 여러 개 줄 때, 중괄호 생략 불가능!
//@Component(value={"my1", "my2", "my3"})

/* value 속성 값을 설정할 때, 속성 명을 생략할 수 있다.*/
//@Component ("my1")
//@Component({"my1", "my2", "my3"})

/* 두 개 이상의 속성을 설정할 때는 value 이름 생략 불가!*/
//@Component("my1", url="url1") // 오류!
@Component(value="my1", url="url1")
public class MyClass {

}











