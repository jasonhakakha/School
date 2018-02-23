public static boolean delete(E x){

if(index == -1) 
return false;

data[index] = data[--size];

while (hasLeftChild(index)) {

int smallerIndex = leftChildIndex(index);

if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0)

smallerIndex = rightChildIndex(index);

if (data[index].compareTo(data[smallerIndex]) < 0) break;

E tmp = data[index];

data[index] = data[smallerIndex];

data[smallerIndex] = tmp;

index = smallerIndex;

}

return true;
