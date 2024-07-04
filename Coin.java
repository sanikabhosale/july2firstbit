package casestudy3;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

public class Coin {
		int id;
		String country;
		String denomination;
		int minting_year;
		double current_value;
		LocalDate AcquiredDate;
		public Coin(int id, String country, String denomination,int minting_year, double current_value,
				String acquired) {
			super();
			this.id = id;
			this.country = country;
			this.denomination = denomination;
			this.minting_year = minting_year;
			this.current_value = current_value;
			this.AcquiredDate=LocalDate.parse(acquired);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getDenomination() {
			return denomination;
		}
		public void setDenomination(String denomination) {
			this.denomination = denomination;
		}
		public int getMinting_year() {
			return minting_year;
		}
		public void setMinting_year(int minting_year) {
			this.minting_year = minting_year;
		}
		public double getCurrent_value() {
			return current_value;
		}
		public void setCurrent_value(double current_value) {
			this.current_value = current_value;
		}
		

         public LocalDate getAcquiredDate() {
			return AcquiredDate;
		}
		public void setAcquiredDate(LocalDate acquiredDate) {
			AcquiredDate = acquiredDate;
		}
		
         public String toString()
         {
        	 String s=+this.id+"  "+this.getCountry()+"  "+this.denomination+"  "+this.getMinting_year()+"  "+this.current_value+"   "+this.getAcquiredDate();
        	 return s;
         }
		
	
	
}
