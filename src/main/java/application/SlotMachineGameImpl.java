// Original coursework: May 2022.
package application;

import java.util.Random;

/*
* SlotMachineGameImpl class
*/
public class SlotMachineGameImpl implements SlotMachineGameInterface
{
   // Instance fields
   public final int IMAGES = 11;   // max number of Images
   public final int SYMBOLS = 3;   // max number of Symbols (Bonus: max number of Symbols can be IMAGES - 1)
   
   private double totalWon = 0;  // Total won money
   private int[] symbols;  // Array of randomized symbols

   /**
   * Contructor
   */
   public SlotMachineGameImpl()
   {
      symbols = new int[SYMBOLS];
   }
   
   /**
   * Spin
   * @param money from User
   * @return money won
   */
   public double Spin(double money)
   {
      // create object of Random class
      Random rand = new Random();
      
      // fill aray of symbols with randomized images
      for (int i = 0; i < SYMBOLS; i++)
         symbols[i] = rand.nextInt(IMAGES - 1) + 1;
         
      int maxSymbols = CalcSymbols();
      return CalcMoney(money, maxSymbols);
   }
   
   /**
   * Calculate maximum number of equal Symbols
   * @return maxSymbols
   */
   private int CalcSymbols()
   {
      int maxEqualSymbols = 0;
      for (int i = 0; i < SYMBOLS; i++)
      {
         int equalSymbols = 0;
         for (int j = 0; j < SYMBOLS; j++)
         {
            if (symbols[i] == symbols[j])
               equalSymbols++;
         }
         
         if (equalSymbols > maxEqualSymbols)
            maxEqualSymbols = equalSymbols;
      }
      return maxEqualSymbols;
   }

   /**
   * Calculate Money and total Money
   * @param maxSymbols
   * @return won money
   */
   private double CalcMoney(double money, int maxSymbols)
   {
      double won = 0;
      
      // calculate current spin won money and total money won
      if (maxSymbols > 1)
      {
         won = money * (maxSymbols + 1);
         totalWon += won;
      }
      return won;
    }
   
   /*
   * getter method
   * @return symbols
   */
   public int[] GetSymbols()
   {
      return symbols;
   }

   /*
   * getter method
   * @return totalWon Total Money
   */
   public double GetTotalWon()
   {
      return totalWon;
   }
}
