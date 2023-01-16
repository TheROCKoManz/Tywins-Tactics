import java.util.Scanner;
class TywinsTactics
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Number of Soldiers and Queries: ");
        int N= inp.nextInt();
        int M= inp.nextInt();
        int[][] superior = new int[N+1][N+1];
        int[] skills = new int[N+1];
        System.out.println("Enter Skills of "+N+" Soldiers: ");
        for(int i=1; i<=N; i++)
            skills[i]= inp.nextInt();

        System.out.println("Enter Superior and Juniors: ");
        for(int i=1; i<N; i++)
        {
            int u = inp.nextInt();
            int v = inp.nextInt();
            superior[u][v] = 1;
        }

        for(int i=1; i<=M; i++)
        {
            System.out.println("Enter Query: ");
            char Q = inp.next().charAt(0);
            if(Q=='U')
            {
                int S = inp.nextInt();
                int up = inp.nextInt();
                skills[S] = up;
            }
            else if(Q=='Q')
            {
                int S = inp.nextInt();
                int sum = skills[S]+sumS(S, superior, skills, N);
                System.out.println("Sum of Skills = "+sum);
            }
        }
    }
    public static int sumS(int S, int[][] superior, int[] skills, int N)
    {
        int sum = 0;
        for(int i=1; i<=N; i++)
        {
            if(superior[S][i]==1)
                sum+=skills[i]+sumS(i,superior,skills,N);
        }
        return sum;
    }
}
