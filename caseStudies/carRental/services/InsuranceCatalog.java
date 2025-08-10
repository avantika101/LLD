package caseStudies.carRental.services;

import caseStudies.carRental.model.AddOns.Insurance.Insurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCatalog {
    List<Insurance> insuranceList;

    InsuranceCatalog(){
        insuranceList = new ArrayList<>();
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void addInsuranceToList(Insurance ins){
        insuranceList.add(ins);
    }

    public void removeInsuranceFromList(Insurance ins){
        insuranceList.remove(ins);
    }

    public boolean doesInsuranceExist(Insurance ins){
        return insuranceList.contains(ins);
    }
}
