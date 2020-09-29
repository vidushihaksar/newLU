
public class client {
    
    public static void main(String[] args) throws Exception{

        // Stack st = new Stack();
        // for(int i=1; i<= 10;i++){
        //     st.push(i*10);
        // }
        // System.out.println(st);
        // st.pop();
        // System.out.println(st);
        // System.out.println(st.size());

        dynamicStack dst = new dynamicStack();
        for(int i=1; i<= 10;i++){
                dst.push(i*10);
        }
        dst.push(120);
        dst.push(140);
        System.out.println(dst.size());
        System.out.println(dst);


    } 
     
}