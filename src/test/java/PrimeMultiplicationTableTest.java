import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.testng.Assert.*;

/**
 * Created by Alwin on 5/9/2016.
 */
public class PrimeMultiplicationTableTest {
    private PrimeMultiplicationTable primeMultiplicationTable;
    private Map<Integer, Integer> primeList_TestData;
    private long start;
    private long end;

    /*Test data for Prime Number list generations*/
    @DataProvider
    public Object[][] getPrimeNumberListSize() {
        return new Object[][]{
                {10}, {5}, {11}, {3}, {42},{'+'}, {'-'}
        };
    }

    /*Test data for Prime Number list generations - Negative scenarios*/
    @DataProvider
    public Object[][] getPrimeNumberListSize_negative() {
        return new Object[][]{
                {-10}, {0}, {-5},{-2},{-100}
        };
    }

    /* Setting up test data for test*/
    @BeforeMethod
    public void setUp() throws Exception {
        primeMultiplicationTable = new PrimeMultiplicationTable();
        primeList_TestData = new HashMap<Integer, Integer>();
        primeList_TestData.put(1, 2);
        primeList_TestData.put(2, 3);
        primeList_TestData.put(3, 5);
        primeList_TestData.put(4, 7);
        primeList_TestData.put(5, 11);
        primeList_TestData.put(6, 13);
        primeList_TestData.put(7, 17);
        primeList_TestData.put(8, 19);
        primeList_TestData.put(9, 23);
        primeList_TestData.put(10, 29);
        primeList_TestData.put(11, 31);
        primeList_TestData.put(12, 37);
        primeList_TestData.put(13, 41);
        primeList_TestData.put(14, 43);
        primeList_TestData.put(15, 47);
        primeList_TestData.put(16, 53);
        primeList_TestData.put(17, 59);
        primeList_TestData.put(18, 61);
        primeList_TestData.put(19, 67);
        primeList_TestData.put(20, 71);
        primeList_TestData.put(21, 73);
        primeList_TestData.put(22, 79);
        primeList_TestData.put(23, 83);
        primeList_TestData.put(24, 89);
        primeList_TestData.put(25, 97);
        primeList_TestData.put(26, 101);
        primeList_TestData.put(27, 103);
        primeList_TestData.put(28, 107);
        primeList_TestData.put(29, 109);
        primeList_TestData.put(30, 113);
        primeList_TestData.put(31, 127);
        primeList_TestData.put(32, 131);
        primeList_TestData.put(33, 137);
        primeList_TestData.put(34, 139);
        primeList_TestData.put(35, 149);
        primeList_TestData.put(36, 151);
        primeList_TestData.put(37, 157);
        primeList_TestData.put(38, 163);
        primeList_TestData.put(39, 167);
        primeList_TestData.put(40, 173);
        primeList_TestData.put(41, 179);
        primeList_TestData.put(42, 181);
        primeList_TestData.put(43, 191);
        primeList_TestData.put(44, 193);
        primeList_TestData.put(45, 197);
    }

    @BeforeMethod
    public void startTimer() {
        start = System.currentTimeMillis();
    }

    @AfterMethod
    public void endTimer(ITestResult result) {
        end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Test Method : " + result.getMethod().getMethodName() +
                " Execution time : " + formatter.format((end - start) / 1000d) + " seconds");
    }

    @Test(dataProvider = "getPrimeNumberListSize")
    public void testGetPrimeNumberMultiplicationList(int size) throws Exception {
        Map<Integer, Integer> primeList_Result = primeMultiplicationTable.getPrimeNumber(size);
        Map<String, Integer> primeMultiplicationList_Result =
                primeMultiplicationTable.getPrimeNumberMultiplicationList(primeList_Result);
        assertEquals(primeList_Result.size() * primeList_Result.size(),
                primeMultiplicationList_Result.size());

        for (int i = 1; i <= primeList_Result.size(); i++) {
            for (int j = 1; j <= primeList_Result.size(); j++) {
                String key = primeList_TestData.get(i) + " * " + primeList_TestData.get(j);
                assertEquals(primeList_TestData.get(i) * primeList_TestData.get(j),
                        primeMultiplicationList_Result.get(key).intValue());
            }
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPrimeNumberMultiplicationEmptyList()throws Exception {
        Map<Integer, Integer> primeList_Result = new HashMap<Integer, Integer>();
        primeMultiplicationTable.getPrimeNumberMultiplicationList(primeList_Result);
     }

    @Test(dataProvider = "getPrimeNumberListSize")
    public void testGetPrimeNumberList(int size) throws Exception {
        Map<Integer, Integer> primeList_Result = primeMultiplicationTable.getPrimeNumber(size);
        for (int i = 1; i < primeList_Result.size(); i++)
            assertEquals(primeList_TestData.get(i), primeList_Result.get(i), "It is failing for size : " + size);
    }

    @Test(dataProvider ="getPrimeNumberListSize_negative", expectedExceptions = IllegalArgumentException.class)
    public void testGetPrimeNumber_NegativeSize(int size) throws Exception {
         primeMultiplicationTable.getPrimeNumber(size);
    }

}