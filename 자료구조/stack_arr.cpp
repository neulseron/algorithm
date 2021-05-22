#include <iostream>

using namespace std;

template <typename T> class Stack {
private:
    T* data;

public:
    int topIndex, maxSize;

    Stack(int s) {
        maxSize = s;
        topIndex = -1;
        data = new T[maxSize];
    }
    ~Stack() {
        delete[] data;
    }

    bool empty() {
        if (topIndex == -1)
            return true;
        return false;
    }

    void pop() {
        if (empty()) {
            cout<<"#stack is empty\n";
        } else {
            topIndex--;
        }
    }

    void push(T a) {
        if (topIndex == maxSize - 1) {
            cout<<"#stack is full\n";
        } else {
            topIndex++;
            data[topIndex] = a;   
        }
    }

    T top() {
        return data[topIndex];
    }

    int size() {
        return topIndex + 1;
    }

    void print() {
        cout<<"=(top)=\n";
        for (int i = topIndex; i >= 0; i--) {
            cout<<data[i]<<"\n";
        }
        cout<<"=(bottom)=\n";
    }
};

int main() {
    Stack<int> st_int(5);
    
    st_int.push(1);
    st_int.push(3);
    st_int.push(2);
    st_int.push(4);
    st_int.push(5);
    st_int.push(6);
    st_int.print();
    //cout<<st_int.top()<<"\n";
    st_int.pop();
    st_int.pop();
    st_int.print();
}
