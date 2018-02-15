/*
 * Travis Gayle
 * Integration Project
 * Model class for primitive data types. Used for showing primitive types and their capacities.
 */

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

  private static final PrimitiveTypeModel[] types = new PrimitiveTypeModel[] { byteType, shortType,
      intType, longType, floatType, doubleType, booleanType, charType };

  private String type;
  private String minValue;
  private String maxValue;

  PrimitiveTypeModel(String type, String minValue, String maxValue) {
    this.type = type;
    this.minValue = minValue;
    this.maxValue = maxValue;
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

  public static PrimitiveTypeModel[] getPrimitiveTypes() {
    return types;
  }


  public static void main(String[] args) {
    //For testing cases.
    for (PrimitiveTypeModel type : PrimitiveTypeModel.getPrimitiveTypes()) {
      System.out.print(type.getType() + ": exists");
      IntegrationProject.slowPrint("..........", 300);
      System.out.println(type.getType()
          + String.format(" range was [%s, %s]%n", type.getMinValue(), type.getMaxValue()));
    }
  }
}

