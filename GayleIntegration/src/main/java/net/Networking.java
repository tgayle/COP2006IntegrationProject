package src.main.java.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Networking {

  private static Retrofit amiiboRetrofit = new Retrofit.Builder()
      .baseUrl("http://www.amiiboapi.com/api/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();
  
  private static AmiiboService ammiboService = amiiboRetrofit.create(AmiiboService.class);
  
  public static AmiiboService getAmiiboService() {
    return ammiboService;
  }
}
