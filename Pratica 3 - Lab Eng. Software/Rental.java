public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        double amount = 0;
        // determine amounts for each line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (getDaysRented() > 2)
                    amount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (getDaysRented() > 3)
                    amount += (getDaysRented() - 3) * 1.5;
                break;
        }

        return amount;
    }

    public int getFrequentRenterPoints() { 
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }

     }
}
