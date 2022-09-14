import java.util.Scanner;
public class A1083331_checkpoint2{

    //Description : Implement the cumulative distribution function class as to calculate the cumulative normal distribution function (a.k.a cndf).
    static private CDF CDF;
    public static void main(String[] args) {

        //Description : To calculate the probability the target occurrence ,we provide the variable of mean,sigma, and target.
        double mean,sigma,target;


        /*********************************The TODO This Time (Checkpoint2) ********************************
         *
         * TODO(1): This time, you have to let user input mean,sigma and target separately.At the same time,you need to check whether the value that inputted by user  is numeric or not.
         * TODO(1.1): After setting all the arguments, you should print out in this term to check the arguments. ---->"mean:"+mean+",sigma:"+sigma+",target:"+target
         * Hint: e.g: Use " mean=setValue("mean") " to set the mean.
         **********************************The End of the TODO**************************************/
        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/
        mean=setValue("mean");
        sigma=setValue("sigma");
        target=setValue("target");
        System.out.println("mean:"+mean+",sigma:"+sigma+",target:"+target+"");
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

        /*********************************The Past TODO (Checkpoint1)********************************
         *
         * Past TODO(1): This time, you have to keep tracking the value of putting target into the CDF as it decreasing until the value is lower(<) than 0.001.
         * Hint1: We provide a method in CDF class to calculate probability. To implement it, you can use "cndf(x)" means calculating the cndf for x, which mean=0, and sigma=1.
         * Hint2: e.g: CDF.cndf(0) --->  0.5
         * Hint3: Before subtracting, you should print out the possibility and target in this term--> "P(x)="+possibility+",x="+target"
         * Hint4: Target should be subtracted from one each time.
             * Hint5: If you find the target that the probability is less than 0.001, you should print "Find!P(x)="+possibility+",x="+target"
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/
        double possibility,z;
        for(;;){
        z=normalize(mean,sigma,target);
        possibility=CDF.cndf(z);
        if(possibility<0.001){
        System.out.println("Find!P(x)="+possibility+",x="+target+"");
        break;
        }
        System.out.println("P(x)="+possibility+",x="+target+"");
        target=target-1;
        }
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

    }

    //Data Standardization
    static private double normalize(double mean,double sigma,double target){
        /*********************************The Past TODO(Checkpoint1)********************************
         *
         * Past TODO(2):You need to standardize the target data.
         * Hint1: z_score = (target_data - mean) / sigma
         *
         **********************************The End of the Past TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/
          double z;
          z=(target-mean)/sigma;
          return z;
         /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/
    }

    // Check the value is numeric or not.

    public static  boolean isNumeric(String str){
        /*********************************The TODO This Time (Checkpoint2) ********************************
         * TODO(2): Here you have to implement  a method to determine whether the parameter is numeric or not.
         * Hint1: Only if the parameter is numeric, the method will return true.
         * Hint2: Noted that the parameter may be blank or characters.
         **********************************The End of the TODO**************************************/


        try {
        /********************************************************************************************
        START OF YOUR CODE
         ********************************************************************************************/
         int i,j,count=0;
         String number="0123456789";
         String blank=" ";
         if(str.charAt(0) == blank.charAt(0) ){
         return false;
        }
        for(i=0;i<str.length();i++){
                for(j=0;j<10;j++){
                  if(str.charAt(i)== number.charAt(j)){
                  count++;
                        }
                    }
                }
        if(count!= str.length()){
        return false;
        }

        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static  double setValue(String argumentTypes){
        /*********************************The TODO This Time (Checkpoint2) ********************************
         * TODO(3): Here you have to let user input mean, sigma, or target based on the parameter. e.g: If the parameter is "mean", then you have to print out the corresponding questions and return a number in double.
         * Hint1: This method should loop and keep asking for the input until user type in a numeric variable.
         * Hint2: a.As asking for inputting mean,you should print out in this term  --> "Please input mean to count the probability."
                  b.As asking for inputting sigma,you should print out in this term --> "Please input sigma to count the probability."
                  c.As asking for inputting target,you should print out in this term --> "Please input target to count the probability."
         * Hint3: If the input value  is not numeric,you need to print out in the following term.
         *        a. For mean -->  "Wrong! Please input mean to count the probability again."
         *        b. For sigma -->  "Wrong! Please input sigma to count the probability again."
         *        c. For target -->  "Wrong! Please input target to count the probability again."

         * Hint4: You can use isNumeric() method we provided to check whether the value  is numeric or not.
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
        START OF YOUR CODE
         ********************************************************************************************/
        Scanner number = new Scanner (System.in);
        String input;
        boolean isnumeric ;
        double num=0;
        System.out.println("Please input "+argumentTypes+" to count the probability.");
        for(;;){
        input=number.nextLine();
        if(input.length()==0){
        System.out.println("Wrong! Please input "+argumentTypes+" to count the probability again.");
        continue;
        }
        isnumeric=isNumeric(input);
        if(isnumeric == true ){
        num=Double.parseDouble(input);
        return num;
}
        System.out.println("Wrong! Please input "+argumentTypes+" to count the probability again.");
}

        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

    }
}
