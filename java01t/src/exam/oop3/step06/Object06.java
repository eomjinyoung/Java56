package exam.oop3.step06;

import java.util.HashMap;

public class Object06 {
  static class Key {
    String id;
    int pwd;
    
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + pwd;
      return result;
    }
   
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Key other = (Key) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (pwd != other.pwd)
        return false;
      return true;
    }
    
    
    
  }
  
  
  public static void main(String[] args) {
    Key k1 = new Key();
    k1.id = "okokmama";
    k1.pwd = 1233;
    
    Key k2 = new Key();
    k2.id = "okokmama";
    k2.pwd = 1233;
    
    /* Map
     * - 키 값을 비교할 때, equals()의 리턴 값이 true, hashCode()의 리턴 값이 같아야 한다.
     * - Map에서 키로 사용되는 클래스는 반드시 equals()와 hashCode()를 재정의 해야 한다.
     */
    HashMap<Key,String> 냉장고 = new HashMap<Key,String>();
    냉장고.put(k1, "개소주");
    
    System.out.println( 냉장고.get(k2) );
    

  }

}










