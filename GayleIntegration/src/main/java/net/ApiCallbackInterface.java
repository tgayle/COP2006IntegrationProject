package src.main.java.net;

/**
 * Travis Gayle.
 * Interface used to representing the result of calling the Amiibo API
 */
public interface ApiCallbackInterface {

  /**
   * Called at end of WebApiIntegration API calls.
   *
   * @param result A result code that represents the end result of the call
   * @param errors A string message with any errors. Null if none
   */
  void onApiRequestComplete(int result, String errors);

}
