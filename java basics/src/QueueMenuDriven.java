import java.util.Scanner;

public class QueueMenuDriven {
    static int[] queue = new int[100];
    static int front = -1;
    static int rear = -1;

    public static void insert(int num){
        if(rear == -1) {
            rear++;
            front++;
            queue[rear] = num;
        }
        else{
            rear++;
            queue[rear] = num;
        }


    }

    public static void delete(){
        if (front == -1){
            System.out.println("Nothing to delete");
        }
        else if (front == rear) {
            System.out.println("The element deleted is "+queue[front]);
            front = -1;
            rear = -1;
        }
        else{
            System.out.println("The element deleted is "+queue[front]);
            front++;
        }

    }

    public static void display(){
        if(rear == -1)
            System.out.println("No element to be displayed");
        else {
            for (int i = front; i <= rear; i++)
                System.out.print(queue[i] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String y;
        //Menu Driven Programs for queue
        do{
            System.out.println("1.Insertion\n2.Deletion\n3.Display the contents");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    System.out.println("Enter number to be inserted");
                    int num = sc.nextInt();
                    insert(num);
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            System.out.println("Do you want to continue: Y or y to continue");
            y = sc.next();
        }while(y != "y");
    }
}
