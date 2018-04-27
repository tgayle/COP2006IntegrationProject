package src.main.java.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import src.main.java.IntegrationProject;
import src.main.java.net.jsonmodels.SeriesJsonModel;

public class WebApiIntegration {

  private static String[] series = {"0x000"}; //Array of series to get information about.

  /**
   * Uses retrofit to connect to open Amiibo API and download information about them.
   *
   * @param callback A callback with the error code of the request. This is 0 if there is no error
   *     and a negative number if there is an issue.
   */
  public static void runAmiiboApi(ApiCallbackInterface callback) {
    //this value tracks the API call result
    AtomicInteger apiResult = new AtomicInteger(0);

    System.out.println("Checking Amiibo Information");
    for (String gameSeries : series) {
      try {
        SeriesJsonModel model = Networking.getAmiiboService().getSeries(gameSeries).execute()
            .body();

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
            IntegrationProject.waitTime(300);
          });
          callback.onApiRequestComplete(apiResult.get(), null);
        }
      } catch (Exception throwable) {
        apiResult.set(-1);
        callback.onApiRequestComplete(apiResult.get(), explainError(throwable));
      }
    }
  }

  /*
  Error 0: No issues
  Error -1: Unknown issue
  Error -2: Unknown Host (No internet/DNS Error)
  Error -3: IOException (Likely an internet issue)
   */
  private static String explainError(Throwable throwable) {
    if (throwable == null) {
      return explainError(0);
    } else if (throwable instanceof UnknownHostException) {
      return explainError(-2);
    } else if (throwable instanceof IOException) {
      return explainError(-3);
    } else {
      return "There was an issue loading from the API. " + throwable.getClass();
    }
  }

  private static String explainError(int errorCode) {
    switch (errorCode) {
      case 0:
        return "No errors.";
      case -1:
        return "There was an unknown issue while loading from the API.";
      case -2:
      case -3:
        return "There was an issue loading from the API. "
            + "Check your internet connection or DNS settings.";
      default:
        return "There may have been an error but this error code does not exist: " + errorCode;
    }
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
