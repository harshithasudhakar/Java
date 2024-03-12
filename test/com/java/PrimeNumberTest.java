import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

  @Test
  void testIsPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(PrimeNumber.checkIfPrime(2));
    assertTrue(PrimeNumber.checkIfPrime(3));
    assertTrue(PrimeNumber.checkIfPrime(7));
  }

  void testIsNotPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertFalse(PrimeNumber.checkIfPrime(4));
    assertFalse(PrimeNumber.checkIfPrime(6));
    assertFalse(PrimeNumber.checkIfPrime(10));
  }
}
