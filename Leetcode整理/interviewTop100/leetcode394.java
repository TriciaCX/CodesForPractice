package interviewTop100;

import java.util.LinkedList;
import java.util.Stack;

public class leetcode394
{
/**
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

 */
	
	/**
	 * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
算法流程：

构建辅助栈stack, 遍历字符串s中每个字符c；
当c为数字时，将数字字符转化为数字multi，用于后续倍数计算；
当c为字母时，在res尾部添加c；
当c为[时，将当前multi和res入栈，并分别置空置 0：
记录此[前的临时结果res至栈，用于发现对应]后的拼接操作；
记录此[前的倍数multi至栈，用于发现对应]后，获取multi × [...]字符串。
进入到新[后，res和multi重新记录。
当c为]时，stack出栈，拼接字符串res = last_res + cur_multi * res:
last_res是上个[到当前[的字符，例如"3[a2[c]]"中的a；
cur_multi是当前[到]内字符的倍数，例如"3[a2[c]]"中的2。
返回字符串res。

复杂度分析：
时间复杂度 O(N)，一次遍历s；
空间复杂度 O(N)，辅助栈在极端情况下需要线性空间，例如2[2[2[a]]]。
	 */
	
	public static void main(String[] args){
		String string = "3[a2[b]]";
		System.out.println(decodeString(string));
	}
	
	public static String decodeString(String s) {
        if(s==null || s.length()<=1)
        	return s;
        StringBuilder sb = new StringBuilder();
        int mul = 0;
        Stack<Integer> mulStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(c=='[') {
        		mulStack.push(mul); //乘数压入乘数栈
        		charStack.push(sb.toString()); //前一部分的字符串也压栈
        		mul = 0;  //重置乘数
        		sb = new StringBuilder(); //重置字符
        	}
        	else if (c==']') {
        		StringBuilder tmp = new StringBuilder();
        		int curMul = mulStack.pop();
        		for(int j=0;j<curMul;j++) {
        			tmp.append(sb);
        		}
				sb = new StringBuilder(charStack.pop()+tmp);
			}
        	else if (c>='0' && c<='9') {
				mul = mul*10+(c-'0');  //数字不一定是个位数呀
			}
        	else {
        		sb.append(c);
        	}
        }
           
        return sb.toString();
	}	

}
