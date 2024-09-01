package FNSJ;

public class Weight {
	
	// instance variables
	private String comment,
					weightTier;
	private int wcate;
	private double weight, cweight;
	
	// a construtor to set the instnace variables as well as to call the priavate methods method 
	public Weight(double weight, int wcate) {
		this.wcate = wcate;
		this.weight = weight;
		setWeightTier();
		setComment();
	}
	
	private void setComment() // a private method made to set comment based on the user choise
	{
		if(weight > cweight) {
			if(weight < 73) {
				comment = "Your current weight is suitable for Flyweight!";
			}
			else if(weight >= 73 && weight < 81) {
				comment = "Your current weight is suitable for Lightweight!";
			}
			else if(weight >= 81 && weight < 90) {
				comment = "Your current weight is suitable for Light-Middleweight!";
			}
			else if(weight >= 90 && weight < 100) {
				comment = "Your current weight is suitable for Middleweight!";
			}
			else{
				comment = "Your current weight is suitable for Light-Heavyweight or Heavyweight.";
			}
		}
		else {
			comment = String.format("You will need atleast %.2fkg to enter the %s weight category", (cweight - weight), weightTier);
		}
		
	}
	
	private void setWeightTier() // a private method made to set the weightTIer and the actual competition weight based on the user choise
	{
		switch(wcate) {
			case 1: weightTier = "Heavyweight"; cweight = 100d; break;
			case 2: weightTier = "Light-Heavyweight"; cweight = 100d; break;
			case 3: weightTier = "Middleweight"; cweight = 90d; break;
			case 4: weightTier = "Light-Middleweight"; cweight =81d; break;
			case 5: weightTier = "Lightweight"; cweight = 73d; break;
			case 6: weightTier = "Flyweight"; cweight = 66d;
		}
	}
	
	// an instance method to display the comment 
	public void compareWeight() {
		System.out.printf(
				"\nYou current weight is %.2fkg and you have choosen for %s. \n" +
				"------------------------------------------------\n" +
				"%20s |\t %20s| \n" +
				"------------------------------------------------\n" +
				"%20s |\t %20skg| \n" +
				"%20s |\t %20skg| \n" +
				"%20s |\t %20skg| \n" +
				"%20s |\t %20skg| \n" +
				"%20s |\t %20skg| \n" +
				"%20s |\t %20skg| \n" +
				"------------------------------------------------\n" +
				"By comparing your weight with the above category, \n %s."

				,weight, weightTier
				,"Categories", "Upper Weight Limit(Kg)"
				,"Heavyweight", "Unlimitd(Over 100)"
				,"Light-Heavyweight", "100"
				,"middleweight", "90"
				,"Light-Middleweight", "81"
				,"Lightweight", "73",
				"Flyweight", "66",
				comment
				
				);
	}
	
	// getters and setters via encapsulation
	public String getWTier() { return weightTier; }
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() { return weight; }
	
	public int getWcate() { return wcate; }
	
}
