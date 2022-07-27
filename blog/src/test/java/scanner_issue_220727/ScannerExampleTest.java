package scanner_issue_220727;

import static scanner_issue_220727.ScannerExample.SCANNER;
import static scanner_issue_220727.ScannerExample.Status.SUCCESS;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import scanner_issue_220727.ScannerExample.Status;

class ScannerExampleTest {

  @Test
  void input1Test() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
    SCANNER = new Scanner(inputStream);
    System.setIn(inputStream);
    ScannerExample ex = new ScannerExample();

    // when
    Status result = ex.input1or2();

    // then
    Assertions.assertThat(result).isEqualTo(SUCCESS);
  }

  @Test
  void input2Test() {
    // given
    ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
    SCANNER = new Scanner(inputStream);
    System.setIn(inputStream);
    ScannerExample ex = new ScannerExample();

    // when
    Status result = ex.input1or2();

    // then
    Assertions.assertThat(result).isEqualTo(SUCCESS);
  }
}