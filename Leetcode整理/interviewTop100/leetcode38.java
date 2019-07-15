package interviewTop100;


public class leetcode38
{
/*
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：（报数报数，用嘴读出来就容易理解了。读法： （这个数字的个数）个 （这个数字）。 111221 读作 三个1两个2一个1 312211）
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。

示例 1:
输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 */

	public String countAndSay(int n) {
		return core("1",n);   
	}

	private String core(String string, int n)
	{
		if(n==1)
			return string;
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i<string.length()) {
			int count = 1;
			//如果一直是同一个数
			while(i<string.length()-1 && string.charAt(i)==string.charAt(i+1)){
				count++;
				i++;
			}
			//下一个数更新
			sb.append(Integer.toString(count)+string.charAt(i));
			i++;
		}
		string = sb.toString();
		return core(string, n-1);
	}
}
