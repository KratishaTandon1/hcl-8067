package Module1.Basic.MyPackage1;
import Module1.Basic.MyPackage.Main1;
public class Main {
     static void main(String[] args){
        int sum=0;
        for(int i=1;i<=10;i++){
            sum+=i;
        }
        System.out.println(sum);
         Main1.main();
    }
}
