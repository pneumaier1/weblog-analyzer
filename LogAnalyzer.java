/**
 * Read web server data and analyse hourly access patterns.
 *
 * @Paul Neumaier
 * @version    2019.10.14
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
	private int[] dayCounts;
	public static int acc;
	private int[] monthCounts;
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    {
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[31];
        monthCounts = new int[12];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);

    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    public int numberOfAccesses()
    {
		acc ++;

	}
	public int busiestHour()
	{
		int maxHours = hourCounts[0];
		for (int i = 0; i < hourCounts.length; i++)
			{
				if(maxHours < hourCounts[i])
					maxHours = hourCounts.length;
			}
	}



	public int quietestHour()
	{
		int minHours = hourCounts[0];
		for (int i = 0; i > hourCounts.length; i++)
			{
				if(minHours > hourCounts[i])
					minHours = hourCounts.length;
			}
	}
	public int busiestTwoHour()
	{
		int maxOne = hourCounts[0];
		int maxTwo = hourCounts[0];
		for (int i = 0; hourCounts[i] i++)
			{
				if(maxOne< hourCounts[i])
					maxOne = hourCounts.length;

				else if(maxTwo< hourCounts[i]
					maxTwo = hourCounts.length;


			}

		if(maxOne > maxTwo)
			return maxOne;
		else
			return maxTwo;
	}
	public int quietestDay()
		{
			int minDay = dayCounts[0];
			for (int i = 0; i > dayCounts.length; i++)
				{
					if(minDay > dayCounts[i])
						minday = dayCounts.length;
				}
		}
	public int busiestDay()
		{
			int maxDay = dayCounts[0];
			for (int i = 0; i < dayCounts.length; i++)
				{
					if(maxDay > dayCounts[i])
						maxDay = dayCounts.length;
				}
		}
	public int busiestMonth()
		{
			int maxMonth = monthCounts[0];
			for (int i = 0; i > monthCounts.length; i++)
				{
					if(maxMonth > monthCounts[i])
						maxMonth = monthCounts.length;
				}
	    }
	public int quietestMonth()
		{
			int minMonth = monthCounts[0];
			for (int i = 0; i > monthCounts.length; i++)
				{
					if(minMonth < monthCounts[i])
						minMonth = monthCounts.length;
				}
	    }


}
