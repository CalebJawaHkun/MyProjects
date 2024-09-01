package FNSJ;

public class Athelete {
	
	private String name;
	private int noce, pth;
	
	// Two instance referances. 
	Weight weight;
	Plan plan;
	
	private double tPlanFee,
	tCompetitionFee, 
	tHoursFee, 
	total;
	
	// a construtor that set the instance variables
	public Athelete(
			String name, 
			int noce, 
			int pth,
			int wcate,
			String tplan,
			double cweight
			) 
	{
		this.name = name;
		this.noce = noce;
		this.pth = pth;		
		
		weight = new Weight(cweight, wcate);
		plan = new Plan(tplan);
		
		tPlanFee  = plan.getPlanFee() * 4;
		tCompetitionFee = noce * 22.00;
		tHoursFee = pth * 9.00 * 4;
		total  = tPlanFee + tCompetitionFee + tHoursFee;
	}

	// getters and setters via encapsulation
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoce() {
		return noce;
	}

	public void setNoce(int noce) {
		this.noce = noce;
	}

	public int getPth() {
		return pth;
	}

	public void setPth(int pth) {
		this.pth = pth;
	}

	public Double gettPlanFee() {
		return tPlanFee;
	}

	public void settPlanFee(Double tPlanFee) {
		this.tPlanFee = tPlanFee;
	}

	public Double gettCompetitionFee() {
		return tCompetitionFee;
	}

	public void settCompetitionFee(Double tCompetitionFee) {
		this.tCompetitionFee = tCompetitionFee;
	}

	public Double gettHoursFee() {
		return tHoursFee;
	}

	public void settHoursFee(Double tHoursFee) {
		this.tHoursFee = tHoursFee;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
