package studyjava.hyeonmo.item5;

import java.util.List;
import java.util.Objects;

// 정적 유틸리티를 잘못 사용한 예
//public class SpellChecker {
//  private static final Lexicon dictionary = ...;
//
//  private SpellChecker() {} // 객체 생성 방지
//
//  public static boolean isValid(String word) { ... }
//  public static List<String> suggestions(String typo) { ... }
//}

// 싱글턴을 잘못 사용한 예
//public class SpellChecker {
//  private static final Lexicon dictionary = ...;
//
//  private SpellChecker(...) {} // 객체 생성 방지
//  public static SpellChecker INSTANCE = new SpellChecker(...);
//
//  public static boolean isValid(String word) { ... }
//  public static List<String> suggestions(String typo) { ... }
//}

public class SpellChecker {
  private static final Lexicon dictionary;

  public SpellChecker(Lexicon dictionary) {
    this.dictionary = Objects.requireNonNull(dictionary);
  }

  public static boolean isValid(String word) { ... }
  public static List<String> suggestions(String typo) { ... }
}
