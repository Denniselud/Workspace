package pack1;

import java.math.BigInteger;

/**
 * 
 * @author Dennis
 *
 */
public class BinKoeffizent {
	/**
	 * Binominal Koeffizent berechnen
	 * 
	 * @param Long n
	 * @param Long k
	 * @return BigInteger
	 */
	public static BigInteger calc(Long n, Long k) {

		BigInteger nf = Fakultet.fakultet(n);			// n!
		BigInteger kf = Fakultet.fakultet(k);			// k!
		BigInteger nMinusK = Fakultet.fakultet(n - k);	// (n-k)!
		BigInteger mul = nMinusK.multiply(kf);			// (n-k)!*k!
		BigInteger erg = nf.divide(mul);				// n!/((n-k)!*k!)!
		return erg;
	}

}
