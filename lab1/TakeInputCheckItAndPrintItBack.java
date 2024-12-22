class TakeInputCheckItAndPrintItBack
{
  public static void main (String args[])
    {
      
      if (args.length != 0){
        for (int i = 0; i < args.length; i++){
         System.out.println("["+ (i + 1) +"] input is: " + args[i]);
        }
      }else {
         System.out.println("Please enter only one input");
      }
    }
}
