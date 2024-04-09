
import org.junit.Test;
import rx.observables.BlockingObservable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void canCalculateThePriceOfItemsNotOnOffer() {
        List<Items> basketOfApples = Arrays.asList(Items.Apple, Items.Apple, Items.Apple);
         Calculator calc = new Calculator(basketOfApples);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(105));
    }

    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyOneGetOneFree() {
        List<Items> basketOfMelons = Arrays.asList(Items.Melon, Items.Melon, Items.Melon);
        Calculator calc = new Calculator(basketOfMelons);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(100));
    }

    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyThreeForThePriceOfTwo() {
        List<Items> basketOfLimes = Arrays.asList(Items.Lime, Items.Lime, Items.Lime, Items.Lime);
        Calculator calc = new Calculator(basketOfLimes);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(45));
    }

    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems() {
        List<Items> basket = Arrays.asList(Items.Banana, Items.Banana, Items.Banana, // 60
                                            Items.Apple, Items.Apple, Items.Apple,  // 105
                                            Items.Melon, Items.Melon, Items.Melon,  // 100
                                            Items.Lime, Items.Lime, Items.Lime, Items.Lime); // 45
        Calculator calc = new Calculator(basket);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(310));
    }

    @Test
    public void canCalculateThePriceOfAnEmptyBasket() {
        List<Items> basket = Arrays.asList();
        Calculator calc = new Calculator(basket);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(0));
    }

}
