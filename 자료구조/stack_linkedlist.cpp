#include <iostream>

using namespace std;

template <typename K> struct Node {
    K data;
    Node* prev = NULL;
    Node* next = NULL;
};

template <typename T> class Stack {
private:

public:
    Node<T>* topN;

    Stack() {
        topN = NULL;
    }
    ~Stack() {
        Node<T>* tmp = topN->prev;
    
        while(tmp != NULL) {
            delete tmp->next;
            tmp = tmp->prev;
        }
    }

    bool empty() {
        if (topN == NULL)
            return true;
        return false;
    }

    void pop() {
        if (empty()) {
            cout<<"#stack is empty\n";
        } else {
            Node<T>* tmpN = topN;

            if (topN->prev == NULL) { // 한개
                topN = NULL;
            } else {
                topN->prev->next = NULL;
                topN = topN->prev;
            }
            
            delete tmpN;
        }
    }

    void push(T a) {
        Node<T>* tmpN = new Node<T>;
        tmpN->data = a;

        if (topN == NULL) {
            topN = tmpN;
        } else {
            tmpN->prev = topN;
            topN->next = tmpN;
            topN = tmpN;
        }   
    }

    T top() {
        return topN->data;
    }

    int size() {
        int cnt = 0;
        Node<T>* tmp = topN;

        while(topN != NULL) {
            cnt++;
            if (tmp->prev == NULL)
                return cnt;
            tmp = tmp->prev;
        }

        return cnt;
    }

    void print() {
        Node<T>* currN = topN;

        cout<<"=(top)=\n";
        while (currN != NULL) {  
            cout<<currN->data<<"\n";
            currN = currN->prev;
        }
        cout<<"=(bottom)=\n";
    }
};

int main() {
    Stack<int> st_int;

    st_int.pop();
    cout<<"size:"<<st_int.size()<<"\n";
    st_int.push(1);
    st_int.push(2);
    st_int.push(3);
    st_int.print();
    cout<<"size:"<<st_int.size()<<"\n";
    st_int.pop();
    st_int.print();
    cout<<"size:"<<st_int.size()<<"\n";
}
