/**
 * Created by Travis on 2/10/2018.
 * Class to model imaginary number and show an example of casting objects. Subclass of Number.java
 */
public class ImaginaryNumber extends Number {

  long imaginaryNumber;

  public ImaginaryNumber(String rationalNumber, long imaginary) {
    super(rationalNumber);
    imaginaryNumber = imaginary;
  }

  public ImaginaryNumber(long rationalNumber, long imaginary) {
    super(rationalNumber);
    imaginaryNumber = imaginary;
  }

  public ImaginaryNumber(Number num, long imaginary) {
    this.number = num.number;
    this.imaginaryNumber = imaginary;
  }

  @Override
  public String toString() {
    return String.format("%s + %di", number, imaginaryNumber);
  }


}
