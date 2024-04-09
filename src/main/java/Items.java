
public class Items {
    private String name;
    private OfferEnum offer;
    private Integer unitPrice;

    public static Items Apple = new Items("Apple", OfferEnum.NONE, 35);
    public static Items Banana = new Items("Banana", OfferEnum.NONE, 20);
    public static Items Melon = new Items("Melon", OfferEnum.BUY_ONE_GET_ONE_FREE, 50);
    public static Items Lime = new Items("Lime", OfferEnum.BUY_THREE_FOR_THE_PRICE_OF_TWO, 15);

    public Items(String name, OfferEnum offer, Integer unitPrice) {
         this.name = name; this.offer = offer; this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }


    public boolean onOffer(OfferEnum offer) {
        return this.offer == offer;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

}
