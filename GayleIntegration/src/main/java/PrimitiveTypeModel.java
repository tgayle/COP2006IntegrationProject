package src.main.java;
/*
 * Travis Gayle
 * Integration Project
 * Model class for primitive data types. Used for showing primitive types and their capacities.
 */

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrimitiveTypeModel {

  private static PrimitiveTypeModel byteType = new PrimitiveTypeModel("byte", "" + Byte.MIN_VALUE,
      "" + Byte.MAX_VALUE);

  private static PrimitiveTypeModel shortType = new PrimitiveTypeModel("short",
      "" + Short.MIN_VALUE, "" + Short.MAX_VALUE);

  private static PrimitiveTypeModel intType = new PrimitiveTypeModel("int", "" + Integer.MIN_VALUE,
      "" + Integer.MAX_VALUE);

  private static PrimitiveTypeModel longType = new PrimitiveTypeModel("long", "" + Long.MIN_VALUE,
      "" + Long.MAX_VALUE);

  private static PrimitiveTypeModel floatType = new PrimitiveTypeModel("float",
      "" + Float.MIN_VALUE, "" + Float.MAX_VALUE);

  private static PrimitiveTypeModel doubleType = new PrimitiveTypeModel("double",
      "" + Double.MIN_VALUE, "" + Double.MAX_VALUE);

  private static PrimitiveTypeModel booleanType = new PrimitiveTypeModel("boolean",
      "" + Boolean.FALSE, "" + Boolean.TRUE);

  private static PrimitiveTypeModel charType = new PrimitiveTypeModel("char",
      "" + Character.MIN_VALUE, "" + Character.MAX_VALUE);

  private static final PrimitiveTypeModel[] types = new PrimitiveTypeModel[]
      {byteType, shortType, intType, longType, floatType, doubleType, booleanType, charType};

  private String type;
  private String minValue;
  private String maxValue;

  private PrimitiveTypeModel(String type, String minValue, String maxValue) {
    this.type = type;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public static List<PrimitiveTypeModel> getPrimitiveTypes() {
    return Arrays.asList(types);
  }

  /**
   * Returns a predicate statement that returns whether or not the given type can handle the given
   * number.
   *
   * @param num The number to check if it fits in an array.
   * @return True if the given number fits in the array. False otherwise and if the type can't
   * handle the number at all, such as <em>boolean</em> or <em>char</em>
   */
  public static Predicate<PrimitiveTypeModel> canHandleNumber(double num) {
    return type -> {
      if (type.type.equals("boolean") || type.type.equals("char")) {
        return false;
      }
      BigDecimal given = new BigDecimal(type.maxValue);
      BigDecimal givenNum = BigDecimal.valueOf(num);
      return given.compareTo(givenNum) >= 0;
    };
  }

  String getType() {
    return type;
  }

  String getMaxValue() {
    return maxValue;
  }

  String getMinValue() {
    return minValue;
  }

}

