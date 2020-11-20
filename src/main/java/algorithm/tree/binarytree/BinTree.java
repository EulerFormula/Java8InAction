package algorithm.tree.binarytree;

import algorithm.queue.CirQueue;
import algorithm.stack.SeqStack;
import lambdasinaction.chap5.Finding;

import javax.swing.*;
import java.util.Scanner;

/**
 * 二叉树
 * 二叉树可以采用顺序存储或者链式存储
 * 顺序存储只适合完全二叉树
 * 通常采用链式存储
 */
public class BinTree {

    private int h;


    public BinTree() {
        this.h = 0;
    }

    /**
     * 先序遍历
     *
     * @param binTNode
     */
    public static void preOrder(BinTNode binTNode) {
        if (binTNode != null) {
            System.out.println(binTNode.getData());
            preOrder(binTNode.getLchild());
            preOrder(binTNode.getRchild());
        }

    }

    /**
     * 中序遍历
     *
     * @param binTNode
     */
    public static void inOrder(BinTNode binTNode) {
        if (binTNode != null) {
            inOrder(binTNode.getLchild());
            System.out.println(binTNode.getData());
            inOrder(binTNode.getRchild());
        }
    }

    /**
     * 后序遍历
     *
     * @param binTNode
     */
    public static void postOrder(BinTNode binTNode) {
        if (binTNode != null) {
            postOrder(binTNode.getLchild());
            postOrder(binTNode.getRchild());
            System.out.println(binTNode.getData());

        }
    }

    /**
     * 利用栈非递归中序遍历
     *
     * @param binTNode
     */
    public static void inOrder1(BinTNode binTNode) {
        //初始化栈
        SeqStack<BinTNode> st = new SeqStack<>();
        st.init();
        st.push(binTNode);
        BinTNode p = null;
        while (!st.isEmpty()) {

            //直到左子树为空为止
            while (st.getTop() != null) {
                st.push(st.getTop().getLchild());
            }

            //null退栈
            p = st.pop();

            if (!st.isEmpty()) {
                System.out.printf("%3c", st.getTop().getData());
                p = st.pop();
                //右子树进栈
                st.push(p.getRchild());
            }
        }

    }

    /**
     * 利用栈非递归前序遍历
     */
    public static void preOrer1(BinTNode binTNode) {
        SeqStack<BinTNode> seqStack = new SeqStack<>();
        seqStack.init();
        seqStack.push(binTNode);
        while (!seqStack.isEmpty()) {
            binTNode = seqStack.pop();
            if (binTNode != null) {
                System.out.printf("%3c", binTNode.getData());

                //右子树进栈
                seqStack.push(binTNode.getRchild());
                //左子树进栈
                seqStack.push(binTNode.getLchild());
            }
        }
    }

    /**
     * 非递归的按层遍历二叉链表树
     * 采用一队列Q，若树不空，先将二叉树根节点输出，并将根节点入队，
     * 然后出队。若根节点有左子树，则将左子树的根节点输出并将其指针入队
     * 若其有右子树，则将其右子树的根节点输出并将其入队，再出队，如此下去，
     * 直到队列为空为止
     */
    public static void transLevel(BinTNode binTNode) {
        CirQueue<BinTNode> cirQueue = new CirQueue<>();
        cirQueue.init();

        if (binTNode == null) {
            return;
        } else {
            System.out.printf("%3c", binTNode.getData());
            cirQueue.enQueue(binTNode);
            while (!cirQueue.isEmpty()) {
                binTNode = cirQueue.deQueue();
                if (binTNode.getLchild() != null) {
                    System.out.printf("%3c", binTNode.getLchild().getData());
                    cirQueue.enQueue(binTNode.getLchild());
                }

                if (binTNode.getRchild() != null) {
                    System.out.printf("%3c", binTNode.getRchild().getData());
                    cirQueue.enQueue(binTNode.getRchild());
                }
            }
        }

    }

    /**
     * 按广义表表示二叉树结构生成二叉链表的算法
     *
     * @param str
     * @return
     */
    public static BinTNode createTree(String str) {

        //用指针数组模拟栈
        BinTNode[] st = new BinTNode[100];

        BinTNode p = null;
        int top;
        int k = 0;
        top = -1;
        BinTNode b = null;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    top++;
                    st[top] = p;
                    k = 1;
                    break;
                case ')':
                    top--;
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    p = new BinTNode();
                    p.setData(ch);
                    p.setLchild(null);
                    p.setRchild(null);
                    if (b == null) {
                        b = p;
                    } else {
                        switch (k) {
                            case 1:
                                st[top].setLchild(p);
                                break;
                            case 2:
                                st[top].setRchild(p);
                                break;
                        }
                    }
            }
        }

        return b;
    }

    /**
     * 按完全二叉树的层次顺序依次输入结点信息建立二叉链表的算法
     * 首先对一般的二叉树添加若干个虚节点，使其成为完全二叉树，然后
     * 依次输入结点信息，若输入的结点不是虚结点"@",则建立一个新结点，
     * 若是第一个结点，则令其为根节点，否则将新结点作为左孩子或右孩子
     * 链接它的双亲结点上
     */
    public static BinTNode createBinTree() {
        //置空二叉树
        BinTNode bt = null;
        //定义队列
        BinTNode[] queue = new BinTNode[100];
        BinTNode s = null;
        int front = 1;
        int rear = 0;
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        //假设结点值为单字符，#为终止符
        while (ch != '#') {
            s = null;
            if (ch != '@') {
                //申请新结点
                s = new BinTNode();
                s.setData(ch);
                s.setLchild(null);
                s.setRchild(null);
            }
            //队尾指针自增
            rear++;
            queue[rear] = s;
            //若rear为1，则说明是根节点，用bt指向它
            if (rear == 1) {
                bt = s;
            } else {
                if (s != null && queue[front] != null) {

                    //rear为偶数，新结点应作为左孩子
                    if (rear % 2 == 0) {
                        queue[front].setLchild(s);
                    } else {
                        queue[front].setRchild(s);
                    }
                }

                //rear为奇数,front指向下一个双亲
                if (rear % 2 != 0) {
                    front++;
                }
            }

            ch = scanner.next().charAt(0);

        }

        return bt;

    }

    /**
     * 求二叉树的深度
     * 若一个二叉树为空，则它的深度为0，否则它的深度等于其左右子树中的最大深度加1。
     *
     * @param binTNode
     * @return
     */
    public static int binTreeDepth(BinTNode binTNode) {
        int depl;
        int depr;
        if (binTNode == null) {
            return 0;
        } else {
            depl = binTreeDepth(binTNode.getLchild());
            depr = binTreeDepth(binTNode.getRchild());

            if (depl > depr) {
                return depl + 1;
            } else {
                return depr + 1;
            }
        }
    }

    /**
     * 按值查找
     */
    public static boolean findBT(BinTNode binTNode, char x) {
        if (binTNode != null) {
            if (binTNode.getData() == x) {
                return true;
            } else {

                return findBT(binTNode.getLchild(), x) || findBT(binTNode.getRchild(), x);
            }
        }
        return false;
    }

    /**
     * 求结点的层次
     */
    public int level(BinTNode binTNode, char x, int initH) {
        if (binTNode == null) {
            h = 0;
        } else if (binTNode.getData() == x) {
            h = initH;
        } else {
            level(binTNode.getLchild(), x, initH + 1);
            if (h == 0) {
                level(binTNode.getRchild(), x, initH + 1);
            }
        }

        return h;
    }

    public static void main(String[] args) {
        BinTNode binTNode = BinTree.createTree("(A(B,C))");
        //BinTNode binTNode = BinTree.createBinTree();

        //BinTree.inOrder(binTNode);
        //BinTree.inOrder1(binTNode);
        BinTree.transLevel(binTNode);


        System.out.println();
        System.out.println("树的深度" + BinTree.binTreeDepth(binTNode));

        System.out.println("查找x的结果：" + BinTree.findBT(binTNode, 'C'));

        BinTree binTree = new BinTree();

        System.out.println("x所在的深度是：" + binTree.level(binTNode,'A',1));
    }
}
