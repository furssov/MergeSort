import java.io.IOException;

import java.util.Optional;


public class Main {
    public static void main(String[] args) {


     int [] b = {10, 99, 2, 25, 15, 30, 1};
        try {
            int [] a = mergeSort(b);
            for (int x: a
                 ) {
                System.out.println(x);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] mergeSort(int [] array) throws IOException
    {
        Optional<int[]> optional = Optional.ofNullable(array);
        if (optional.isPresent())
        {
            if (optional.get().length == 1)
            {
                return optional.get();
            }

            int [] arrayB = new int[array.length / 2];
            System.arraycopy(array, 0, arrayB, 0, array.length / 2);

            int [] arrayC = new int[array.length - array.length / 2];
            System.arraycopy(array, array.length / 2, arrayC, 0, array.length - array.length / 2);
            arrayB = mergeSort(arrayB);
            arrayC = mergeSort(arrayC);

            return merge(arrayB, arrayC);
        }
        else throw new IOException("null");

    }

    private static int[] merge (int [] a, int [] b)
    {
        int sizeA = a.length;
        int sizeB = b.length;
        int [] c = new int[sizeA + sizeB];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexA < sizeA && indexB < sizeB)
        {
            if (a[indexA] < b[indexB])
            {
                c[indexC++] = a[indexA++];
            }
            else
            {
                c[indexC++] = b[indexB++];
            }
        }
        while (indexA < sizeA)
        {
            c[indexC++] = a[indexA++];
        }
        while (indexB < sizeB)
        {
            c[indexC++] = b[indexB++];
        }
        return c;
    }
}
