package com.equalexperts.fb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.Is.is;

public class RealFizzBuzzTest {

  private RealFizzBuzz realFizzBuzz;

  @BeforeMethod
  public void onSetup() {
    realFizzBuzz = new RealFizzBuzz();
  }

  /**
   * The business requirements don't say so but I assumed that the value should be
   * a positive integer.
   */
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Wrong input parameter -1")
  public void givenNegativeValue_whenGeneratingLabel_thenItShouldThrowAnException() {
    realFizzBuzz.generateLabel(-1);
  }

  @DataProvider(name = "numbersDataProvider")
  public Object[][] numbersDataProvider() {
    return new Object[][] {
            {1, "1"},
            {2, "2"},
            {3, "lucky"},
            {4, "4"},
            {5, "buzz"},
            {6, "fizz"},
            {7, "7"},
            {8, "8"},
            {9, "fizz"},
            {10, "buzz"},
            {11, "11"},
            {12, "fizz"},
            {13, "lucky"},
            {14, "14"},
            {15, "fizzbuzz"},
            {16, "16"},
            {17, "17"},
            {18, "fizz"},
            {19, "19"},
            {20, "buzz"},
    };
  }

  @Test(dataProvider = "numbersDataProvider")
  public void givenNumber_whenGeneratingLabel_thenItShouldReturnTheCorrectLabel(final Integer number, final String expectedResult) {
    assertThat(realFizzBuzz.generateLabel(number), is(expectedResult));
  }

  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Wrong range input: 4, 3")
  public void givenAnIntervalWithStartGreaterThanEnd_whenGeneratingLabels_thenItShouldThrowException() {
    realFizzBuzz.generateLabels(4, 3);
  }

  @Test
  public void givenAnInterval_whenGeneratingLabels_thenItshouldReturnTheCorrectOutput() {
    final Map<String, Long> generatedLabels = realFizzBuzz.generateLabels(1, 20);
    assertThat(generatedLabels, hasEntry("fizz", new Long(4)));
    assertThat(generatedLabels, hasEntry("buzz", new Long(3)));
    assertThat(generatedLabels, hasEntry("fizzbuzz", new Long(1)));
    assertThat(generatedLabels, hasEntry("lucky", new Long(2)));
    assertThat(generatedLabels, hasEntry("integer", new Long(10)));
  }
}
