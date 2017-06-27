package com.paranora;

/**
 * Created by yangqun on 2017/06/26.
 */
public class NumCounter {

    private int num;
    private int sum;
    // 是否当前是个完整的数字
    private boolean isWholeNum;

    public NumCounter(int num, int sum, boolean isWholeNum) {
        this.num = num;
        this.sum = sum;
        this.isWholeNum = isWholeNum;
    }

    public NumCounter accumulate(Character c){
        NumCounter numCounter=null;
        if (Character.isDigit(c)){
            if(isWholeNum){
                numCounter=new NumCounter(Integer.parseInt("" + c), sum + num, false);
            } else {
                numCounter=new NumCounter(Integer.parseInt("" + num + c), sum, false);
            }
        }else {
            numCounter= new NumCounter(0, sum + num, true);
        }
        return numCounter;
    }

    public NumCounter combine(NumCounter numCounter){
        return new NumCounter(numCounter.num, this.getSum() + numCounter.getSum(), numCounter.isWholeNum);
    }

    public int getSum() {
        return sum + num;
    }
}