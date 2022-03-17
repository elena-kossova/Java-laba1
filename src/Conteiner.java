/**The class allows you to work with data in the form of a linked list
 @param <L> - type of the value stored in the list
 */

public class Conteiner <L> {
    /** Pointer to the beginning of the list */
    private ListElem head;
    /** Pointer to the end of the list */
    private ListElem tail;
    /** List dimension*/
    private int count;

    /** Class of the list item
     * */
    public class ListElem<L> {
        /** Element */
        private L elem;
        /** Link to the next element */
        private ListElem next;
        /** Structure of a single list item
         * @param data value in the data field
         * */
        ListElem (L data){
            elem = data;
            next = null;
        }
    }

    /** Default Constructor*/
    public Conteiner() {
        head = null;
        count = 0;
    }

    /** Checking the list for emptiness
     * @return 1 if the list is empty, otherwise it will return 0 */
    int isEmpty(){
        if(head == null) return 1;
        else return 0;
    }

    /** Adding an element
     * @param newElem new element to be added
     * */
    void add(L newElem){
        ListElem p = new ListElem(newElem);
        if (isEmpty() == 1) {
            head = p;
        }
        else {
            tail.next = p;
        }
        tail = p;
        count++;
    }

    /** General deletion of an element by index with a check for the possibility of deletion
     * @param index the index where the element to be deleted is located
     * @return true if it succeeded to delete, otherwise - false
     * */
    boolean delete(int index) {
        if (index < 0 || index >= count || count == 0) {
                return false;
        }
        if (index == 0){
            deleteFromHead();
            return true;
        }
        else {
            delByIndex(index);
            return true;
        }
    }

    /** Deleting an item from the beginning of the list */
    void deleteFromHead(){
        ListElem p = head;
        if(tail == head){
            tail = null;
        }
        head = head.next;
        p = null;
        count--;
    }
    /** Deletion by index
     * @param index index of the item being deleted
     * */
    void delByIndex(int index){
        ListElem p = head;
        int i = 0;
        while(i != index-1 && i < count){
            p = p.next;
            i++;
        }
        if (p == null){
            throw new RuntimeException("Удаление невозможно! Вышли за пределы списка");
        }
        ListElem delElem = p.next;
        p.next = delElem.next;
        delElem.next = null;
        count--;
    }

    /** List dimension
     * @return list size
     * * */
    int sizeOfList(){
        return count;
    }

    /** Printing the list
     * @return a string containing all the list items
     * */
    public String toString(){
        String list = "";
        ListElem p = head;
        while(p != null){
            list += p.elem + " ";
            p = p.next;
        }
        return list;
    }
}
