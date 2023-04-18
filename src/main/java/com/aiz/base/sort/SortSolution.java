package com.aiz.base.sort;

import java.util.Arrays;

/**
 * @ClassName SortSolution
 * @Description 排序算法
 * @Author Yao
 * @Date Create in 11:46 下午 2021/6/16
 * @Version 1.0
 */
public class SortSolution {

    /**
     * 1。冒泡排序：它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 2。选择排序：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 3。插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            int current = array[i];
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 4。希尔排序：希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止。
     * <p>
     * 希尔排序也是一种插入排序，它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] shellSort(int[] array) {
        int length = array.length;
        int temp, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }


    /**
     * 6。归并排序：将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
     * <p>
     * 步骤1：把长度为n的输入序列分成两个长度为n/2的子序列；
     * 步骤2：对这两个子序列分别采用归并排序；
     * 步骤3：将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] mergeSort(int[] array, int l, int h) {
        if (l == h) {
            return new int[]{array[l]};
        }
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(array, l, mid);
        int[] rightArr = mergeSort(array, mid + 1, h);

        int[] result = new int[leftArr.length + rightArr.length];

        int index = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            result[index++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            result[index++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            result[index++] = rightArr[j++];
        }
        return result;
    }

    /**
     * 6。快速排序：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * <p>
     * 步骤1：从数列中挑出一个元素，称为 “基准”(pivot)
     * 步骤2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区(partition)操作；
     * 步骤3：递归地(recursive)把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return quickSort(arrayCopy, 0, arrayCopy.length - 1);
    }

    private static int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p);
            quickSort(array, p + 1, right);
        }
        return array;
    }

    private static int partition(int[] array, int left, int right) {
        // 设定基准值（pivot）
        int pivot = array[left];
        // pivotIndex为小于基准值的区间
        int pivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) {
                swap(array, i, ++pivotIndex);
            }
        }
        swap(array, left, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 7。堆排序：是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     * 堆排序可以说是一种利用堆的概念来排序的选择排序：
     * (1)、大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
     * (2)、小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
     * 堆排序的平均时间复杂度为 Ο(nlogn)。
     * <p>
     * 步骤1：把无序数组构建成二叉堆。
     * 步骤2：循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */

    public static int[] heapSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        int length = arrayCopy.length;
        buildMaxHeap(arrayCopy, length);
        for (int i = length - 1; i > 0; i--) {
            swap(arrayCopy, 0, i);
            length--;
            heapify(arrayCopy, 0, length);
        }
        return arrayCopy;
    }

    /**
     * 构建大顶堆
     */
    private static void buildMaxHeap(int[] array, int length) {
        // Math.floor() 函数用来返回数字的下舍整数
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            heapify(array, i, length);
        }
    }

    /**
     * 数组：8 1 9 6 4 7 1 1 3
     * 堆：
     * 8
     * 1    9
     * 6  4  7  1
     * 1 3
     * 数组中第n(n>=0)个元素对应堆中的左右孩子结点分别为2n+1和2n+2
     * <p>
     * 选择根节点的孩子节点中的最大值和根节点交换。
     */

    /**
     * 重建堆
     * 调整array[i,length]为大顶堆
     */
    private static void heapify(int[] array, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, length);
        }
    }


    /**
     * 8。计数排序：计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。
     * 然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序。
     * <p>
     * 步骤1：找出待排序的数组中最大和最小的元素；
     * 步骤2：统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 步骤3：对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 步骤4：反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    private static int[] countingSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        // find max
        int max = arrayCopy[0], min = arrayCopy[0];
        for (int i = 1; i < arrayCopy.length; i++) {
            max = Math.max(max, arrayCopy[i]);
            min = Math.min(min, arrayCopy[i]);
        }
        // 数组C(bucket)
        // [min,min+1... ...max-1,max]，一共max-min+1个
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < arrayCopy.length; i++) {
            bucket[arrayCopy[i] - min]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            while (count > 0) {
                arrayCopy[arrIndex++] = i + min;
                count--;
            }
        }
        return arrayCopy;
    }


    /**
     * 8。桶排序：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排。
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * <p>
     * 步骤1：人为设置一个BucketSize，作为每个桶所能放置多少个不同数值；（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     * 步骤2：遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 步骤3：对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     * 步骤4：从不是空的桶里把排好序的数据拼接起来。
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */
    private static int[] bucketSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        return bucketSort(arrayCopy, 5);
    }

    private static int[] bucketSort(int[] array, int bucketSize) {
        if (array.length == 0) {
            return array;
        }
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < array.length; i++) {
            int index = (int) Math.floor((array[i] - min) / bucketSize);
            buckets[index] = arrayAppend(buckets[index], array[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertionSort(bucket);
            for (int value : bucket) {
                array[arrIndex++] = value;
            }
        }

        return array;
    }

    /**
     * 自动扩容，并保存数据
     */
    private static int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    /**
     * 10。基数排序：基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
     * <p>
     * 步骤1：取得数组中的最大数，并取得位数；
     * 步骤2：arr为原始数组，从最低位开始取每个位组成radix数组；
     * 步骤3：对radix进行计数排序（利用计数排序适用于小范围数的特点）
     *
     * @param array 需要排序的数组
     * @return 排序后的数组
     */

    private static int[] radixSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        int maxDigit = getMaxDigit(arrayCopy);
        return radixSort(arrayCopy, maxDigit);
    }

    private static int[] radixSort(int[] array, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < array.length; j++) {
                int bucket = ((array[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], array[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    array[pos++] = value;
                }
            }
        }
        return array;
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] array) {
        int maxValue = getMaxValue(array);
        return getNumLength(maxValue);
    }

    private static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int value : array) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected static int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        // 1.冒泡排序
        int[] bubbleArray = bubbleSort(array);
        printArray(bubbleArray);

        // 2.选择排序
        int[] selectionArray = selectionSort(array);
        printArray(selectionArray);

        // 3.插入排序
        int[] insertionArray = insertionSort(array);
        printArray(insertionArray);

        // 4.希尔排序
        int[] shellArray = shellSort(array);
        printArray(shellArray);

        // 5.归并排序
        int[] mergeArray = mergeSort(array, 0, array.length - 1);
        printArray(mergeArray);

        // 6.快速排序*
        int[] array6 = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        int[] quickArray = quickSort(array6);
        printArray(quickArray);

        // 7.堆排序*
        int[] array7 = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        int[] heapArray = heapSort(array7);
        printArray(heapArray);

        // 8.计数排序
        int[] array8 = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        int[] countingArray = countingSort(array8);
        printArray(countingArray);

        // 9.桶排序
        int[] array9 = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        int[] bucketArray = bucketSort(array9);
        printArray(bucketArray);

        // 10.基数排序
        int[] array10 = new int[]{9, 2, 1, 4, 3, 8, 0, -1};
        int[] radixArray = radixSort(array10);
        printArray(radixArray);
    }

    /**
     * 打印数组
     *
     * @param array 需要打印的数组
     */
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
/*
 * 参考链接：https://blog.csdn.net/weixin_41190227/article/details/86600821
 * https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
 */