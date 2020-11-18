package algorithm.generalizedlist;

/**
 * 0表示原子，1表示子表
 */
public enum NodeTag {
    ATOM(0),LIST(1);

    private int v;

    NodeTag(int v) {
        this.v = v;
    }
}
