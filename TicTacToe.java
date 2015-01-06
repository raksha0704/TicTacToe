
import java.util.Scanner;
public class TicTacToe {
	public static void main(String[] args)
	{   boolean game = true;
		Toast toe =new Toast();
		System.out.println("Welcome to the game of tic tac toe");
		System.out.println("Please follow this format: ");
		System.out.println("1   2   3");
		System.out.println("4   5   6");
		System.out.println("7   8   9");

		String[][] array = new String[3][3];

		 int res=1;
	      for(int i=0;i<3;i++)
	      for(int j=0;j<3;j++)
	      {

		   array[i][j]=String.valueOf(res);
		   res++;
	      }

		Scanner in = new Scanner(System.in);
		String pos; int position=0;
		String s[]={"O","X"};
		int index;
   for(int i=1; i<=9;i++)
   {
	if(game)
	{
		index= i%2;
		System.out.println("Player "+index+": Enter position");
		try{
		position =in.nextInt();
		}
		catch (Exception e){
			//System.out.println("Invalid input");
		}
		pos=String.valueOf(position);

		toe.markMove(pos,s[index],array);
		toe.displayArray(array);
		 game =toe.winner(s[index],array);
			}
   }

	if(game)
	{
		System.out.println("Draw match :p");
	}
}
}

   class Toast
    {
	   boolean flags=true;
	   Scanner keyboard = new Scanner(System.in);



		public void displayArray(String array[][])
		{
		 for(int k=0; k<3; k++)
		 {
			 for(int f=0;f<3;f++)
			 {
				 System.out.print(array[k][f]+ " ");
			 }
		 System.out.println();
		 }
		 }

		public void markMove(String pos, String sym, String array[][])
		{
			boolean flag=false;

				do{
					 flag=false; boolean pole=true;
				for(int a=0;a<3;a++)
		          for(int b=0;b<3;b++)
				{
					if(pos.equals(array[a][b]))
					{

						array[a][b]=sym;
						pole=false;

					}
				}
					if(pole){
						System.out.println("Invalid move. Enter valid number");
						int position=keyboard.nextInt();
						pos=String.valueOf(position);
						flag=true;
					}

				}while(flag);

		}
		public boolean winner( String sym,String[][] array)
		{

			for(int i=0;i<3;i++)
			{
				if((array[i][0]+array[i][1]+array[i][2]).equals(sym+sym+sym))
				{
					won(sym);
				flags=false;
				}
			}

			for(int i=0;i<3;i++)
			{
				if((array[0][i]+array[1][i]+array[2][i]).equals(sym+sym+sym))
				{	won(sym);
				  flags=false;
				}
			}
		if((array[0][0]+array[1][1]+array[2][2]).equals(sym+sym+sym))
		{  won(sym);
		   flags=false;
		}
		else if((array[0][2]+array[1][1]+array[2][0]).equals(sym+sym+sym))
		{ won(sym);
		 flags=false;
		}

			return flags;
		}

		public void won(String sym)
		{
			 if(sym.equals("X"))
			 {  System.out.println("Player 1 is the winner!");

		}


			  else
				  {System.out.println("Player 2 is the winner!");

				  }

		}
    }



