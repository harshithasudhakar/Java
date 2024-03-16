import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberTest {

  @Test
  public void testIsPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(prime.checkIfPrime(2));
    assertTrue(prime.checkIfPrime(3));
    assertTrue(prime.checkIfPrime(7));
  }

  @Test
  public void testIsNotPrime(){
    PrimeNumber prime = new PrimeNumber();
    assertTrue(prime.checkIfPrime(4));
    assertTrue(prime.checkIfPrime(6));
    assertTrue(prime.checkIfPrime(10));
  }
}
