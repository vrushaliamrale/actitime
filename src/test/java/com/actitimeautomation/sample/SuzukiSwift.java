package com.actitimeautomation.sample;

public class SuzukiSwift {

    public static void main(String [] arg){
           Car car =new Car(){  //class body starts here

                    @Override
                public void engine(String ccType) {
                    System.out.println("The Engine has cc: "+ ccType);
                }

                    @Override
                public void fuelType(String type) {
                    System.out.println("Fuel Type: "+ type);
                }

                    @Override
                public void airBags(int number){
                System.out.println("Total airbags : " + number);

            }
        };

           car.engine("2000CC");

           car.fuelType("CNG");

           car.airBags(2);





    }




}
