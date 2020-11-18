package algorithm.generalizedlist;

import java.util.Scanner;


public class GList {


    /**
     * 建立广义表
     */
    public static GLNode createGList(GLNode glNode) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        if (ch != ' ') {
            glNode = new GLNode();
            if (ch == '(') {
                glNode.setTag(NodeTag.LIST);
                //递归调用构造子表
                glNode.setSlink(createGList(glNode.getSlink()));
            } else {
                //构造原子结点
                glNode.setTag(NodeTag.ATOM);
                glNode.setData(ch);
            }
        } else {
            glNode = null;
        }
        ch = scanner.next().charAt(0);
        if (glNode != null) {
            if (ch == ',') {
                //递归构造后续广义表
                glNode.setNext(createGList(glNode.getNext()));
            } else {
                //表示遇到'）'或者结束符'；'时，无后续表
                glNode.setNext(null);
            }
        }
        return glNode;
    }

    /**
     * 输出广义表
     */
    public static void printGList(GLNode glNode) {
        if (glNode != null) {
            if (glNode.getTag() == NodeTag.LIST) {
                System.out.print("(");
                if (glNode.getSlink() == null) {
                    System.out.print(" ");
                } else {
                    //递归调用输出子表
                    printGList(glNode.getSlink());
                }
            } else {
                //输出结点数据域值
                System.out.printf("%c", glNode.getData());
            }

            if (glNode.getTag() == NodeTag.LIST) {
                System.out.print(")");
            }

            if (glNode.getNext() != null) {
                System.out.print(",");
                //递归调用输出下一个结点
                printGList(glNode.getNext());
            }
        }
    }

    /**
     * 广义表的查找
     * 设f(p,x)为查找函数，当查找成功时返回true,否则返回false,则有如下递归模型：
     * 若 p.tag==0 且 p.data==x 则 f(p,x)=true
     * 若 p.tag==0 且 p.data!=x 则 f(p,x)=f(p.next,x)
     * 若 p.tag==1 则 f(p,x)=f(p.slink,x) or f(p.next,x)
     *
     * @param glNode
     * @param x
     */
    public static boolean findGListX(GLNode glNode, char x) {
        if (glNode != null) {
            if (glNode.getTag() == NodeTag.ATOM && glNode.getData() == x) {
                return true;
            } else {
                if (glNode.getTag() == NodeTag.LIST) {
                    return findGListX(glNode.getSlink(), x);
                }
                return findGListX(glNode.getNext(), x);
            }
        }
        return false;
    }

    /**
     * 求广义表头结点
     *
     * @param glNode
     * @return
     */
    public static GLNode head(GLNode glNode) {
        GLNode p;
        if (glNode != null && glNode.getTag() != NodeTag.ATOM) {
            p = glNode.getSlink();
            //p.setNext(null);
            return p;
        } else {
            return null;
        }
    }

    public static GLNode tail(GLNode glNode) {

        GLNode p = null;

        if (glNode != null && glNode.getTag() != NodeTag.ATOM) {
            p = glNode.getSlink();
            p = p.getNext();

            glNode.setSlink(p);
        }

        return p;
    }


    /**
     * 求广义表深度
     * 扫描广义表的第一层的每个结点，对每个结点递归调用计算出其子表的深度，
     * 取最大的子表深度，然后加1即为广义表的最大深度
     * @param glNode
     * @return
     */
    public static int depth(GLNode glNode) {
        if (glNode.getTag() == NodeTag.ATOM) {
            return 0;
        } else {
            if (glNode.getTag() == NodeTag.LIST && glNode.getSlink() == null) {
                return 1;
            } else {
                glNode = glNode.getSlink();
                int max = 0;

                do {
                    int h = depth(glNode);
                    if (h > max) {
                        max = h;
                    }
                    glNode = glNode.getNext();
                } while (glNode != null);

                return max+1;
            }
        }
    }

    public static void main(String[] args) {
        GLNode glNode = null;
        glNode = GList.createGList(glNode);
        GList.printGList(glNode);

        System.out.println();
        System.out.println("查找结果：" + (GList.findGListX(glNode, 'a') ? "成功" : "失败"));


        System.out.println("头结点是：" + GList.head(glNode).getData());

        System.out.println("尾结点是：");
        GList.printGList(GList.tail(glNode));

        System.out.println();
        System.out.println("最大深度是:"+GList.depth(glNode));

    }
}
