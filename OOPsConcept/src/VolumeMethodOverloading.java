import java.util.Scanner;

class Volume {
    public double findVolume(double radius ){
        return ( 4.0 / 3.0 ) * Math.PI * Math.pow(radius,3);
    }
    public double findVolume(boolean isCube, double side){
        return Math.pow(side,3);
    }
    public double findVolume(double length, double breadth, double height){
        return length * breadth * height;
    }
}
public class VolumeMethodOverloading {

    static void sphere(){
        Scanner sc = new Scanner(System.in);
        double radius;
        System.out.print("Enter Radius : ");
        radius = sc.nextDouble();
        Volume v = new Volume();
        System.out.println("The volume of sphere is : " + v.findVolume(radius) );
    }

    static void cube(){
        Scanner sc = new Scanner(System.in);
        double side;
        System.out.print("Enter side : ");
        side = sc.nextDouble();
        Volume v = new Volume();
        System.out.println("The volume of cube is : " + v.findVolume(true, side) );
    }

    static void rectangularPrism(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length :");
        double length = sc.nextDouble();
        System.out.print("Enter breadth : ");
        double width = sc.nextDouble();
        System.out.print("Enter height : ");
        double height = sc.nextDouble();
        Volume v = new Volume();
        System.out.println("The volume of rectangular prism is : " + v.findVolume(length, width, height) );
    }
    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("1.Sphere\n2.cube\n3.Rectangular Prism\n4.Exit");
            op = sc.nextInt();
            switch(op){
                case 1:
                    sphere();
                    break;
                case 2:
                    cube();
                    break;
                case 3:
                    rectangularPrism();
                    break;
                default:
                    System.out.println( "Exiting..." );
            }
        }while(op!=4);
    }
}

