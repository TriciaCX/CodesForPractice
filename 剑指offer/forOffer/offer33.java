package forOffer;

public class offer33 {
    /**
     * 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null ||sequence.length==0)
            return false;
        return vertify(sequence,0,sequence.length-1);
    }

    private boolean vertify(int[] sequence, int start, int end) {
        if(end-start<=1) return true;
        int rootVal = sequence[end];
        int cutIdx = start;
        while(cutIdx<end && sequence[cutIdx]<rootVal){
            cutIdx++;
        }
        for(int i=cutIdx;i<end;i++){
            if(sequence[i]<rootVal)
                return false;
        }
        return vertify(sequence,start,cutIdx-1) && vertify(sequence,cutIdx,end-1);
    }

}
