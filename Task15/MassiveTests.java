package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MassiveTests {
	private Massive massive;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@Before
	public void beforeTest() {
		System.out.println("Before Test");
		massive = new Massive();
		massive.setName("My array");
	}

	@Test
	public void testMultiplyArrayElements() {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		massive.setArray(array);
		int expectedResult = array[0] * array[1] * array[2];
		int actualResult = massive.multiplyArrayElements();
		assertEquals(expectedResult, actualResult);
	}

	@After
	public void afterTest() {
		System.out.println("After Test");
	}

	@Ignore
	@Test
	public void testMultiplyArrayElementsNegativeNumbers() {
		int[] array = new int[3];
		array[0] = -1;
		array[1] = -2;
		array[2] = -3;
		massive.setArray(array);
		int expectedResult = array[0] * array[1] * array[2];
		int actualResult = massive.multiplyArrayElements();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetMinElement() {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 50;
		array[2] = 185;
		massive.setArray(array);
		int expectedResult = array[0];
		int actualResult = massive.getMinElement();
		assertEquals(expectedResult, actualResult);
	}


	@Test(timeout = 2000)
	public void testGetMinElementNegativeNumbers() {
		int[] array = new int[3];
		array[0] = -1;
		array[1] = -5;
		array[2] = -8;
		massive.setArray(array);
		int expectedResult = array[2];
		int actualResult = massive.getMinElement();
		assertEquals(expectedResult, actualResult);
	}

	@Ignore
	@Test
	public void testGetMaxElement() {
		int[] array = new int[3];
		array[0] = 9;
		array[1] = 155;
		array[2] = 5;
		massive.setArray(array);
		int expectedResult = array[1];
		int actualResult = massive.getMaxElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetMaxElementNegativeNumbers() {
		int[] array = new int[3];
		array[0] = -9;
		array[1] = -15;
		array[2] = -5;
		massive.setArray(array);
		assertEquals(array[2], massive.getMaxElement());
	}

	@Test
	public void testArrayCycleToTheRight() {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		massive.setArray(array);
		int[] expectedResult = { 2, 3, 1 };
		int[] actualResult = massive.getArrayCycleToTheRight();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testArrayCycleToTheRightWithZeroElement() {
		int[] array = new int[3];
		array[0] = 1;
		array[2] = 3;
		massive.setArray(array);
		int[] expectedResult = { 0, 3, 1 };
		int[] actualResult = massive.getArrayCycleToTheRight();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testWriteElementToArrayByIndex() {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		massive.setArray(array);
		int[] expectedResult = { 1, 10, 3 };
		int[] actualResult = massive.writeElementToArrayByIndex(1, 10);
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testWriteElementToArrayByIndexCheckException() {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		massive.setArray(array);
		massive.writeElementToArrayByIndex(5, 10);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
}
