
 class EnterNoAndStringLoop {
    public static void main(String[] args) {
       
        try{
          if (args.length != 2){
            throw new RuntimeException("Please enter a string and a number");
          }
          int iterations = Integer.parseInt(args[0]);
          if (iterations > 0){
              for (int i = 0; i < iterations; i++){
                System.out.println(args[1]);
              }
          } else {
                System.out.println("Please enter a positive number");
          }
          
          
        }catch (Exception e) {
           System.out.println("First argument must be a number" + e.getMessage());
        }
        
        
    }
}



