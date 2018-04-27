package src.main.java.number;

/**
 * Created by Travis on 2/10/2018. Class to model imaginary number and show an example of casting
 * objects. Subclass of Number.java
 */
public class ImaginaryNumber extends Number {

  protected long imaginaryNumber;

  public ImaginaryNumber(String rationalNumber, long imaginary) {
    super(rationalNumber);
    imaginaryNumber = imaginary;
  }

  public ImaginaryNumber(long rationalNumber, long imaginary) {
    super(rationalNumber);
    imaginaryNumber = imaginary;
  }

  /**
   * Create a new imaginary number with a real part and imaginary part.
   *
   * @param num a Number object with a number.
   * @param imaginary An long that will represent the imaginary part of the number.
   */
  public ImaginaryNumber(Number num, long imaginary) {
    super(num);
    this.number = num.number;
    this.imaginaryNumber = imaginary;
  }

  @Override
  public String toString() {
    return String.format("%s + %di", number, imaginaryNumber);
  }

}
