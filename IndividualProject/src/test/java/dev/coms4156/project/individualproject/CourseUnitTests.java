package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;




/** * Class contains testing for the Course class of this project. */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
    emptyCourse = new Course("not griffin", "barnard", "until the end of time", 0);
  }


  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void enrollStudentTest() {
    boolean expectedResult = true;
    assertEquals(expectedResult, testCourse.enrollStudent());
    assertEquals(false, emptyCourse.enrollStudent());
  }

  @Test
  public void dropStudentTest() {
    testCourse.enrollStudent();
    testCourse.enrollStudent();
    assertTrue(testCourse.dropStudent());
    assertFalse(emptyCourse.dropStudent());
  }

  @Test
  public void getCourseLocationTest() {
    String expectedResult = "417 IAB";
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    String expectedResult = "Griffin Newbold";
    assertEquals(expectedResult, testCourse.getInstructorName());
    assertEquals("not griffin", emptyCourse.getInstructorName());
  }

  @Test
  public void getCourseTimeSlotTest() {
    String expectedResult = "11:40-12:55";
    assertEquals(expectedResult, testCourse.getCourseTimeSlot());
    assertEquals("until the end of time", emptyCourse.getCourseTimeSlot());
  }

  @Test
  public void reassignInstructorTest() {
    String expectedResult = "the better Newbold";
    emptyCourse.reassignInstructor("the better Newbold");
    assertEquals(expectedResult, emptyCourse.getInstructorName());
  }

  @Test
  public void reassignLocationTest() {
    String expectedResult = "my dorm";
    emptyCourse.reassignLocation("my dorm");
    assertEquals(expectedResult, emptyCourse.getCourseLocation());
  }

  @Test
  public void reassignTimeTest() {
    String expectedResult = "33:00-49:00";
    emptyCourse.reassignTime("33:00-49:00");
    assertEquals(expectedResult, emptyCourse.getCourseTimeSlot());
  }

  @Test
  public void setEnrolledStudentCountTest() {
    int expectedResult = 1938084;
    testCourse.setEnrolledStudentCount(1938084);
    assertEquals(expectedResult, testCourse.getEnrolledStudentCount());
  }

  @Test
  public void isCourseFullTest() {
    boolean expectedResult = true;
    assertEquals(expectedResult, emptyCourse.isCourseFull());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
  public static Course emptyCourse;
}

