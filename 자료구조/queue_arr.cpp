#include <iostream>

using namespace std;

// 원형 큐
template <typename T> class Queue {
private:
    T* data;
    int maxSize;
    int currDataSize;

public:
    int frontIndex, rearIndex;

    Queue(int s) {
        maxSize = s;
        frontIndex = rearIndex = 0;
        data = new T[maxSize];
        currDataSize = 0;
    }
    ~Queue() {
        delete[] data;
    }

    bool empty() {
        if (currDataSize == 0)
            return true;
        return false;
    }

    void pop() {
        if (empty()) {
            cout<<"#queue is empty\n";
        } else {
            frontIndex = (frontIndex + 1) % maxSize;
            currDataSize--;
        }
    }

    void push(T a) {
        if (currDataSize == maxSize) {
            cout<<"#queue is full\n";
        } else {
            data[rearIndex] = a;  
            rearIndex = (rearIndex + 1) % maxSize;
            currDataSize++;
        }
    }

    T front() {
        return data[frontIndex];
    }

    T back() {
        return data[(rearIndex - 1 + maxSize) % maxSize];
    }

    int size() {
        return currDataSize;
    }

    void print() {
        cout<<"[front] ";
        for (int i = 0; i < currDataSize; i++) {
            int id = (frontIndex + i) % maxSize;
            cout<<data[id]<<" ";
        }
        cout<<"[back]\n";
    }
};

int main() {
    Queue<int> q_int(5);
    
    q_int.push(5);
    q_int.push(4);
    q_int.push(3);
    q_int.push(2);
    q_int.push(1);
    q_int.push(0);
    q_int.print();
    //cout<<"size:"<<q_int.size()<<"\n";
    cout<<"front:"<<q_int.front()<<"\n";
    cout<<"back:"<<q_int.back()<<"\n";
    //cout<<"is Empty?:"<<q_int.empty()<<"\n";
    q_int.pop();
    q_int.print();
    cout<<"front:"<<q_int.front()<<"\n";
    cout<<"back:"<<q_int.back()<<"\n";
    q_int.pop();
    q_int.print();
    cout<<"front:"<<q_int.front()<<"\n";
    cout<<"back:"<<q_int.back()<<"\n";
    q_int.push(10);
    q_int.print();
    cout<<"front:"<<q_int.front()<<"\n";
    cout<<"back:"<<q_int.back()<<"\n";
    q_int.pop();
    q_int.pop();
    q_int.pop();
    q_int.print();
    q_int.push(99);
    q_int.print();
    cout<<"front:"<<q_int.front()<<"\n";
    cout<<"back:"<<q_int.back()<<"\n";
}
