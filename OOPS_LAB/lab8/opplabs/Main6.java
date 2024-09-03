package opplabs;

interface Sports {
	  int getNumberOfGoals();
	  void dispTeam();
	}

	class Hockey implements Sports {
	  private int numberOfGoals;
	  private String teamName;

	  public Hockey(int numberOfGoals, String teamName) {
	    this.numberOfGoals = numberOfGoals;
	    this.teamName = teamName;
	  }

	  @Override
	  public int getNumberOfGoals() {
	    return numberOfGoals;
	  }

	  @Override
	  public void dispTeam() {
	    System.out.println("The winning hockey team is " + teamName + " with " + numberOfGoals + " goals.");
	  }
	}

	class Football implements Sports {
	  private int numberOfGoals;
	  private String teamName;

	  public Football(int numberOfGoals, String teamName) {
	    this.numberOfGoals = numberOfGoals;
	    this.teamName = teamName;
	  }

	  @Override
	  public int getNumberOfGoals() {
	    return numberOfGoals;
	  }

	  @Override
	  public void dispTeam() {
	    System.out.println("The winning football team is " + teamName + " with " + numberOfGoals + " goals.");
	  }
	}

	public class Main6 {
	  public static void main(String[] args) {
	    Sports hockey = new Hockey(5, "Team A");
	    Sports football = new Football(3, "Team B");

	    if (hockey.getNumberOfGoals() > football.getNumberOfGoals()) {
	      hockey.dispTeam();
	    } else {
	      football.dispTeam();
	    }
	  }
	}

