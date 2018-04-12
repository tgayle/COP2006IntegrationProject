package main;

import java.math.BigDecimal;

/**
 * Created by Travis on 2/10/2018.
 * Class to model Numbers and for showing example of casting
 * objects. Also a wrapper of BigDecimal
 */

public class Number {

  protected BigDecimal number;

  public Number(String num) {
    number = new BigDecimal(num);
  }

  public Number(long num) {
    number = new BigDecimal(num);
  }

  protected Number(Number num) {
    this.number = num.number;
  }

  public Number(BigDecimal num) {
    this.number = num;
  }

  public Number add(Number one, Number two) {
    return new Number(one.number.add(two.number));
  }

  public Number substract(Number n1, Number n2) {
    return new Number(n1.number.subtract(n2.number));
  }

  public Number multiply(Number one, Number two) {
    return new Number(one.number.multiply(two.number));
  }

  public Number divide(Number n1, Number n2) {
    return new Number(n1.number.divide(n2.number));
  }

  @Override
  public String toString() {
    return number.toString();
  }
}
