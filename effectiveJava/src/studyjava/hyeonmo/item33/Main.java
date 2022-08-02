package studyjava.hyeonmo.item33;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import studyjava.hyeonmo.item33.Row.Column;

public class Main {


  public static void main(String[] args) {
    Row row = new Row();
    Column<String> column = new Column<>(String.class, "col");
//    row.putColumn((Column) column, 33); // 에러!
//    Integer col = row.getColumn(column);
  }

//    Set<Integer> uncheckedSet = new HashSet<>();
//    ((HashSet) uncheckedSet).add("ABC"); // 에러 안남!
//
//    Set<Integer> checkedSet = Collections.checkedSet(new HashSet<>(), Integer.class);
//    ((HashSet) checkedSet).add("ABC"); // 에러 남!
}
