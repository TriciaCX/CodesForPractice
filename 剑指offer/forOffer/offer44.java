package forOffer;

public class offer44 {
    /**
     * 数字序列种的某一位数字
     * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
     */
    public int getDigitAtIndex(int index){
        if(index<0)
            return -1;
        int place=1; //1表示个位，2表示十位
        while(true){
            int amount = getAmountOfPlace(place);
            int totalAmount = amount*place;
            if(index<totalAmount)
                return getDigitAtIndex(index,place);
            index -= totalAmount;
            place++;
        }
    }

    /**
     * place位数的数字组成的字符串长度
     * 10,90,900,...
     * 1位的数有10个，0-9
     * 2位的数有90个，10-99
     */
    private int getAmountOfPlace(int place) {
        if(place==1)
            return 10;
        return (int)Math.pow(10,place-1)*9;
    }

    /**
     * place位数起的数字
     * 0,10,100,...
     */
    private int getBeginNumberOfPlace(int place){
        if(place==1)
            return 0;
        return (int)Math.pow(10,place-1);
    }

    /**
     * 在place位数组成的字符串中，第index个数
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index/place;
        String number = (beginNumber+shiftNumber) +"";
        int count = index%place;
        return number.charAt(count)-'0';
    }

}
