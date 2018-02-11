import java.math.BigDecimal;

/**
 * Created by Travis on 2/10/2018.
 */

public class Number {

  protected BigDecimal number;

  public Number(String num) {
    number = new BigDecimal(num);
  }

  public Number(long num) {
    number = new BigDecimal(num);
  }

  protected Number() {

  }

  @Override
  public String toString() {
    return number.toString();
  }
}
