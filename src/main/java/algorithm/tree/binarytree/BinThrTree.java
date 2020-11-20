package algorithm.tree.binarytree;

import com.sun.source.tree.Tree;

/**
 * 二叉树的线索化
 */
public class BinThrTree {

    private BinThrNode<Character> pre;

    public BinThrTree() {
        this.pre = null;
    }

    /**
     * 按广义表表示二叉树结构生成二叉链表的算法
     *
     * @param str
     * @return
     */
    public static BinThrNode createTree(String str) {

        //用指针数组模拟栈
        BinThrNode[] st = new BinThrNode[100];

        BinThrNode p = null;
        int top;
        int k = 0;
        top = -1;
        BinThrNode b = null;
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
                    p = new BinThrNode();
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
     * 二叉链表中序线索化
     *
     * @param bt
     */
    public void inorderThread(BinThrNode bt) {
        if (bt != null) {
            inorderThread(bt.getLchild());

            if (bt.getLchild() == null) {
                bt.setLtag(1);
            } else {
                bt.setLtag(0);
            }

            if (bt.getRchild() == null) {
                bt.setRtag(1);
            } else {
                bt.setRtag(0);
            }

            if (pre != null) {
                if (pre.getRtag() == 1) {
                    //给前驱结点加后继线索
                    pre.setRchild(bt);
                }

                if (bt.getLtag() == 1) {
                    //给当前结点加前趋线索
                    bt.setLchild(pre);
                }
            }

            pre = bt;

            inorderThread(bt.getRchild());
        }
    }

    /**
     * 查找某结点的后继结点
     *
     * @param binThrNode
     * @return
     */
    public static BinThrNode<Character> inorderNext(BinThrNode<Character> binThrNode) {
        if (binThrNode.getRtag() == 1) {
            return binThrNode.getRchild();
        } else {
            binThrNode = binThrNode.getRchild();
            while (binThrNode.getLtag() == 0) {
                //沿左指针链向下查找
                binThrNode = binThrNode.getLchild();
            }
            return binThrNode;
        }
    }

    /**
     * 线索二叉树的中序遍历
     *
     * @param bt
     */
    public static void tinorderThrTree(BinThrNode<Character> bt) {
        BinThrNode<Character> p = null;
        if (bt != null) {
            p = bt;
            //使p指向根节点
            while (p.getLtag() == 0) {
                p = p.getLchild();
            }
            do {
                //输出访问节点
                System.out.printf("%3c", p.getData());
                //查找节点p的中序后继
                p = inorderNext(p);
            } while (p != null);
        }
    }

    public static void main(String[] args) {
        BinThrNode<Character> bt = BinThrTree.createTree("(A(B,C))");

        BinThrTree tree = new BinThrTree();
        tree.inorderThread(bt);
        System.out.println();

        System.out.println("查找根节点的后继结点为：" + BinThrTree.inorderNext(bt).getData());

        System.out.println("中序遍历");
        BinThrTree.tinorderThrTree(bt);
    }
}
