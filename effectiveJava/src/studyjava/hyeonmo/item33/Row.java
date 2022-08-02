package studyjava.hyeonmo.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Row {

  Map<Column<?>, Object> columns = new HashMap<>();

  public <T> void putColumn(Column<T> column, T columnValue) {
    columns.put(Objects.requireNonNull(column), column.columnClass.cast(columnValue));
  }

  public <T> T getColumn(Column<T> column) {
    return column.columnClass.cast(columns.get(column));
  }

  static class Column<T> {

    Class<T> columnClass;
    String columnName;

    public Column(Class<T> columnClass, String columnName) {
      this.columnClass = columnClass;
      this.columnName = columnName;
    }
  }
}
