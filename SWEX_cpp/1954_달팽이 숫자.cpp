#include <iostream>
#include <vector>
using namespace std;

int dirx[4] = { 0, 1, 0, -1 };
int diry[4] = { 1, 0, -1, 0 };

int main(void) {
	int T;
	cin >> T;

	for (int n=1; n<=T; n++) {
		int num;
		cin >> num;

		int x = 0, y = 0;
		int inx = 0, iny = 0;
		vector<vector<int> > snail(num, vector<int>(num, 0));
		for (int i = 1; i <= num*num; i++) {
			snail[x][y] = i;
			int nx = x + dirx[inx];
			int ny = y + diry[iny];
			if (nx < num && ny < num && nx >= 0 && ny >= 0 && snail[nx][ny] == 0) {
				x = nx;
				y = ny;
			}
			else {
				inx = (inx + 1) % 4 ;
				iny = (iny + 1) % 4 ;
				if (i != num*num) i -= 1;
			}
		}
		
		cout << "#" << n << "\n";
		for (int i = 0; i < snail.size(); i++) {
			for (int j = 0; j < snail.size(); j++) cout << snail[i][j] << " ";
			cout << "\n";
		}
	}
}
