import java.util.Random;

//java.util.Random;
public class AllSortImplementation {
    public static void main(String[] args) {
        int[] mas = new int[20];
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(41) - 20;
        }
        PrintMas(mas);
        //  PrintMas(BubbleSort(mas));
        //  PrintMas(InsertionSort(mas));
       // QuickSort(mas, 0, mas.length);
        PrintMas(mas);

    }

    public static void PrintMas(int[] mas) {
        for (int value : mas) {
            System.out.print(value + "\t");
        }
        System.out.println("");
    }

    public static int[] BubbleSort(int[] mas) {
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

        return mas;
    }

    public static int[] InsertionSort(int[] mas) {
        int temp;
        for (int i = 0; i < mas.length; i++) {
            temp = mas[i];
            for (int j = i - 1; j >= 0 && mas[j] > temp; j--) {
                mas[j + 1] = mas[j];
                mas[j] = temp;
            }
        }
        return mas;
    }

    public static int[] SelectSort(int[] mas) {
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
        return mas;
    }

  /*  public static void QuickSort(int[] mas, int low, int high) {
        if (mas.length == 0)
            return;

        if (low >= high)
            return;

        int opora = mas[mas.length / 2];

        int i = low, j = high;
        while (i <= j) {
            while (mas[i] < opora) {
                i++;
            }

            while (mas[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
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
    }*/
}