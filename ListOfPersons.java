package assignment1;

public class ListOfPersons {
    private Person[] list;
    private int size;

    public ListOfPersons(){
        this.list = new Person[10];
        this.size = 0;
    }

    public int getSize(){
        return(this.size);
    }

    public Person[] getList(){
        Person[] fullList = new Person[this.size];
        for (int i=0; i<this.size; i++){
            fullList[i] = this.list[i];
        }
        return(fullList);
    }

    public Person getPerson(int spot){
        if(spot >= this.size || spot < 0){
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        return(this.list[spot]);
    }

    public void addPerson(Person toAdd){
        if (toAdd != null) {
            if (list.length == size) {
                resize();
            }
            list[size] = toAdd;
            size += 1;
        }
    }

    private void resize(){
        Person[] large = new Person[list.length*2];
        for(int i=0; i<size; i++){
            large[i] = list[i];
        }
        list = large;
    }

    public int indexOf(Person find){
        if (find == null){
            return (-1);
        }
        for (int i=0; i<size; i++){
            if (find.equals(list[i])){
                return (i);
            }
        }
        return (-1);
    }

    public boolean removePerson(Person remove){
        int index = indexOf(remove);
        if (index == -1){
            return false;
        }
        for (int i=index; i<(size-1); i++){
            list[i] = list[i+1];
        }
        list[size-1] = null;
        size -= 1;
        return true;
    }

    public MilitaryPerson[] getArmy(){
        MilitaryPerson[] temp = new MilitaryPerson[size];
        int militaryPersonCount = 0;
        for (int i=0; i<size; i++){
            if (list[i] instanceof MilitaryPerson){
                temp[militaryPersonCount] = (MilitaryPerson) list[i];
                militaryPersonCount += 1;
            }
        }
        MilitaryPerson[] militaryList = new MilitaryPerson[militaryPersonCount];
        for (int a=0; a<militaryPersonCount; a++){
            militaryList[a] = temp[a];
        }
        return militaryList;
    }
}
