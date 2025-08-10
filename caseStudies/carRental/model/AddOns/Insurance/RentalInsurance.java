package caseStudies.carRental.model.AddOns.Insurance;

public class RentalInsurance implements Insurance{

    @Override
    public String getName() {
        return "Rental Insurance";
    }

    @Override
    public int getAmount() {
        return 30;
    }

    @Override
    public InsuranceType getInsuranceType() {
        return InsuranceType.RENTAL;
    }
}
