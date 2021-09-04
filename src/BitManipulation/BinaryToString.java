package BitManipulation;

/*
        Binary to String: Given a real number between 8 and 1 (e.g., 0.72) that is passed in as a double,
        print the binary representation. If the number cannot be represented accurately in binary with at
        most 32 characters, print "ERROR:'
*/

public class BinaryToString {

    double input = 0.625d;

    public BinaryToString(){
        System.out.println(binaryToString());
    }

    private String binaryToString()
    {
        StringBuilder sb = new StringBuilder();

        while(input > 0)
        {
            if(sb.length() >= 32)
                return "Error";

            double temp = input * 2;

            if(temp >= 1.0d)
            {
                sb.append(1);
                input = temp - 1;
            }
            else {
                sb.append(0);
                input = temp;
            }
        }

        return sb.toString();
    }





}
