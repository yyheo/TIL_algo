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
            int[] arr = new int[] { 3, 2, 6 };
            foreach (int i in so.solution(arr, 10))
            {
                Console.WriteLine(i);
            }
        }
    }

    public class Solution
    {
        public int[] solution(int[] arr, int divisor)
        {
            List<int> vallist = new List<int>();
            int[] answer = new int[] { };
            foreach (int val in arr)
            {
                if (val % divisor == 0) vallist.Add(val);
            }
            if (vallist.Count == 0) vallist.Add(-1);
            answer = vallist.ToArray();
            Array.Sort(answer);
            return answer;
        }
    }
}
