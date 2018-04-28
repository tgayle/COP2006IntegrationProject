package src.main.java.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import src.main.java.net.jsonmodels.AmiiboJsonModel;
import src.main.java.net.jsonmodels.SeriesJsonModel;

/*
 * Travis Gayle
 * Interface for Retrofit to generate connections to API
 */
public interface AmiiboService {

  @GET("amiibo")
  Call<AmiiboJsonModel> getAmiibo(@Query("name") String name);

  @GET("amiibo")
  Call<SeriesJsonModel> getSeries(@Query("gameseries") String series);
}
