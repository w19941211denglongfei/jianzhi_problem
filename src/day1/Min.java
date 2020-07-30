package day1;
public class Min {
    public static int min(int[] numbers, int length){
        if (numbers == null || length <= 0){
            return -1;
        }
        int l = 0;
        int r = length - 1;
        int mid = 0; //情况1
        while (numbers[l] >= numbers[r]){
            if (r - l == 1){
                mid = r;
                break;
            }
            //情况2
            if (numbers[l] == numbers[r] && numbers[mid] == numbers[l]){
                return MinInOrder(numbers,l,r);
            }
            mid = l + r >> 1;
            if (numbers[mid] >= numbers[l]){
                l = mid;
            }else {
                if (numbers[mid] <= numbers[r]){
                    r = mid;
                }
            }
        }
        return numbers[mid];
    }

    public static int MinInOrder(int[] numbers, int l, int r){
        int result = numbers[l];
        for (int i = l+1; i <= r; ++i){
            if (result > numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3,4,5,1,2};
        int length = n.length - 1;
        int result = min(n,length);
        System.out.println(result);
    }
}
