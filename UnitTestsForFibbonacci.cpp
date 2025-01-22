#include "pch.h"
#include "CppUnitTest.h"
#include "../KollokFibonacci/KollokFibonacci.cpp"
using namespace Microsoft::VisualStudio::CppUnitTestFramework;
namespace UnitTestsForFibbonacci
{
	TEST_CLASS(UnitTestsForFibbonacci)
	{
	public:
		
		TEST_METHOD(TestFibbonacci) {
			vector<long long> toBeCalculated(8);

			vector<long long> results(8);
			results[0] = 0;
			results[1] = 1;
			results[2] = 1;
			results[3] = 2;
			results[4] = 3;
			results[5] = 5;
			results[6] = 8;
			results[7] = 13;
			Fib(toBeCalculated);
			for (int i = 0; i < results.size(); i++) {
				Assert::AreEqual(results[i], toBeCalculated[i]);
			}
		}
	};
}
