public class Main {

    static java.util.Scanner scanner = new java.util.Scanner(System.in);

    static String input(String info){
        System.out.print(info+" : ");
        String data = scanner.nextLine();
        return data;

    }
    

    public static void main(String[] args){
        viewShowTodoList();

    }

    static String[] todolist = new String[1];
    
    static void showTodoList(){
        System.out.println("------------------------");
        System.out.println("        To Do List      ");
        System.out.println("------------------------");
        if (todolist.length != 0){
            for (int i = 0; i < todolist.length; i++){
                if(todolist[i] != null){
                    System.out.println(i+1+". "+todolist[i]);
                }
            }
            System.out.println("------------------------");
        }
    }

    static void testShowTodoList(){
        todolist[0]="test";
        showTodoList();
    }

    static void addTodo(String todo){
        boolean isFull = true;
        for (int i = 0; i < todolist.length; i++){
            if (todolist[i] == null){
                todolist[i] = todo;
                isFull = false;
            }
        }

        if(isFull){
            var temp = todolist;
            todolist = new String[temp.length+1];
            for (int i = 0; i < temp.length; i++){
                todolist[i] = temp[i];
            }
            todolist[temp.length] = todo;
        }
        
    }

    static void testAddTodo(){
       
       for (int i = 0; i < 5; i++){
        addTodo("Todo ke-"+(i+1));
        showTodoList();
       }
    }

    static String removeTodo(int number){
        if((number - 1) >= todolist.length){
            return "Nomor tidak ada di list";
        }else if((number - 1) == todolist.length-1){
            if (todolist[number-1] == null){
                return "Todo tidak ada";
            }else{
                todolist[number - 1] = null;
                return "Sukses menghapus todo ke- "+number;
            }

        }else {
            for (int i = number - 1; i < todolist.length-1; i++){
                todolist[i] = todolist[i+1];
            }
            todolist[todolist.length-1] = null;
            return "Sukses menghapus todo ke- "+number;
        }


    }

    static void testRemoveTodo(){
        //showTodoList();
        addTodo("satu");
        showTodoList();
        System.out.println(removeTodo(2));

        showTodoList();
        System.out.println(removeTodo(6));
        showTodoList();
    }

    static void viewShowTodoList(){
        do{
            showTodoList();
            System.out.println("----------MENU----------");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            System.out.println("------------------------");
            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodo();
            } else if (input.equals("2")){
                viewRemoveTodo();
            } else if (input.equals("3")){
                break;
            } else {
                System.out.println("Tidak Dimengerti");
            }

            
        }while(true);

    }

    static void viewAddTodo(){
        System.out.println("------TAMBAH TODO------");
        var input = input("Todo (x jika batal)");
        
        if(input.equals("x")){
            //viewShowTodoList();
        } else {
            addTodo(input);
            //viewShowTodoList();
        }
    }

    static void viewRemoveTodo(){
        System.out.println("------REMOVE TODO------");
        var input = input("Nomor todo yang mau dihapus (x jika batal)");
        if(input.equals("x")){
            //viewShowTodoList();
        } else {
            System.out.println(removeTodo(Integer.parseInt(input)));
            
        }
    }
}
