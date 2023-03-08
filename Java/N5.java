public class N5 {

   public static int roundToInt (double toRound){
      int rounded;
      rounded = (int) Math.round(toRound);
      return rounded;
   }

   public static double roundDp (double toRound, int places) {
      int power = 1;
      for (int powers = 0; powers <places; powers ++) {
         power = power * 10;
      }
      toRound = toRound * power;
      int rounded = roundToInt(toRound);
      toRound = (double) rounded / power;
      return toRound;
   }
   
   public static int randomInt (int highNum) {
   
      int number = (int) (Math.floor((highNum+1)*Math.random()));
      return number;
   }
}