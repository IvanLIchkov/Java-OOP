package HotelReservation;

public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double priceReductionFactor;

    DiscountType(double priceReductionFactor) {
        this.priceReductionFactor = priceReductionFactor;
    }

    public double getPriceReductionFactor(){
        return priceReductionFactor;
    }
    public static DiscountType parse(String s){
        switch (s){
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
              throw new IllegalArgumentException("Unknown enum value"+s);
        }
    }
}
