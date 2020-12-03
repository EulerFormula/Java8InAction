package algorithm.search;

import algorithm.tree.binarytree.BinTNode;
import algorithm.tree.binarytree.BinThrNode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 二叉查找树
 */
public class BSTree {

    /**
     * 插入
     *
     * @param t
     * @param node
     * @return
     */
    public static BinThrNode<Integer> insertBST(BinThrNode<Integer> t, BinThrNode<Integer> node) {
        BinThrNode<Integer> f = t;
        BinThrNode<Integer> p = t;
        //找插入位置
        while (p != null) {
            //f指向p的双亲
            f = p;
            if (node.getData() < p.getData()) {
                p = p.getLchild();
            } else {
                p = p.getRchild();
            }
        }

        //若T为空，新结点做为根节点
        if (t == null) {
            t = node;
        } else if (node.getData() < f.getData()) {
            f.setLchild(node);
        } else {
            f.setRchild(node);
        }

        return t;

    }

    /**
     * 生成
     *
     * @return
     */
    public static BinThrNode<Integer> createBST() {
        BinThrNode<Integer> t = null;
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();

        while (key != 0) {
            BinThrNode<Integer> node = new BinThrNode<>();
            node.setData(key);
            node.setLchild(null);
            node.setRchild(null);

            t = insertBST(t, node);
            key = scanner.nextInt();
        }
        return t;
    }

    /**
     * 查找
     *
     * @param t
     * @param x
     * @return
     */
    public static BinThrNode<Integer> searchBST(BinThrNode<Integer> t, Integer x) {
        if (t == null || t.getData().equals(x)) {
            return t;
        }
        if (x < t.getData()) {
            return searchBST(t.getLchild(), x);
        } else {
            return searchBST(t.getRchild(), x);
        }
    }

    /**
     * 删除
     * 1.若p是叶子结点:直接删除
     * 2.若p只有一颗子树，直接用p的子树取代p
     * 3.若p既有左子树又有右子树，用p的直接前驱结点代替p，即从p的左子树中选择值最大的结点s放在p的位置,
     * s是p的左子树中最右边的结点且没有右子树。
     *
     * @param t
     * @param t
     */
    public static void del(BinThrNode<Integer> t, Integer x) {
        //TODO

    }

    public static void inOrder(BinThrNode<Integer> t) {
        if (t != null) {
            inOrder(t.getLchild());
            System.out.printf("%3d", t.getData());
            inOrder(t.getRchild());
        }
    }


    public static void main(String[] args) {

        BinThrNode<Integer> t = createBST();

        System.out.println("=====二叉树中序遍历=====");
        inOrder(t);

        System.out.println();
        BinThrNode<Integer> node = searchBST(t, 1);
        System.out.println(node != null ? "找到了" : "未找到");
    }
}
