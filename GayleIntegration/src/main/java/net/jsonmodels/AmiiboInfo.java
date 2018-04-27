package src.main.java.net.jsonmodels;

public class AmiiboInfo {

  private String amiiboSeries;
  private String gameSeries;
  private String name;
  private AmiiboReleaseDatesModel release;
  private String type;

  public String getAmiiboSeries() {
    return amiiboSeries;
  }

  public String getGameSeries() {
    return gameSeries;
  }

  public String getName() {
    return name;
  }

  public AmiiboReleaseDatesModel getReleaseDates() {
    return release;
  }

  public String getType() {
    return type;
  }
}
