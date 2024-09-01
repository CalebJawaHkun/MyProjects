package FNSJ;
// IO stands for Intro and Outro!
public class IO extends Core{
	static void intro() // a method to introduce the prices of the service
	{
		String title = "Training Plan - Prices($USD)";
		String data[][] = {
				{"Beginner (2 sessions per week) , weekly fee", "$25.00"},
				{"Intermediate (3 sessions per week) , weekly fee", "$30.00"},
				{"Elite (5 sessions per week) , weekly fee ", "$35.00"},
				{"Private tuition , per hour", "$9.00"},
				{"Competition entry fee , per competition", "$22.00"}
		};
		

		for(int x = 0; x < data.length; x++) {
			if(x == 0) {
				System.out.printf("%40s\n", title);
			}
			else {
				System.out.printf("%50s \t %s\n",  data[x][0], data[x][1]);
			}
		}		
	}
	
	static void outro(Athelete obj) // a method to display invoice and comment for the athelete.
	{
		String name = obj.getName(),
				tplan = obj.plan.getPlanType();
		int noce = obj.getNoce(),
				pth = obj.getPth();
		
		double tplanFee = obj.gettPlanFee(),
				noceFee = obj.gettCompetitionFee(),
				pthFee = obj.gettHoursFee(),
				total = obj.getTotal();
		
		System.out.printf(
				"Invoice For North Suxxex Judo Traning of athelete \t \"%s\" \n" +
				"----------------------------------------------------------------------- \n" +
				"%20s |\t %20s |\t %20s |\n" +
				"----------------------------------------------------------------------- \n" +
				"%20s |\t %20s |\t %20.2f$ |\n" +
				"%20s |\t %20d |\t %20.2f$ |\n" +
				"%20s |\t %20d |\t %20.2f$ |\n" +
				"----------------------------------------------------------------------- \n" +
				"%45s |\t %20.2f$ |\n"
				
				,
				name,  
				"Service/Fee", "Quantity/Type", "Fee Per Month",
				"Training Plan", tplan, tplanFee,
				"Competition Entry Fee", noce, noceFee,
				"Private Tutor(hours)", pth, pthFee,
				"Total", total				
				);
		

		obj.weight.compareWeight();
	}
}
