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
            Console.WriteLine(so.solution(5, 24));
        }
    }

    public class Solution {
    public string solution(int a, int b) {
            int[] daynum = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            string[] day = new string[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
            int num = 4;

            for (int i = 0; i < a-1; i++) num += daynum[i];
            num += b;

            string answer = day[num % 7];
            return answer;
    }
}
}
