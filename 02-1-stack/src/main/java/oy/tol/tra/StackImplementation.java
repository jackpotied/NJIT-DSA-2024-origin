package oy.tol.tra;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 *
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.
 * - StackImplementation(int size), which allocates an array of Object's with size.
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int currentIndex;
   private static final int DEFAULT_STACK_SIZE = 10;

   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException {
      this (DEFAULT_STACK_SIZE);
   }

   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      if(capacity<2){
         throw new StackAllocationException("");
      }
      this.capacity=capacity;
      this.currentIndex=-1;
      itemArray=new Object[this.capacity];
   }

   @Override
   public int capacity() {
      // TODO: Implement this
      return this.capacity;
   }
   public int reallocation(int capacity){
      if(capacity<this.capacity){
         return -1;
      }
      Object [] newarray=new Object[capacity];
      System.arraycopy(itemArray,0,newarray,0,currentIndex+1);
      itemArray=newarray;
      this.capacity=capacity;
      return 0;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      // TODO: Implement this
      if(element==null){
         throw new NullPointerException("首先，你得传个东西");
      }
      if(currentIndex == itemArray.length - 1){

         if( reallocation(this.capacity+DEFAULT_STACK_SIZE)==-1) {
            throw new StackAllocationException("物理学不存在了");
         };
      }
      itemArray[++currentIndex]=element;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("");
      }
      Object popped=itemArray[currentIndex];
      itemArray[currentIndex--]=null;
      return (E)popped;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("");
      }
      Object peeked=itemArray[currentIndex];

      return (E)peeked;
   }

   @Override
   public int size() {
      // TODO: Implement this
      return this.currentIndex+1;
   }

   @Override
   public void clear() {

         for (int s = 0; s <= currentIndex; s++) {
            itemArray[s] = null;
      }
         currentIndex=-1;
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
      if(this.currentIndex==-1){
         return true;
      }
      else {
         return false;
      }
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
