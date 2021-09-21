/*
javac -g 看到debug信息 包括变量名
javap -c
javap -verbose
*/
public class Hello {

    private int count =0;


    public int plus(int a ,int b){
        return a+b;
    }

    public int sub(int a ,int b){
        return a-b;
    }

    public int mul(int a ,int b){
        return a*b;
    }

    public int division(int a ,int b){
        return a/b;
    }

    public int forLoop(){
        int[] numbers = {1,2,3};
        for(int number : numbers){
            if(number>0){
                count+=number;
            }
        }

        return this.count;
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        int result = hello.forLoop();
    }
}
