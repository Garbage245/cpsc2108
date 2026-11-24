public class GameMap{
    Room currentRoom;
    Room[] roomList = new Room[81];


    GameMap(){
        for (int i = 0; i < 81 ; i++){
            roomList[i] = new Room();
        }
        for (int i = 0; i < 81 ; i++){
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
        this.currentRoom = roomList[40];
    }

    public void forward(){
        currentRoom = currentRoom.forward;
    }
    
    public void backward(){
        currentRoom = currentRoom.backward;
    }
    
    public void left(){
        currentRoom = currentRoom.left;
    }

    public void right(){
        currentRoom = currentRoom.right;
    }

    public String roomDesc(){
        return currentRoom.desc;
    }
}
