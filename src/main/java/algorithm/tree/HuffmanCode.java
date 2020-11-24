package algorithm.tree;

import java.util.Arrays;

/**
 * 哈夫曼编码
 */
public class HuffmanCode {

    private CodeNode[] codeNodes;

    public HuffmanCode() {

        codeNodes = new CodeNode[HuffmanTree.N+1];
        for(int i=0;i<codeNodes.length;i++){
            codeNodes[i] = new CodeNode();
        }
    }

    public CodeNode[] getCodeNodes() {
        return codeNodes;
    }

    public void setCodeNodes(CodeNode[] codeNodes) {
        this.codeNodes = codeNodes;
    }

    public static void huffmanEncoding(HuffmanTree tree, HuffmanCode code) {
        //临时存放编码串
        char[] cd = new char[HuffmanTree.N];
        //指示编码在cd中起始位置
        int start;
        //c指示孩子的位置
        int c;
        //p指示双亲的位置
        int p;
        HTNode[] htNodes = tree.getHtNodes();
        CodeNode[] codeNodes = code.getCodeNodes();
        for (int i = 1; i <= HuffmanTree.N; i++) {
            //初始位置
            start = HuffmanTree.N-1;
            //从叶子结点i开始上溯
            c = i;
            //直至上溯到htNodes[c]是树根为止
            while ((p = htNodes[c].getParent()) > 0) {
                cd[start--] = (htNodes[p].getLchild() == c) ? '0' : '1';
                c = p;
            }

            codeNodes[i].setBits(Arrays.copyOfRange(cd,start+1,HuffmanTree.N));
            //保存编码长度
            codeNodes[i].setLen(HuffmanTree.N-start-1);
        }
    }
}
