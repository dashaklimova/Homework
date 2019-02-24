package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MassiveTestsNG {

	private MassiveNG massive;
	private int[] baseArray;
	private int[] arrayWithNegativeNumbers;
	private int[] arrayWithZeroElement;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		massive = new MassiveNG();
		massive.setName("My array");
		baseArray = new int[] { 1, 2, 3 };
		arrayWithNegativeNumbers = new int[] { -1, -2, -3 };
		arrayWithZeroElement = new int[] { 1, 0, 3 };
	}

	@Test
	public void testMultiplyArrayElements() {
		massive.setArray(baseArray);
		int expectedResult = baseArray[0] * baseArray[1] * baseArray[2];
		int actualResult = massive.multiplyArrayElements();
		assertEquals(expectedResult, actualResult);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@Test(enabled = false)
	public void testMultiplyArrayElementsNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int expectedResult = arrayWithNegativeNumbers[0] * arrayWithNegativeNumbers[1] * arrayWithNegativeNumbers[2];
		int actualResult = massive.multiplyArrayElements();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMultiplyArrayElementswithZeroElement() {
		massive.setArray(arrayWithZeroElement);
		int expectedResult = 0;
		int actualResult = massive.multiplyArrayElements();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetMinElement() {
		massive.setArray(baseArray);
		int expectedResult = baseArray[0];
		int actualResult = massive.getMinElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test(timeOut = 2000)
	public void testGetMinElementNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int expectedResult = arrayWithNegativeNumbers[2];
		int actualResult = massive.getMinElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetMinElementWithZeroElement() {
		massive.setArray(arrayWithZeroElement);
		assertEquals(0, massive.getMinElement());
	}

	@Test
	public void testGetMaxElement() {
		massive.setArray(baseArray);
		assertEquals(baseArray[2], massive.getMaxElement());
	}

	@Test
	public void testGetMaxElementNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		assertEquals(arrayWithNegativeNumbers[0], massive.getMaxElement());
	}

	@Test(enabled = false)
	public void testGetMaxElementWithZeroElement() {
		massive.setArray(arrayWithZeroElement);
		assertEquals(arrayWithZeroElement[2], massive.getMaxElement());
	}

	@Test
	public void testArrayCycleToTheRight() {
		massive.setArray(baseArray);
		int[] expectedResult = { 2, 3, 1 };
		int[] actualResult = massive.getArrayCycleToTheRight();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testArrayCycleToTheRightNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int[] expectedResult = { -2, -3, -1 };
		int[] actualResult = massive.getArrayCycleToTheRight();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testArrayCycleToTheRightWithZeroElement() {
		massive.setArray(arrayWithZeroElement);
		int[] expectedResult = { 0, 3, 1 };
		int[] actualResult = massive.getArrayCycleToTheRight();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testWriteElementToArrayByIndex() {
		massive.setArray(baseArray);
		int[] expectedResult = { 1, 10, 3 };
		int[] actualResult = massive.writeElementToArrayByIndex(1, 10);
		assertEquals(expectedResult, actualResult);
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testWriteElementToArrayByIndexCheckException() {
		massive.setArray(baseArray);
		massive.writeElementToArrayByIndex(5, 10);
	}

	@Test
	public void testGetFirstArrayElement() {
		massive.setArray(baseArray);
		int expectedResult = 1;
		int actualResult = massive.getFirstArrayElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetFirstArrayElementNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int expectedResult = -1;
		int actualResult = massive.getFirstArrayElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetFirstArrayElementWithZeroElements() {
		massive.setArray(arrayWithZeroElement);
		assertEquals(1, massive.getFirstArrayElement());
	}

	@Test
	public void testGetLastArrayElement() {
		massive.setArray(baseArray);
		int expectedResult = 3;
		int actualResult = massive.getLastArrayElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetLastArrayElementNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int expectedResult = -3;
		int actualResult = massive.getLastArrayElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetLastArrayElementWithZeroElements() {
		massive.setArray(arrayWithZeroElement);
		assertEquals(3, massive.getLastArrayElement());
	}

	@Test
	public void testWriteArrayInReverseOrder() {
		massive.setArray(baseArray);
		int[] expectedResult = { 3, 2, 1 };
		int[] actualResult = massive.writeArrayInReverseOrder();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetSum() {
		massive.setArray(baseArray);
		assertEquals(6, massive.getSum());
	}

	@Test
	public void testGetSumNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		assertEquals(-6, massive.getSum());
	}

	@Test
	public void testGetSumWithZeroElement() {
		massive.setArray(arrayWithZeroElement);
		assertEquals(4, massive.getSum());
	}

	@Test
	public void testGetDoubleArray() {
		massive.setArray(baseArray);
		int[] expectedResult = { 2, 4, 6 };
		int[] actualResult = massive.getDoubleArray();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetDoubleArrayNegativeNumbers() {
		massive.setArray(arrayWithNegativeNumbers);
		int[] expectedResult = { -2, -4, -6 };
		int[] actualResult = massive.getDoubleArray();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetDoubleArrayZeroElement() {
		massive.setArray(arrayWithZeroElement);
		int[] expectedResult = { 2, 0, 6 };
		int[] actualResult = massive.getDoubleArray();
		assertEquals(expectedResult, actualResult);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
