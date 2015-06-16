package YodaSpeakRecursive;

/**
 * Created by dsvid88 on 5/16/15.
 */
public class YodaSpeakRecursive {

    public static void main(String[] args) {
        System.out.println("Enter something:");
        String input = System.console().readLine();

        System.out.println("You entered : " + input);

        String delims = "[ ]+";
        String[] tokens = input.split(delims);
        String[] rtokens = new String[tokens.length];



        String[] backwards = reverse(tokens, rtokens);



                //new String[tokens.length];

        System.out.println("Reversed Sentence");
       int c = 0;
        while( c < backwards.length ){
            System.out.print(backwards[c] + ", ");
            c++;
        }


    }


    public static String[] reverse(String[] tokens, String[] rtokens) {

      //  String[] rtokens = new String[tokens.length];


        if (tokens.length == 1) {
            rtokens[tokens.length-1] = tokens[0];
            return rtokens;
        }
        else if ( tokens.length>2){

            for (int i = 0; i < tokens.length; i++){


               String[] shorterTokens = new String[tokens.length-1];
                System.out.println("Shortened senetence :");
                for( int k = 0; k < tokens.length - 1; k++)
                {
                    shorterTokens[k] = tokens[k];
                    System.out.print(shorterTokens[k] + " ");
                }


                //System.out.println(tokens[tokens.length-1]);
            int j = 1; //<---- this needs to be fixed

                System.out.print("The value of j is " + j + " and we are inserting " + tokens[tokens.length-1]);
                System.out.println();
                rtokens[j] = tokens[tokens.length-1];
              // reverse(shorterTokens);

            

                i++;
            }

        }
        return rtokens;
    }
}