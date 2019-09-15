package suanfa;

//快速傅里叶变换进行高精度乘法
// https://blog.csdn.net/ljhandlwt/article/details/51999762
// https://www.cnblogs.com/RabbitHu/p/FFT.html
public class FFTMutiply {


    //复数类 complex number
    public class CM {
        // 实数部分 real quantity
        Double re;
        // 虚数部分 imaginary quantity
        Double im;

        CM(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public CM add(CM b) {
            return new CM(re + b.re, im + b.im);
        }

        public CM minus(CM b) {
            return new CM(re - b.re, im - b.im);
        }

        public CM multiply(CM b) {
            return new CM(re * b.re - im * b.im, im * b.re + re * b.im);
        }
    }

    //雷德算法，用来实现倒位序  http://blog.sina.com.cn/s/blog_154d272c90102x98p.html
    public CM[] rader(CM[] a, int len) {
        int j = len / 2;
        for (int i = 1; i < len - 1; i++) {
            if (i < j) {
                CM t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
            int k = len / 2;
            while (j >= k) {
                j = j - k;
                k = k / 2;
            }
            j += k;
        }
        return a;
    }

    public CM[] FFT(CM[] a, int len, int flag) {
        a = rader(a, len);
        //分治算法，从最小的开始算
        for (int curLen = 2; curLen <= len; curLen *= 2) {
            // 初始化单位复根
            CM wn = new CM(Math.cos(2 * Math.PI / curLen), Math.sin(flag * 2 * Math.PI / curLen));
            for (int i = 0; i < len; i += curLen) {
                CM w = new CM(1, 0);
                for (int j = i; j < i + curLen / 2; j++) {
                    CM u = a[j];
                    CM t = w.multiply(a[j + curLen / 2]);
                    a[j] = u.add(t);
                    a[j + curLen / 2] = u.minus(t);
                    w = w.multiply(wn);
                }
            }
        }
        if (flag == -1) {
            for (int i = 0; i < len; i++) {
                a[i].re /= len;
            }
        }
        return a;
    }

    public String multiply(String num1, String num2) {
        //FFT要求n为2的次幂以方便分治,而结果最大的长度为原长度两倍
        int n = Math.max(num1.length() * 2, num2.length() * 2);
        int p = 1;
        while (n > p) {
            p = p * 2;
        }
        n = p;

        CM[] n1 = new CM[n];
        CM[] n2 = new CM[n];
        for (int i = 0; i < n; i++) {
            if (num1.length() - i - 1 >= 0) {
                n1[i] = new CM(num1.charAt(num1.length() - i - 1) - '0', 0);
            } else {
                n1[i] = new CM(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (num2.length() - i - 1 >= 0) {
                n2[i] = new CM(num2.charAt(num2.length() - i - 1) - '0', 0);
            } else {
                n2[i] = new CM(0, 0);
            }
        }
        n1 = FFT(n1, n, 1);
        n2 = FFT(n2, n, 1);
        CM[] result = new CM[n];
        for (int i = 0; i < n; i++) {
            result[i] = n1[i].multiply(n2[i]);

        }
        result = FFT(result, n, -1);
        int[] ans = new int[n];
        //结果四舍五入
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (result[i].re + 0.5);
        }
        //进位
        for (int i = 0; i < n - 1; i++) {
            ans[i + 1] += (ans[i] / 10);
            ans[i] = ans[i] % 10;
        }
        //去掉前导0
        int realLen = n;
        while ((realLen>1) && (ans[realLen - 1] == 0)) {
            realLen--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = realLen - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
