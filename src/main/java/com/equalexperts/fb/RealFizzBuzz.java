package com.equalexperts.fb;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.equalexperts.fb.RealFizzBuzzUtils.generateLabelForSpecialCase;

public class RealFizzBuzz {

  private static final String FIZZ = "fizz";
  private static final String BUZZ = "buzz";
  private static final String FIZZBUZZ = "fizzbuzz";
  private static final String LUCKY = "lucky";

  /**
   * Generates and prints to console a list of labels for a given range, according to fizz buzz rules.
   * @param start
   * @param end
   * @return
   */
  public Map<String, Long> generateLabels(final Integer start, final Integer end) {

    if (start > end) {
      throw new IllegalArgumentException(String.format("Wrong range input: %s, %s", start, end));
    }

    final List<String> labelsList = IntStream
            .rangeClosed(start, end)
            .boxed()
            .map(this::generateLabel)
            .collect(Collectors.toList());


    //didn't use a Logger because I didn't consider it was in the scope of this test.
    System.out.println(String.format("For a range of: [%s, %s] the following values have been generated: %s", start, end, labelsList));

    final Map<String, Long> labelsMap = labelsList
            .stream()
            .collect(Collectors.groupingBy(RealFizzBuzzUtils::generateKey, Collectors.counting()));

    labelsMap.forEach((key, value) -> System.out.print(String.format("%s: %d ", key, value)));

    return labelsMap;
  }

  /**
   * Generates a label for a given input.
   * @param number
   * @return
   */
  protected String generateLabel(final Integer number) {
    if (number < 0) {
      throw  new IllegalArgumentException(String.format("Wrong input parameter %s", number));
    }

    String result = number.toString();

    result = generateLabelForSpecialCase((t) -> t % 3 == 0, number, result, FIZZ);
    result = generateLabelForSpecialCase((t) -> t % 5 == 0, number, result, BUZZ);
    result = generateLabelForSpecialCase((t) -> (t % 3 == 0 && t % 5 == 0), number, result, FIZZBUZZ);
    result = generateLabelForSpecialCase((t) -> t.toString().contains("3"), number, result, LUCKY);

    return result;
  }

}
