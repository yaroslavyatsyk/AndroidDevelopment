package com.example.assignment1;

public class WagePayment {

    private double amountOfHours;
    private double paymentPerHour;

    public WagePayment(double hours, double basePayment) {
        amountOfHours = hours;
        paymentPerHour = basePayment;
    }

    public double getHours() {
        return amountOfHours;
    }

    public double getBasePayment() {
        return paymentPerHour;
    }

    public double CalculateTotalIncome() {
        if(amountOfHours <= 40) {
            return amountOfHours * paymentPerHour;
        }
        else {
            return (amountOfHours - 40) * paymentPerHour * 1.5 + amountOfHours * paymentPerHour;
        }
    }
    public double CalculateTax() {
        return this.CalculateTotalIncome() * 0.18;
    }

    public double CalculateNetIncome() {
        return this.CalculateTotalIncome() - this.CalculateTax();
    }
}
