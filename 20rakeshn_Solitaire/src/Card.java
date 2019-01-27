
/**
 * This class contains attributes and methods one can implement on a card 
 * in the Solitaire game.
 * @author RakeshNori
 * @version 1/5/2017
 */
public class Card 
{
	private int rank;
	private String suit;
	private boolean isFaceUp;
	public Card(int r, String s)
	{
		rank = r;
		suit = s;
		isFaceUp = false;
	}
	/**
	 * Gives the card value.
	 * @return the value (1 - 10, Jack, Queen, King, Ace) of a given card.
	 */
	public int getRank()
	{
		return rank;
	}
	/**
	 * Gives the suit of a card.
	 * @return return diamonds ("d"), hearts ("h"), spades ("s"), or clubs ("c").
	 */
	public String getSuit()
	{
		return suit;
	}
	/**
	 * Checks if the card is red color.
	 * @return true if the card is a diamond or heart; otherwise,
	 * 		   false.
	 */
	public boolean isRed()
	{
		return suit.equals("d") || suit.equals("h");
	}
	/**
	 * Checks if the card is faced up.
	 * @return true if the card is faced upwards; otherwise,
	 *		   false.
	 */
	public boolean isFaceUp()
	{
		return isFaceUp;
	}
	/**
	 * Turns a card upwards.
	 */
	public void turnUp()
	{
		isFaceUp = true;
	}
	/**
	 * Makes a card faced down.
	 */
	public void turnDown()
	{
		isFaceUp = false;
	}
	/**
	 * Fetches the corresponding file image for the card.
	 * @return the FileName that has the image of the card.
	 */
	public String getFileName()
	{
		if (!isFaceUp())
		{
			return "cards/back.gif";
		}
		else
		{
			String file = "cards/";
			if (rank >= 2 && rank <= 9)
				file += rank;
			else
			{
				if (rank == 10)
					file += "t";
				else if (rank == 11)
					file += "j";
				else if (rank == 12)
					file += "q";
				else if (rank == 13)
					file += "k";
				else if (rank == 1)
					file += "a";
			}
			file += suit;
			file += ".gif";
			return file;
		}
	}
}
