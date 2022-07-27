package scanner_issue_220727;

import static scanner_issue_220727.ScannerExample.Status.FAIL;
import static scanner_issue_220727.ScannerExample.Status.SUCCESS;

import java.util.Scanner;

public class ScannerExample {

  public static Scanner SCANNER = new Scanner(System.in);
  Integer inputNum;

  Status input1or2() {
    try {
      inputNum = Integer.valueOf(SCANNER.nextLine());
      if (inputNum != 1 && inputNum != 2) {
        throw new IllegalArgumentException();
      }
      return SUCCESS;
    } catch (Exception e) {
      e.printStackTrace();
      return FAIL;
    }
  }

  public enum Status {
    SUCCESS, FAIL
  }
}
