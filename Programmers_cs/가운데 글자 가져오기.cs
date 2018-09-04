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
            Console.WriteLine(so.solution("abcde"));
        }
    }

    public class Solution {
        public string solution(string s)
        {
            string answer = "";
            if ((s.Length % 2) == 1)
                answer = s.Substring(s.Length/2,1);
            else
                answer = s.Substring(s.Length / 2-1,2);
            return answer;
        }
    }
}
