package algorithm.stack;

/**
 * 顺序栈（整型）
 */
public class SeqStack1 {

    private int[] data = new int[100];
    private int top;


    public void display(String msg){
        System.out.println("====="+msg+"=====");
        for (int i=0;i<=top;i++){
            System.out.print(String.format("%d",data[i]));
        }
        System.out.println();
    }

    /**
     * 置空栈
     */
    public void init() {
        top = -1;
    }

    /**
     * 判栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判栈满
     */
    public boolean isFull() {
        return top == data.length - 1;
    }


    /**
     * 进栈
     */
    public void push(int x) {
        if (isFull()) {
            System.out.println("stack overflow");
        } else {
            top++;
            data[top] = x;
        }
    }

    /**
     * 退栈
     *
     * @return
     */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return null;
        } else {
            return data[top--];
        }
    }

    /**
     * 取栈顶元素
     */
    public Integer getTop() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        } else {
            return data[top];
        }
    }


    public static void main(String[] args) {
        SeqStack1 seqStack = new SeqStack1();

        seqStack.init();
        seqStack.push(1);
        seqStack.push(2);
        seqStack.push(3);
        seqStack.push(4);

        seqStack.display("进栈后当前元素");


        seqStack.pop();
        seqStack.pop();
        seqStack.display("出栈后元素");

        seqStack.pop();
        seqStack.pop();
        //栈下溢
        seqStack.pop();
    }
}
