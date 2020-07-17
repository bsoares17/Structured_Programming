package conversions;

import javax.swing.JOptionPane;

public class MetricToEnglishAndEnglishToMetric 
{
	public MetricToEnglishAndEnglishToMetric() 
	{
		makeChoice();
	}

	private void makeChoice() 
	{
		String selection;
		String options = "\n0 - exit\n1 - convert from metric to english\n2 - convert from english to metric";
		selection = JOptionPane.showInputDialog("Select what you would like to do" + options);

		switch (selection.charAt(0)) 
		{
		case '0':
			System.exit(0);
			break;
		case '1':
			metricToEnglish();
			break;
		case '2':
			englishToMetric();
			break;
		}
	}

	private void metricToEnglish() 
	{
		int kilometers = 0;
		int meters = 0;
		double centimeters = 0;
		int totalMeters = 0;
		double totalCentimeters = 0;
		int miles = 0;
		int yards = 0;
		int feet = 0;
		double inches = 0;
		double totalInches = 0;
		double totalFeet = 0;
		double totalYards = 0;
		double totalMiles = 0;

		kilometers = inputIntDistance("kilometers");
		meters = inputIntDistance("meters");
		centimeters = inputDoubleDistance("centimeters");

		totalMeters += meters + convertKilometersToMeters(kilometers);

		totalCentimeters += centimeters + convertMetersToCentimeters(totalMeters);

		totalInches = convertCentimetersToTotalInches(totalCentimeters);

		totalFeet += convertTotalInchesToTotalFeet(totalInches);

		inches += findInchesAfterFeetAreRemovedFromTotalInches(totalInches);

		totalYards += convertTotalFeetToYards(totalFeet);

		feet += findFeetAfterYardsAreRemovedFromTotalFeet(totalFeet);

		totalMiles += convertYardsToMiles(totalMiles);

		yards += findYardsAfterMilesAreRemovedFromTotalYards(totalYards);

		displayEnglish(kilometers, meters, centimeters, miles, yards, feet, inches);
	}

	public void displayEnglish(int kilometers, int meters, double centimeters, int miles, int yards, int feet,
			double inches) 
	{
		JOptionPane.showMessageDialog(null,
				kilometers + " kilometers, " + meters + " meters, and " + round(centimeters, 2)
						+ " centimeters converts to \n" + miles + " miles, " + yards + " yards, " + feet + " feet, and "
						+ round(inches, 2) + " inches ");
	}

	private void englishToMetric() 
	{
		int kilometers2 = 0;
		int meters2 = 0;
		double centimeters2 = 0;
		double totalMeters = 0;
		double totalCentimeters = 0;
		int miles2 = 0;
		double yards2 = 0;
		int feet2 = 0;
		double inches2 = 0;
		double totalInches = 0;
		double totalFeet = 0;
		double totalYards = 0;
		double totalKilometers = 0;

		miles2 = inputIntDistance("miles");
		yards2 = inputDoubleDistance("yards");
		feet2 = inputIntDistance("feet");
		inches2 = inputDoubleDistance("inches");

		totalYards = yards2 + convertMilesToYards(miles2);

		totalFeet += feet2 + convertYardsToFeet(totalYards);

		totalInches += inches2 + convertFeetToTotalInches(totalFeet);

		totalCentimeters += convertInchesToTotalCentimeters(totalInches);

		centimeters2 += findCentimetersAfterInchesAreRemoved(totalCentimeters);

		totalMeters += convertCentimetersToMeters(totalCentimeters);

		meters2 += findMetersAfterCentimetersAreRemoved(totalMeters);

		totalKilometers += convertMetersToKilometers(totalMeters);

		kilometers2 += findKilometersAfterMetersAreRemoved(totalKilometers);

		displayMetric(kilometers2, meters2, centimeters2, miles2, yards2, feet2, inches2);
	}

	private void displayMetric(int kilometers2, int meters2, double centimeters2, int miles2, double yards2, int feet2,
			double inches2) {
		JOptionPane.showMessageDialog(null,
				miles2 + " miles, " + yards2 + " yards, " + feet2 + " feet, " + " and, " + round(inches2, 2)
						+ " inches converts to " + kilometers2 + " kilometers, " + meters2 + " meters, and "
						+ round(centimeters2, 2) + " centimeters");

	}

	public int convertKilometersToMeters(int kilometers) 
	{
		return kilometers * 1000;
	}

	public int convertMetersToCentimeters(int meters) 
	{
		return meters * 100;
	}

	public double convertCentimetersToTotalInches(double totalCentimeters) 
	{
		return totalCentimeters / 2.54;
	}

	public int convertTotalInchesToTotalFeet(double totalInches) 
	{
		return (int) totalInches / 12;
	}

	public double findInchesAfterFeetAreRemovedFromTotalInches(double totalInches) 
	{
		return totalInches % 12;
	}

	public double convertTotalFeetToYards(double totalFeet) 
	{
		return totalFeet / 3;
	}

	public double findFeetAfterYardsAreRemovedFromTotalFeet(double totalYards) 
	{
		return totalYards % 3;
	}

	public double convertYardsToMiles(double totalMiles) 
	{
		return totalMiles / 1760;
	}

	public double findYardsAfterMilesAreRemovedFromTotalYards(double totalYards) 
	{
		return totalYards % 1760;
	}

	public double convertMilesToYards(double miles2) 
	{
		return miles2 * 1760;
	}

	public double convertYardsToFeet(double totalYards) 
	{
		return totalYards * 3;
	}

	public int convertFeetToTotalInches(double totalFeet) 
	{
		return (int) totalFeet * 12;
	}

	public double findFeetAfterInchesAreRemovedFromTotalFeet(double totalInches) 
	{
		return totalInches % 12;
	}

	public double convertInchesToTotalCentimeters(double totalInches) 
	{
		return totalInches * 2.54;
	}

	public double findCentimetersAfterInchesAreRemoved(double totalCentimeters) 
	{
		return totalCentimeters * 2.54;
	}

	public double convertCentimetersToMeters(double totalMeters) 
	{
		return totalMeters / 100;
	}

	public double findMetersAfterCentimetersAreRemoved(double totalMeters) 
	{
		return totalMeters % 100;
	}

	public double convertMetersToKilometers(double totalKilometers) 
	{
		return totalKilometers / 1000;
	}

	public double findKilometersAfterMetersAreRemoved(double totalKilometers) 
	{
		return totalKilometers % 1000;
	}

	public int inputIntDistance(String message) 
	{
		String number;

		do {
			number = JOptionPane.showInputDialog("please input a value for " + message);
		} while (!canBePositiveInt(number));

		return Integer.parseInt(number);
	}

	public double inputDoubleDistance(String message) 
	{
		String number;

		do {
			number = JOptionPane.showInputDialog("please input a value for " + message);
		} while (!canBePositiveDouble(number));

		return Double.parseDouble(number);
	}

	public boolean canBePositiveInt(String tempString) 
	{
		for (int n = 0; n < tempString.length(); n++) 
		{
			if (n == 0 && tempString.charAt(0) == '+')
				continue;

			if (tempString.charAt(n) < '0' || tempString.charAt(n) > '9')
				return false;
		}
		return true;
	}

	public boolean canBePositiveDouble(String tempString) 
	{
		boolean validDecimalPoint = false;

		for (double n = 0; n < tempString.length(); n++) 
		{
			if (n == 0 && tempString.charAt(0) == '+')
				continue;

			if (!validDecimalPoint) {
				if (tempString.charAt(0) == '.')
				{
					validDecimalPoint = true;
					continue;
				}
			}

			if (tempString.charAt(0) < '0' || tempString.charAt(0) > '9')
				return false;
		}
		return true;
	}

	public double round(double numberToRound, int numberOfPlaces) 
	{
		double tempDouble = (numberToRound * Math.pow(10, numberOfPlaces));

		tempDouble += .5;

		int tempInt = (int) tempDouble;

		tempDouble = tempInt / Math.pow(10, numberOfPlaces);

		return tempDouble;
	}
}