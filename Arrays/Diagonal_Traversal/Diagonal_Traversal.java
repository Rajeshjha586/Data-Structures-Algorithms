//https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

public class Diagonal_Traversal
{
    public static int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }
    public static void Diagonal_Traversal(int[][] mat)
    {
        int r_size = mat.length;
        int c_size = mat[0].length;

        for(int i=1; i<(r_size+c_size); i++)
        {
            int start_col = Math.max(0, i-r_size);

            int count = min(i, (c_size - start_col), r_size);

            for(int x=0; x<count; x++)
            {
                System.out.print(mat[Math.min(r_size, i) - x - 1][start_col + x] + " ");
            }
            System.out.println();
        }
        
    }
    public static void display(int[][] mat)
    {
        for(int i=0; i<mat.length; i++)
        {
            for(int j=0; j<mat[0].length; j++)
            {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solve()
    {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        };

        System.out.println("Given Matrix of Array : ");
        display(mat);

        System.out.println("After Diagonal Traversal");
        Diagonal_Traversal(mat);
    }
    public static void main(String[] args)
    {
        solve();
    }
}
