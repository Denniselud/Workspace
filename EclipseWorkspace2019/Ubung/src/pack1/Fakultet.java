package pack1;

import java.math.BigInteger;
/**
 * Fakultät
 * @author Dennis
 *
 */
class Fakultet {
/**
 * 
 * @param Long f1
 * @return BigInteger
 */
	public static BigInteger fakultet(long f1) {

		long x = f1;
		BigInteger bi = new BigInteger("1");
		// System.out.println(bi.toString());

		while (x > 1) {
			bi = bi.multiply(BigInteger.valueOf(x));
			x--;
		}
		return bi;
	}
}