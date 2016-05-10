
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alwin on 5/9/2016.
 */
public class PrimeMultiplicationTable {
    /* Prints multiplication table in Java */
    private static Map<String, Integer> primeMultiplicationList;

    static {
        primeMultiplicationList = new HashMap<String, Integer>();
    }

    public static void main(String[] args) {
            int tableSize = 10;
            Map<Integer, Integer> primeList = getPrimeNumber(tableSize);
            printPrimeMultiplicationTable(primeList);
        }

    /** To print prime number multiplication table based on prime number list provided
     * @param      primeList    list of prime numbers.
     * @exception  IllegalArgumentException  if the <code>primeList</code> is empty.
     */

    public static void printPrimeMultiplicationTable(Map<Integer, Integer> primeList){
        if (primeList.isEmpty()) throw new IllegalArgumentException("Prime Number list cannot be null");
        // Header Row to print Prime Number
        System.out.format("      ");
        for (int i = 1; i <= primeList.size(); i++) {
            System.out.format("%4d", primeList.get(i));
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
        primeMultiplicationList= getPrimeNumberMultiplicationList(primeList);
        for (int i = 1; i <= primeList.size(); i++) {
            System.out.format("%4d |", primeList.get(i));
            for (int j = 1; j <= primeList.size(); j++) {
                String key = primeList.get(i) + " * " + primeList.get(j);
                System.out.format("%4d",primeMultiplicationList.get(key));
            }
            System.out.println();
        }
    }

    /** To get prime number multiplication table based on prime number list provided
     * @param      primeList    list of prime numbers.
     * @exception  IllegalArgumentException  if the <code>primeList</code> is empty.
     * @return     primeNumberMultiplicationMap  map of prime numbers multiplication table.
     */

    public static Map<String, Integer> getPrimeNumberMultiplicationList(Map<Integer, Integer> primeList)
    {
        if (primeList.isEmpty()) throw new IllegalArgumentException("Prime Number list cannot be null");
        Map<String, Integer> primeNumberMultiplicationMap = new HashMap();
        for (int i = 1; i <= primeList.size(); i++) {
            for (int j = 1; j <= primeList.size(); j++) {
                primeNumberMultiplicationMap.put(primeList.get(i) + " * " + primeList.get(j), primeList.get(i) * primeList.get(j));
            }
        }
        return primeNumberMultiplicationMap;
    }

    /** To get prime number list based on size provided
     * @param      size    list of prime number from 1 to size.
     * @exception  IllegalArgumentException  if the <code>size</code> is <= 0.
     * @return     primeMap  map of prime numbers from 1 to size.
     */

    public static Map<Integer, Integer> getPrimeNumber(int size) {
        int status = 1;
        int num = 3;
        Map<Integer, Integer> primeMap = new HashMap();
        if (size == 0) throw new IllegalArgumentException
                ("Prime Number list generation Size cannot be zero");
        if (size < 0) throw new IllegalArgumentException
                ("Prime Number list generation Size cannot be negative");

        if (size == 1)
        {
            primeMap.put(1, 2);
        } else {
            primeMap.put(1, 2);
            for (int i = 2; i <= size; ) {
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        status = 0;
                        break;
                    }
                }
                if (status != 0) {
                    primeMap.put(i, num);
                    i++;
                }
                status = 1;
                num++;
            }
        }
        return primeMap;
    }
}
