package src.main.java.net.jsonmodels;

import java.util.List;

public class SeriesJsonModel {

  private List<AmiiboInfo> amiibo;

  private SeriesJsonModel(List<AmiiboInfo> amiibo) {
    this.amiibo = amiibo;
  }

  public List<AmiiboInfo> getAmiibos() {
    return amiibo;
  }
}
