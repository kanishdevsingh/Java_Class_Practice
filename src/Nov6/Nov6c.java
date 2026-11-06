package Nov6;

import Nov6.college.FeeStructure;

public class Nov6c {
    public static void main(String[] args) {
        int tutionFee = 25000;
        FeeStructure fee = new FeeStructure(tutionFee);
        fee.calculateTotalFee();

    }
}
