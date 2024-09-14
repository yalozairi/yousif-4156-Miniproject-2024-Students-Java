package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/** * Class contains testing for the Department class of this project. */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  /** setup for testing. */
  @BeforeAll
  public static void setupDepartmentForTesting() {
    testCourseASE = new Course("Kaiser", "interwebs", "tomorrow", 100);
    testCourseAP = new Course("Jae", "columbia", "yesterday", 200);

    HashMap<String, Course> coursesHashMap = new HashMap<>();
    coursesHashMap.put("ASE", testCourseASE);
    coursesHashMap.put("AP", testCourseAP);

    testDepartment = new Department("AAA", coursesHashMap, "Griffin Oldbold", 7);
  }

  @Test
  public void toStringTest() {
    String expectedResult = "AAA ASE: \n"
        + "Instructor: Kaiser; Location: interwebs; Time: tomorrow\n"
        + "AAA AP: \n"
        + "Instructor: Jae; Location: columbia; Time: yesterday\n";
    assertEquals(expectedResult, testDepartment.toString());
  }

  /** The test course/department instance used for testing. */
  public static Department testDepartment;
  public static HashMap<String, Course> coursesHashMap;
  public static Course testCourseASE;
  public static Course testCourseAP;
}

