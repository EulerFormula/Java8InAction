package algorithm.stack;

import java.util.PrimitiveIterator;
import java.util.Scanner;

/**
 * 栈的应用举例
 */
public class StackUse {


    /**
     * 循环读入表达式中的字符，如遇左括号“（”就进栈，
     * 遇右括号“）”则判断是否为空，若为空，则返回false，
     * 否则退栈，循环结束后再判断栈是否为空，若栈空则说明
     * 括号匹配，否则说明不匹配
     */
    public static boolean kuohao(String input) {
        SeqStack<Character> seqStack = new SeqStack<>();
        seqStack.init();


        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch == '(') {
                seqStack.push('(');
            } else if (ch == ')') {
                if (seqStack.isEmpty()) {
                    return false;
                } else {
                    char x = (char)seqStack.pop();
                }
            }
        }

        if (seqStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 回文是中心对称，首先要知道中心位置在哪儿，有了中心位置以后，
     * 就可以从中间向两头进行比较，若完全相同，则该字符串是中心对称，
     * 否则不是
     */
    public static boolean isPalindrom(String input) {
        SeqStack<Character> seqStack = new SeqStack<>();
        seqStack.init();

        for (int i = 0; i < input.length() / 2; i++) {
            seqStack.push(input.charAt(i));
        }

        for (int i = (input.length() + 1) / 2; i < input.length(); i++) {
            if (input.charAt(i) != (char)seqStack.pop()) {
                return false;
            }
        }

        return true;
    }

    /**
     * N = (N/d)*d + N%d
     */
    public static void conversion(int N,int d){
        SeqStack<Character> seqStack = new SeqStack<>();
        seqStack.init();

        System.out.print(N+"的"+d+"进制是：");
        while (N!=0){
            seqStack.push((char)(N%d+48));
            N = N/d;
        }

        while (!seqStack.isEmpty()){
            char ch = (char)seqStack.pop();
            System.out.printf("%c",ch);
        }
        System.out.println();
    }
    public static void main(String[] args) {

        String kuohoa1 = "(2+(3+2))";
        //左括号多
        String kuohoa2 = "(2+((3+2))";
        //右括号多
        String kuohoa3 = "(2+(3+2)))";

        System.out.println(kuohoa1 + "括号匹配结果：" + StackUse.kuohao(kuohoa1));
        System.out.println(kuohoa2 + "括号匹配结果：" + StackUse.kuohao(kuohoa2));
        System.out.println(kuohoa3 + "括号匹配结果：" + StackUse.kuohao(kuohoa3));

        String huiwen1 = "ababbaba";
        String huiwen2 = "abcba";
        String huiwen3 = "abc";

        System.out.println((huiwen1 + (isPalindrom(huiwen1) ? "是" : "不是") + "回文"));
        System.out.println((huiwen2 + (isPalindrom(huiwen2) ? "是" : "不是") + "回文"));
        System.out.println((huiwen3 + (isPalindrom(huiwen3) ? "是" : "不是") + "回文"));


        StackUse.conversion(8,2);

    }
}
