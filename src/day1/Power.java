package day1;

public class Power {
    public double power(int base, int exponent){
        boolean flag = true; //设置一个标志位 用来判断正负
        if(exponent < 0){
            flag = false;
            exponent = -1 * exponent;
        }
        double res = 1;
        while(exponent != 0){
            if((exponent & 1) != 0){
                res = res*base;
            }
            exponent = exponent >> 1;
            base = base*base;
        }
        if(flag)
            return res;
        else
            return 1/res;
    }
}
