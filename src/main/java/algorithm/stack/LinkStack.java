package algorithm.stack;

/**
 * 链栈
 */
public class LinkStack {

    private StackNode top;


    public void display(String msg) {

        System.out.println("=====" + msg + "=====");

        StackNode p = top;
        while (p != null) {

            System.out.print(String.format("%3c", p.getData()));
            p = p.getNext();
            if (p != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    /**
     * 判栈空
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 进栈
     */
    public StackNode push(char x) {
        //申请新结点
        StackNode stackNode = new StackNode();
        stackNode.setData(x);
        //将新结点插入栈顶
        stackNode.setNext(top);

        //使top指向新的栈顶
        top = stackNode;

        //返回栈顶指针
        return top;
    }

    /**
     * 退栈
     */
    public Character pop() {
        StackNode p = top;

        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        } else {
            //栈顶指针指向下一个结点
            top = top.getNext();
            Character ch = p.getData();
            //删除p指向的结点
            p = null;
            return ch;
        }

    }

    /**
     * 取栈顶元素
     */
    public Character getTop() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        } else {
            return top.getData();
        }
    }



    public static void main(String[] args) {

        LinkStack linkStack = new LinkStack();

        linkStack.push('t');
        linkStack.push('e');
        linkStack.push('s');
        linkStack.push('t');
        linkStack.display("进栈后当前元素");

        linkStack.pop();
        linkStack.pop();
        linkStack.display("出栈后当前元素");

        linkStack.pop();
        linkStack.pop();
        linkStack.pop();


    }
}
