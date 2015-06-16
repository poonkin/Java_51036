package P9_16;

/**
 * Created by dsvid88 on 4/23/15.
 */
public class Driver {

    public static void main(String[] args) {

        Country A = new Country("A", 100000);
        System.out.println(A.getName() + " has a surface area of " + A.getSize().toString());
        Country B = new Country("B", 150000);
        System.out.println(B.getName() + " has a surface area of " + B.getSize().toString());
        Country C = new Country("C", 120000);
        System.out.println(C.getName() + " has a surface area of " + C.getSize().toString());

        Measurable[] countryList = new Measurable[3];

        countryList[0] = A;
        countryList[1] = B;
        countryList[2] = C;

        Country largestCountry = (Country) maximum(countryList);

        System.out.println("\n");
        System.out.println( largestCountry.getName() + " has the largest surface area of " + largestCountry.getSize() );

    }

    public static Measurable maximum(Measurable[] objects) {

        Measurable max = objects[0];
        for (Measurable obj : objects) {

            if (obj.getSize().toString().compareTo(max.getSize().toString()) > 0) {
                max = obj;
            }
        }

        return max;

    }

}

