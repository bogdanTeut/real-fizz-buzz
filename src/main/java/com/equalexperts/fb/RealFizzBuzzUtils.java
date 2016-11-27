package com.equalexperts.fb;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.function.Predicate;

/**
 * Helper class
 */
public class RealFizzBuzzUtils {

  public static final String INTEGER_LABEL = "integer";

  /**
   * Deals with special cases
   * @param specialCasePredicate
   * @param number
   * @param result
   * @param label
   * @return
   */
  public static String generateLabelForSpecialCase(final Predicate<Integer> specialCasePredicate, final Integer number,
                                                   final String result, final String label) {
    return specialCasePredicate.test(number)
            ?label
            :result;
  }

  /**
   * Generates the key for the report.
   * @param generated
   * @return
   */
  public static String generateKey(final String generated) {
    if (NumberUtils.isNumber(generated)) {
      return INTEGER_LABEL;
    }

    return generated;
  }
}
