
public class dynamicStack extends Stack {
    
    public dynamicStack(){
        super();
    }
    
    public dynamicStack(int size){
        super(size);
    }


    @Override
    public void push(int val){
        if (super.size() == super.capacity()) {
            int[] temp = new int[super.size()];
            int  i = super.size()-1;
            while(super.size() != 0){
                temp[i--] = super.pop_();
            }
           
            super.setValues(2*temp.length);
            for(int ele : temp){
                super.push_(ele);
            }

        }
        super.push_(val);
    }
}