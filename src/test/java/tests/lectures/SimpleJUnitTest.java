package tests.lectures;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
    int result;

    private int getResult() {
        return 3;
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("### beforeAll\n");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("### afterAll\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###   beforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   afterEach\n");
        result = 0;
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(result > 2);
        System.out.println("###     firstTest");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(result > 2);
        System.out.println("###     secondTest");
    }

    @Test
    void thirdTest() {
        Assertions.assertTrue(result > 2);
        System.out.println("###     thirdTest");
    }
}
