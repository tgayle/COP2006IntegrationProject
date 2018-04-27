package src.main.java.net.jsonmodels;

import java.util.ArrayList;
import java.util.List;

public class AmiiboReleaseDatesModel {
  
  private String au;
  private String eu;
  private String jp;
  private String na;
  
  private AmiiboReleaseDatesModel(String au, String eu, String jp, String na) {
    this.au = au;
    this.eu = eu;
    this.jp = jp;
    this.na = na;
  }
  
  public String getAu() {
    return au;
  }
  
  public String getEu() {
    return eu;
  }
  
  public String getJp() {
    return jp;
  }
  
  public String getNa() {
    return na;
  }
  
  /**
   * Provides a List of all the amiibo dates. Dates can be null if they're never released in a
   * region.
   *
   * @return a List of each of the AmiiboDates
   */
  public List<AmiiboDate> getAllReleaseDates() {
    List<AmiiboDate> dates = new ArrayList<>();
    dates.add(new AmiiboDate("na", na));
    dates.add(new AmiiboDate("eu", eu));
    dates.add(new AmiiboDate("jp", jp));
    dates.add(new AmiiboDate("au", au));
    return dates;
  }
  
  public static class AmiiboDate {
    
    private String region;
    private String date;
    
    AmiiboDate(String region, String date) {
      this.region = region;
      this.date = date;
    }
    
    public String getRegion() {
      return region;
    }
    
    public String getDate() {
      return date;
    }
    
  }
}
