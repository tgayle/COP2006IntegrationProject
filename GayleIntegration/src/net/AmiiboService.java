package src.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import src.net.jsonmodels.AmiiboJSONModel;
import src.net.jsonmodels.SeriesJSONModel;

public interface AmiiboService {

  @GET("amiibo")
  Call<AmiiboJSONModel> getAmiibo(@Query("name") String name);

  @GET("amiibo")
  Call<SeriesJSONModel> getSeries(@Query("gameseries") String series);
}
