import java.util.Random;

/**
 * Created by Administrator on 2017/6/7.
 */
public class Resume {
    public static int question1(int n){
        int step = 0;
        while(n!=1){
            if(n%2==0){
                n = n/2;
            }else {
                n = (3*n+1)/2;
            }
            step++;
        }
        return step;
    }

    public static String question2(int n){
        if(n>999||n<0){
            return "不合法参数";
        }
        String B_mark = "";
        String S_mark = "";
        String num_mark = "";
        while(n>0){
            if(n/100>=1){
                for(int i=0;i<n/100;i++){
                    B_mark += "B";
                }
                n = n%100;
            }else if(n/10>=1){
                for(int i=0;i<n/10;i++){
                    S_mark += "S";
                }
                n = n%10;
            }else {
                for(int i=1;i<=n;i++){
                    S_mark += i;
                }
                n = 0;
            }
        }
        return B_mark + S_mark + num_mark;
    }

    public static int question3(int[] input,int sum){
        int count = 0;
        for(int i=0;i<input.length;i++){
            for(int j=0;j<i;j++){
                if(input[i]+input[j]==sum){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(question1(3));
        //System.out.println(question2(234));
        //System.out.println(question3(new int[]{1,2,3,4,5},6));

        Source source = new Source(20);
        new Thread(new MyThread(source,"线程1")).start();
        new Thread(new MyThread(source,"线程2")).start();
        new Thread(new MyThread(source,"线程3")).start();

    }
}

class MyThread implements Runnable {

    private String name;
    private Source source;

    public MyThread() {

    }

    public MyThread(Source source,String name) {
        this.name = name;
        this.source = source;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean canAdd = source.addOne(name);
            if (!canAdd) {
                break;
            }
        }
    }
}



class Source {
    private int count = 0;
    private int max;

    public boolean addOne(String theadName) {
        synchronized (this) {
            if (count >= max) {
                return false;
            }
            count++;
            System.out.println(theadName + ":" + count);
            return true;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Source(){

    }

    public Source(int max){
        this.max = max;
    }
}
