package caseStudies.parkingLot;

public class PaymentService {
    public void processPayment(Ticket tc, PaymentMethod pm){
        double fee = tc.calculateFee();
        System.out.println("fee:"+fee+" paid using method:"+pm);
    }
}
