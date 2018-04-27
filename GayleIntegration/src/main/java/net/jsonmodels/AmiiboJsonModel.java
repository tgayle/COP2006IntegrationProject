package src.main.java.net.jsonmodels;

import java.util.List;

public class AmiiboJsonModel {
  
  private List<AmiiboInfo> amiibo;
  
  private AmiiboJsonModel(List<AmiiboInfo> amiibo) {
    this.amiibo = amiibo;
  }
  
  public List<AmiiboInfo> getAmiibo() {
    return amiibo;
  }
  
}
