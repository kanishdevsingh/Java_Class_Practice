package Nov6.college;

public class FeeStructure {
    final int Registration_Fee = 10000;
    int tutionFee;

    public FeeStructure(int tutionFee){
        this.tutionFee = tutionFee;
    }
    public void calculateTotalFee(){
        int totalFee = Registration_Fee + tutionFee;

        System.out.println("Registration Fee : " + totalFee);
        System.out.println("Tution Fee : " + tutionFee);
        System.out.println("Total Fee : " + totalFee);
    }
}
