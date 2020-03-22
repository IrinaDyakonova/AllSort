import java.util.Random;
import java.util.Scanner;

public class AllSortImplementation {
    public static void main(String[] args) throws InterruptedException {
        int length_mas;
        String choose_for_y_n;
        Random random = new Random();
        int choose;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Do you want to work in my program? Enter Y or N");
            choose_for_y_n=s.next();
            if (choose_for_y_n.equals("Y"))
            {
                System.out.println("Enter the number of elements in the array");

                length_mas = s.nextInt();
                int[] mas = new int[length_mas];
                for (int i = 0; i < mas.length; i++) {
                    mas[i] = random.nextInt(41) - 20;
                }
                System.out.println("Array with random numbers");
                PrintMas(mas);
                System.out.println("Implemented Sorts\n\t1 - bubble sort\n\t2 - merge sort\n\t3 - insertion sort\n\t4 - selection sort\n\t5 - quick sort\n\t0 - exit\n");
                choose = s.nextInt();
                switch (choose) {
                    case 1:
                        BubbleSort(mas);
                        break;
                    case 2:
                        mas = MargeSort(mas);
                        break;
                    case 3:
                        InsertionSort(mas);
                        break;
                    case 4:
                        SelectSort(mas);
                        break;
                    case 5:
                        QuickSort(mas, 0, mas.length - 1);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Sorry, but you have chosen something that is not in the menu");
                }
                System.out.println("Array after sorted");
                PrintMas(mas);
            }
            else return;;
        } while (true);
    }

    public static void PrintMas(int[] mas) {
        for (int value : mas) {
            System.out.print(value + "\t");
        }
        System.out.println("");
    }

    public static void BubbleSort(int[] mas) {
        int temp;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
    }

    public static void InsertionSort(int[] mas) {
        int temp;
        for (int i = 0; i < mas.length; i++) {
            temp = mas[i];
            for (int j = i - 1; j >= 0 && mas[j] > temp; j--) {
                mas[j + 1] = mas[j];
                mas[j] = temp;
            }
        }
    }

    public static void SelectSort(int[] mas) {
        int temp, temp_index;
        for (int i = 0; i < mas.length; i++) {
            temp = mas[i];
            temp_index = i;
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[j] < temp) {
                    temp_index = j;
                    temp = mas[j];
                }
            }
            mas[temp_index] = mas[i];
            mas[i] = temp;
        }
    }

    public static void QuickSort(int[] mas, int low, int high) {
        if (mas.length == 0)
            return;
        if (low >= high)
            return;
        int opora = mas[(low + (high - low) / 2)];
        int i = low, j = high;
        while (i <= j) {
            while (mas[i] < opora) {
                i++;
            }
            while (mas[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            QuickSort(mas, low, j);
        if (high > i)
            QuickSort(mas, i, high);
    }

    public static int [] MargeSort(int[] mas)
    {
        if (mas.length<=1) {
            return  mas;
        }
        int midpoint = mas.length/2;
        int [] left = new int[midpoint];
        int [] rigth;
        if (mas.length%2 == 0)
        {
            rigth = new int[midpoint];
        }
        else
        {
            rigth = new int[midpoint+1];
        }
        for(int i=0; i<midpoint; i++)
        {
            left[i] = mas[i];
        }
        for(int j=0; j<rigth.length; j++)
        {
            rigth [j] = mas[midpoint+j];
        }
        int [] result = new int[mas.length];
        left=MargeSort(left);
        rigth=MargeSort(rigth);
        result=Marge(left, rigth);
        return  result;
    }

    public static int[]  Marge(int [] left, int [] right)
    {
        int [] result = new int [left.length+right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer=rightPointer=resultPointer=0;
        while (leftPointer<left.length || rightPointer<right.length) {
            if (leftPointer<left.length && rightPointer<right.length) {
                if (left[leftPointer]<right[rightPointer]) {
                    result[resultPointer++]=left[leftPointer++];
                }
                else {
                    result[resultPointer++]=right[rightPointer++];
                }
            }
            else if (leftPointer<left.length) {
                result[resultPointer++]=left[leftPointer++];
            }
            else if (rightPointer<right.length) {
                result[resultPointer++]=right[rightPointer++];
            }
        }
        return  result;
    }
}