using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Solution so = new Solution();
            Console.WriteLine(so.solution(3,5));
        }
    }

    public class Solution
    {
        public int solution(int a, int b)
        {
                int sum = 0;
                if (a>b) {
                    for(int i=a; i>=b; i--) sum+=i; 
                } else {
                    for(int i=a; i<=b; i++) sum+=i; 
                }
                int answer = sum;
                return answer;
        }
    }
}
