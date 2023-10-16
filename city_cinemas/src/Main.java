abstract class MovieClub{
    private double yearlyFee;
    private double ticketPrice;
    private String benefits;

    public MovieClub(double ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice(){
        return ticketPrice;
    }

    public abstract double getYearlyClubFee();

    public String getBenefits(){
        return benefits;
    }

    protected void setBenefits(String benefits){
        this.benefits = benefits;
    }

    @Override
    public String toString(){
        return "Class Name: " + this.getClass().getSimpleName() +
                "\nTicket Price: $" + ticketPrice +
                "\nClub Benefits: " + benefits;
    }
}

class SeniorClub extends MovieClub{
    public SeniorClub(double initialticketPrice){
        super(initialticketPrice * 0.5);
        setBenefits("Free child-sized popcorn & soda.");
    }

    @Override
    public double getYearlyClubFee(){
        return 5.0;
    }
}

class GoldClub extends MovieClub{
    public GoldClub(double initialTicketPrice){
        super(initialTicketPrice * 0.1);//90% off
        setBenefits("Free soda refill.");
    }

    @Override
    public double getYearlyClubFee(){
        return 15.0;
    }
}

class PlatinumClub extends MovieClub{
    public PlatinumClub(double initialTicketPrice){
        super(initialTicketPrice * 0.2); //80% off
        setBenefits("Free soda and popcorn refill, buddy passes.");
    }

    @Override
    public double getYearlyClubFee(){
        return 30.0;
    }
}

class PlatinumPlusClub extends PlatinumClub{
    public PlatinumPlusClub(double initialTicketPrice){
        super(initialTicketPrice);//same as Platinum
        setBenefits("Free soda and popcorn refill, buddy passes.");
    }

    public double getYearlyClubFee(){
        return super.getYearlyClubFee() + 10;
    }
}

public class Main {
    public static void main(String[] args){
        MovieClub[] clubs = new MovieClub[]{
                new SeniorClub(10.0),
                new GoldClub(10.0),
                new PlatinumClub(10.0),
                new PlatinumPlusClub(10.0)
        };

        for (MovieClub club: clubs){
            System.out.println(club);
            if (club instanceof PlatinumPlusClub){
                System.out.println("Free Passes: 2");
            } else if (club instanceof PlatinumClub){
                System.out.println("Free Pass: 1");
            }
            System.out.println("Yearly Fee: $" + club.getYearlyClubFee());
            System.out.println();
        }
    }
}