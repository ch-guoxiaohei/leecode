package classic;

public class _02_RemoveDup {

    /**
     * mermind flow 图
     * flowchart TD
     *     subgraph Array1
     *         A[元素1]
     *         B[元素2]
     *         C[元素3]
     *     end
     *
     *     subgraph Array2
     *         D[元素A]
     *         E[元素B]
     *         F[元素C]
     *     end
     *
     *     B -- 比较 --> D
     *     C -- 比较 --> E
     * @param args
     */
    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{0, 0, 1, 2});
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int newArrayIndex = 0;
        int index = 1;
        while (index < nums.length) {
            if (nums[index] != nums[newArrayIndex]) {
                newArrayIndex++;
                nums[newArrayIndex] = nums[index];
            }
            index = index + 1;
        }
        return newArrayIndex + 1;
    }
}
