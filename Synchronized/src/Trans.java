class Trans {
    synchronized void printNum(){
        System.out.println(Thread.currentThread());
        for(int i = 0; i < 25; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static synchronized  void printStaticNum() {
        System.out.println(Thread.currentThread());
        for(int i = 0; i < 25; i++){
            System.out.print("a ");
        }
        System.out.println();
    }
}