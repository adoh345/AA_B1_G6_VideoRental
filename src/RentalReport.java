import java.util.List;

public class RentalReport {

    public String getReport(List<Rental> rentals)
    {
        String result = "";

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {

            int daysRented = each.getDaysRented();
            double eachCharge = each.getEachCharge(daysRented);
            int eachPoint = each.getEachPoint(daysRented);

            result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                    + "\tPoint: " + eachPoint + "\n";

            totalCharge += eachCharge;

            totalPoint += eachPoint ;
        }

        result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

        checkFreeCoupon(totalPoint);

        return result ;
    }


    private  void checkFreeCoupon(int totalPoint) {

        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");

        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
    }
}
