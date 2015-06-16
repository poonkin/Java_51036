package P8_14;

    /**
     * Created by dsvid88 on 4/16/15.
     */
    public class Geometry {

        //volume of a sphere
        public static double sphereVolume(double r) {
            double v = (4/3) * Math.PI * r * r * r;
            return v;
        }

        //sphere surface area
        public static double sphereSurface(double r){
            double a = 4 * Math.PI * r * r;
            return a;
        }

        //finding the volume of a cylinder
        public static double cylinderVolume(double r, double h ){
            double v = Math.PI * r * r * h;
            return v;
        }

        //cylinder surface area
        public static double cylinderSurface(double r, double h) {
            double a = 2 * Math.PI * r * h + 2 * Math.PI * r * r;
            return a;
        }

        //volume of a cone
        public static double coneVolume( double r, double h) {
            double v = Math.PI * r * r * (h /3);
            return v;
        }

        //area of a cone surface
        public static double coneSurface(double r, double h) {
            double a = Math.PI*r*(r + Math.sqrt(h*h + r*r));
            return a;
        }

    }
