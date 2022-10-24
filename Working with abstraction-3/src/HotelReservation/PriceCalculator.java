package HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private String season;
    private String discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }
    public PriceCalculator(double pricePerDay, int numberOfDays, String season) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = "None";
    }
    public String price(){
        double total=pricePerDay*numberOfDays;
        total=seasonPriceAdd(total,season);
        total=discountPrice(total,discountType);
        return String.format("%.2f",total);
    }

    private double discountPrice(double total, String discountType) {
        switch (discountType){
            case "VIP":
                return total*0.80;
            case "SecondVisit":
                return total*0.90;
            case "None":
                return total;
        }
        return total;
    }

    private double seasonPriceAdd(double total, String season) {
        switch (season){
            case "Autumn":
                return total;
            case "Spring":
                return total*2;
            case "Winter":
                return total*3;
            case "Summer":
                return total*4;
        }
        return total;
    }
}
