import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by zhuhaitao on 16/5/28.
 * 7中常用的排序算法：
 * 冒泡排序、选择排序、插入排序、希尔排序、归并排序、快速排序、堆排序
 */
public class Sort {
    public static void main(String[] args) {
        //待排序数组
        int[] A = new int[] {9, 5, 2, 6, 4, 1, 0, 3, 8, 7};
        int n = A.length;

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(fmt.format(new Date()) + " before sort:" + Arrays.toString(A));

        //bubbleSort(A, n);
        //selectSort(A, n);
        //insertSort(A, n);
        //quickSort(A, 0, n-1);

        //int[] B = new int[n]; //临时存储区
        //mergeSort(A, 0, n-1, B);

        shellSort(A, n);



        System.out.println(fmt.format(new Date()) + "  after sort:" + Arrays.toString(A));
    }

    /**
     * 冒泡排序算法
     * 算法思想：
     * 对一个无序数组，比较相邻两个元素的关键字大小，并交换它们的位置，使关键字最小的元素像气泡一样逐渐向上“漂浮”到“水面”。
     * @param A  待排序数组
     * @param n  数组长度
     */
    public static void bubbleSort(int A[], int n) {
        //从尾部向前遍历，按照从小到达顺序排序
        for(int i = 0; i < n; i++) {
            for(int j = n-1; j > i; j--) {
                if(A[j] < A[j-1]) {
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序算法
     * 算法思想：
     * 遍历无序区，每趟找出一个最小的元素（位置），然后将它放到有序区尾部，直到整个数组有序。
     * @param A  待排序数组
     * @param n  数组长度
     */
    public static void selectSort(int A[], int n) {
        //从前往后遍历数组，每次趟找出一个最小的元素，放在指定位置上
        for(int i = 0; i < n; i++) {
            int minIdx = i; //本趟最小元素所在的位置
            for(int j = i+1; j < n; j++) {
                if(A[minIdx] > A[j]) {
                    minIdx = j;
                }
            }
            //交换位置：把最小元素放到A[i]位置上
            int temp = A[i];
            A[i] = A[minIdx];
            A[minIdx] = temp;
        }
    }

    /**
     * 插入排序算法
     * 算法思想：
     * 每次从无序区首部取出一个元素，插入到有序区中。有序区插入规则：
     * 从尾部向前遍历有序区，遇到比目标大的元素，就后移一个位置，遇到小于等于目标的元素，就停止遍历，然后把目标元素放入目标位置。
     * @param A  待排序数组
     * @param n  数组长度
     */
    public static void insertSort(int A[], int n) {
        for(int i = 1; i < n; i++) {
            int target = A[i]; //本趟的目标数据
            int insertIdx = i; //本趟目标数据的插入位置
            //从有序区尾部向前查找，i前面是有序区
            for(int j = i-1; j >= 0; j--) {
                if(target >= A[j]) {
                    break;
                }
                A[j+1] = A[j]; //j元素后移
                insertIdx = j;
            }
            A[insertIdx] = target;
        }
    }

    /**
     * 快速排序算法
     * 算法思想：
     * 1.从序列中找出一个基准数base（一般取第一个元素），经过一趟快速排序，达到这样的效果：基准数左边的都比它小，基准数左边的数都比它大；
     * 2.设置两个“哨兵”i和j，分别从序列两端开始“探测”，i从前向后找一个比base大的数、j从后向前找一个比base小的数，每次一定要j先动（非常重要），
     *   找到后交换它们的位置，然后继续“探测”。如果i和j相遇则说本趟排序结束，停止移动，然后把相遇位置i的数和base交换位置。
     * 3.以基准数为中心，将数组分割成两部分，分别对左边和右边的两个序列进行快速排序，直到无法拆分出新的子序列为止。
     *
     * @param A     待排序数组
     * @param head  序列头部位置
     * @param tail  序列尾部位置
     */
    public static void quickSort(int A[], final int head, final int tail) {
        if(head > tail) {
            return;
        }
        //取第一个数head作为基准数
        int i = head;
        int j = tail;
        while(i < j) {
            //j先动（非常重要），从后向前探测，遇到比base小的数时停止
            while(i < j && A[j] >= A[head]) {
                j--;
            }
            //i向后探测，遇到比base大的数时停止
            while(i < j && A[i] <= A[head]) {
                i++;
            }
            //交换两个数
            if(i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        //将base放到合理的位置
        int temp = A[i];
        A[i] = A[head];
        A[head] = temp;

        //对左边序列快速排序
        quickSort(A, head, i - 1);
        //对右边序列快速排序
        quickSort(A, i + 1, tail);
    }

    /**
     * 归并排序算法
     * 算法思想：
     * 将待排序序列拆分成两个子序列，子序列继续拆分，直到无法继续拆出新的子序列；
     * 拆分结束后，开始合并，合并两个有序序列：从两个有序序列第一个元素开始比较，
     * 将较小的元素放入临时数组中，直到合并成一个有序序列，然后将有序序列回填到原数组位置中。
     * @param A     待排序数组
     * @param start 排序区域开始位置（包含）
     * @param end   排序区域结束位置（包含）
     * @param B     临时数据存储区，长度与A相同
     */
    public static void mergeSort(int A[], int start, int end, int B[]) {
        //当start == end的时候，表示只剩下一个元素，不可继续拆分，直接合并即可
        if(start < end) {
            int mid = (start + end) / 2; //中间位置

            mergeSort(A, start, mid, B); //左边的序列
            mergeSort(A, mid + 1, end, B); //右边的序列
            mergeArray(A, start, mid, end, B); //合并左右两个有序序列
        }
    }

    /**
     * 合并两个有序序列
     * 分别使用两个索引指向两个有序序列头部，比较两个索引元素的大小，把较小的放入临时数组对应的位置，然后索引后移，
     * 如果有一个有序序列全部放入临时数组中，则结束比较，然后将剩余的序列（如果有）直接放入临时数组中。最后把临时
     * 数组的元素拷贝到序列对应的位置中。
     * @param A     待排序数组
     * @param start 有序序列1 开始位置(包含)
     * @param mid   有序序列1 结束位置(包含)，有序序列2 开始位置(包含)
     * @param end   有序序列2 结束位置(包含)
     * @param B     临时数据存储区，长度与A相同
     */
    private static void mergeArray(int A[], int start, int mid, int end, int B[]) {
        //注意：start <= mid, mid+1 <= end
        int i = start, m = mid;
        int j = mid + 1, n = end;
        int b = 0; //临时数组的索引
        //比较两个有序序列元素，把较小的放入临时数组
        while(i <= m && j <= n) {
            if(A[i] < A[j]) {
                B[b++] = A[i++];
            }
            else {
                B[b++] = A[j++];
            }
        }
        //处理剩余元素
        while(i <= m) {
            B[b++] = A[i++];
        }
        while(j <= n) {
            B[b++] = A[j++];
        }
        //合并后的数据填充到序列原来的位置
        for(int k = 0; k < b; k++) {
            A[start+k] = B[k];
        }
    }

    /**
     * 希尔排序算法
     * 算法思想：
     * 希尔排序的本质，是先分组，利用插入排序减少内部无序化，在整体进行一次插入排序。
     * 相当于先把先把一个大的数组分成几个小的数组插入排序，减少数组中每个元素遍历整个大的数组进行插入排序，
     * 从而提高了插入排序效率。
     *
     * 希尔排序的实质就是分组插入排序，该方法又称缩小增量排序。
     * 将无序数组分割为若干个子序列，子序列不是逐段分割的，而是相隔特定的增量的子序列，对各个子序列进行插入排序；
     * 然后再选择一个更小的增量，再将数组分割为多个子序列进行排序......最后选择增量为1，即使用直接插入排序，使最终数组成为有序。
     * 采用首选增量为n/2，以此递推，每次增量为原先的1/2，直到增量为1
     *
     * @param A  待排序数组
     * @param n  数组长度
     */
    public static void shellSort(int A[], int n) {
        int step = n / 2; //初始增量设为数组长度的一半
        while(step >= 1) {
            shellInsert(A, step, n); //对子序列采用插入排序

            step = step / 2; //每次增量变为上次的二分之一
        }
    }

    /**
     * 希尔排序的插入排序
     * @param A    数组
     * @param step 步长
     * @param n    数组长度
     */
    private static void shellInsert(int A[], int step, int n) {

    }

    /**
     * 堆排序算法
     * @param A  待排序数组
     * @param n  数组长度
     */
    public static void heapSort(int A[], int n) {

    }
}
