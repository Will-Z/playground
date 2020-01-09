package algorithm.sort;

/**
 * 经典快排  不稳定
 * @author will
 * @date 2019/12/26
 */
public class QuickSort {
    private void qsort(int head, int tail, int[] d) {
        int i = head;
        int j = tail;
        int x = d[head];
        while (i < j) {
            while (i < j && d[j] >= x) {
                j--;
            }
            d[i] = d[j];
            while (i < j && d[i] <= x) {
                i++;
            }
            d[j] = d[i];
        }
        d[i] = x;
        if (head < j - 1) {
            qsort(head, j - 1, d);
        }
        if (i + 1 < tail) {
            qsort(i + 1, tail, d);
        }
    }

    public static void main(String[] args) {
        int[] d = new int[] {43, 2, 3, 10, 1, 884, 6, 9, 48, 84};
        new QuickSort().qsort(0, d.length -1 , d);

        System.out.println(new QuickSort().getClass().getSimpleName() + "  " + Thread.currentThread().getName());
        for (int i = 0; i < d.length; i++ ) {
            System.out.print(d[i] + " ");
        }
    }


}
