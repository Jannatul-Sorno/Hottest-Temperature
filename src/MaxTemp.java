import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class MaxTemp {
	public CSVRecord hottestHourInDay(CSVParser parser)
	{
		CSVRecord largestSoFar = null;
		for(CSVRecord currentRow : parser)
		{
			if(largestSoFar == null)
				largestSoFar = currentRow;
			else
			{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if(currentTemp > largestTemp)
					largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}
	public void testHottestHourInDay()
	{
		FileResource fr = new FileResource();
		CSVRecord largest = hottestHourInDay(fr.getCSVParser());
		System.out.println(largest.get("TemperatureF"));
	}
	public static void main(String[] args)
	{
		MaxTemp c = new MaxTemp();
		c.testHottestHourInDay();
	}
}