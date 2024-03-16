import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPrimeNumber {

  @Test
  void testIsPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(prime.checkIfPrime(2));
    assertTrue(prime.checkIfPrime(3));
    assertTrue(prime.checkIfPrime(7));
  }

  void testIsNotPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertFalse(prime.checkIfPrime(4));
    assertFalse(prime.checkIfPrime(6));
    assertFalse(prime.checkIfPrime(10));
  }
}
