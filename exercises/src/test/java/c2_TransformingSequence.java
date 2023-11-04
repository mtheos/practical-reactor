import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * It's time to do some data manipulation!
 * <p>
 * Read first:
 * <p>
 * https://projectreactor.io/docs/core/release/reference/#which.values
 * <p>
 * Useful documentation:
 * <p>
 * https://projectreactor.io/docs/core/release/reference/#which-operator
 * https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html
 * https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html
 *
 * @author Stefan Dragisic
 */
public class c2_TransformingSequence extends TransformingSequenceBase {

  /***
   * Your task is simple:
   *  Increment each number emitted by the numerical service
   */
  @Test
  public void transforming_sequence() {
    //todo change only this line
    Flux<Integer> numbersFlux = numerical_service();

    //StepVerifier is used for testing purposes
    //ignore it for now, or explore it independently
    StepVerifier.create(numbersFlux).expectNext(2, 3, 4, 5, 6, 7, 8, 9, 10, 11).verifyComplete();
  }

  /***
   * Transform given number sequence to:
   *   - ">": if given number is greater than 0
   *   - "=": if number is equal to 0
   *   - "<": if given number is lesser then 0
   */
  @Test
  public void transforming_sequence_2() {
    Flux<Integer> numbersFlux = numerical_service_2();

    //todo: do your changes here
    Flux<String> resultSequence = null;

    //don't change code below
    StepVerifier.create(resultSequence).expectNext(">", "<", "=", ">", ">").verifyComplete();
  }

  /**
   * `object_service()` streams sequence of Objects, but if you peek into service implementation, you can see
   * that these items are in fact strings!
   * Casting using `map()` to cast is one way to do it, but there is more convenient way.
   * Remove `map` operator and use more appropriate operator to cast sequence to String.
   */
  @Test
  public void cast() {
    Flux<String> numbersFlux = object_service().map(i -> (String) i); //todo: change this line only


    StepVerifier.create(numbersFlux).expectNext("1", "2", "3", "4", "5").verifyComplete();
  }

  /**
   * `maybe_service()` may return some result.
   * In case it doesn't return any result, return value "no results".
   */
  @Test
  public void maybe() {
    //todo: change this line only
    Mono<String> result = maybe_service();

    StepVerifier.create(result).expectNext("no results").verifyComplete();
  }

  /**
   * Reduce the values from `numerical_service()` into a single number that is equal to sum of all numbers emitted by
   * this service.
   */
  @Test
  public void sequence_sum() {
    //todo: change code as you need
    Mono<Integer> sum = null;
    numerical_service();

    //don't change code below
    StepVerifier.create(sum).expectNext(55).verifyComplete();
  }

  /***
   *  Reduce the values from `numerical_service()` but emit each intermediary number
   *  Use first Flux value as initial value.
   */
  @Test
  public void sum_each_successive() {
    //todo: do your changes here
    Flux<Integer> sumEach = numerical_service();

    StepVerifier.create(sumEach).expectNext(1, 3, 6, 10, 15, 21, 28, 36, 45, 55).verifyComplete();
  }

  /**
   * A developer who wrote `numerical_service()` forgot that sequence should start with zero, so you must prepend zero
   * to result sequence.
   * <p>
   * Do not alter `numerical_service` implementation!
   * Use only one operator.
   */
  @Test
  public void sequence_starts_with_zero() {
    //todo: change this line only
    Flux<Integer> result = numerical_service();

    StepVerifier.create(result).expectNext(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).verifyComplete();
  }
}
