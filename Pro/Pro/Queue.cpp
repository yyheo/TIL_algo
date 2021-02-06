#if 0
const int BUFSIZE = 100000;
const int NULL = 0;
struct Node {
	int data;
	Node* next;
	Node* alloc(int nd, Node* nn) {
		data = nd, next = nn;
		return this;
	}
}buf[BUFSIZE];
int bcnt;

struct Queue {
	Node *head, *tail;
	int cnt;
	void init() {
		bcnt = cnt = 0;
		//buf[bcnt].alloc(0, NULL);
		//head = tail = buf + bcnt++;
		head = tail = buf[bcnt++].alloc(0, NULL);
	}
	bool empty() { return cnt == 0; }
	int size() { return cnt; }
	int front() { return head->next->data; }
	int back() { return tail->data; }
	void push(int num) {
		cnt++;
		tail = tail->next = buf[bcnt++].alloc(num, NULL);
	}
	void pop() {
		if (empty()) return;
		cnt--;
		head = head->next;
	}
} que;

Queue* newQueue() {
	que.init();
	return &que;
}

void delQueue(Queue *que) {
	que = NULL;
}

bool empty(Queue *que) {
	return que->empty();
}

int size(Queue* que) {
	return que->size();
}

int front(Queue* que) {
	return que->front();
}

int back(Queue* que) {
	return que->back();
}

void push(Queue* que, int num) {
	que->push(num);
}

void pop(Queue* que) {
	que->pop();
}

int main(void) {
	Queue* que = newQueue();
	push(que, 1);
	push(que, 2);
	pop(que);
	return 0;
}
#endif