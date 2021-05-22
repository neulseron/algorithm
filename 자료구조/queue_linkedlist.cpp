#include <iostream>

using namespace std;

template <typename K> struct Node {
    K data;
    Node* prev = NULL;
    Node* next = NULL;
};

template <typename T> class Queue {
private:

public:
    Node<T> *frontN, *rearN;

    Queue() {
        frontN = NULL;
        rearN = NULL;
    }
    
    ~Queue() {
        Node<T>* tmp = frontN->next;
    
        while(tmp != NULL) {
            delete tmp->prev;
            tmp = tmp->next;
        }
    }

    bool empty() {
        if (frontN == rearN)
            return true;
        return false;
    }

    void pop() {
        if (empty()) {
            cout<<"#queue is empty\n";
        } else {
            Node<T>* tmpN = frontN;

            if (frontN->next == NULL) { // 한개
                rearN = NULL;
                frontN = NULL;
            } else {
                frontN->next->prev = NULL;
                frontN = frontN->next;
            }
            
            delete tmpN;
        }
    }

    void push(T a) {
        Node<T>* tmpN = new Node<T>;
        tmpN->data = a;

        if (rearN == NULL) {
            rearN = tmpN;
            frontN = tmpN;
        } else {
            tmpN->prev = rearN;
            rearN->next = tmpN;
            rearN = tmpN;
        }   
    }

    T front() {
        return frontN->data;
    }

    T back() {
        return rearN->data;
    }

    int size() {
        int cnt = 0;
        Node<T>* tmp = frontN;

        while(frontN != NULL) {
            cnt++;
            if (tmp->next == NULL)
                return cnt;
            tmp = tmp->next;
        }

        return cnt;
    }

    void print() {
        Node<T>* currN = frontN;

        cout<<"[front] ";
        while (currN != NULL) {  
            cout<<currN->data<<" ";
            currN = currN->next;
        }
        cout<<" [back]\n";
    }
    
};

int main() {
    Queue<int> q_int;

    q_int.pop();
    q_int.push(5);
    cout<<q_int.front()<<endl;
    cout<<q_int.back()<<endl;
    cout<<"=======\n";
    q_int.push(4);
    cout<<q_int.front()<<endl;
    cout<<q_int.back()<<endl;
    cout<<"size:"<<q_int.size()<<endl;
    cout<<"=======\n";
    q_int.push(3);
    cout<<q_int.front()<<endl;
    cout<<q_int.back()<<endl;
    cout<<"size:"<<q_int.size()<<endl;
    q_int.print();
    cout<<"=======\n";
    q_int.push(2);
    cout<<"size:"<<q_int.size()<<endl;
    q_int.print();
    cout<<"=======\n";
    q_int.pop();
    q_int.pop();
    q_int.push(1);
    cout<<"size:"<<q_int.size()<<endl;
    q_int.print();
    cout<<"=======\n";
}
