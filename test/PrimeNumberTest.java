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
    assertFalse(prime.checkIfPrime(4));
    assertFalse(prime.checkIfPrime(6));
    assertFalse(prime.checkIfPrime(10));
  }

  @Test
  public void testNorPrimeNorComposite(){
    PrimeNumber prime = new PrimeNumber();
    assertthrows(IllegalArgumentException.class,
                () -> {
                  prime.checkIfPrime(-1);
                });
    assertthrows(IllegalArgumentException.class,
                () -> {
                  prime.checkIfPrime(0);
                });
    assertthrows(IllegalArgumentException.class,
                () -> {
                  prime.checkIfPrime(1);
                });
  }
}
