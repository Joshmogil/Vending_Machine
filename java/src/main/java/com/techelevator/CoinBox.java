package com.techelevator;

public class CoinBox {

    private int moneyDeposited;

    public int getMoneyDeposited() {
        return moneyDeposited;
    }

    public CoinBox(){
        this.moneyDeposited =0;
    }

    public void feed(int amount) {
        this.moneyDeposited += amount;
    }

    public void spend(int amount) {
        this.moneyDeposited -= amount;
    }
    //Method figures out how many dollars, quarters, dimes, nickels, and pennies to give back
    public String dispenseChange() {
        //Here the cost has already been subtracted from money deposited, then set to amount
        int amount = this.moneyDeposited;
        //Logic for determining amount of each
        int dollars = ((amount - (amount%100)))/100;
        amount = amount%100;
        int numQuarters = ((amount - (amount%25)))/25;
        amount = amount%25;
        int numDimes = ((amount - (amount%10)))/10;
        amount = amount%10;
        int numNickles = ((amount - (amount%5)))/5;
        amount = amount%5;
        int numPennies = amount;
        //Sets money deposited back to 0
        this.moneyDeposited = 0;

        String dollarsStr = (dollars != 0)?dollars + " dollars, ": "";
        String quartersStr = (numQuarters != 0)? numQuarters+ " quarters, ": "";
        String dimesStr = (numDimes != 0)? numDimes+ " dimes, ": "";
        String nicklesStr = (numNickles != 0)? numNickles+ " nickles, ": "";
        String penniesStr = (numPennies != 0)? numPennies+ " pennies, ": "";

        String changeStatement = "Your change is $ " +dollarsStr+quartersStr+dimesStr+nicklesStr+penniesStr;
        changeStatement = changeStatement.substring(0,changeStatement.length()-2);
        System.out.println(changeStatement);
        return changeStatement;
    }
}
