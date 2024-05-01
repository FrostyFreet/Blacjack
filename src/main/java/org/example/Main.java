package org.example;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11);
        int p1value = 0;
        int dealervalue = 0;

        int answer;
        System.out.println("\t\t\tWelcome to BLACK JACK!");
        while (true)
        {
            boolean p1turn = true;
            //player logic
            if (p1turn)
            {
                System.out.println("\n\t\tYour Turn");
                System.out.println("Your Hand=" + p1value);
                System.out.println("Would you like a card(1) or stop(0)?");
                answer = input.nextInt();
                if (answer == 0)
                {
                    p1turn = false;
                    System.out.println("\t\tDealer's Turn");
                    int rand = random.nextInt(values.size());
                    dealervalue += values.get(rand);
                    System.out.println("Your Hand= " + p1value  + ", Dealer's Hand= " + dealervalue);

                    if (dealervalue == p1value || dealervalue < p1value)
                    {
                        rand = random.nextInt(values.size());
                        dealervalue += values.get(rand);
                    }
                    else if(dealervalue > 21)
                    {
                        System.out.println("You won!");
                        break;
                    }
                    else if (dealervalue >p1value)
                    {
                        System.out.println("You lost!");
                        break;
                    }
                    System.out.println("Good Bye!");
                }

                else
                {
                    int rand = random.nextInt(values.size());
                    p1value += values.get(rand);
                    System.out.println("Your Hand=" + p1value+"\n");
                    if (p1value > 21)
                    {
                        System.out.println("Your Hand= " + p1value  + ", Dealer's Hand= " + dealervalue);
                        System.out.println("You lost!");
                        break;
                    }
                    if (p1value == 21)
                    {
                        System.out.println("Your Hand= " + p1value  + ", Dealer's Hand= " + dealervalue);
                        System.out.println("You won!");
                        break;
                    } else
                    {
                        p1turn = false;
                    }


                }
            }
            //Dealers logic
            if (!p1turn)
            {
                System.out.println("\t\tDealer's Turn");
                int rand = random.nextInt(values.size());
                dealervalue += values.get(rand);
                System.out.println("Dealer's Hand= " + dealervalue);
                    if (dealervalue > 21)
                    {
                        System.out.println("Your Hand= " + p1value  + ", Dealer's Hand= " + dealervalue);
                        System.out.println("You've won!");
                        break;
                    }
                    if (dealervalue == 21)
                    {
                        System.out.println("Your Hand= " + p1value  + ", Dealer's Hand= " + dealervalue);
                        System.out.println("You lost!");
                        break;
                    }
                    else
                    {
                        p1turn = true;
                    }
            }


        }


    }
}
