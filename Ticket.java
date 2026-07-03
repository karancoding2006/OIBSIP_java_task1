public class Ticket {
    private final String pnrNumber;
    private final String passengerName;
    private final String trainNumber;
    private final String trainName;
    private final String classType;
    private final String dateOfJourney;
    private final String from;
    private final String to;

    public Ticket(String pnrNumber, String passengerName, String trainNumber,
                  String trainName, String classType, String dateOfJourney,
                  String from, String to) {
        this.pnrNumber = pnrNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void display() {
        System.out.println("\n========== TICKET DETAILS ==========");
        System.out.println("PNR Number     : " + pnrNumber);
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Train Number   : " + trainNumber);
        System.out.println("Train Name     : " + trainName);
        System.out.println("Class Type     : " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From           : " + from);
        System.out.println("To             : " + to);
        System.out.println("====================================");
    }
}
