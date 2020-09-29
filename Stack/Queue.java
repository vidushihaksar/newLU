package Stack;

public class Queue {
    private int[] st;
    private int head;
    private int tail;
    private int maxsize;
    private int size;
    

    public Queue(){
        setValues(10);
    }

    public Queue(int n){
        setValues(n);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for(int i= 0; i < this.size ; i++){
            sb.append(this.st[(this.head+i) % this.maxsize]);
            if(i != this.size-1) sb.append(" ,");
        }

        sb.append("]");
        return sb.toString();
    }

    protected void setValues(int n){
        this.st = new int[n];
        this.head = this.tail =  0;
        this.maxsize = n;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public int capacity(){
        return this.maxsize;
    }

    public int peek() throws Exception{
        if(this.size == 0){
            throw new Exception("Queue is empty");
        }

        return peek_();
    }

    protected int peek_(){
        return this.st[this.head];
    }

    public void push(int val) throws Exception{
        if(this.size() == this.capacity()){
            throw new Exception("Queue is full");
        }
        push_(val);
    }

    protected void push_(int val){
        this.st[this.tail] = val;
        this.tail= (this.tail+1) % this.maxsize;
        this.size++;

    }

    public int remove() throws Exception{
        if(this.size == 0){
            throw new Exception("Queue is empty");
        }

        return remove();
    }

    protected int remove_(){
        int ans = peek_();
        this.st[this.head] = 0;
        this.head = (this.head+1) % this.maxsize;
        this.size--;
        return ans;
    }
}