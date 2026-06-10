// d)Findthetime&spacecomplexityoffloorSqrtfunctioninthefollowingcodetocalculatesquare root of a number :

public class MCQ {

    public static int floorSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int i = 1, result = 1;
        while (result <= x) {
            i++;
            result = i * i;
        }

        return i - 1;
    }

    public static void main(String args[]) {
        int x = 11;
        System.out.print(floorSqrt(x));

    }
}

// Your loop works like this:
// i	result = i * i	Check
// 1	1	1 ≤ 11 ✅
// 2	4	4 ≤ 11 ✅
// 3	9	9 ≤ 11 ✅
// 4	16	16 ≤ 11 ❌
