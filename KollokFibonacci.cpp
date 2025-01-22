#include <iostream>
#include <vector>
using namespace std;
void Fib(vector<long long>& results) {
	results[0] = 0;
	results[1] = 1;
	for (int i = 2; i < results.size(); i++)
		results[i] = results[i - 1] + results[i - 2];
}
int main()
{
	int amount;
	cout << "Enter amount of first Fibbonacci numbers\n";
	cin >> amount;
	vector<long long> results(amount+1);
	/*results[0] = 0;
	results[1] = 1;
	for (int i = 2; i < results.size(); i++)
		results[i] = results[i - 1] + results[i - 2];*/
	Fib(results);
	cout << "First " << amount << " Fibbonacci numbers are:\n";
	for (int i = 1; i < results.size(); i++)
		cout << results[i] << " ";
}
