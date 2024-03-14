import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPrimeNumber {

  @Test
  void testIsPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(PrimeNumber.checkIfPrime(2));
    assertTrue(PrimeNumber.checkIfPrime(3));
    assertTrue(PrimeNumber.checkIfPrime(7));
  }

  void testIsNotPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(PrimeNumber.checkIfPrime(4));
    assertTrue(PrimeNumber.checkIfPrime(6));
    assertTrue(PrimeNumber.checkIfPrime(10));
  }
}
