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
}
