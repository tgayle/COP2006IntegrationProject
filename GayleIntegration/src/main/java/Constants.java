package src.main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Travis Gayle
 * Class to hold commonly used constants and variables.
 */
public class Constants {

  private static final String[] YES_DECISIONS = new String[]{"y", "yes"};
  public static final List<String> YES_DECISIONS_LIST = Collections
      .unmodifiableList(Arrays.asList(YES_DECISIONS));
  private static final String[] CONFIRM_DECLINE_OPTIONS = {"y", "n", "yes", "no"};
  public static final List<String> CONFIRM_DECLINE_OPTIONS_LIST = Collections
      .unmodifiableList(Arrays.asList(CONFIRM_DECLINE_OPTIONS));
}
