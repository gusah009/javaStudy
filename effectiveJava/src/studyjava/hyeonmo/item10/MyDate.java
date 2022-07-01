package studyjava.hyeonmo.item10;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyDate {

  final int year, month, day;

  @Override
  public boolean equals(Object obj) {
    // 1. == 연산자를 사용해 자기 자신의 참조인지 확인
    if (obj == this) {
      return true;
    }

    // 2. instanceof 연산자로 입력이 올바른 타입인지 확인
    if (!(obj instanceof MyDate)) {
      return false;
    }

    // 3. 입력을 올바른 타입으로 형변환
    MyDate other = (MyDate) obj;

    // 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는 지 하나씩 검사
    return other.year == year &&
        other.month == month &&
        other.day == day;
  }
}
