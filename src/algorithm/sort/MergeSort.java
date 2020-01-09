package algorithm.sort;

/**
 * 归并排序 稳定
 * 需要多开一个数组
 * @author will
 * @date 2019/12/24
 */
public class MergeSort {
    void mSort(int s, int t, int[] a, int[] r) {
        if (s == t) {
            return;
        }
        int m = s + t >> 1;
        mSort(s, m, a, r);
        mSort(m + 1, t, a, r);
        int i = s;
        int k = s;
        int j = m + 1;
        while (i <= m && j <= t) {
            if (a[i] <= a[j]) {
                r[k] = a[i]; i++; k++;
            } else {
                r[k] = a[j]; j++; k++;
            }
        }
        while (i <= m) {
            r[k] = a[i]; i++; k++;
        }
        while (j <= t) {
            r[k] = a[j]; j++; k++;
        }
        for (int l = s; l <= t; l++) {
            a[l] = r[l];
        }
    }

    public static void main(String[] args) {
        System.out.println(new MergeSort().getClass().getSimpleName() + "  " + Thread.currentThread().getName());

        int[] a = new int[] {43, 2, 3, 10, 1, 884, 6, 9, 48, 84};
        int[] r = new int[10];
        new MergeSort().mSort(0, 9, a, r);

        for (int item : r) {
            System.out.print(item + " ");
        }

    }
}
