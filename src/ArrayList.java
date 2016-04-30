public class ArrayList<T>
{
    public static final int DEFAULT_SIZE = 10;

    private T[] array;
    private int size;

    public ArrayList()
    {
        array = (T[]) (new Object[DEFAULT_SIZE]);
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public T get(int i)
    {
        return array[i];
    }

    public void add(T element)
    {
        if (size == array.length)
            expandCapacity();

        array[size] = element;
        size++;
    }

    public boolean contains(T element)
    {
        int i;
        for(i = 0; array[i] != element && i < size; i++)
            ;
        return i < size;
    }

    private void expandCapacity()
    {
        T[] newArray = (T[]) (new Object[array.length * 2]);

        for (int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public String toString()
    {
        String result = "";

        int i;
        for (i = 0; i < size - 1; i++)
            result += array[i] + "\n";

        if (size > 0)
            result += array[i];

        return result;
    }
}
