package Stack;


public class Dqueue extends Queue {
    
    public Dqueue(){
        super();
    }

    public Dqueue(int size){
        super(size);
    }

    @Override
    public void push(int val){
        if(super.size() == super.capacity()){
            int[]temp = new int[this.size()];

            int i=0;
            while(i < super.size()){
                temp[i++] = super.remove_();

            }
            super.setValues(2*temp.length);
            for(int ele:temp){
                super.push_(ele);
            }


        }

        super.push_(val);
    }
}