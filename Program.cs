using System;
using System.IO;
using System.Linq;

namespace FileIO
{
    class Program
    {
        static void Main(string[] args)
        {
            string filepath = @"numbers.txt";
            string[] lines = { };
            try
            {
                lines = File.ReadAllLines(filepath);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            lines = lines.Select(line => line.Trim()).OrderByDescending(line => line).ToArray();

            try
            {
                File.WriteAllLines(filepath + ".out.txt", lines);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            foreach (string line in lines)
            {
                Console.WriteLine(line);
            }
                
            Console.ReadKey();
        }
    }
}

//  Content of the numbers.txt file:
//    1
//   2
//     3
//  4
//      5
//         6
//       7
//        8
//  9
//  0

//  Content of the result file:
//  9
//  8
//  7
//  6
//  5
//  4
//  3
//  2
//  1
//  0