class KStackClass
{
    int freeTop;
    int arr[];
    int top[];
    int next[];
    int KSize;
    int capacity;
    KStackClass(int KSize, int n)
    {
        this.KSize = KSize;
        this.capacity = n;
        arr = new int[capacity];
        top = new int[KSize];
        next = new int[capacity];
        topFill();
        nextFill();
        freeTop = 0;
    }
    void topFill()
    {
        for (int i = 0; i < KSize; i++) {
            top[i] = -1;
        }
    }
    void nextFill()
    {
        for (int i = 0; i < capacity-1; i++) {
            next[i] = i+1;
        }
        next[capacity-1] = -1;
    }
    void push(int element, int stackNumber)
    {
        int index = freeTop;
        freeTop = next[index];
        next[index] = top[stackNumber];
        top[stackNumber] = index;
        arr[index] = element;
    }
    int pop(int stackNumber)
    {
        int index = top[stackNumber];
        top[stackNumber] = next[index];
        next[index] = freeTop;
        freeTop = index;
        return arr[index];
    }
}
public class MaintainNStack {
    public static void main(String[] args) {
        KStackClass kStack = new KStackClass(3, 10);
        kStack.push(10,0);
        kStack.push(20,0);
        kStack.push(30,0);
        kStack.push(100,1);
        kStack.push(200,1);
        kStack.push(300, 1);
        kStack.push(1000, 2);
        kStack.push(2000, 2);
        kStack.push(3000, 2);
        System.out.println(kStack.pop(0));
        System.out.println(kStack.pop(1));
        System.out.println(kStack.pop(2));
    }
}
