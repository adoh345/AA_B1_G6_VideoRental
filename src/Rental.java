import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public String getTitle(){
		return video.getTitle();
	}

	public int getPriceCode(){
		return video.getPriceCode();
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getDaysRentedLimit() {

		if ( getDaysRented() <= 2) return 0;

		switch ( video.getVideoType() ) {
			case Video.VHS: return 5 ;
			case Video.CD: return 3 ;
			case Video.DVD: return 2 ;
		}
		return 0;
	}

	public int getEachPoint(int daysRented) {
		int eachPoint = 1;

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}


	public int getDaysRented() {
		int daysRented;
		long diff;

		long rentDate = getRentDate().getTime();

		if (getStatus() == 1) { // returned Video
			diff = getReturnDate().getTime() - rentDate;

		} else { // not yet returned
			diff = new Date().getTime() - rentDate;

		}
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

		return daysRented;
	}

	public double getEachCharge(int daysRented) {
		double eachCharge = 0;

		switch (getVideo().getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
		}
		return eachCharge;
	}

}
