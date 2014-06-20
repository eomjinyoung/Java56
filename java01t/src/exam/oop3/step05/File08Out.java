package exam.oop3.step05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* ObjectOutputStream
 * - 인스턴스의 변수 값들을 바이트 배열로 변환하여 출력하는 역할
 * - 클래스 정보가 추가된다.
 *   => Serialize (Marshaling)
 *   
 * ObjectInputStream
 * - 바이트 배열(클래스 정보 + 인스턴스 값들)을 읽어서 인스턴스를 생성하는 역할
 *   =>Deserialize (Unmarshaling)
 *   
 * Serializable
 * - 자바는 기본으로 보안을 위해 인스턴스의 값이 바이트 배열로 추출되어 외부로 나가는 것을 제한한다.
 * - 따라서 허락이 안된 인스턴스를 외부로 출력하려하면 NotSerializableException 예외가 발생한다.
 * - 해결: 해당 클래스에 외부로 나가도 된다는 표시를 해야 한다.
 *       java.io.Serializable 인터페이스를 구현한다.
 * - Serializable 인터페이스는 메서드가 없다. => 외부 출력 가능 표시용!  
 */

public class File08Out {

  public static void main(String[] args) throws IOException {
    Score score = new Score();
    score.setName("홍길동");
    score.setKor(100);
    score.setEng(90);
    score.setMath(80);
    
    FileOutputStream out = new FileOutputStream("file08.dat");
    ObjectOutputStream out2 = new ObjectOutputStream(out);
    
    out2.writeObject(score);
    
    out2.close();
    out.close();

  }

}

















