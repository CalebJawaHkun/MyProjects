package FNSJ;

public class Plan {
	// instance variables
	private String planType;
	private double planFee;
	
	
	public Plan(String plan) // a constructor
	{
		this.planType = plan;
		setPlanFee();
	}
	
	private void setPlanFee() // a private method to set the fee based on the choosen plan
	{
		if(planType.equalsIgnoreCase("Beginner")) {
			this.planFee = 25.00;
		}
		else if(planType.equalsIgnoreCase("Intermediate")) {
			this.planFee = 30.00;
		}
		else {
			this.planFee = 35.00;
		}
	}
	
	public String getPlanType() { return planType; }
	public double getPlanFee() { return planFee; }
	
}
