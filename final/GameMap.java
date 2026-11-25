import java.util.Stack;

public class GameMap{
    Room currentRoom;
    Stack<Room> previousRoom = new Stack<>();
    Room[] roomList = new Room[81];


    public GameMap(){
        for (int i = 0; i < 81 ; i++){
            roomList[i] = new Room();
        }
        for (int i = 0; i < 81 ; i++){
            if (i != 40){
                if (i - 9 >= 0){
                roomList[i].forward = roomList[i-9];
                }
                if (i + 9 < 81){
                    roomList[i].backward = roomList[i+9];
                }
                if (!(i % 9 == 0)){
                    roomList[i].left = roomList[i-1];
                }
                if (!(i % 9 == 8)){
                    roomList[i].right = roomList[i+1];
                }
                roomList[i].assignDesc();
            }
            else{
                this.currentRoom = roomList[i];
                roomList[i].assignSpawn();
            }
        }
        // assign 8 pages
    }

    public void forward(){
        previousRoom.push(currentRoom);
        currentRoom = currentRoom.forward;
    }
    
    public void backward(){
        previousRoom.push(currentRoom);
        currentRoom = currentRoom.backward;
    }
    
    public void left(){
        previousRoom.push(currentRoom);
        currentRoom = currentRoom.left;
    }

    public void right(){
        previousRoom.push(currentRoom);
        currentRoom = currentRoom.right;
    }

    public void previous(){
        currentRoom = previousRoom.peek();
    }

    public String roomDesc(){
        // add conditional that returns a page if desc = "page"
        return currentRoom.desc;
    }
}
