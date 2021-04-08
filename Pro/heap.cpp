
 
using namespace std;
typedef pair<int, int> pii;
struct Heap {
    int n;
    pii v[100009];
    int index[100009];
    void inil() {
        n = 1;
    }
    void push(int value, int i) {
        v[n] = pii(value, i);
        index[i] = n;
        n++;
        update(n - 1);
    }
    pii pop(int i = -1) {
        int pid = 1;
        if (i != -1) {
            pid = index[i];
        }
        n--;
        pii res = v[pid];
        v[pid] = v[n];
        v[n] = res;
        index[v[pid].second] = pid;
        index[v[n].second] = n;
 
 
        update(pid);
 
 
        return res;
    }
    pii top() { return v[1]; }
    void update_direct(int i, int vv) {
        v[index[i]].first = vv;
        update(index[i]);
    }
    void update(int ti) {
        //update
        while (ti > 1) {
            int ri = ti / 2;
            if (v[ri] > v[ti]) {
                pii tmp = v[ri];
                v[ri] = v[ti];
                v[ti] = tmp;
                index[v[ti].second] = ti;
                index[v[ri].second] = ri;
                ti = ri;
            }
            else
                break;
        }
 
 
        //downdate
        while (ti < n) {
            int pi = ti * 2;
            int qi = ti * 2 + 1;
            int ri = pi;
            if (pi >= n)break;
            if (qi >= n)ri = pi;
            else {
                if (v[ri] > v[qi])ri = qi;
            }
            if (v[ti] > v[ri]) {
                pii tmp = v[ri];
                v[ri] = v[ti];
                v[ti] = tmp;
                index[v[ti].second] = ti;
                index[v[ri].second] = ri;
                ti = ri;
            }
            else
                break;
        }
    }
};
Heap hop;
int n;
int main() {
    int i, j, k;
    scanf("%d", &n);
    hop.inil();
    for (i = 1; i <= n; i++) {
        scanf("%d", &j);
        hop.push(j, i);
    }
    scanf("%d", &n);
    while (n--) {
        int type;
        scanf("%d", &type);
        if (type == 2) {
            printf("%d\n", hop.top().second);
        }
        else {
            scanf("%d %d", &i, &j);
            hop.update_direct(i, j);
        }
    }
}
