package dev.coms4156.project.individualproject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

/** * Class contains testing for the MyFileDatabaseUnitTests class of this project. */
@SpringBootTest
@ContextConfiguration
public class MyFileDatabaseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new MyFileDatabase(12, "hello");
    emptyCourse = new MyFileDatabase(13, "bye");
  }

  @Test
  public void toStringTest() {
    String expectedResult = "\n12; hello";
    assertEquals(expectedResult, testCourse.toString());
    assertEquals("", testCourse.toString());
  }

  /** The test course instance used for testing. */
  public static MyFileDatabase testCourse;
  public static MyFileDatabase emptyCourse;
}

