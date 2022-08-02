package studyjava.hyeonmo.item42;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FilterEverything {

  public static <T> void filter(Collection<T> collection, MyFilter myFilter) {
    for (Iterator<T> it = collection.iterator(); it.hasNext(); ) {
      T t = it.next();
      if (!myFilter.filter(t)) {
        it.remove();
      }
    }
  }
}
