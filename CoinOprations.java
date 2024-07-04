package casestudy3;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoinOprations {

	static List<Coin> coinList=new ArrayList();
	static List<String> list=new ArrayList();
	
	static Scanner sc=new Scanner(System.in);
	 public CoinOprations() {
		// TODO Auto-generated constructor stub
	}
	public static void coinCollection() throws SQLException 
	{
		
		int ch1;
		System.out.println("1.add coin thought database\n2.add in file"); 
    	ch1=sc.nextInt();
        switch(ch1)
        {
        case 1:
        	fech();
        break;
        case 2:
        	addFileData();
        break;
        	
        }
		int ch;
		do
		{	
		System.out.println("1.add Coin \n2.update Coin \n3.delete Coin \n4.search Coin \n5.display \n6.sorted by Current value\n0.exit");
	    ch=sc.nextInt();
	    switch(ch)
	    {
	    case 1:
	    	addCoin();
	    	break;
	    case 2:
	    	updateCoin();
	    	break;
	    case 3:
	    	deleteCoin();
	    	break;
	    case 4:
	    	searchCoin();
	    	break;
	    case 5:
	    	display();
	    	break;
	    case 6:
	    	sortByCurrentValue();
	    }	
	    if(ch==0)
	    {
	    	saveInDatabase();
	    }
	    }while(ch!=0);
	    
	}
	

	

	public static void sortByCurrentValue() {
		// TODO Auto-generated method stub
		List<Coin> CoinList1=new ArrayList();
		for(Coin x:coinList)
		{
			CoinList1.add(x);
		}
		Collections.sort(CoinList1, new Comparator<Coin>()
				{

					@Override
					public int compare(Coin o1, Coin o2) {
						// TODO Auto-generated method stub
						return Double.compare(o1.getCurrent_value(), o2.getCurrent_value());
					}
			
				});
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("| id | Country | Denomination | Minting Year | Current Value | Acquired Date |");
	    System.out.println("|----|---------|--------------|--------------|---------------|---------------|");
	    for (Coin x : CoinList1) {
	        System.out.printf("| %2d | %-7s | %-12s | %12d | %13.1f | %13s |\n", 
	                           x.id, x.country, x.denomination, x.minting_year, x.getCurrent_value(), x.getAcquiredDate());
	    }
	    System.out.println("+----------------------------------------------------------------------------+");
	
		
	}

	public static void addCoin()
	{
		
				int id;
				String country;
				String denomination;
				int minting_year;
				double value;
				String acquired;
				System.out.println("Enter coin id:");
				id=sc.nextInt();
				System.out.println("Enter coin country:");
				country=sc.next();
				System.out.println("Enter coin denomination(type):");
				denomination=sc.next();
				System.out.println("Enter coin minting year:");
				minting_year=sc.nextInt();
				System.out.println("Enter coin Current value:");
				value=sc.nextDouble();
				System.out.println("Enter coin  Acquired date in yyyy-mm-dd format:");
				acquired=sc.next();
				Coin c1=new Coin(id,country,denomination,minting_year,value,acquired);
				coinList.add(c1);
				list.add("Ins");
				
				System.out.println("Coin added successfully!");

		
		
	}
	
	public static void addFileData() 
	{
		try {
			Scanner s=new Scanner(new File("coin1.csv"));
			while(s.hasNext())
			{
				String str=s.nextLine();
				String[] cn=str.split(",");
				int id=Integer.parseInt(cn[0]);
				int year=Integer.parseInt(cn[3]);
				double d=Double.parseDouble(cn[4]);
				Coin c=new Coin(id,cn[1],cn[2],year,d,cn[5].toString());
				coinList.add(c);
				list.add("Ins");
			}
		} catch (NumberFormatException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void updateCoin()
	{
	
		int ch;
		do
		{
		System.out.println("1.Country\n2. Denomination\n3.Current Value \n4.Year of Minting\n5.Acquired Date\n0.exit");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			updateCountry();
		break;
		case 2:
			updateDenomination();
		break;
		case 3:	
			updateValue();	
		break;
		case 4:
			updateMintingYear();
		break;
		case 5:
			updateAcquireDate();
		break;
		
		}

	}while(ch!=0);
}
	
	public static void updateValue()
	{
		System.out.println("Enter coin id");
		int id=sc.nextInt();
		double upvalue;
		int f=0;
		for(int i=0;i<coinList.size();i++)
		{
			if(coinList.get(i).getId()==id)
			{
				System.out.println("Enter updated coin value");
				upvalue=sc.nextDouble();
				coinList.get(i).setCurrent_value(upvalue);
				if(list.get(i).equalsIgnoreCase("Uc"))
				     list.set(i,"UP");
				else if(list.get(i).equalsIgnoreCase("Ins"))
					 list.set(i,"Ins");
				else if(list.get(i).equalsIgnoreCase("del"))
					System.out.println("record are deleted");
				System.out.println("updated succsesfully");
				f++;
			}
		}
		if(f==0)
		{
			System.out.println("id not found");
		}
	}
	public static void updateCountry()
	{
		System.out.println("Enter coin id");
		int id=sc.nextInt();
		String up;
		int f=0;
		for(int i=0;i<coinList.size();i++)
		{
			if(coinList.get(i).getId()==id)
			{
				System.out.println("Enter updated coin Country");
				up=sc.next();
				coinList.get(i).setCountry(up);
				if(list.get(i).equalsIgnoreCase("Uc"))
				     list.set(i,"UP");
				else if(list.get(i).equalsIgnoreCase("Ins"))
					 list.set(i,"Ins");
				else if(list.get(i).equalsIgnoreCase("del"))
					System.out.println("record are deleted");
				System.out.println("updated succsesfully");
				f++;
			}
		}
		if(f==0)
		{
			System.out.println("id not found");
		}
	}
	
	public static void updateDenomination()
	{
		System.out.println("Enter coin id");
		int id=sc.nextInt();
		String up;
		int f=0;
		for(int i=0;i<coinList.size();i++)
		{
			if(coinList.get(i).getId()==id)
			{
				System.out.println("Enter updated coin Denomination");
				up=sc.next();
				coinList.get(i).setDenomination(up);
				if(list.get(i).equalsIgnoreCase("Uc"))
				     list.set(i,"UP");
				else if(list.get(i).equalsIgnoreCase("Ins"))
					 list.set(i,"Ins");
				else if(list.get(i).equalsIgnoreCase("del"))
					System.out.println("record are deleted");
				System.out.println("updated succsesfully");
				f++;
			}
		}
		if(f==0)
		{
			System.out.println("id not found");
		}
	}
	public static void updateMintingYear()
	{
		System.out.println("Enter coin id");
		int id=sc.nextInt();
		int up;
		int f=0;
		for(int i=0;i<coinList.size();i++)
		{
			if(coinList.get(i).getId()==id)
			{
				System.out.println("Enter updated coin Minting Year");
				up=sc.nextInt();
				coinList.get(i).setMinting_year(up);
				if(list.get(i).equalsIgnoreCase("Uc"))
				     list.set(i,"UP");
				else if(list.get(i).equalsIgnoreCase("Ins"))
					 list.set(i,"Ins");
				else if(list.get(i).equalsIgnoreCase("del"))
					System.out.println("record are deleted");
				System.out.println("updated succsesfully");
				f++;
			}
		}
		if(f==0)
		{
			System.out.println("id not found");
		}
	}
	
	public static void updateAcquireDate()
	{
		System.out.println("Enter coin id");
		int id=sc.nextInt();
		int f=0;
		for(int i=0;i<coinList.size();i++)
		{
			if(coinList.get(i).getId()==id)
			{
				System.out.println("Enter updated coin Acquire Date");
				LocalDate up=LocalDate.parse(sc.next());
				coinList.get(i).setAcquiredDate(up);
				if(list.get(i).equalsIgnoreCase("Uc"))
				     list.set(i,"UP");
				else if(list.get(i).equalsIgnoreCase("Ins"))
					 list.set(i,"Ins");
				else if(list.get(i).equalsIgnoreCase("del"))
					System.out.println("record are deleted");
				System.out.println("updated succsesfully");
				f++;
			}
		}
		if(f==0)
		{
			System.out.println("id not found");
		}
	}
	
	
	public static void searchCoin()
	{
		int ch;
		do
		{
		System.out.println("1.Country\n2.Year of Minting\n3.Current Value (sorted)\n4.Country + Denomination\n5.Country + Year of Minting\n6.Country + Denomination + Year of Minting \n7.Acquired Date + Country\n0.exit");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			searchByCountry();
		break;
		case 2:
			searchByMintingyear();
		break;
		case 3:	
			searchByCurrentValue();	
		break;
		case 4:
			searchByCountryDenominatoion();
		break;
		case 5:
			searchByCountryMintingyear();
		break;
		case 6:
			searchByCountryDenominatoionMintingyear();
		break;
		case 7:
			searchByCountryAcquiredDate();
		break;
			
		}
		}while(ch!=0);
	}
	
	
	public static void searchByCountryAcquiredDate() {
		// TODO Auto-generated method stub
			System.out.println("Enter Country Name");
			String country=sc.next();
			System.out.println("Enter Acquired date of coin in yyyy-mm-dd format:");
			String date=sc.next();
			LocalDate date1=LocalDate.parse(date);
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCountry().equalsIgnoreCase(country) && coinList.get(i).getAcquiredDate().compareTo(date1)==0)
				{
					System.out.println(coinList.get(i).toString());
				}
			}

	}

	public static void searchByCountryDenominatoionMintingyear() {
		// TODO Auto-generated method stub

			System.out.println("Enter Country Name");
			String country=sc.next();
			System.out.println("Enter Denomination(type) of coin");
			String denomination=sc.next();
			System.out.println("Enter Minting year of coin");
			int year=sc.nextInt();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCountry().equalsIgnoreCase(country) && coinList.get(i).getDenomination().equalsIgnoreCase(denomination) && coinList.get(i).getMinting_year()==year)
				{
					System.out.println(coinList.get(i).toString());
				}
			}

		
	}

	public static void searchByCountryMintingyear() {
		// TODO Auto-generated method stub

			System.out.println("Enter Country Name");
			String country=sc.next();
			System.out.println("Enter Minting year of coin");
			int year=sc.nextInt();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCountry().equalsIgnoreCase(country) && coinList.get(i).getMinting_year()==year )
				{
					System.out.println(coinList.get(i).toString());
				}
			}

	}

	public static void searchByCountryDenominatoion() {
		// TODO Auto-generated method 

			System.out.println("Enter Country Name");
			String country=sc.next();
			System.out.println("Enter Denomination(type) of coin");
			String denomination=sc.next();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCountry().equalsIgnoreCase(country) && coinList.get(i).getDenomination().equalsIgnoreCase(denomination) )
				{
					System.out.println(coinList.get(i).toString());
				}
			}

		
	}
	

	public static void searchByCurrentValue() {
		// TODO Auto-generated method stub

			System.out.println("Enter Current Value ");
			double current_value=sc.nextDouble();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCurrent_value()==current_value)
				{
					System.out.println(coinList.get(i).toString());
				}
			}

		
	}

	public static void searchByMintingyear() {
		// TODO Auto-generated method stub
			System.out.println("Enter Year of Minting");
			int minting_year=sc.nextInt();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getMinting_year()==minting_year)
				{
					System.out.println(coinList.get(i).toString());
				}
			}

	}

	public static void searchByCountry() {
		// TODO Auto-generated method stub
		
			System.out.println("Enter Country Name");
			String country=sc.next();
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getCountry().equalsIgnoreCase(country))
				{
					System.out.println(coinList.get(i).toString());
				}
			}
	
	}

	public static void display() {
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("| id | Country | Denomination | Minting Year | Current Value | Acquired Date |");
	    System.out.println("|----|---------|--------------|--------------|---------------|---------------|");
	    for (Coin x : coinList) {
	    	//if(!list.get(x).equals("del"))
	        System.out.printf("| %2d | %-7s | %-12s | %12d | %13.1f | %13s |\n",x.id, x.country, x.denomination, x.minting_year, x.getCurrent_value(), x.getAcquiredDate());
	    }
	    System.out.println("+----------------------------------------------------------------------------+");
	}
	public static void deleteCoin() {
		// TODO Auto-generated method stub

			System.out.println("Enter coin id");
			int id=sc.nextInt();
			int f=0;
			for(int i=0;i<coinList.size();i++)
			{
				if(coinList.get(i).getId()==id)
				{
				//	coinList.remove(i);
					System.out.println("changes will be save after termination.....");
					if(list.get(i).equalsIgnoreCase("Uc") ||list.get(i).equalsIgnoreCase("Ins")||list.get(i).equalsIgnoreCase("Up"))
						list.set(i,"del");
					else if(list.get(i).equalsIgnoreCase("del"))
						 System.out.println("record are deleted");
					System.out.println("deleted succsesfully");
					f++;
				}
			}
			if(f==0)
			{
				System.out.println("id not found");
			}
	}	


	public static void fech() {
		// TODO Auto-generated method stub
		try {
			Connection con=Database.databaseConnection();
			String query="select * from CoinCollection";
			Statement stmt = con.createStatement();
			//stmt.setS(1, country);
			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt(1);
				 String country = rs.getString("country");
	                String denomination = rs.getString("denomination");
	                int yearOfMinting = rs.getInt("minting_year");
	                double currentValue = rs.getDouble("current_value");
	                String acquiredDate = rs.getDate("AcquiredDate").toString(); // Convert java.sql.Date to java.time.LocalDate

	                Coin c= new Coin(id,country, denomination, yearOfMinting, currentValue, acquiredDate);
	                coinList.add(c); 
	                list.add("uc");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void saveInDatabase() throws SQLException
	{
//		for(String x:list)
//			{
//				System.out.println(x);
//			}
		
		Connection con=Database.databaseConnection();
		java.sql.Date date1;
		for(int i=0;i<list.size();i++)
		{
			if(!list.get(i).equalsIgnoreCase("Uc"))
			{
			
				switch(list.get(i))
				{
				case "Ins":
				{
					String query="insert into CoinCollection values(?,?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, coinList.get(i).id);
					pstmt.setString(2,coinList.get(i).getCountry());
					pstmt.setString(3,coinList.get(i).getDenomination());
					pstmt.setInt(4, coinList.get(i).getMinting_year());
					pstmt.setDouble(5,coinList.get(i).getCurrent_value());
					 Date date = Date.valueOf(coinList.get(i).getAcquiredDate());
		              pstmt.setDate(6, date);
					int row=pstmt.executeUpdate();
					System.out.println(row+" "+"row affected  inserted succsesfully");
					
				}
				break;
		
				case "UP":
				{
					try {
						String query="update CoinCollection set country=?,denomination=?,minting_year=?,current_value=?,AcquiredDate=? where id=?";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1,coinList.get(i).getCountry());
						pstmt.setString(2,coinList.get(i).getDenomination());
						pstmt.setInt(3,coinList.get(i).getMinting_year());
						pstmt.setDouble(4,coinList.get(i).getCurrent_value());
						String date = coinList.get(i).getAcquiredDate().toString();
						  pstmt.setString(5, date);
						
//					date1=java.sql.Date.valueOf(coinList.get(i).getAcquiredDate());
//					pstmt.setDate(5, date1);
						pstmt.setInt(6, coinList.get(i).id);
						int row=pstmt.executeUpdate();
						System.out.println(row+" "+"row affected....updated succsesfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
				case "del":
				{
					String query="delete from CoinCollection where id=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1,coinList.get(i).id);
					int row=pstmt.executeUpdate();
					System.out.println(row+" "+"row affected....deleted succsesfully");
				}
				break;
			}
			}
			
		}
		
				      

	}

}
