package entryexam;


import java.util.*;

/**
 * Created by shipeng on 2017/8/9.
 */
public class EntryExam {


    /**
     * 1. 遍历1-100，被3整除的输出a, 被5整除的输出b，被15整除的输出c。
     * 点评: 刚哥御用笔试题，考察点主要在于被15整除的数也可以被3和5整除，写代码的时候注意绕过这个逻辑即可，据说有50%的人写不出来，o(╯□╰)o。
     */
    public static void easy1() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("c" + "   " + i);
            } else if (i % 3 == 0) {
                System.out.println("a" + "   " + i);
            } else if (i % 5 == 0) {
                System.out.println("b" + "   " + i);
            }
        }
    }

    /**
     * 2. 输入一个字符串，全是大写字母范围从'A'-'Z'(A,B,C,D,AA,AB,AC)，输出相应的int值. (A=1,B=2,Z=26,AA=27...)
     * 点评: 就是考察了一下 sum = sum * 26 + curr;
     */
    public static int easy2(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < 'A' || c > 'Z') {
                return 0;
            }
            sum = sum * 26 + (c - 'A') + 1;
        }
        return sum;
    }


    /**
     * 3. 求两个数的最大公约数
     * 点评: 如果候选人知道辗转相除法，应该还是比较简单的。否则可能就写不出来了，面试官还是根据候选人的实际情况，看看要不要考察这道题目。
     */
    public static int easy3(int a, int b) {
        if (a < 1 || b < 1) {
            return 1;
        }
        return gcdHelper(Math.max(a, b), Math.min(a, b));
    }


    private static int gcdHelper(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        int c = a - b;
        return gcdHelper(Math.max(b, c), Math.min(b, c));
    }


    /**
     * 4. 判断一个字符串是不是回文,  given "abcba" return true， given "abcab" return false;
     * 点评: 超级简单有木有，最多5分钟，不能再多了。
     */
    public static boolean easy4(String input) {
        if (input == null || input.length() <= 1) {
            return true;
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 5. 输入两个字符串表示version，"1.1.2", "1.1.1", 判断两个version那个是最新的。(简化一下，假定输入都是合法的)
     * "1.1.1" < "1.1.2"。 "2" > "1.1"
     * 点评: 也没啥，就是考察写代码的基本功，拆分字符串，compare，循环等。
     */
    public static int easy5(String ver1, String ver2) {
        if (ver1 == ver2) {
            return 0;
        }
        if (ver1 == null) {
            return -1;
        }
        if (ver2 == null) {
            return 1;
        }

        String[] array1 = ver1.split("\\.");
        String[] array2 = ver2.split("\\.");

        int len1 = array1.length;
        int len2 = array2.length;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            int num1 = Integer.valueOf(array1[i]);
            int num2 = Integer.valueOf(array2[i]);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return len1 > len2 ? 1 : -1;
    }


    /**
     * 6. 有两个已经排好序的数组(升序)，现在把这两个数组合成一个按升序排列的数组。
     * given array1=[1,3,5,7,9], given array2=[2,4,6,8,10], return newarray[1,2,3,4,5,6,7,8,9,10]
     * 点评: 数组基本操作
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] easy6(int[] array1, int[] array2) {
        if (array1 == null || array1.length < 1) {
            return array2;
        }
        if (array2 == null || array2.length < 1) {
            return array1;
        }
        int len1 = array1.length;
        int len2 = array2.length;
        int[] merge = new int[len1 + len2];

        int i = 0, j = 0, k = 0;
        while (j < len1 && k < len2) {
            if (array1[j] <= array2[k]) {
                merge[i++] = array1[j++];
            } else {
                merge[i++] = array2[k++];
            }
        }
        while (j < len1) {
            merge[i++] = array1[j++];
        }

        while (k < len2) {
            merge[i++] = array2[k++];
        }

        return merge;
    }


    /**
     * 7. 单词计数，输入一个字符串数组，统计每个单词出现的次数。
     * given ["boy","girl","boy"], return boy:2, girl:1
     * 点评: 数据结构考察，用个map保存一下key，value即可，还是很简单的。
     */
    public static void easy7(String[] words) {
        if (words == null || words.length < 1) {
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        System.out.println("finish");
    }


    /**
     * 8. 给定两个区间，判断这两个区间是否重合，given [1,3],[5,6] return 不重合(false), given[1,3],[2,5] return 重合(true)
     * 点评: 考察一下逻辑思维能力，没啥特别的，也就一行代码的事情。
     */
    public static boolean easy8(int[] interval1, int[] interval2) {
        if (interval1 == null || interval2 == null) {
            return false;
        }

        return !(interval1[0] > interval2[1] || interval1[1] < interval2[0]);
    }


    /**
     * 9. 翻转链表
     * 点评: 老题目，不过如果没准备的话，翻起来也没那么容易
     */
    public static LinkedNode easy9(LinkedNode head) {
        if (head == null || head.nextNode == null) {
            return head;
        }

        LinkedNode curr = head;
        LinkedNode pre = null;
        LinkedNode next;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    /**
     * 10. 一个排好序的数组(升序)，给一个数字，判断数组中是否有两个数加起来=给定的数字
     * array=[1,2,3,4,5], given target=8, return true(3+5==8),  given 10, return false;
     * 点评: 要求o(n)复杂度，两个指针，遍历一遍就行了。
     */
    public static boolean easy10(int[] array, int target) {
        if (array == null || array.length < 2) {
            return false;
        }

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if ((array[start] + array[end]) == target) {
                return true;
            } else if ((array[start] + array[end]) > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }


    /**
     * 1. 有一个排好序的数组(升序)，给定一个数字，找出这个数字在这个数组中第一次出现的index，如果不在数组中则返回-1.
     * 比如array=[1,2,2,3,4,5], target=2, return 1(第一次出现2的数组下标是1)
     * 点评: 算法复杂度要求log(n)，即要求候选人用二分查找来做，与经典的二分查找不一样，要求是要返回第一次出现该数字的index，只会'背'二分查找的同学是很难写出来的
     *
     * @return
     */
    public static int normal1(int[] array, int target) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                int candidate = mid;
                while (candidate >= 0 && array[candidate] == target) {
                    candidate--;
                }
                return candidate + 1;
            } else if (array[mid] > target) {
                end--;
            } else {
                start++;
            }
        }
        return -1;
    }


    /**
     * 2. 把字符串转成int，即输入"123",输出123。(不允许用库函数，绝对不允许)
     * 点评: 很难的一道题目。各种边界考察，诸如正负号、非法字符、int越界。候选人考虑到的边界情况越多越好，不期望完全bugfree。
     */
    public static int normal2(String str) {
        boolean isNegative = false;
        str = str.trim();
        if (str.startsWith("-")) {
            isNegative = true;
        }
        int sum = 0;
        int multi = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }
            if (sum > multi || ((sum == multi) && Integer.MAX_VALUE % 10 < (c - '0'))) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum * 10 + (c - '0');
        }

        return isNegative ? -sum : sum;
    }


    /**
     * 3. 给一个字符串，都是小写字母范围从'a'-'z', 其中有些字符出现了不止一次，删掉那些出现多次的字符，确保每个字符只出现一次。字符顺序不做要求。
     * 比如 "bcabc",  返回"bca"，或者"cab"  都是OK的。
     * 点评: 就是考察一下字符串的基本操作，对数据结构的理解。
     */

    public static String normal3(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        int[] flag = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            flag[c - 'a']++;
        }

        char[] array = new char[26];
        int j = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] >= 1) {
                array[j++] = (char) ('a' + i);
            }
        }
        return new String(array, 0, j);
    }


    /**
     * 4. 求pi，没错就是求pi(圆周率)。
     * 点评: 如果候选人有机器学习相关背景，并且对于蒙特卡罗方法比较熟悉的话，应该可以写出来。
     */
    public static float normal4() {
        Random r = new Random();
        int total = 10000000;
        int sum = 0;
        for (int i = 0; i < total; i++) {
            //随机生成[0,1]之间的坐标点
            double distance = Math.pow(r.nextFloat(), 2) + Math.pow(r.nextFloat(), 2);
            if (distance <= 1) {
                sum++;
            }
        }
        return (float) sum * 4 / total;
    }


    /**
     * 5. 对一个整数开根号(不许用库函数)
     * 点评: 方法应该有很多。这道题目还是为某些有机器学习背景的同学准备的。我本人是比较倾向于候选人用牛顿迭代法来做，
     * 如果接触过一些机器学习或者上过类似计算方法这样的课程，应该是第一时间反应用牛顿迭代法。
     */
    public static float normal5(int m) {
        // 牛顿迭代法，求解x^2-a=0
        // y=f(x)'(x-x0) + f(x0)
        // m=2x0(x1-x0)+x0^2 --> m=2x0*x1-x0^2  --> x1=(m+x0^2)/2x0
        if (m <= 1) {
            return m;
        }
        float err = 0.001f;
        int maxIter = 100;
        float currErr = m;
        int i = 0;
        float curr = 1;
        float next = 0;
        while (i < maxIter && currErr > err) {
            next = (m + curr * curr) / 2 / curr;
            currErr = Math.abs(next * next - m);
            curr = next;
            i++;
        }
        return next;
    }


    /**
     * 6. 给4个数字，判断能不能用加减乘除算出24点。比如 5，5，5，1。可以算出24点，返回true。 (5-1/5)*5 = 24;
     * 点评：部分有竞赛背景的同学不妨拿这道题目难为一下，只用返回true or false就可以，不需要给出具体表达式。
     * 对于有ACM背景的同学来说30分钟应该是可以写出来的，其他正常人类就不要用这道题目为难人家了。
     */
    public static boolean normal6(int[] array) {
        if (array == null || array.length != 4) {
            return false;
        }
        float[] newArray = new float[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return helper(newArray);
    }

    private static boolean helper(float[] array) {
        if (array.length == 2) {
            if (array[0] + array[1] == 24) {
                return true;
            } else if (Math.abs(array[0] - array[1]) == 24) {
                return true;
            } else if (array[0] * array[1] == 24) {
                return true;
            } else {
                if (array[0] != 0) {
                    if (array[1] / array[0] == 24) {
                        return true;
                    }
                }
                if (array[1] != 0) {
                    if (array[0] / array[1] == 24) {
                        return true;
                    }
                }
            }
            return false;
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                float[] newArray = generateNewArray(array, i, j);
                newArray[newArray.length - 1] = array[i] + array[j];
                if (helper(newArray)) {
                    return true;
                }
                newArray[newArray.length - 1] = Math.abs(array[i] - array[j]);
                if (helper(newArray)) {
                    return true;
                }
                newArray[newArray.length - 1] = array[i] * array[j];
                if (helper(newArray)) {
                    return true;
                }

                if (array[i] != 0) {
                    newArray[newArray.length - 1] = array[j] / array[i];
                    if (helper(newArray)) {
                        return true;
                    }
                }

                if (array[j] != 0) {
                    newArray[newArray.length - 1] = array[i] / array[j];
                    if (helper(newArray)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static float[] generateNewArray(float[] array, int i , int j) {
        float[] res = new float[array.length - 1];
        for (int k = 0, m = 0; k < array.length; k++) {
            if (k != i && k != j) {
                res[m++] = array[k];
            }
        }
        return res;
    }


    /**
     * 7. 判断一个字符串是不是合法的ip(不许用正则)
     * 点评: 考察字符串基本操作，各种边界条件。要想写个bugfree的没有那么简单。
     */
    public static boolean normal7(String str) {
        if (null == str || str.length() < 7 || str.length() > 15) {
            return false;
        }
        String[] parts = str.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        try {
            for (int i = 0; i < parts.length; i++) {
                int num = Integer.parseInt(parts[i]);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * 8. 翻转一个int，即输入12345，输出54321. 输入-123，输出-321
     * 点评: 候选人至少要考虑两个场景，负数和越界。其他的就是一些基本功的考察。写好也不容易。
     */
    public static int normal8(int a) {
        int sign = a < 0 ? -1 : 1;
        a = Math.abs(a);
        int sum = 0;
        int[] tmp = new int[10];
        int max = 0;
        while (a > 0) {
            tmp[max++] = a % 10;
            a = a / 10;
        }
        int multi = Integer.MAX_VALUE / 10;
        for (int i = 0; i < max; i++) {
            // 判断是否越界，如果越界就返回Integer.MAX_VALUE
            if (sum > multi || ((sum == multi) && Integer.MAX_VALUE % 10 < tmp[i])) {
                return Integer.MAX_VALUE * sign;
            }
            sum = sum * 10 + tmp[i];
        }
        if (sum < 0) {
            return Integer.MAX_VALUE * sign;
        }
        return sum * sign;
    }


    /**
     * 9. 10进制数转成16进制(不许用库函数，不许用)， given 100, return 64,  given 250, return FA
     * 简化一下，只考虑正数，负数的十六进制表达有点怪怪的。
     * 点评: 就是各种基本功了，也没啥，力求代码写得好看点。
     */

    public static String normal9(int m) {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        m = Math.abs(m);

        StringBuilder sb = new StringBuilder();
        while (m > 0) {
            sb.append(chars[m % 16]);
            m = m / 16;
        }
        return sb.reverse().toString();
    }


    /**
     * 10. 有两个n维向量(n 很大)，并且两个向量中有大量的0，求这两个向量的点积。
     * 点积的定义: 给定两个向量，向量a[1,2,,,,n],向量b[1,2,,,,n]，(两个向量的维度一定是一样的)，点积= a1*b1 + a2*b2 + ....+ an*bn;
     * 点评: 一个小算法，因为向量中有大量的0，所以可以用一些小技巧提高一下算点积的速度，仅此而已。
     */
    public static int normal10(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return 0;
        }
        if (array1.length != array2.length) {
            return 0;
        }

        Set<Integer> nonZero = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0) {
                nonZero.add(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] != 0 && nonZero.contains(i)) {
                sum += array1[i] * array2[i];
            }
        }
        return sum;
    }


    private static class LinkedNode {
        public LinkedNode() {
        }

        public LinkedNode(int val) {
            this.val = val;
        }

        public int val;
        public LinkedNode preNode;
        public LinkedNode nextNode;
    }


    public static void main(String[] args) {
        EntryExam.easy1();
        System.out.println(EntryExam.easy2("A"));
        System.out.println(EntryExam.easy3(3, 5));
        System.out.println(EntryExam.easy4("abcab"));
        System.out.println(EntryExam.easy5("1.0.1", "1.0"));
        EntryExam.easy6(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8});
        EntryExam.easy7(new String[]{"boy1", "boy2", "boy1", "boy3"});
        System.out.println(EntryExam.easy8(new int[]{1, 3}, new int[]{4, 5}));

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        node1.nextNode = node2;
        node2.nextNode = node3;
        EntryExam.easy9(node1);

        System.out.println(EntryExam.easy10(new int[]{1, 3, 4}, 6));


        System.out.println(EntryExam.normal1(new int[]{1, 2, 2, 3, 4}, 2));
        System.out.println(EntryExam.normal2("2113"));
        System.out.println(EntryExam.normal3("leetcode"));
        System.out.println(EntryExam.normal4());
        System.out.println(EntryExam.normal5(5));
        System.out.println(EntryExam.normal6(new int[]{4, 10, 10, 4}));
        System.out.println(EntryExam.normal7("127.0.0.1"));
        System.out.println(EntryExam.normal8(1234567899));
        System.out.println(EntryExam.normal9(-255));
        System.out.println(EntryExam.normal10(new int[]{0, 3, 0, 0, 0}, new int[]{1, 2, 3, 4, 5}));

    }

}
