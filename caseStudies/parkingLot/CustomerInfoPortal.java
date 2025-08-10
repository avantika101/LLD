package caseStudies.parkingLot;

class CustomerInfoPortal {
    private final PaymentService paymentService;

    public CustomerInfoPortal(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void payForTicket(Ticket ticket, PaymentMethod method) {
        paymentService.processPayment(ticket, method);
    }
}

