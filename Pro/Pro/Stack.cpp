#if 0
#include <stdio.h>
#define NULL 0
#define BUFSIZE 100000

struct Node {
	int num;
	Node* next;
	Node* alloc(int nd, Node* np) {
		num = nd, next = np;
		return this;
	}
} buf[BUFSIZE];
int bcnt;

struct Stack {
	Node * head;
	int cnt;
	void init() {
		cnt = bcnt = 0;
		head = NULL;
	}
	bool empty() { return cnt == 0; }
	int size() { return cnt; }
	int top() { return head->num; }
	void push(int num) {
		cnt++;
		head = buf[bcnt++].alloc(num, head);
	}
	void pop() {
		if (empty()) return;
		cnt--;
		head = head->next;
	}
}stkObject;

Stack* newStack() {
	stkObject.init();
	return &stkObject;
}

void delStack(Stack*stk) {
	stk->init();
}

bool empty(Stack*stk) {
	return stk->empty();
}

int size(Stack*stk) {
	return stk->size();
}

int top(Stack *stk) {
	return stk->top();
}

void push(Stack*stk, int num) {
	stk->push(num);
}

void pop(Stack* stk) {
	stk->pop();
}

int main(void) {
	Stack* stk = newStack();
	push(stk, 1);
	push(stk, 2);
	pop(stk);
	return 0;
}
#endif