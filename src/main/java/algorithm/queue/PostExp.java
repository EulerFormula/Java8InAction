package algorithm.queue;

import algorithm.stack.SeqStack;
import algorithm.stack.SeqStack1;

import java.util.Scanner;

/**
 * 中缀表达式到后缀表达式的转换
 */
public class PostExp {

    /**
     * 判断运算符的优先级
     */
    static int priority(char op) {

        switch (op) {
            case '(':
            case '#':
                return 0;
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }


    /**
     * 将中缀表达式转为后缀表达式
     * 1.顺序扫描中缀算术表达式，当读到数字时，直接将其送至输出队列中；当读到运算符时，将栈中所有优先级高于
     * 或等于该运算符的运算符弹出，送至输出队列中，再将当前运算符入栈；当读入左括号时，即入栈；当读到右括号时，
     * 将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列中，再删除栈中的左括号
     *2.为了方便边界条件（栈空）的判断，提高算法的运行效率，在扫描读入中缀表达式之前，在空栈中预先压入一个"#"
     * 字符作为栈底元素，另外在表达式的最后增加一个"#"字字符，作为中缀表达式的结束标志。
     * @param queue
     */
    static void ctPostExp(CirQueue queue) {
        SeqStack seqStack = new SeqStack();
        seqStack.init();
        seqStack.push('#');

        System.out.print("请输入中缀表达式以#结尾:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case ' ':
                    //去除空格符
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    queue.enQueue(c);
                    break;
                case '(':
                    seqStack.push(c);
                    break;
                case ')':
                case '#':
                    char op;
                    do {
                        op = seqStack.pop();
                        if (op != '(' && op != '#') {
                            queue.enQueue(op);
                        }
                    } while (op != '(' && op != '#');
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (priority(c) <= priority(seqStack.getTop())) {
                        op = seqStack.pop();
                        queue.enQueue(op);
                    }

                    seqStack.push(c);
                    break;
            }
        }
    }

    static int cPostExp(CirQueue queue){
        SeqStack1 seqStack1=new SeqStack1();
        seqStack1.init();

        char ch;
        while (!queue.isEmpty()){
            ch = queue.deQueue();
            if(ch>='0' && ch<='9'){
                seqStack1.push(ch-'0');
            }else {
                int y = seqStack1.pop();
                int x = seqStack1.pop();

                switch (ch){
                    case '+':
                        seqStack1.push(x+y);
                        break;
                    case '-':
                        seqStack1.push(x-y);
                        break;
                    case '*':
                        seqStack1.push(x*y);
                        break;
                    case '/':
                        seqStack1.push(x/y);
                        break;
                }

            }



        }

        return seqStack1.getTop();
    }

    public static void main(String[] args) {
        CirQueue cirQueue = new CirQueue();
        cirQueue.init();
        ctPostExp(cirQueue);

        cirQueue.display("后缀表达式为：");

        System.out.println("后缀表达式计算结果为："+cPostExp(cirQueue));
    }

}
