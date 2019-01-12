import java.util.*;
import java.text.*;
public class Number6 {

public static void main(String[] args) {

    int assetNum;
    double purchPrice, usefulLife, salvageVal, numYears ,ddRate  ;
	
    Scanner kbd = new Scanner (System.in);

    System.out.println("Please enter asset number: ");
    assetNum = kbd.nextInt();

    System.out.println("Please enter initial purchase price: ");
    purchPrice = kbd.nextDouble();

    System.out.println("Please enter useful life of the asset (in years): ");
    usefulLife = kbd.nextDouble();

    System.out.println("Please enter the salvage value: ");
    salvageVal = kbd.nextDouble();

    System.out.println("Please enter the number of years of depreciation: ");
    numYears = kbd.nextDouble();

    ddRate = 0 ; //1/usefulLife;//((1.0 / usefulLife) * 2) * 100;
    //ddRate = purchPrice * ((1/numYears)*2);
    //ddRate = 0;

    System.out.println("Asset No: " + assetNum);
    System.out.printf("Initial Purchase Price: $%,.0f%n" , purchPrice);
    System.out.printf("Useful Life: %.0f years%n" , usefulLife); 
    System.out.printf("Salvage Value: $%,.0f%n" , salvageVal);
    System.out.printf("Double Declining Rate: %.0f%%%n" , ddRate);
    System.out.printf("Number of Years: %.0f years%n" , numYears);
    System.out.println();

    System.out.println("Year          Yearly          Accumulated          Book");
    System.out.println("              Depreciation    Depreciation         Value");
    System.out.println();

    int year;
    double yearlyDepr;
    double accDepr;
    double bookVal;
    double oldbookVal, oldaccDepr, oldyearlyDepr = 0;
    boolean calcend = false;

    bookVal = purchPrice;
    accDepr = 0;
    year = 0;
    yearlyDepr = 0;
    
    while (bookVal >= salvageVal){
        
        year++;
        
        ddRate = ((numYears+1) - year) / (numYears*((numYears+1)/2));
        
        yearlyDepr = (purchPrice-salvageVal) * (ddRate) ;
        accDepr = accDepr + yearlyDepr;
        bookVal = bookVal - yearlyDepr;
        
        System.out.printf("%d %,18.0f %,18.0f %,18.0f%n" , year, yearlyDepr, accDepr, bookVal);
        
        if ((year >= numYears) ||  (bookVal == salvageVal)){
            break;
        }
        
    }
    
}
}
