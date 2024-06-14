package testing;
public class NetRunRateCalculator {

    public static void main(String[] args) {
        // Example data 
        int totalRunsScored = 55;
        int totalOversFaced = 8;
        int totalRunsConceded = 45;
        int totalOversBowled = 8;

        // Calculate Net Run Rate
        double netRunRate = calculateNRR(totalRunsScored, totalOversFaced, totalRunsConceded, totalOversBowled);

        // Display the result
        System.out.println("Net Run Rate: " + netRunRate);
    } 

    public static double calculateNRR(int totalRunsScored, int totalOversFaced,
                                      int totalRunsConceded, int totalOversBowled) {
        double runRateScored = (double) totalRunsScored / totalOversFaced;
        double runRateConceded = (double) totalRunsConceded / totalOversBowled;

        return runRateScored - runRateConceded;
    }
}
