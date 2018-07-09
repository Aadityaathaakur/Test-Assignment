package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{

	@SuppressWarnings("unused")
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	int count = 0;
	
	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		int flag = -1;
		for(int i=0; i<numArray.length; i++) {
			if(numArray[i] == searchingNum)
				flag = i; 
		}

		return flag;
	}

	public boolean add(int numberToAdd) {
		
		int check;
		boolean flag = false;
		check = search(numberToAdd);
		if(check==-1){
			if(count == numArray.length) {
				doubleCapacity(numArray.length);
			}
			numArray[count] = numberToAdd;
			count++;
			flag=true;
			
		}
		
		for(int i=0; i<numArray.length; i++)
			System.out.print(numArray[i] +" ");
		System.out.println("-----------------------------");
		
		return flag;
	
	}

	public void doubleCapacity(int current_capacity) {
		// TODO Auto-generated method stub
		int[] numArrayPrev = new int[current_capacity];
		for(int i=0; i<numArray.length; i++){
		numArrayPrev[i] = numArray[i];
		}
		numArray = new int[current_capacity*2];
		for(int i=0; i<current_capacity; i++) {
			numArray[i] = numArrayPrev[i]; 
		}
		for(int i=0; i<numArray.length; i++)
		System.out.println(numArray[i]);
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		int flag = search(numberToRemove);
		if(flag==-1)
		return false;
		else
			for(int i=flag-1;i<numArray.length;i++) {
				numArray[i] = numArray[i+1];
			}
		    numArray[numArray.length-1] = 0;
			return true;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		int[] check = new int[n];
		for(int i=0; i<n; i++) {
			check[i] = numArray[i];
		}
		for(int i = numArray.length-1; i>=0; i--){
			
		}
		
		return null;
	}
	
	public String toString() {
		int flag;
		String ret ="{";
		StringBuffer str = new StringBuffer(ret) ;
		flag = getCount();
		if(flag==0)
			return (new String("{}"));
		else {
			for(int i=0; i<count; i++) {
				str.append(numArray[i]);
				if(i!=count-1) {
				str.append(",");}
			}
		str.append("}");
		return new String(str);
		}
		
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		
	}
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	