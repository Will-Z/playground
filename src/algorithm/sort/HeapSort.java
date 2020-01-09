package algorithm.sort;

/**
 * @author will
 * @date 2020/1/9
 */
public class HeapSort {
    private void down(int[] a, int i, int tot) {
        while (i <= (tot >> 1) - 1) {
            int j = 2 * i;
            if (j < tot && a[j + 1] < a[j]) {
                j++;
            }
            if ( a[j] < a[i]) {
                int x;
                x = a[i]; a[i] = a[j]; a[j] = x;
                i = j;
            } else break;
        }

    }

    private void hsort(int[] a, int n) {
        int tot = n;
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            down(a, i, n);
        }
        int tem;
        while(tot > 0) {
            tem = a[tot - 1]; a[tot - 1] = a[0]; a[0] = tem;
            tot--;
            down(a,0, tot);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MergeSort().getClass().getSimpleName() + "  " + Thread.currentThread().getName());
        int[] a = new int[] {43, 2, 3, 10, 1, 884, 6, 9, 48, 84};
        new HeapSort().hsort(a, a.length);
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }

    }


}
