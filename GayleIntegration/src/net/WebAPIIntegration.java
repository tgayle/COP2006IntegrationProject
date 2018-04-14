package src.net;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import src.net.jsonmodels.SeriesJSONModel;

public class WebAPIIntegration {

  static String[] series = {"0x000"};

  public static int run(APICallbackInterface callback) {
    AtomicInteger apiResult = new AtomicInteger(0); //use this to track the result of this api call.

    System.out.println("Checking Amiibo Information");
    for (String gameSeries : series) {
      Networking.getAmiiboService().getSeries(gameSeries)
          .enqueue(new Callback<SeriesJSONModel>() {
            @Override
            public void onResponse(Call<SeriesJSONModel> call, Response<SeriesJSONModel> response) {
              SeriesJSONModel model = response.body();

              if (model != null) {
                model.getAmiibos().forEach(amiibo -> {
                  System.out.printf("Found %s from %s%n", amiibo.getName(), amiibo.getGameSeries());
                  System.out.println("Type: " + amiibo.getType());
                  System.out.println("Amiibo Series: " + amiibo.getAmiiboSeries());
                  System.out.println("Release Dates: ");

                  amiibo.getReleaseDates().getAllReleaseDates().forEach(date -> {
                    String strForDate =
                        (date.getDate() == null) ? "Never Released" : date.getDate();
                    System.out.printf("\t%s: %s%n", expandRegionCode(date.getRegion()), strForDate);
                  });
                  System.out.println();
                });
                callback.onComplete(apiResult.get());
              }
            }

            @Override
            public void onFailure(Call<SeriesJSONModel> call, Throwable throwable) {
              System.out.println(
                  "Error loading amiibo info. Is it possible that there's something wrong with your connection?");
              apiResult.set(-1);
              callback.onComplete(apiResult.get());
            }
          });
    }

    return apiResult.get();
  }

  private static String expandRegionCode(String code) {
    switch (code) {
      case "au":
        return "Australia";
      case "eu":
        return "Europe";
      case "jp":
        return "Japan";
      case "na":
        return "North America";
      default:
        return "Unknown Region: " + code;
    }
  }

}
