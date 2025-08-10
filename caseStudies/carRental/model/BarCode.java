package caseStudies.carRental.model;

import caseStudies.carRental.enums.BarCodeStatus;

public class BarCode {
    private final String barcode;
    private BarCodeStatus barCodeStatus;

    BarCode(String barcode){
        this.barcode = barcode;
        this.barCodeStatus = BarCodeStatus.ACTIVE;
    }

    public void makeBarcodeInactive(){
        this.barCodeStatus = BarCodeStatus.INACTIVE;
    }

    public void makeBarcodeActive(){
        this.barCodeStatus = BarCodeStatus.ACTIVE;
    }

    public BarCodeStatus getBarcodeStatus(){
        return this.barCodeStatus;
    }

    public String getBarcode(){
        return this.barcode;
    }
}
