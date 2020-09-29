
public class Stack{
    
    private int[] st;
    private int tos;
    private int maxsize;
    

    public Stack(){
        setValues(10);
    }

    public Stack(int n){
        setValues(n);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for(int i= this.tos; i >= 0 ; i-- ){
            sb.append(this.st[i]);
            if(i != 0) sb.append(" ,");
        }

        sb.append("]");
        return sb.toString();
    }

    protected void setValues(int n){
        this.st = new int[n];
        this.tos = -1;
        this.maxsize = n;
    }

    public int size(){
        return this.tos+1;
    }

    public int capacity(){
        return this.maxsize;
    }

    public int top() throws Exception{
        if(this.tos == -1){
            throw new Exception("Stack is empty");
        }

        return top_();
    }

    protected int top_(){
        return this.st[this.tos];
    }

    public void push(int val) throws Exception{
        if(this.size() == this.capacity()){
            throw new Exception("Stack is full");
        }
        push_(val);
    }

    protected void push_(int val){
        this.st[++this.tos] = val;
    }

    public int pop() throws Exception{
        if(this.tos == -1){
            throw new Exception("Stack is empty");
        }

        return pop_();
    }

    protected int pop_(){
        int ans = top_();
        this.st[this.tos] = 0;
        this.tos--;
        return ans;
    }

}