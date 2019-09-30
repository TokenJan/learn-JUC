class Counter {

    private volatile int counter = 0;

    void increase() {
        counter++;
    }

    int getNum() {
        return counter;
    }
}
